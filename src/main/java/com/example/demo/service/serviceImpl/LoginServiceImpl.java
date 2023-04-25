package com.example.demo.service.serviceImpl;

import com.example.demo.config.RedisCache;
import com.example.demo.service.LoginService;
import com.example.demo.util.JwtUtil;
import com.example.demo.util.Result;
import com.example.demo.vo.LoginUser;
import com.example.demo.vo.UserTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Objects;

/**
 * @Author gxx
 * @Date 2023年04月18日09时34分
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private RedisCache redisCache;


    @Override
    public Result login(UserTable user) {

        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user.getUserName(),user.getPassWord());
        Authentication authentication = authenticationManager.authenticate(authenticationToken);

        if (Objects.isNull(authentication)){
            throw new RuntimeException("用户名或密码错误");
        }

        //使用userid 生成Token
        LoginUser loginUser = (LoginUser)authentication.getPrincipal();

        String userId = loginUser.getUserTable().getUserId().toString();
        String jwt = JwtUtil.createJWT(userId);

        //authenticate存入redis
        redisCache.setCacheObject("login:" + userId,loginUser);
        //把token相应给前端
        HashMap<String,String> map = new HashMap<>();
        map.put("token",jwt);
        return Result.success(map);
    }

    @Override
    public Result logout() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        Long userid = loginUser.getUserTable().getUserId();
        redisCache.deleteObject("login:"+userid);
        return Result.success("退出成功");
    }


}

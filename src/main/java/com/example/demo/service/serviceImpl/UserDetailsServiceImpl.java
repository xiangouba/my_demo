package com.example.demo.service.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.demo.mapper.UserTableMapper;
import com.example.demo.vo.LoginUser;
import com.example.demo.vo.UserTable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * @Author gxx
 * @Date 2023年04月18日09时09分
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Resource
    private UserTableMapper userTableMapper;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        //根据用户查询用户信息
        LambdaQueryWrapper<UserTable> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(UserTable :: getUserName,userName);
        UserTable user = userTableMapper.selectOne(wrapper);
        //如果查询不到数据就抛出异常
        if (Objects.isNull(user)){
            throw new RuntimeException("用户名或这密码错误");
        }
        //TODO 根据用户查询权限信息 添加到LoginUser中

        // 封装成UserDetails对象返回
        return new LoginUser(user);
    }
}

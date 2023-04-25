package com.example.demo.service.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.demo.mapper.ReaderDataMapper;
import com.example.demo.mapper.UserTableMapper;
import com.example.demo.service.IDemoService;
import com.example.demo.vo.ReaderData;
import com.example.demo.vo.UserTable;
import org.springframework.security.config.core.userdetails.UserDetailsMapFactoryBean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author gxx
 * @Date 2023年04月06日14时08分
 */
@Service
public class IDemoServiceImpl implements IDemoService {

    @Resource
    private ReaderDataMapper readerDataMapper;

    @Resource
    private UserTableMapper userTableMapper;

    @Override
    public ReaderData getData(Integer id) {
//        List<ReaderData> readerDataList = new ArrayList<>();
//
//        for (Integer id : idList) {
//            readerDataList.add(readerDataMapper.selectById(id));
//        }
        return readerDataMapper.selectById(id);
    }

    @Override
    public UserTable getUser(String userName) {

        LambdaQueryWrapper<UserTable> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(UserTable :: getUserName,userName);
        UserTable user = userTableMapper.selectOne(wrapper);
        return user;
    }
}

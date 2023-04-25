package com.example.demo.service;

import com.example.demo.util.Result;
import com.example.demo.vo.UserTable;

/**
 * @Author gxx
 * @Date 2023年04月18日09时36分
 */
public interface LoginService {
    public Result login(UserTable user);

    public Result logout();
}

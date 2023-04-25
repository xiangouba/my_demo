package com.example.demo.controller;

import com.example.demo.util.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;


/**
 * @Author gxx
 * @Date 2023年04月18日09时29分
 */
@Controller
public class LoginController {

    @PostMapping("/user/login")
    public Result login(){
        return null;
    }

}

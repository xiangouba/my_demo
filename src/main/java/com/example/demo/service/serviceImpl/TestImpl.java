package com.example.demo.service.serviceImpl;

import com.example.demo.service.Itest;

/**
 * @Author gxx
 * @Date 2023年07月08日16时20分
 */
public class TestImpl implements Itest{

        @Override
    public void test() {
//        Itest.super.test();
            System.out.println("默认的方法重新实现了");
    }

    @Override
    public void test1() {

        System.out.println("实现类的方法实现");
    }
}

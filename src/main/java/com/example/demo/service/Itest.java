package com.example.demo.service;

import java.util.PrimitiveIterator;

/**
 * @Author gxx
 * @Date 2023年07月08日16时17分
 */
public interface Itest {
    default void test(){
        System.out.println("默认的测试方法");
    }

    void test1();
}

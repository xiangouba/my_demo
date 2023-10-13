package com.example.demo;

public class SuperStar implements IService{
    @Override
    public void func1() {
        System.out.println("目标对象内部的方法1");
    }

    @Override
    public void func2() {
        System.out.println("目标对象内部的方法2");
    }
}

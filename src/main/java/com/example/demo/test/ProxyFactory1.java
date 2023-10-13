package com.example.demo.test;


import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class ProxyFactory1 implements MethodInterceptor {
    //目标对象
    private Object target;
    //传入目标对象
    public ProxyFactory1(Object target){
        this.target = target;
    }
    //Cglib采用底层的字节码技术，在子类中采用方法拦截的技术，
    // 拦截父类指定方法的调用，并顺势植入代理功能的代码
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        //代理对象的功能
        System.out.println("预定场地");
        //调用目标对象的方法
        Object returnValue = method.invoke(target,objects);
        //代理对象的功能
        System.out.println("执行完毕");
        return returnValue;
    }

    public Object getProxyInstance(){
        Enhancer en = new Enhancer();
        en.setSuperclass(target.getClass());
        en.setCallback(this);
        return en.create();
    }
}

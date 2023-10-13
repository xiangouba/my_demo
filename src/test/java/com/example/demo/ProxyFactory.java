package com.example.demo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyFactory {
    //任何的代理对象，都要清楚目标对象，在此得设置一个目标对象
    private IService superStar;

    //传入目标对象
    public ProxyFactory(IService superStar){
        this.superStar = superStar;
    }

    //给目标对象生成代理实例
    public Object getProxyInstance(){
        return Proxy.newProxyInstance(
                //指定当前目标对象
                superStar.getClass().getClassLoader(),
                superStar.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("预定场地");
                        //目标对象执行自己的方法
                        Object returnValue = method.invoke(superStar,args);
                        System.out.println("执行完毕");
                        return returnValue;
                    }
                }
        );
    }
}

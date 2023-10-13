package com.example.demo;

import com.example.demo.test.ProxyFactory1;
import com.example.demo.test.SuperStar2;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ProxyTest {

    @Test
    public void Test(){
        //先创建目标对象
        IService superStar = new SuperStar();
        IService superStar2 = new SuperStar1();

        //创建代理对象
        IService agent = (IService) new ProxyFactory(superStar).getProxyInstance();
        IService agent2 = (IService) new ProxyFactory(superStar2).getProxyInstance();

        agent.func1();
        agent2.func1();
    }

    @Test
    public void cglibTest(){
        SuperStar2 superStar2 = new SuperStar2();
        System.out.println(superStar2.getClass());
        SuperStar2 proxy = (SuperStar2) new ProxyFactory1(superStar2).getProxyInstance();
        System.out.println(proxy.getClass());
        proxy.fun1();
    }
}

package com.example.demo;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Stack;

/**
 * @Author gxx
 * @Date 2023��08��08��16ʱ28��
 */
@SpringBootTest
public class DataStructureTest {
    /*
    * 测试数据结构
    * 链表
    * 队列
    * */


//    测试stack类
    @Test
    public void test_stack(){
        Stack<String> s = new Stack<String>();
        s.push("aaa");
        s.push("bbb");
        s.push("ccc");

        System.out.println("获取最后一个元素：" + s.peek());
        System.out.println("弹出一个元素：" + s.pop());
        System.out.println("获取弹出后的最后一个元素：" + s.peek());
    }
}

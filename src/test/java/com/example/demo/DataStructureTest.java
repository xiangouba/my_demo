package com.example.demo;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingQueue;

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

    @Test
    public void test_ArrayDeque(){
        Deque<String> deque = new ArrayDeque<String>(1);
        deque.push("a");
        deque.push("b");
        deque.push("c");
        deque.push("d");

        deque.offerLast("e");
        deque.offerLast("f");
        deque.offerLast("g");
        deque.offerLast("h");

        deque.push("i");
        deque.offerLast("j");

        deque.poll();
        System.out.println("数据出栈：");
        while (!deque.isEmpty()){
            System.out.println(deque.pop());
        }
    }

    @Test
    public void test_arrayCopy(){
        int head = 0,tail = 0;
//        int a = (head - 1) & tail ;
//        System.out.println(a);
        Object[] elements = new Object[8];
        elements[head = (head - 1) & (elements.length - 1)] = "a";
        elements[head = (head - 1) & (elements.length - 1)] = "b";
        elements[head = (head - 1) & (elements.length - 1)] = "c";
        elements[head = (head - 1) & (elements.length - 1)] = "d";

        elements[tail] = "e";

    }

    @Test
    public void test_queue(){
        Queue<String> linkedQueue = new LinkedBlockingQueue<>();
//        linkedQueue.add("a");
//        String a = linkedQueue.poll();
        System.out.println("a:" + linkedQueue.poll());
    }
}

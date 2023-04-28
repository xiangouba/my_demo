package com.example.demo;


import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author gxx
 * @Date 2023年04月28日10时32分
 */
@SpringBootTest
public class DemoTest {

    /**
     * 链表测试
     */
    @Test
    public void test1(){
        LinkedList<String> list = new LinkedList<>();

        list.add("a");
        list.addFirst("b");
        list.addLast("c");

        System.out.println(list);
    }

    /**
     * 数组测试
     */
    @Test
    public void test2(){
//        ArrayList<String> list = new ArrayList<>();
//
//        list.add("a");
//        list.remove("a");

//        int[] i = new int[3];
//        i[0] = 0;
//        i[1] = 1;
//        i[2] = 2;
//
//        int[] j = new int[3];
//
//        System.arraycopy(i,1,j,0,1);
//        System.out.println(Arrays.toString(j));

        List<String> list = new ArrayList<>();

        list.add("a");
        list.add("b");
        list.add("c");

        list.get(0).toString();
    }
}

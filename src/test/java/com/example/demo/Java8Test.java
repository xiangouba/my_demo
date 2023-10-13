package com.example.demo;

import org.junit.Test;
import org.junit.internal.runners.statements.RunAfters;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@SpringBootTest
public class Java8Test {

    /**
     * lambda test
     */
    @Test
    public void lambdaTest(){
//        new Thread(()-> System.out.println("lambda test")).start();
        Runnable runnable = () -> {
            System.out.println("lambda 创建线程 ！");
        };

        Thread thread = new Thread(runnable);

        thread.start();

        Runnable runnable1 = () -> System.out.println("lambda 去除｛｝ 创建线程！");;
        Thread thread1 = new Thread(runnable1);
        thread1.start();

        Runnable runnable2 = () -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("lambda 创建了第二个线程！！");
            }
        };

        Thread thread2 = new Thread(runnable2);
        thread2.start();

        for (int i = 0; i < 1000; i++) {
            System.out.println("线程执行1！！");
        }

//        System.out.println("线程执行2！！");
    }

    public void lambdaTest2(){
        System.out.println("自然排序/定制排序：比较基本/引用数据类型，A>B=1 A<B=-1 A==B=0");
        Comparator<Integer> com1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1,Integer o2) {
                return Integer.compare(o1,o2);
            }
        };
        System.out.println("定制排序1：" + com1.compare(1,2));

        Comparator<Integer> com2 = (Integer o1,Integer o2) ->{return Integer.compare(o1,o2); };

        System.out.println("定制排序2：" + com2.compare(3,2));

//        lambda 优化  省略类型
        Comparator<Integer> com3 = (o1,o2) -> Integer.compare(o1,o2);
        System.out.println("定制排序：" + com3.compare(4,3));

//        方法引用
        Comparator<Integer> com4 = Integer :: compare;
        System.out.println("定制排序：" + com4.compare(2,2));

    }

    /**
     * 日期api
     */
    @Test
    public void dateApi(){

    }

    /**
     * Stream test
     */
    @Test
    public void streamTest(){
        List<Emp> emps = Emp.getEmployees();

        //返回一个顺序流
        Stream<Emp> stream = emps.stream();

        //返回一个并行流
        Stream<Emp> parallelStream = emps.parallelStream();

        //通过数组返回对应的Stream流对象
        int[] arr = new int[]{1,2,3,4,5,6};
        //调用Arrays类的 static
        IntStream intStream = Arrays.stream(arr);
        Emp e1 = new Emp(1001,"Tom",34,6000.38);
        Emp e2 = new Emp(1002,"Jerry",34, 6000.38);
        Emp[] arr1 = new Emp[]{e1,e2};
        Stream<Emp> empStream = Arrays.stream(arr1);

        Stream.iterate(0,t -> t + 2).limit(10).forEach(System.out::println);
    }

    @Test
    public void streamTest2(){
        List<Emp> emps = Emp.getEmployees();

//        List<Emp> empList = new ArrayList<>();
////        emps.forEach(System.out::println);
//        emps.forEach(a -> empList.add(a));
//        empList.forEach(System.out::println);

        Stream<Emp> stream = emps.stream();
        //过滤
//        Stream<Emp> empStream = stream.filter(emp -> emp.getSalary() > 7000);

//        List<Emp> empList = empStream.collect(Collectors.toList());
//        List<Double> empList = empStream.map(Emp::getSalary).collect(Collectors.toList());

//        Map<Integer,String> empMap = empStream.collect(Collectors.toMap(Emp::getId,Emp::getName));

//        empMap.forEach((key,value) -> {
//            System.out.println(key + ":" + value);
//        });

//        empList.stream().forEach(System.out::println);
//        System.out.println(empStream.allMatch(e -> e.getSalary() > 7000));

//        Emp em = empStream.max(Comparator.comparing( emp -> emp.getSalary())).get();

        Map<Integer,List<Emp>> empList = stream.collect(Collectors.groupingBy(e -> e.getId()));
        empList.forEach((key,value) ->{
            System.out.println(key + ":" + value);
        });
//        System.out.println(em);
    }
}

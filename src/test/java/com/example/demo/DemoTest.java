package com.example.demo;


import com.alibaba.druid.sql.visitor.functions.If;
import com.alibaba.fastjson2.JSONObject;
import com.example.demo.vo.DemoVO;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.*;

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
        list.add("b");
        list.add("c");
//       list.addFirst("b");
        list.addLast("c");

        list.remove();

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
        list.add("A");
        list.add("a");
        list.add("b");
        list.add("c");
        System.out.println(list.get(3).toString());
    }

    /**
     * 队列测试
     */
    @Test
    public void test3(){
        Queue<Integer> queue = new LinkedList<Integer>();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            queue.offer(random.nextInt(i+10));
        }
        while (queue.peek() != null){
            System.out.println(queue);
        }


    }

    @Test
    public void test4(){

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);

        list.forEach(item->{if (item == 1){
        list.remove(item);}
        });

        Map<Integer,String> map = new HashMap<>();
        map.put(1,"a");
        map.put(2,"b");

//        for (Integer integer : list) {
//            if (integer == 1){
//                list.remove(integer);
//                System.out.println(integer);
//            }
//        }
        System.out.println(list);
//        Iterator<Integer> iterator = list.iterator();
//        while (iterator.hasNext()){
//            Integer a = iterator.next();
//            if (a == 1){
//                iterator.remove();
//            }
//        }
//        System.out.println(list);
//
        map.remove(1,"b");
//        System.out.println(map);
    }


    @Test
    public void test5(){

        List<String> stringList = new ArrayList<>();
        List<Integer> ints = new ArrayList<>();
        DemoVO demoVO = new DemoVO();
        stringList.add("1");
        stringList.add("2");
        stringList.add("3");
        stringList = handle(stringList,ints,demoVO);
        System.out.println(stringList);
        System.out.println(demoVO);
    }

    public List<String> handle(List<String> stringList,List<Integer> ints,DemoVO demoVO){

        ints.add(Integer.parseInt(stringList.get(0)));
        ints.add(Integer.parseInt(stringList.get(1)));
        ints.add(Integer.parseInt(stringList.get(2)));
        demoVO.setParams("123456");
        return stringList;
    }

    @Test
    public void test6(){

        List<Map<String,Object>> mapList = new ArrayList<>();

        Map<String,List<Map<String,Object>>> oldMap = new HashMap<>();
        Map mapOfColumnValues = new HashMap();
        Map mapOfColumnValues1 = new HashMap();
        Map mapOfColumnValues2 = new HashMap();
        Map mapOfColumnValues3 = new HashMap();
        Map mapOfColumnValues4= new HashMap();
        Map mapOfColumnValues5 = new HashMap();
        mapOfColumnValues.put("ID","1");
        mapOfColumnValues.put("name","zahngsan");
        mapOfColumnValues1.put("ID","1");
        mapOfColumnValues1.put("name","lisi");
        mapOfColumnValues2.put("ID","2");
        mapOfColumnValues2.put("name","nihao");
        mapOfColumnValues3.put("ID","3");
        mapOfColumnValues3.put("name","甲");
        mapOfColumnValues4.put("ID","3");
        mapOfColumnValues4.put("name","乙");
        mapOfColumnValues5.put("ID","3");
        mapOfColumnValues5.put("name","丙");
        mapList.add(mapOfColumnValues);
        mapList.add(mapOfColumnValues1);
        mapList.add(mapOfColumnValues2);
        mapList.add(mapOfColumnValues3);
        mapList.add(mapOfColumnValues4);
        mapList.add(mapOfColumnValues5);
        for (Map<String, Object> map : mapList) {
            if (oldMap.get(map.get("ID")) == null) {
                List<Map<String,Object>> list = new ArrayList<>();
                list.add(map);
                oldMap.put(map.get("ID").toString(),list);
            } else {
                oldMap.get(map.get("ID")).add(map);
            }
        }

        System.out.println(oldMap);
    }

    @Test
    public void test7(){

        Object[] a = {1,"a"};
//        Arrays.stream(a).toArray();
        System.out.println(a);

//        long time1 = arrayListFor();
//        long time2 = linkedListFor();
//
//        long time3 = linkedListFor1();
//        System.out.println("for循环用的时间：" + time1);
//        System.out.println("迭代器循环用的时间：" + time2);
//        System.out.println("for循环linkedlist用的时间：" + time3);
    }

    public static long arrayListFor(){
        List arryaList = new ArrayList();

        for (int i = 0; i < 500000; i++) {
            arryaList.add(i);
        }
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < arryaList.size(); i++) {
            Object object = arryaList.get(i);
        }
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    public static long linkedListFor(){
        List arryaList = new LinkedList();

        for (int i = 0; i < 500000; i++) {
            arryaList.add(i);
        }
        long startTime = System.currentTimeMillis();

        for (Object o : arryaList) {
            Object object = o;
        }

        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    public static long linkedListFor1(){
        List arryaList = new LinkedList();

        for (int i = 0; i < 5000; i++) {
            arryaList.add(i);
        }
        long startTime = System.currentTimeMillis();

//        for (Object o : arryaList) {
//            Object object = o;
//        }

        for (int i = 0; i < arryaList.size(); i++) {
            Object o = arryaList.get(i);
        }

        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }


}

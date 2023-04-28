package com.example.demo;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import com.alibaba.fastjson2.TypeReference;
import com.example.demo.mapper.ReaderDataMapper;
import com.example.demo.mapper.UserTableMapper;
import com.example.demo.util.ExcelUtil;
import com.example.demo.vo.ReaderData;
import com.example.demo.vo.UserTable;
import org.apache.commons.lang.StringUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.*;

@SpringBootTest
class DemoApplicationTests {

    @Resource
    private UserTableMapper userTableMapper;

    @Autowired
    private ExcelUtil excelUtil;
    @Resource
    private ReaderDataMapper readerDataMapper;
    @Test
    public void test(){
        ReaderData readerData = new ReaderData();
        readerData.setId(3);
        readerData.setName("王五");
        readerData.setAge(25);
        readerDataMapper.insert(readerData);
    }


//    @Test
//    public void test1() {
//        //文件路径
//        String dataUrl = "C:\\Users\\rh\\Desktop\\demo\\demo.xlsx";
//        try {
//            //创建工作簿对象
//            XSSFWorkbook xssfWorkbook = new XSSFWorkbook(new FileInputStream(dataUrl));
//            //获取工作簿下的工作表的个数
//            int sheetNum = xssfWorkbook.getNumberOfSheets();
//            //遍历工作簿中的所有数据
//            for (int i = 0; i < sheetNum; i++) {
//                //读取第一个工作表
//                XSSFSheet hssfSheet = xssfWorkbook.getSheetAt(i);
//                //获取最后一行
//                int maxRow = hssfSheet.getLastRowNum();
//                for (int j = 0; j <= maxRow; j++) {
//                    //获取每一行的最后数据所在的单元格
//                    int maxRol = hssfSheet.getRow(j).getLastCellNum();
//                    System.out.println("--------第" + j + "行的数据如下--------");
//                    for (int k = 0; k < maxRol; k++) {
//                        System.out.println(hssfSheet.getRow(j).getCell(k) + "  ");
//                    }
//                }
//            }
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }


    @Test
    public void test2(){
        Map<String,String> a = new HashMap<>();

        a.put("a","a");
        System.out.println("map之前的内容==" + a);

        func(a);

        System.out.println("map之后的内容==" + a);


    }

    public void func(Map<String,String> map){
        map.put("b","b");

    }


    @Test
    public void test3(){
        String a = "a";
        System.out.println("之前的a==" + a);

        string1(a);

        System.out.println("之后的a==" + a);
    }

    public void string1(String a){
        String b = "b";
        a = b;
    }

    @Test
    public void test4(){
        long b = fibLoop(93);
        System.out.println(b);
    }

    public long fibLoop(int num){
        if (num < 1 || num > 93){
            return 0;
        }
        long a = 1;
        long b = 1;
        long temp;
        for (int i = 2; i < num; i++) {
            temp = a;
            a = b;
            b += temp;
            System.out.println(b);
        }

        return b;
    }

    @Test
    public void treadTest(){
//        String[] b = new String[]{"1","2","3","4","5","6"};
//        System.out.println(b);
        List<String> aList = new ArrayList<>();
        aList.add("a");
        aList.add("b");
//
    }

    @Test
    public void ifTest(){
        List<String> stringList = new ArrayList<>();
        List<String> newList = new ArrayList<>();

        stringList.add("U");
        stringList.add("I");
        stringList.add("D");
        stringList.add("D");
        stringList.add("D");
        stringList.add("I");
        stringList.add("I");
        stringList.add("U");
        stringList.add("U");
        stringList.add("I");
        stringList.add("D");
        stringList.add("I");

        System.out.println("stringList元素个数" + stringList.size());
        System.out.println(stringList);
        System.out.println("------------------------------------------");
        int count = 0;
        int newCount = 0;
        for (String s : stringList) {
            if ("U".equals(s) || "I".equals(s)){
                count++;
                newList.add(s);
            }
            if ("D".equals(s) || "U".equals(s)){
                newCount++;
                newList.add(s);
            }
        }

        System.out.println("newList元素个数" + newList.size());
        System.out.println(newList);
        System.out.println("count" + count);
        System.out.println("newCount" + newCount);

    }

    @Test
    public void test8(){

        String content = "{\n" +
                "  \"code\": \"200\",\n" +
                "  \"msg\": \"返回描述\",\n" +
                "  \"data\": [\n" +
                "    {\n" +
                "      \"id\": \"1\",\n" +
                "      \"name\": \"张三\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"2\",\n" +
                "      \"name\": \"李四\"\n" +
                "    }\n" +
                "  ]\n" +
                "}";
        content = "[\n" +
                "  {\n" +
                "    \"id\": \"1\",\n" +
                "    \"name\": \"张三\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": \"2\",\n" +
                "    \"name\": \"李四\"\n" +
                "  }\n" +
                "]";
            if(StringUtils.isBlank(content)) {
                System.out.println(false);
            }
            StringUtils.isEmpty(content);
            try {
                JSONArray jsonStr = JSONArray.parseArray(content);
                System.out.println(true);
            } catch (Exception e) {
                System.out.println(false);
            }
    }


    @Test
    public void test9(){
        String content = "{\n" +
                "  \"code\": \"200\",\n" +
                "  \"msg\": \"返回描述\",\n" +
                "  \"data\": [\n" +
                "    {\n" +
                "      \"id\": \"1\",\n" +
                "      \"name\": \"张三\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"2\",\n" +
                "      \"name\": \"李四\"\n" +
                "    }\n" +
                "  ]\n" +
                "}";

        if(StringUtils.isBlank(content)) {
            System.out.println(false);
        }
        StringUtils.isBlank(content);
        try {
            JSONObject jsonStr = JSONObject.parseObject(content);
            System.out.println(true);
        } catch (Exception e) {
            System.out.println(false);
        }
    }

    @Test
    public void test10(){
        String content = "{\n" +
                "  \"code\": \"200\",\n" +
                "  \"msg\": \"返回描述\",\n" +
                "  \"data\": [\n" +
                "    {\n" +
                "      \"id\": \"1\",\n" +
                "      \"name\": \"张三\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"2\",\n" +
                "      \"name\": \"李四\"\n" +
                "    }\n" +
                "  ]\n" +
                "}";
        JSONObject jsonStr = JSONObject.parseObject(content);
        Map<String, Object> map = new HashMap<>(16);
        Iterator<Map.Entry<String, Object>> iterator = jsonStr.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Object> entry = iterator.next();
            map.put(entry.getKey(), entry.getValue());
        }
        System.out.println(map);
    }


    @Test
    public void testFastJson(){
        List<Map<String,Object>> listMap = new ArrayList<>();
        String jsonStr = " [\n" +
                "        {\n" +
                "            \"id\": 1,\n" +
                "            \"name\": \"张三\",\n" +
                "            \"age\": 13\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": 2,\n" +
                "            \"name\": \"李四\",\n" +
                "            \"age\": 14\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": 3,\n" +
                "            \"name\": \"王五\",\n" +
                "            \"age\": 25\n" +
                "        }\n" +
                "    ]";
       listMap = JSON.parseObject(jsonStr,new TypeReference<List<Map<String,Object>>>(){});

//        data = Collections.singletonList(JSONObject.parse(jsonStr).toJavaObject(Map.class));
        String[] array = (String[]) listMap.toArray(new String[listMap.size()]);
        System.out.println(array);
        List<ReaderData> readerDataList = new ArrayList<>();

        for (Map datum : listMap) {
            System.out.println(datum.get("id"));
            ReaderData readerData = new ReaderData((Integer) datum.get("id"),(String) datum.get("name"),(Integer) datum.get("age"));
            readerDataList.add(readerData);
        }

        System.out.println(listMap);
        System.out.println(readerDataList);
    }


    @Test
    public void testColumn(){
        List<Map<String,Object>> listMap = new ArrayList<>();
        String jsonStr = " [\n" +
                "        {\n" +
                "            \"id\": 1,\n" +
                "            \"name\": \"张三\",\n" +
                "            \"age\": 13\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": 2,\n" +
                "            \"name\": \"李四\",\n" +
                "            \"age\": 14\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": 3,\n" +
                "            \"name\": \"王五\",\n" +
                "            \"age\": 25\n" +
                "        }\n" +
                "    ]";
        listMap = JSON.parseObject(jsonStr,new TypeReference<List<Map<String,Object>>>(){});

        List<String> columnList = new ArrayList<>();
        columnList.add("id");
        columnList.add("name");
        columnList.add("age");


        LinkedList<Object> linkedList = new LinkedList<>();
        for (Map<String, Object> datum : listMap) {
            for (String column : columnList) {
                linkedList.add(datum.get(column));
            }
        }

        System.out.println(linkedList);
    }



    @Test
    public void testExcel() throws IOException {
        List<UserTable> userTables = userTableMapper.selectList(null);
        Map<String,Object> map = new HashMap<>();
        map.put("data",userTables);
        excelUtil.exportExcel("template.xlsx","C:\\Users\\rh\\Desktop\\demo\\demoTemplate.xlsx",map);
    }


}

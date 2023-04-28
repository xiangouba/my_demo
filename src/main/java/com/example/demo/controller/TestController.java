package com.example.demo.controller;


import com.alibaba.fastjson2.JSONObject;
import com.example.demo.service.IDemoService;
import com.example.demo.util.Result;
import com.example.demo.util.Sm4Util;
import com.example.demo.vo.DemoVO;
import com.example.demo.vo.DemoVO2;
import com.example.demo.vo.RequestVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


/**
 * @Author gxx
 * @Date 2023年02月20日08时35分
 */
@RestController
@RequestMapping("/controller")
public class TestController {

    @Autowired
    private IDemoService demoService;

    @PostMapping("/test")
    public void test(@RequestBody DemoVO a){
        System.out.println(a);
        System.out.println("-=-=-=-=-=-=-=");
    }


    @PostMapping("/test1")
    public String test(@RequestBody DemoVO2 demoVO2){
        System.out.println(demoVO2);
        return demoVO2.toString();
    }


    @PostMapping("/test/result")
    public Result testResult(@RequestBody String requestVOStr){
        String str = Sm4Util.decryptEcb(requestVOStr);
        RequestVO requestVO = JSONObject.parseObject(str,RequestVO.class);
        requestVO.setCode(200);

        List<RequestVO> requestVOList = new ArrayList<>();
        RequestVO re = new RequestVO();
        re.setCompanyName("A公司");
        re.setUrl("http://fsdfskdj");
        re.setSource("fdd");
        re.setInterType("type");
        re.setCode(200);
        requestVOList.add(re);
        requestVOList.add(requestVO);
        String a = JSONObject.toJSONString(requestVOList);
        System.out.println(a);
        String data = Sm4Util.encryptEcb(a);
        System.out.println(data);
        //
        return Result.success(data);
//        return Result.success(demoService.getData(id));
    }
}

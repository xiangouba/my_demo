package com.example.demo.util;

/**
 * @Author gxx
 * @Date 2023年04月06日13时58分
 */
public class Error {
    private Integer code;
    private String msg;

    private Error(Integer code,String msg){
        this.code = code;
        this.msg = msg;
    }

    //静态常常用异常
    public static Error ERROR_1 = new Error(400,"标准异常1——系统访问失败");
    public static Error ERROR_2 = new Error(500,"标准错误2——系统内部错误");

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}

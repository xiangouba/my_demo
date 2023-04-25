package com.example.demo.util;

/**
 * @Author gxx
 * @Date 2023年04月06日13时49分
 */
public class Result <T> {
    private Integer code;
    private String msg;
    private T data;


    public static <T> Result<T> success(T data) {
        return new Result<T>(data);
    }


    public static <T> Result<T> error(String msg) {
        return new Result<T>(msg);
    }

    public static <T> Result<T> error() {
        return new Result<T>("error");
    }

    public Result(T data) {
        this.code = 200;
        this.msg = "success";
        this.data = data;
    }

    private Result() {
        this.code = 200;
        this.msg = "success";
    }

    private Result(String msg) {
        this.code = 400;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public T getData() {
        return data;
    }

    public static <T> Result<T> error(Error error){
        return new Result<T>(error);
    }

    private Result(Error error){
        if (error == null){
            return;
        }
        this.code = error.getCode();
        this.msg = error.getMsg();
    }
}

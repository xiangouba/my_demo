package com.example.demo.vo;

import lombok.Data;

/**
 * @Author gxx
 * @Date 2023年04月07日11时10分
 */
@Data
public class RequestVO {
    private Integer code;
    private String source;
    private String interType;
    private String url;
    private String companyName;
}

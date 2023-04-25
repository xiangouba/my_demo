package com.example.demo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.rmi.Naming;

/**
 * @Author gxx
 * @Date 2023年03月13日16时32分
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReaderData {
    private Integer id;
    private String name;
    private Integer age;
}

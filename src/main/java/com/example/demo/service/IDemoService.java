package com.example.demo.service;

import com.example.demo.vo.ReaderData;
import com.example.demo.vo.UserTable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author gxx
 * @Date 2023年04月06日14时06分
 */
public interface IDemoService {

    /**
     * @param idList 参数id
     * 查询id对应的对象
     * @return 对象
     */
    public ReaderData getData(Integer id);

    public UserTable getUser(String userName);
}

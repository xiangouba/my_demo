package com.example.demo.vo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;


/**
 * @Author gxx
 * @Date 2023年02月20日09时21分
 */
@Data
public class DemoVO {
    private Integer insuretype;
    private String partnerCode;
    private String passTime;
    private String params;
}

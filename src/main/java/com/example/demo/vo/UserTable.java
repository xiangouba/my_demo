package com.example.demo.vo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
* 用户表
* @TableName user_table
*/
@Data
public class UserTable implements Serializable {

    /**
    * 主键id
    */
    private Long userId;
    /**
    * 用户名
    */
    private String userName;
    /**
    * 正式姓名
    */
    private String userFullName;
    /**
    * 密码
    */
    private String passWord;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 手机号
     */
    private String phoneNumber;

    /**
     * 性别
     */
    private Integer sex;

    /**
     * 用户类型
     */
    private Integer userType;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 创建人
     */
    private String createName;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 更细人
     */
    private String updateName;
    
}

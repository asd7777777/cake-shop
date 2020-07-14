package com.three.shop.domain.entity;

import java.util.Date;
import lombok.Data;

/**
 * @author Administrator
 */
@Data
public class User {
    /**
    * 用户id,主键
    */
    private Integer userId;

    /**
    * 用户名
    */
    private String username;

    /**
    * 用户密码
    */
    private String password;

    /**
    * 用户邮箱
    */
    private String email;

    /**
    * 用户电话号码
    */
    private String phone;

    /**
    * 创建时间
    */
    private Date createTime;

    /**
    * 用户状态 1代表正常,0代表禁用
    */
    private Integer status;
}
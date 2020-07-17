package com.three.shop.domain.dto;

import lombok.Data;

import java.util.Date;
@Data
public class AdminDto {
    /**
     * 管理员主键
     */
    private Integer adminId;

    /**
     * 管理员姓名
     */
    private String adminName;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 状态 0表示冻结 1表示未冻结
     */
    private Integer status;

    /**
     * 加入时间
     */
    private Date createTime;
}

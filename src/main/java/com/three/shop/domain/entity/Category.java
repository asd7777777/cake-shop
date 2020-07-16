package com.three.shop.domain.entity;

import lombok.Data;

import java.util.Date;

/**
* Description：类别
*
* @author sheng
* @date 2020/7/15 19:50
* @since JDK 1.8
*/
@Data
public class Category {
    /**
    * 类别 id
    */
    private Integer categoryId;

    /**
    * 类别名
    */
    private String categoryName;

    /**
    * 创建时间
    */
    private Date createTime;

    /**
    * 修改时间
    */
    private Date updateTime;

    /**
    * 状态，默认为1使用状态，0为假删除
    */
    private Integer status;
}
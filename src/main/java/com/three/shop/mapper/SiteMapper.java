package com.three.shop.mapper;

import com.three.shop.domain.entity.Site;
import com.three.shop.domain.entity.User;
import org.apache.ibatis.annotations.Param;

import java.awt.*;

public interface SiteMapper {
    //查询
    Site selectById( int id);
    //添加
    int insert( Site site);
    //更新
    int update(@Param("site") Site site);
}
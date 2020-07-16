package com.three.shop.mapper;

import com.three.shop.domain.entity.Site;
import com.three.shop.domain.entity.User;
import com.three.shop.exception.DaoException;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface SiteMapper {
    //查询
   List<Site>  selectById(@Param("id") int id) throws DaoException;
    //添加
    int add( Site site);

//    int update(@Param("site") Site site);
    int update(@Param("site") List<Integer> site) throws DaoException;
}
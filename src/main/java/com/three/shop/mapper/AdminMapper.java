package com.three.shop.mapper;

import com.three.shop.domain.entity.Admin;
import com.three.shop.domain.entity.Site;
import com.three.shop.exception.DaoException;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdminMapper {

    List<Admin> selectById(@Param("id") int id) throws DaoException;

    //添加
    int add( Admin admin);


}
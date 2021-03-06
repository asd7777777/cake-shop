package com.three.shop.service;

import com.three.shop.domain.dto.SiteDto;

import com.three.shop.domain.entity.Site;

import java.util.List;
public interface SiteService {
    //添加
    int add(SiteDto siteDto);
    //查询
    List<Site> list(int id);
    //删除
    int delete(List<Integer> ids);
}

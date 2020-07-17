package com.three.shop.service;

import com.three.shop.domain.dto.SiteDto;
import com.three.shop.domain.entity.Admin;
import com.three.shop.domain.entity.Site;

import java.util.List;


public interface AdminService {
    //查询
    List<Admin> list(int id);
    // 添加
    int add(Admin admin);

}

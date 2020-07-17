package com.three.shop.service.impl;

import com.three.shop.domain.entity.Admin;
import com.three.shop.mapper.AdminMapper;
import com.three.shop.service.AdminService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class AdminServiceimpl implements AdminService {

    @Resource
    AdminMapper adminMapper;

    @Override
    public List<Admin> list(int id) {


        return adminMapper.selectById(id);
    }


    @Override
    public int add(Admin admin) {

        return 0;
    }
}

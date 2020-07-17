package com.three.shop.controller;

import com.three.shop.domain.dto.AdminDto;
import com.three.shop.domain.dto.SiteDto;
import com.three.shop.domain.entity.Admin;
import com.three.shop.domain.entity.Site;
import com.three.shop.service.AdminService;
import com.three.shop.service.SiteService;
import com.three.shop.utils.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/admin")
    public class AdminController {
    @Resource
    AdminService adminService;

    /**
     * 查询管理员
     *
     */
    @GetMapping("/list2")
    public ResponseEntity<List<Admin>> list(@PathVariable() int id){
        List<Admin> list = adminService.list(id);
        return ResponseEntity.success(list);
    }
    /**
     *修改管理员信息
     *
     */
    @PutMapping("/update2")
    public ResponseEntity<List<AdminDto>> update(Admin admin)  {
        adminService.add(admin);

        return null;
    }
}

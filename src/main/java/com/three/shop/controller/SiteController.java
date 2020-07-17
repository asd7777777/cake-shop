package com.three.shop.controller;

import com.three.shop.domain.dto.SiteDto;
import com.three.shop.domain.entity.Site;
import com.three.shop.exception.ServiceException;
import com.three.shop.service.SiteService;
import com.three.shop.utils.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.security.Provider;
import java.util.List;

    @RestController
    @RequestMapping("/Site")
    public class SiteController  {
    @Resource
    SiteService siteService;

    /**
     * 查询站点信息
     *
     */
    @GetMapping("/list/{id}")
    public ResponseEntity<List<Site>> list(@PathVariable() int id){
    List<Site> list = siteService.list(id);

    return ResponseEntity.success(list);
}


    /**
     *修改站点信息
     *
     */
    @PutMapping("/update")
    public ResponseEntity<List<SiteDto>> update( SiteDto siteDto)  {
        siteService.add(siteDto);

        return null;
    }

}

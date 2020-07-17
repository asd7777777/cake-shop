package com.three.shop.service.impl;


import com.three.shop.domain.dto.SiteDto;
import com.three.shop.domain.entity.Site;
import com.three.shop.mapper.SiteMapper;
import com.three.shop.service.SiteService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SiteServiceimpl implements SiteService {

    @Resource
    SiteMapper siteMapper;
    //添加
    @Override
    public int add(SiteDto siteDto) {
        Site site = new Site();
        site.setSiteDep(siteDto.getSitedep());
        site.setUsername(siteDto.getUsername());
        site.setKeyword(siteDto.getKeyword());
        site.setIcp(siteDto.getIcp());
        site.setCompanyName(siteDto.getCompanyname());
        site.setEamil(siteDto.getEamil());
        site.setPhone(site.getPhone());
        site.setStatus(site.getStatus());
        site.setHint(site.getHint());

        return siteMapper.add(site);
}
    //查询
    @Override
    public List<Site> list(int id) {
        return  siteMapper.selectById(id);
    }
    //删除
    @Override
    public int delete(List<Integer> ids) {
        return siteMapper.update(ids);
    }

}

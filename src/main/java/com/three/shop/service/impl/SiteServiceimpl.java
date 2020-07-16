package com.three.shop.service.impl;

import com.three.shop.mapper.SiteMapper;
import com.three.shop.service.SiteService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SiteServiceimpl extends SiteService {

    @Resource
    SiteMapper siteMapper;

}

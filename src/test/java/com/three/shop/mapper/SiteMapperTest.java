package com.three.shop.mapper;

import com.three.shop.domain.dto.SiteDto;
import com.three.shop.domain.dto.UserDto;
import com.three.shop.domain.entity.Site;
import com.three.shop.domain.entity.User;
import com.three.shop.service.SiteService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-context.xml","classpath:spring-mybatis.xml","classpath:spring-tx.xml"})
public class SiteMapperTest {
    @Resource
    SiteService siteService;

    @Test
    public void selectById() {
        Site site = new Site();
        site.setUsername("王麻子");
        site.setEamil("秦叔宝");
        site.setPhone("888");



    }

    @Test
    public void insert() {
    }

    @Test
    public void update() {
    }
}
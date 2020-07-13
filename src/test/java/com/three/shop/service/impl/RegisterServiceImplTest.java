package com.three.shop.service.impl;

import com.three.shop.domain.dto.RegisterDto;
import com.three.shop.exception.ServiceException;
import com.three.shop.service.RegisterService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-context.xml","classpath:spring-mybatis.xml","classpath:spring-tx.xml"})
public class RegisterServiceImplTest {
    @Resource
    RegisterService registerService;
    @Test
    public void register() throws ServiceException {
        RegisterDto registerDto = new RegisterDto();
        registerDto.setUsername("张三");
        registerDto.setPassword("123456789");
        registerDto.setEmail("123@123.com");
        registerDto.setPhone("1233525244");
        int register = registerService.register(registerDto);
    }
}
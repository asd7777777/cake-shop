package com.three.shop.service.impl;

import com.three.shop.domain.dto.LoginDto;
import com.three.shop.domain.entity.User;
import com.three.shop.exception.ServiceException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-context.xml", "classpath:spring-mybatis.xml", "classpath:spring-tx.xml"})
public class LoginServiceTest {
    @Resource
    LoginService loginService;
    @Test
    public void selectByNameAndPhoneAndEmailService() throws ServiceException {
        LoginDto loginDto = new LoginDto();
        loginDto.setUsername("张三");
        loginDto.setPassword("123456789");
        User user = loginService.selectByNameAndPhoneAndEmailService(loginDto);
    }
}

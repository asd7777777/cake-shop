package com.three.shop.controller;

import com.three.shop.domain.dto.LoginDto;
import com.three.shop.domain.dto.RegisterDto;
import com.three.shop.domain.entity.User;
import com.three.shop.exception.ServiceException;
import com.three.shop.service.RegisterService;
import com.three.shop.service.impl.LoginService;
import com.three.shop.utils.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Administrator
 */
@RestController
public class UserController {
    @Resource
    RegisterService registerService;
    @Resource
    LoginService loginService;
    @PostMapping("/register")
    public ResponseEntity<Integer> registerController(RegisterDto registerDto) throws ServiceException {
        int count = registerService.register(registerDto);
        return ResponseEntity.success(count);
    }
    @PostMapping("/login")
    public ResponseEntity<User> loginController(LoginDto loginDto) throws ServiceException {
        User user = loginService.selectByNameAndPhoneAndEmailService(loginDto);
        return ResponseEntity.success(user);
    }
}

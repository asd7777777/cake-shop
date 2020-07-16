package com.three.shop.controller;

import com.three.shop.domain.dto.LoginDto;
import com.three.shop.domain.dto.RegisterDto;
import com.three.shop.domain.entity.User;
import com.three.shop.exception.ServiceException;
import com.three.shop.service.RegisterService;
import com.three.shop.service.LoginService;
import com.three.shop.utils.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

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
    public ResponseEntity<Integer> registerController(@RequestBody RegisterDto registerDto) throws ServiceException {
        int count = registerService.register(registerDto);
        return ResponseEntity.success(count);
    }
    @GetMapping("/login")
    public ResponseEntity<LoginDto> loginController(LoginDto loginDto, HttpSession session) throws ServiceException {
        LoginDto loginDto1 = loginService.selectByNameAndPhoneAndEmailService(loginDto);
        loginDto1.setPassword(null);
        session.setAttribute("LoginDto", loginDto);
        return ResponseEntity.success(loginDto1);
    }
}

package com.three.shop.service.impl;

import com.three.shop.domain.dto.LoginDto;
import com.three.shop.domain.entity.User;
import com.three.shop.exception.ServiceException;
import com.three.shop.mapper.UserMapper;
import com.three.shop.utils.Status;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Administrator
 */
@Service
public class LoginServiceImpl implements LoginService{
    @Resource
    UserMapper userMapper;
    @Override
    public User selectByNameAndPhoneAndEmailService(LoginDto loginDto) throws ServiceException {
        User user = new User();
        BeanUtils.copyProperties(loginDto, user);
        User user1 = userMapper.selectByNameAndPhoneAndEmail(user);
        if (!user1.getPassword().equals(loginDto.getPassword())) {
            throw new ServiceException(Status.SERVICE_ERROR3);
        }
        return user1;
    }
}

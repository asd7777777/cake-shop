package com.three.shop.service.impl;

import com.three.shop.domain.dto.LoginDto;
import com.three.shop.domain.entity.User;
import com.three.shop.exception.ServiceException;

/**
 * @author Administrator
 */
public interface LoginService {
    /**
     * 根据用户传入的电话号码或者邮箱或者用户名查询,完成登录功能
     * @param loginDto 封装参数
     * @return 返回查询到的对象
     */
    User selectByNameAndPhoneAndEmailService(LoginDto loginDto) throws ServiceException;
}

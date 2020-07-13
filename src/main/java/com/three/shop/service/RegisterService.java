package com.three.shop.service;

import com.three.shop.domain.dto.RegisterDto;
import com.three.shop.exception.ServiceException;


/**
 * @author Administrator
 */
public interface RegisterService {
    /**
     * * 注册用户功能
     * @param registerDto  用户的注册内容
     * @return 返回影响行数
     * @throws ServiceException 抛出数据层异常,由全局异常捕获
     */
    int register(RegisterDto registerDto) throws ServiceException;
}

package com.three.shop.service.impl;

import com.three.shop.domain.dto.UserDto;
import com.three.shop.domain.entity.User;
import com.three.shop.exception.ServiceException;
import com.three.shop.mapper.UserMapper;
import com.three.shop.service.RegisterService;
import com.three.shop.utils.Status;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Administrator
 */
@Service
public class RegisterServiceImpl implements RegisterService {
    @Resource
    UserMapper userMapper;
    @Override
    public int register(UserDto userDto) throws ServiceException{
        User user = new User();
//        转换成User对象
        BeanUtils.copyProperties(userDto, user);
//        根据用户名查询数据库内是否存在该用户
        User user1 = userMapper.selectByUsername(userDto.getUsername());
//        根据用户电话号码查询数据库内是否存在该用户
        User user2 = userMapper.selectByPhone(userDto.getPhone());
//        根据用户邮箱查询数据库内是否存在该用户
        User user3 = userMapper.selectByEmail(userDto.getEmail());
        int count = 0;
        if (user1 == null){
            if (user2 == null) {
                if (user3 == null) {
                    count = userMapper.insert(user);
                }else {
                    throw new ServiceException(Status.SERVICE_ERROR2);
                }
            }else {
                throw new ServiceException(Status.SERVICE_ERROR2);
            }
        }else {
            throw new ServiceException(Status.SERVICE_ERROR2);
        }

        return count;
    }
}

package com.three.shop.mapper;

import com.three.shop.domain.entity.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    int deleteByPrimaryKey(Integer userId);

    /**
     * 添加用户
     * @param record 用户内容
     * @return 返回影响行数
     */
    int insert(User record);

    int insertSelective(User record);

    /**
     * 根据用户id来查询用户
     * @param userId
     * @return
     */
    User selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    /**
     * 根据用户名查询用户
     * @param username  用户名
     * @return 返回查询到的结果
     */
    User selectByUsername(@Param("username") String username);

    /**
     * 根据用户电话号码查询用户
     * @param phone 用户电话号码
     * @return 返回查询到的用户
     */
    User selectByPhone(@Param("phone") String phone);

    /**
     * 根据用户的邮箱查询用户
     * @param email 用户邮箱
     * @return
     */
    User selectByEmail(@Param("email") String email);

    /**
     * 根据用户名或者邮箱或者手机号码查询用户
     * @param user
     * @return
     */
    User selectByNameAndPhoneAndEmail(@Param("user") User user);
}
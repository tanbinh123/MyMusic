package com.wufu.music.Dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author wufu
 * @date 2021/1/18 22:04
 */
@Mapper
public interface LoginMapper {

    /**
     * 登陆验证
     * @param userName 用户名
     * @param password 密码
     * @return 返回满足条件的用户数量
     */
    public int verifyLogin(@Param("user_name") String userName,
                           @Param("password") String password);

    /**
     * 获取 userId
     * @param userName 用户名
     * @param password 密码
     * @return 返回 userId
     */
    public int getUserId(@Param("user_name")String userName,
                         @Param("password")String password);
}

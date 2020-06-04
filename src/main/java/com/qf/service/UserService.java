package com.qf.service;

import com.qf.pojo.SysUser;
import org.apache.ibatis.annotations.Param;

/**
 * @author 炜哥哥
 * @date 2020/1/13 15:47
 */

public interface UserService {
    SysUser clickLogin(String tel);

    //注册用户
    Integer addUserByregister(SysUser sysUser);
    //修改Tel
    Integer  updateTel(@Param("userId") Integer userId, @Param("tel")String tel);

    //查询用户
    SysUser findUserById(Integer id);

    //修改Email
    Integer  updateEmail(@Param("userId") Integer userId, @Param("email")String email);


    //修改个人密码
    Integer  updatePwd(@Param("userId") Integer userId, @Param("password")String password);

}

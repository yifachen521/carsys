package com.qf.dao;

import com.qf.pojo.SysUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author 炜哥哥
 * @date 2020/1/13 15:33
 */
@Repository
public interface UserDao {

    //验证登录
    SysUser clickLogin(String tel);

    //查询用户
    SysUser findUserById(Integer id);
    //注册用户
    Integer addUserByregister(SysUser sysUser);

    //修改手机号
    Integer  updateTel(@Param("userId") Integer userId, @Param("tel")String tel);

    //修改Email
    Integer  updateEmail(@Param("userId") Integer userId, @Param("email")String email);


    //修改个人密码
    Integer  updatePwd(@Param("userId") Integer userId, @Param("password")String password);


}

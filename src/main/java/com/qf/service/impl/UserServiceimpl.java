package com.qf.service.impl;

import com.qf.dao.UserDao;
import com.qf.pojo.SysUser;
import com.qf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 炜哥哥
 * @date 2020/1/13 15:47
 */
@Service
public class UserServiceimpl implements UserService {
    @Autowired

    private UserDao userDao;


    //返回登录查询的结果
    @Override
    public SysUser clickLogin(String tel) {
        SysUser sysUser = userDao.clickLogin(tel);
        return sysUser;
    }

    @Override
    public Integer addUserByregister(SysUser sysUser) {

        return userDao.addUserByregister(sysUser);
    }

    @Override
    public Integer updateTel(Integer userId, String tel) {
        return userDao.updateTel(userId,tel);
    }

    @Override
    public SysUser findUserById(Integer id) {
        return userDao.findUserById(id);
    }

    @Override
    public Integer updateEmail(Integer userId, String email) {
        return userDao.updateEmail(userId,email);
    }

    @Override
    public Integer updatePwd(Integer userId, String password) {
        return userDao.updatePwd(userId,password);
    }
}

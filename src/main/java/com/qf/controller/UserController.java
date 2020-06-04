package com.qf.controller;

import com.qf.pojo.SysUser;
import com.qf.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

/**
 * @author 炜哥哥
 * @date 2020/1/13 14:38
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


    /**
     * 去登陆
     *
     * @return
     */
    @RequestMapping("/gologin")
    public String gologin() {
        return "pagehome/login";
    }

    /**
     * 验证登录
     *
     * @return
     */
    @RequestMapping("/chickLogin")
    @ResponseBody
    public String chickLogin(String tel, String password, HttpServletRequest request, Model model) {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(tel, password);
        try {
            subject.login(token);
            SysUser sysUser = userService.clickLogin(tel);
            request.getSession().setAttribute("sysUser",sysUser);
            return "1";
        }catch (UnknownAccountException e){
            model.addAttribute("msg","账户不对");
            return "2";
        } catch(IncorrectCredentialsException e) {
            model.addAttribute("msg","密码不对");
            return "2";
        }catch(AuthenticationException e) {
            e.printStackTrace();
            return "2";
        }
    }

    //登录成功跳转页面
    @RequestMapping("/loginsuccess")
    public String loginsuccess(HttpServletRequest request) {
        return "pagehome/loginsuccess";
    }

    //去注册
    @RequestMapping("/register")
    public String register() {

        return "pagehome/register";
    }

    //注册提交数据
    @RequestMapping("/addUserByregister")
    @ResponseBody
    public String addUserByregister(SysUser sysUser, HttpServletRequest request) {
        //注册成功的话 就把信息放入session中
        Integer integer = userService.addUserByregister(sysUser);
        Integer userId = sysUser.getId();
        System.out.println(userId+"1111----");//返回的就是刚刚插入的自增长的id的值
        if (integer == 1) {
            //注册成功
            //再查出来
            SysUser sysUser1 = userService.clickLogin(sysUser.getTel());
            request.getSession().setAttribute("sysUser", sysUser1);
            return "1";
        }
        return "111";

    }

    //退出
/*    @RequestMapping("/logout")
    public String logout(HttpServletRequest request) {
        //清空session  跳转未登录的首页
        request.getSession().invalidate();
        return "pagehome/index";
    }*/

    //忘记密码
    @RequestMapping("/backPass")
    public String backPass() {
        return "";
    }

    //判断用户是否登录
    @ResponseBody
    @RequestMapping("/denglu")
    public String denglu(HttpServletRequest request) {
        SysUser sysUser = (SysUser) request.getSession().getAttribute("sysUser");
        if (sysUser != null) {
            return "1";
        }
        return "0";
    }

    //个人zhongxin
    @RequestMapping("/myinfo")
    public String myinfo() {

        return "/mymain/myinfo";
    }


    @RequestMapping("/mymsg")
    @ResponseBody
    public HashMap<String, Object> mymsg(HttpServletRequest request) {

        SysUser sysUser = (SysUser) request.getSession().getAttribute("sysUser");
        //查一下
        SysUser userById = userService.findUserById(sysUser.getId());
        //回写信息
        HashMap<String, Object> data = new HashMap<>();
        data.put("code", "1");
        data.put("tel", userById.getTel());
        data.put("email", userById.getEmail());
        return data;
    }


    //修改手机号
    @RequestMapping("/updateTel")
    @ResponseBody
    public String updateTel(String tel, HttpServletRequest request) {
        SysUser sysUser = (SysUser) request.getSession().getAttribute("sysUser");
        Integer userId = sysUser.getId();
        userService.updateTel(userId, tel);
        String res = "1";
        return res;
    }

    //修改邮箱
    @RequestMapping("/updateEmail")
    public String updateEmail(String email, HttpServletRequest request) {
        SysUser sysUser = (SysUser) request.getSession().getAttribute("sysUser");
        Integer userId = sysUser.getId();
        System.out.println(email + "22-------");
        userService.updateTel(userId, email);
        return "riderict:/user/myinfo";
    }


}

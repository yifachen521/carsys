package com.qf.config;

import com.qf.realm.MyRealm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * @author 炜哥哥
 * @date 2020/1/16 8:25
 */
@Configuration
public class ShiroConfig {

    //1.创建myRealm
    @Bean
    public MyRealm getMyRealm() {
        return new MyRealm();
    }

    //2.创建 DefaultWebSecurityManager
    @Bean
    public DefaultWebSecurityManager getDefaultWebSecurityManager(){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        //引入自定义的myRealm
        securityManager.setRealm(getMyRealm());
        return securityManager;
    }
    //3. ShiroFilterFactoryBean
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        //设置安全管理器
        shiroFilterFactoryBean.setSecurityManager(getDefaultWebSecurityManager());

        //添加shiro的内置过滤器
        //设置请求登录的路径 如果未设置就让他去到登录 (没登录点啥都是去到登录界面)
        shiroFilterFactoryBean.setLoginUrl("/user/gologin");

        //设置拦截的路径的map集合
        HashMap<String, String> stringStringHashMap = new LinkedHashMap<>();
        //设置默认不拦截的路径
        //放行所有静态资源
        stringStringHashMap.put("/css/**","anon");
        stringStringHashMap.put("/fonts/**","anon");
        stringStringHashMap.put("/images/**","anon");
        stringStringHashMap.put("/js/**","anon");
        stringStringHashMap.put("/layui/**","anon");

       //去登录  不拦
        stringStringHashMap.put("/user/gologin","anon");
        //登录信息提交
        stringStringHashMap.put("/user/chickLogin","anon");
        //注册提交信息
        stringStringHashMap.put("/user/addUserByregister","anon");

        //首页不拦
        stringStringHashMap.put("/","anon");
        stringStringHashMap.put("/test1","anon");
        //注册不拦
        stringStringHashMap.put("/user/register","anon");

        //退出认证
        stringStringHashMap.put("/user/logout","logout");

        //设置拦截的路径
        stringStringHashMap.put("/**","authc");
        stringStringHashMap.put("/user/**","authc");
        stringStringHashMap.put("/order/**","authc");
        stringStringHashMap.put("/shortRent/**","authc");
        stringStringHashMap.put("/pagehome/**","authc");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(stringStringHashMap);
        return shiroFilterFactoryBean;
    }

}

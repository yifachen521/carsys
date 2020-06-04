package com.qf.pojo;

import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @author 炜哥哥
 * @date 2020/1/13 14:05
 */
@Component
public class SysUser implements Serializable {


    private Integer id;
    private  String tel;
    private  String password;
    private  String email;
    private  String invitation;

    @Override
    public String toString() {
        return "SysUser{" +
                "id=" + id +
                ", tel='" + tel + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", invitation='" + invitation + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getInvitation() {
        return invitation;
    }

    public void setInvitation(String invitation) {
        this.invitation = invitation;
    }
}

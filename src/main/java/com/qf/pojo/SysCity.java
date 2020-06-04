package com.qf.pojo;

import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @author 炜哥哥
 * @date 2020/1/13 14:02
 */
@Component
public class SysCity implements Serializable {
    private  Integer id;
    private  String name;
    private  Integer pid;

    @Override
    public String toString() {
        return "SysCity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pid=" + pid +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }
}

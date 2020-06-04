package com.qf.pojo;

import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @author 炜哥哥
 * @date 2020/1/13 12:00
 */
@Component
public class SysCar implements Serializable {
    private Integer id;
    private String name;
    private String type;
    private Integer sitnum;
    private Integer cid;
    private Double price;
    private Integer number;
    private String picture;

    @Override
    public String toString() {
        return "SysCar{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", sitnum=" + sitnum +
                ", cid=" + cid +
                ", price=" + price +
                ", number=" + number +
                ", picture='" + picture + '\'' +
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getSitnum() {
        return sitnum;
    }

    public void setSitnum(Integer sitnum) {
        this.sitnum = sitnum;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}
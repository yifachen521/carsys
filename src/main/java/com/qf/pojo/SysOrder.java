package com.qf.pojo;

import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @author 炜哥哥
 * @date 2020/1/13 14:03
 */
@Component
public class SysOrder implements Serializable {

    private Integer id;
    private Integer cid;
    private Integer uid;
    private Integer getid;
    private Integer backid;
    private Double oprice;
    private  String status;

    public SysOrder() {
    }

    public SysOrder(Integer id, Integer cid, Integer uid, Integer getid, Integer backid, Double oprice) {
        this.id = id;
        this.cid = cid;
        this.uid = uid;
        this.getid = getid;
        this.backid = backid;
        this.oprice = oprice;

    }

    @Override
    public String toString() {
        return "SysOrder{" +
                "id=" + id +
                ", cid=" + cid +
                ", uid=" + uid +
                ", getid=" + getid +
                ", backid=" + backid +
                ", oprice=" + oprice +
                ", status='" + status + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getGetid() {
        return getid;
    }

    public void setGetid(Integer getid) {
        this.getid = getid;
    }

    public Integer getBackid() {
        return backid;
    }

    public void setBackid(Integer backid) {
        this.backid = backid;
    }

    public Double getOprice() {
        return oprice;
    }

    public void setOprice(Double oprice) {
        this.oprice = oprice;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

package com.qf.pojo;

import org.springframework.stereotype.Component;

/**
 * @author 炜哥哥
 * @date 2020/1/14 16:37
 */
@Component
public class Order {

    private Integer oid;
    private Double oprice;
    private String cname;
    private String getcity;
    private String backcity;
    private String ostatus;

    @Override
    public String toString() {
        return "Order{" +
                "oid=" + oid +
                ", oprice=" + oprice +
                ", cname='" + cname + '\'' +
                ", getcity='" + getcity + '\'' +
                ", backcity='" + backcity + '\'' +
                ", ostatus='" + ostatus + '\'' +
                '}';
    }

    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }

    public Double getOprice() {
        return oprice;
    }

    public void setOprice(Double oprice) {
        this.oprice = oprice;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getGetcity() {
        return getcity;
    }

    public void setGetcity(String getcity) {
        this.getcity = getcity;
    }

    public String getBackcity() {
        return backcity;
    }

    public void setBackcity(String backcity) {
        this.backcity = backcity;
    }

    public String getOstatus() {
        return ostatus;
    }

    public void setOstatus(String ostatus) {
        this.ostatus = ostatus;
    }
}

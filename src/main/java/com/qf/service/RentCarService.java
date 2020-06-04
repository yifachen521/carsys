package com.qf.service;

import com.qf.pojo.SysCar;
import com.qf.pojo.SysCity;

import java.util.List;

/**
 * @author 炜哥哥
 * @date 2020/1/13 20:06
 */
public interface RentCarService {
    List<SysCity> select1(Integer pid);
    List<SysCar> selectCar(Integer cid);

    //查询取还车 城市的名称
    SysCity getcheCity(Integer getid);


    SysCity backcheCity(Integer backid);

    List<SysCar> chooseCarPrice(Integer cid);

    List<SysCar> chooseCarSitNum(Integer cid);

}

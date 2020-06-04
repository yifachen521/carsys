package com.qf.dao;

import com.qf.pojo.SysCar;
import com.qf.pojo.SysCity;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 炜哥哥
 * @date 2020/1/13 19:12
 */
@Repository
public interface RentCarDao {

    //租车地址  集合
    List<SysCity> select1(Integer pid);

    //传入cid来查询该地区可租的所有的车型
    List<SysCar> selectCar(Integer cid);

    //查询取还车 城市的名称
    SysCity getcheCity(Integer getid);


    SysCity backcheCity(Integer backid);

    List<SysCar> chooseCarPrice(Integer cid);

    List<SysCar> chooseCarSitNum(Integer cid);
}

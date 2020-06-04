package com.qf.service;

import com.qf.pojo.Order;
import com.qf.pojo.SysCar;
import com.qf.pojo.SysOrder;

import java.util.List;

/**
 * @author 炜哥哥
 * @date 2020/1/14 11:25
 */
public interface OrderService {
    SysCar carInfo(Integer id);

    Integer addorder(SysOrder sysOrder);

    //查询订单总条数
    Integer findAllorder(Integer uid);

    List<Order> findMyOrder(Integer uid);

    Integer delOrderById(Integer oid);

}

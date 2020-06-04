package com.qf.dao;

import com.qf.pojo.Order;
import com.qf.pojo.SysCar;
import com.qf.pojo.SysOrder;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 炜哥哥
 * @date 2020/1/14 11:21
 */
@Repository
public interface OrderDao {
    //
    SysCar carInfo(Integer id);

    //添加订单
    Integer addorder(SysOrder sysOrder);

    //查询订单总条数
    Integer findAllorder(Integer uid);

    //查询我的订单

    List<Order> findMyOrder(Integer uid);

    //删除订单
    Integer delOrderById(Integer oid);
}

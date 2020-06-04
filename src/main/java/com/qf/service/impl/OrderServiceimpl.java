package com.qf.service.impl;

import com.qf.dao.OrderDao;
import com.qf.pojo.Order;
import com.qf.pojo.SysCar;
import com.qf.pojo.SysOrder;
import com.qf.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 炜哥哥
 * @date 2020/1/14 11:25
 */
@Service
public class OrderServiceimpl implements OrderService {

    @Autowired
    private OrderDao orderDao;
    @Override
    public SysCar carInfo(Integer id) {
        return orderDao.carInfo(id);
    }

    @Override
    public Integer addorder(SysOrder sysOrder) {
        return orderDao.addorder(sysOrder);
    }

    @Override
    public Integer findAllorder(Integer uid) {
        return orderDao.findAllorder(uid);
    }

    @Override
    public List<Order> findMyOrder(Integer uid) {
        return orderDao.findMyOrder(uid);
    }

    @Override
    public Integer delOrderById(Integer oid) {
        return orderDao.delOrderById(oid);
    }
}

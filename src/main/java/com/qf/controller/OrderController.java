package com.qf.controller;

import com.qf.pojo.Order;
import com.qf.pojo.SysCar;
import com.qf.pojo.SysOrder;
import com.qf.pojo.SysUser;
import com.qf.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

/**
 * @author 炜哥哥
 * @date 2020/1/14 11:01
 */
@RequestMapping("/order")
@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;


    //跳转订单页
    @RequestMapping("/ordersubmit")
    public String ordersubmit() {
        return "order/ordersubmit";
    }

    //车型信息
    @RequestMapping("/orderCarinfo")
    @ResponseBody
    public HashMap<String, Object> orderCarinfo(Integer cid) {
        //根据cid去查询车辆信息
        SysCar sysCar = orderService.carInfo(cid);

        HashMap<String, Object> data = new HashMap<>();
        data.put("code", "1");
        data.put("info", sysCar);
        return data;
    }

    //添加订单
    @RequestMapping("/add")
    @ResponseBody
    public Properties add(SysOrder sysOrder, HttpServletRequest request) {
        //用户id
        SysUser sysUser = (SysUser) request.getSession().getAttribute("sysUser");
        Integer uid = sysUser.getId();
        sysOrder.setUid(uid);
        sysOrder.setStatus("已预定");
        orderService.addorder(sysOrder);
        Properties data = new Properties();
        data.setProperty("info","success");
        return data;
    }

    //跳转我的订单
    @RequestMapping("/mymain")
    public String mymain() {
        return "mymain/mymain";
    }


    @RequestMapping("/all")
    @ResponseBody
    public HashMap<String,Object> all(Integer page,HttpServletRequest request){
        //用户id
        SysUser sysUser = (SysUser) request.getSession().getAttribute("sysUser");
        Integer uid = sysUser.getId();

        //查询我的订单的数据总条数
        Integer allorder = orderService.findAllorder(uid);

        //查询我的订单数据集合
        List<Order> myOrder = orderService.findMyOrder(uid);

        HashMap<String, Object> data = new HashMap<>();
        HashMap<String, Object> info = new HashMap<>();
        info.put("total",allorder);
        info.put("rows",myOrder);
        data.put("code","1");
        data.put("info",info);
        return data;
    }
    //删除订单
    @RequestMapping("/delOrderById")

    public  String delOrderById(Integer oid){

        orderService.delOrderById(oid);
        return "redirect:/order/mymain";

    }




}

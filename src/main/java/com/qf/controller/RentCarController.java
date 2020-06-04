package com.qf.controller;

import com.qf.pojo.SysCar;
import com.qf.pojo.SysCity;
import com.qf.service.RentCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;

/**
 * @author 炜哥哥
 * @date 2020/1/13 17:55
 */
@Controller
@RequestMapping("/shortRent")
public class RentCarController {

    @Autowired
    private RentCarService rentCarService;

    //去短租
    @RequestMapping("/shortrent")
    public String goshortrent() {
        //期间  还要查出来城市  二级联动
        return "shortRent/shortrent";
    }

    //回填借车地址下拉列表
    @RequestMapping("/select1")
    @ResponseBody
    public List<SysCity> select1(String pid) {
        //转换类型
        Integer pid1 = null;
        try {
            pid1 = Integer.parseInt(pid);
        } catch (Exception e) {
            //转型异常 说明未选择一级地址
            return null;
        }
        //查询集合
        List<SysCity> data = rentCarService.select1(pid1);
        //返回数据
        return data;
    }



    @RequestMapping("/chooseCarPrice")
    @ResponseBody
    public HashMap<String, Object> chooseCarPrice(Integer getid) {
        //根据传入的id来查找该地区所有可租的车型  按价格
        List<SysCar> info = rentCarService.chooseCarPrice(getid);
        HashMap<String, Object> data = new HashMap<>();
        data.put("code", "1");
        data.put("cars", info);
        return data;
    }


    //跳转预订车型
    @RequestMapping("/chooseCar")
    public String chooseCar() {
        return "shortRent/shortsort";
    }


    @RequestMapping("/chooseCarSitnum")
    @ResponseBody
    public HashMap<String, Object> chooseCarSitnum(Integer getid) {
        //根据传入的id来查找该地区所有可租的车型  按热度
        List<SysCar> info = rentCarService.chooseCarSitNum(getid);
        HashMap<String, Object> data = new HashMap<>();
        data.put("code", "1");
        data.put("info", info);
        return data;
    }

    //跳转选车 回填取车和还车地址
    @RequestMapping("/citys")
    @ResponseBody
    public HashMap<String, Object> dizhi(Integer getid, Integer backid) {

        //根据这两个id取查询城市的名字
        //取车地址
        SysCity getcheCity = rentCarService.getcheCity(getid);
        //还车地址
        SysCity backcheCity = rentCarService.backcheCity(backid);
        HashMap<String, Object> data = new HashMap<>();

        data.put("code", "1");
        data.put("getCity", getcheCity);
        data.put("backCity", backcheCity);
        return data;
    }


}

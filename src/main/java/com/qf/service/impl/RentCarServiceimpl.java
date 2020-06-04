package com.qf.service.impl;

import com.qf.dao.RentCarDao;
import com.qf.pojo.SysCar;
import com.qf.pojo.SysCity;
import com.qf.service.RentCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 炜哥哥
 * @date 2020/1/13 20:07
 */
@Service
public class RentCarServiceimpl implements RentCarService {
    @Autowired
    private RentCarDao rentCarDao;

    @Override
    public List<SysCity> select1(Integer pid) {

        return rentCarDao.select1(pid);
    }

    @Override
    public List<SysCar> selectCar(Integer cid) {

        return rentCarDao.selectCar(cid);
    }

    @Override
    public SysCity getcheCity(Integer getid) {
        return rentCarDao.getcheCity(getid);
    }

    @Override
    public SysCity backcheCity(Integer backid) {
        return rentCarDao.backcheCity(backid);
    }

    @Override
    public List<SysCar> chooseCarPrice(Integer cid) {
        return rentCarDao.chooseCarPrice(cid);
    }

    @Override
    public List<SysCar> chooseCarSitNum(Integer cid) {
        return rentCarDao.chooseCarSitNum(cid);
    }
}

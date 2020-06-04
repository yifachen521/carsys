package com.qf;

import com.qf.dao.OrderDao;
import com.qf.dao.UserDao;
import com.qf.pojo.SysOrder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CarsysApplicationTests {

    @Test
    void contextLoads() {
    }
@Autowired
    private UserDao userDao;

    @Test
    public  void test1(){
        userDao.updateTel(2,"11111");

    }
}

package com.qf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 炜哥哥
 * @date 2020/1/13 14:10
 */
@Controller

public class TestController {
    @RequestMapping(value={"/test1","/"})
    public  String test1(){
        return "pagehome/index";
    }
}

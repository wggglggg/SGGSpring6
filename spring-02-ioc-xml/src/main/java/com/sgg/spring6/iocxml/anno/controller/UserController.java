package com.sgg.spring6.iocxml.anno.controller;

import com.sgg.spring6.iocxml.anno.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * ClassName: UserController
 * Description:
 *
 * @Author wggglggg
 * @Create 2023/7/31 15:24
 * @Version 1.0
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;


    public void addUser(){
        System.out.println("controller方法执行了...");
        //调用service的方法
        userService.addUserService();
    }
}

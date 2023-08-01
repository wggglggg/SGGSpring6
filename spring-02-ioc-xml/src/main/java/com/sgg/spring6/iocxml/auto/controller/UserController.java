package com.sgg.spring6.iocxml.auto.controller;

import com.sgg.spring6.iocxml.auto.service.UserService;

/**
 * ClassName: UserController
 * Description:
 *
 * @Author wggglggg
 * @Create 2023/7/31 15:24
 * @Version 1.0
 */
public class UserController {

    private UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void addUser(){
        System.out.println("controller方法执行了...");
        //调用service的方法
        userService.addUserService();
    }
}

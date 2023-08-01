package com.sgg.spring6.iocxml.anno.service.impl;

import com.sgg.spring6.iocxml.anno.dao.UserDAO;
import com.sgg.spring6.iocxml.anno.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ClassName: UserServiceImpl
 * Description:
 *
 * @Author wggglggg
 * @Create 2023/7/31 15:23
 * @Version 1.0
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;


    @Override
    public void addUserService() {
        System.out.println("userService方法执行了...");
        userDAO.addUserDAO();;
    }
}

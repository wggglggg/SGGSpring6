package com.sgg.spring6.iocxml.jdbc.service.impl;

import com.sgg.spring6.iocxml.jdbc.dao.UserDAO;
import com.sgg.spring6.iocxml.jdbc.service.UserService;

/**
 * ClassName: UserServiceImpl
 * Description:
 *
 * @Author wggglggg
 * @Create 2023/7/31 15:23
 * @Version 1.0
 */
public class UserServiceImpl implements UserService {

    private UserDAO userDAO;

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public void addUserService() {
        System.out.println("userService方法执行了...");
        userDAO.addUserDAO();;
    }
}

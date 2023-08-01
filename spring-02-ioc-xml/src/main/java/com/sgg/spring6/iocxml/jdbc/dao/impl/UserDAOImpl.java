package com.sgg.spring6.iocxml.jdbc.dao.impl;

import com.sgg.spring6.iocxml.jdbc.dao.UserDAO;

/**
 * ClassName: UserDAOImpl
 * Description:
 *
 * @Author wggglggg
 * @Create 2023/7/31 15:21
 * @Version 1.0
 */
public class UserDAOImpl implements UserDAO {
    @Override
    public void addUserDAO() {
        System.out.println("userDao方法执行了...");

    }
}

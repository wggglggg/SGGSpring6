package com.sggspring6.service.impl;

import com.sggspring6.anno.Bean;
import com.sggspring6.anno.Di;
import com.sggspring6.dao.UserDAO;
import com.sggspring6.service.UserService;

/**
 * ClassName: UserServiceImpl
 * Description:
 *
 * @Author wggglggg
 * @Create 2023/7/30 19:09
 * @Version 1.0
 */
@Bean
public class UserServiceImpl implements UserService {

    @Di
    private UserDAO userDAO;

    @Override
    public void add() {
        System.out.println("in the UserServiceImpl");
        userDAO.add();
    }
}

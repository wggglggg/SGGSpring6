package com.sggspring6.dao.impl;

import com.sggspring6.anno.Bean;
import com.sggspring6.dao.UserDAO;

/**
 * ClassName: UserDAOImpl
 * Description:
 *
 * @Author wggglggg
 * @Create 2023/7/30 19:11
 * @Version 1.0
 */

@Bean
public class UserDAOImpl implements UserDAO {
    @Override
    public void add() {
        System.out.println("in the UserDAOImpl");
    }
}

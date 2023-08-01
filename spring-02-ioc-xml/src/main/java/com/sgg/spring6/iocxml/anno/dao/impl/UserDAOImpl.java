package com.sgg.spring6.iocxml.anno.dao.impl;


import com.sgg.spring6.iocxml.anno.dao.UserDAO;
import org.springframework.stereotype.Repository;

/**
 * ClassName: UserDAOImpl
 * Description:
 *
 * @Author wggglggg
 * @Create 2023/7/31 15:21
 * @Version 1.0
 */
@Repository
public class UserDAOImpl implements UserDAO {
    @Override
    public void addUserDAO() {
        System.out.println("userDao方法执行了...");

    }
}

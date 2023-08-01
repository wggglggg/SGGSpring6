package com.sgg.spring6.iocxml.jdbc;

import com.alibaba.druid.pool.DruidDataSource;
import com.sgg.spring6.iocxml.jdbc.controller.UserController;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * ClassName: TestUser
 * Description:
 *
 * @Author wggglggg
 * @Create 2023/7/31 15:26
 * @Version 1.0
 */
public class TestUser {

    @Test
    public void testAutoXml() throws SQLException {
        ApplicationContext context = new ClassPathXmlApplicationContext("jdbc.xml");
        DruidDataSource dataSource = context.getBean(DruidDataSource.class);
        System.out.println("dataSource = " + dataSource.getConnection());
    }
}

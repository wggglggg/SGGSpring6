package com.sgg.spring6.iocxml.anno;

import com.sgg.spring6.iocxml.anno.controller.UserController;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
    public void testAutoXml(){
        ApplicationContext context = new ClassPathXmlApplicationContext("anno.xml");
        UserController userController = context.getBean("userController", UserController.class);
        userController.addUser();
    }
}

package com.sgg.spring6;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * ClassName: TestUser
 * Description:
 *
 * @Author wggglggg
 * @Create 2023/7/31 15:03
 * @Version 1.0
 */
public class TestUser {
    
    @Test
    public void testUserObject(){
        //加载spring配置文件，对象创建
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");

        //获取创建的对象
        User user = (User) context.getBean("user");
        System.out.println("1:"+user);

        //使用对象调用方法进行测试
        System.out.print("2:");
        user.add();
    }
}

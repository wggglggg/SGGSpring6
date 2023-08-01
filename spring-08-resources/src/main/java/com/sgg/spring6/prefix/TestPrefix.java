package com.sgg.spring6.prefix;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * ClassName: TestPrefix
 * Description:
 *
 * @Author wggglggg
 * @Create 2023/8/1 8:53
 * @Version 1.0
 */
public class TestPrefix {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("prefixbean.xml");

        ResourceBean resourceBean = context.getBean("resourceBean", ResourceBean.class);
        resourceBean.showResource();
    }
}

package com.sgg.spring6.javai18n;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;
import java.util.Locale;

/**
 * ClassName: TestSpringi18n
 * Description:
 *
 * @Author wggglggg
 * @Create 2023/8/1 9:29
 * @Version 1.0
 */
public class TestSpringi18n {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("springi18n.xml");
        Object[] objects = {"username", new Date().toString()};

        // footbal为sport_zh_CN.properties文件内的key, objects为传入文件内{?}点位, Locale.CHINA为选择哪一个配置文件
        String footbal = context.getMessage("footbal", objects, Locale.CHINA);
        System.out.println("footbal = " + footbal);
    }
}

package com.sggspring6.test;

import com.sggspring6.anno_context.AnnotationApplicationContext;
import com.sggspring6.anno_context.ApplicationContext;
import com.sggspring6.service.UserService;
import org.junit.jupiter.api.Test;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Enumeration;

/**
 * ClassName: TestAnnotation
 * Description:
 *
 * @Author wggglggg
 * @Create 2023/7/30 19:23
 * @Version 1.0
 */
public class TestAnnotation {

    @Test
    public void testAnnotationApplicationContext() throws UnsupportedEncodingException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        ApplicationContext context = new AnnotationApplicationContext("com.sggspring6");
        UserService  userService = (UserService) context.getBean(UserService.class);
        System.out.println("userService = " + userService);
        userService.add();
    }

    @Test
    public void test() throws UnsupportedEncodingException {
        String basePackage = "com.sggspring6".replaceAll("\\.", "\\/");
        System.out.println("basePackage = " + basePackage);
        URL url = Thread.currentThread().getContextClassLoader().getResource(basePackage);
        System.out.println("resource = " + url);

        String filePath = URLDecoder.decode(url.getFile(), "utf-8");
        System.out.println("filePath = " + filePath);
        System.out.println("filePath = " + filePath.length());

        String rootPath = filePath.substring(0, filePath.length() - basePackage.length());
        System.out.println("rootPath = " + rootPath);
        System.out.println("rootPath = " + rootPath.length());

    }
}

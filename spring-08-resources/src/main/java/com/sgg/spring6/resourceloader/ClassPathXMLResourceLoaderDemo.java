package com.sgg.spring6.resourceloader;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.io.InputStream;

/**
 * ClassName: ClassPathXMLResourceLoaderDemo
 * Description:
 *
 * @Author wggglggg
 * @Create 2023/8/1 7:56
 * @Version 1.0
 */
public class ClassPathXMLResourceLoaderDemo {
    public static void main(String[] args){
        // 读取resources文件夹下的文件
        ApplicationContext context = new ClassPathXmlApplicationContext();
        Resource resource = context.getResource("resource.txt");
        //        通过ApplicationContext访问资源
        //        ApplicationContext实例获取Resource实例时，
        //        默认采用与ApplicationContext相同的资源访问策略
        System.out.println("resource.getFilename() = " + resource.getFilename());
        System.out.println("resource.getDescription() = " + resource.getDescription());

        try {
            InputStream is = resource.getInputStream();
            byte[] buffer = new byte[1024];

            while(is.read(buffer) != -1){

                System.out.println("resource.getInputStream() = " + new String(buffer));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}

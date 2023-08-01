package com.sgg.spring6.resources;

import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.io.InputStream;

/**
 * ClassName: ClassPathResourceDemo
 * Description:
 *
 * @Author wggglggg
 * @Create 2023/7/31 22:04
 * @Version 1.0
 */
public class ClassPathResourceDemo {

    public static void main(String[] args) {
        loadAndReadClassResource("resource.txt");
    }

    public static void loadAndReadClassResource(String path) {
        // 创建一个 Resource 对象
        ClassPathResource resource = new ClassPathResource(path);

        // 获取文件名    resource.getFilename() = resource.txt
        System.out.println("resource.getFilename() = " + resource.getFilename());
        // 获取文件描述  resource.getDescription() = class path resource [resource.txt]
        System.out.println("resource.getDescription() = " + resource.getDescription());

        //获取文件内容    buffer = abcdefg.//
        try {
            InputStream is = resource.getInputStream();
            byte[] buffer = new byte[1024];

            while((is.read(buffer)) != -1 ){
                System.out.println("buffer = " + new String(buffer).trim());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

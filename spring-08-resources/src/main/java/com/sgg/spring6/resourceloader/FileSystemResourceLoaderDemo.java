package com.sgg.spring6.resourceloader;

import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.io.InputStream;

/**
 * ClassName: FileSystemResourceLoaderDemo
 * Description:
 *
 * @Author wggglggg
 * @Create 2023/8/1 8:18
 * @Version 1.0
 */
public class FileSystemResourceLoaderDemo {
    public static void main(String[] args) {
        FileSystemXmlApplicationContext context = new FileSystemXmlApplicationContext();
        Resource resource = context.getResource("resource.txt");

        System.out.println("resource.getFilename() = " + resource.getFilename());
        System.out.println("resource.getDescription() = " + resource.getDescription());

        try {
            InputStream is = resource.getInputStream();
            byte[] buffer = new byte[1024];

            // 将文件内的信息读进buffer里,1024个字节会处理一次
            while(is.read(buffer) != -1){
                System.out.println("new String(buffer) = " + new String(buffer));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

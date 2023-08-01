package com.sgg.spring6.resources;

import org.springframework.core.io.FileSystemResource;

import java.io.IOException;
import java.io.InputStream;

/**
 * ClassName: FileSystemResourceDemo
 * Description:
 *
 * @Author wggglggg
 * @Create 2023/8/1 7:47
 * @Version 1.0
 */
public class FileSystemResourceDemo {

    public static void main(String[] args) {

        // 读取的是项目根目录SGGSpring6
        loadFileSystemResource("resource.txt");
    }
    public static void loadFileSystemResource(String path){
        //相对路径
        FileSystemResource fsr = new FileSystemResource(path);

        // 获取文件名    fsr.getFilename() = resource.txt
        System.out.println("fsr.getFilename() = " + fsr.getFilename());
        // 获取文件描述   fsr.getDescription() = file [C:\Users\wggglggg\OneDrive\venvs\JavaProjects\Spring\SGGSpring6\resource.txt]
        System.out.println("fsr.getDescription() = " + fsr.getDescription());

        try {
            //获取文件内容    new String(buffer) = abcdefg.//
            InputStream is = fsr.getInputStream();

            byte[] buffer = new byte[1024];
            while(is.read(buffer) != -1){
                System.out.println("new String(buffer) = " + new String(buffer).trim());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

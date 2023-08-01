package com.sgg.spring6.resources;

import org.springframework.core.io.UrlResource;

import java.io.IOException;
import java.net.MalformedURLException;

/**
 * ClassName: UrlResourceDemo
 * Description:
 *
 * @Author wggglggg
 * @Create 2023/7/31 21:37
 * @Version 1.0
 */
public class UrlResourceDemo {

    public static void loadAndReadUrlResource(String path){
        // 创建一个 Resource 对象
        UrlResource url = null;
        try {
            url = new UrlResource(path);
            // 获取资源名    url.getFilename() =
            System.out.println("url.getFilename() = " + url.getFilename());
            //  url.getUri() = http://www.baidu.com
            System.out.println("url.getUri() = " + url.getURI());

            // 获取资源描述   url.getDescription() = URL [http://www.baidu.com]
            System.out.println("url.getDescription() = " + url.getDescription());

            //获取资源内容    url.getInputStream().read() = 60
            System.out.println("url.getInputStream().read() = " + url.getInputStream().read());


        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        //访问网络资源
//        loadAndReadUrlResource("http://www.baidu.com");

        //2 访问文件系统资源
        loadAndReadUrlResource("file:resource.txt");
    }
}

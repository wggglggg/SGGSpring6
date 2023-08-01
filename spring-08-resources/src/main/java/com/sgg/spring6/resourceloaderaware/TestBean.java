package com.sgg.spring6.resourceloaderaware;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import java.io.IOException;
import java.io.InputStream;

/**
 * ClassName: TestBean
 * Description:
 *
 * @Author wggglggg
 * @Create 2023/8/1 8:38
 * @Version 1.0
 */
public class TestBean {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        Bean bean = context.getBean("bean", Bean.class);

        ResourceLoader resourceLoader = bean.getResourceLoader();

        // Bean实现了implements ResourceLoaderAware , 也带有了spring的特性,有了它的功能
        // resourceLoader == context = true
        System.out.println("resourceLoader == context = " + (resourceLoader == context));


        Resource resource = resourceLoader.getResource("resource.txt");
        // resource.getFilename() = resource.txt 读取的是resources文件夹下的
        System.out.println("resource.getFilename() = " + resource.getFilename());
        // resource.getDescription() = class path resource [resource.txt]
        System.out.println("resource.getDescription() = " + resource.getDescription());

        try {
            InputStream is = resource.getInputStream();
            byte[] buffer = new byte[1024];

            while (is.read(buffer) != -1){
                // new String(buffer) = abcdefg.//
                System.out.println("new String(buffer) = " + new String(buffer));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

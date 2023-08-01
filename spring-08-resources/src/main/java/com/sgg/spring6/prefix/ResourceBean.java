package com.sgg.spring6.prefix;

import org.springframework.core.io.Resource;

import java.io.IOException;
import java.io.InputStream;

/**
 * ClassName: ResourceBean
 * Description:
 *
 * @Author wggglggg
 * @Create 2023/8/1 8:49
 * @Version 1.0
 */
public class ResourceBean {

    private Resource resource;
    public void setResource(Resource resource){
        this.resource = resource;
    }

    public Resource getResource() {
        return resource;
    }

    public void showResource(){
        System.out.println("resource.getFilename() = " + resource.getFilename());
        System.out.println("resource.getDescription() = " + resource.getDescription());
        try {
            InputStream is = resource.getInputStream();
            byte[] buffer = new byte[1024];

            while(is.read(buffer) != -1){
                System.out.println("new String(buffer) = " + new String(buffer));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

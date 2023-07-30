package com.sggspring6.anno_context;

import com.sggspring6.anno.Bean;
import com.sggspring6.anno.Di;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * ClassName: AnnotationApplicationContext
 * Description:
 *
 * @Author wggglggg
 * @Create 2023/7/30 19:17
 * @Version 1.0
 */
public class AnnotationApplicationContext implements ApplicationContext{

    //创建map集合，放bean对象
    private Map<Class<?>, Object> beanFactory = new HashMap<>();
    private String rootPath;

    //返回对象
    @Override
    public Object getBean(Class clazz) {

        return beanFactory.get(clazz);
    }

    //创建有参数构造，传递包路径，设置包扫描规则
    //当前包及其子包，哪个类有@Bean注解，把这个类通过反射实例化
    public AnnotationApplicationContext(String basePackage) {
        //1 把.替换成"\"  basePackage = com/sggspring6
        try {
            basePackage = basePackage.replaceAll("\\.", "\\\\");

            //2 获取包绝对路径 resource = file:/C:/Users/wggglggg/OneDrive/venvs/JavaProjects/Spring/SGGSpring6/spring-03-make-a-ico/target/classes/com/sggspring6
            URL url = Thread.currentThread().getContextClassLoader().getResource(basePackage);

            // filePath = /C:/Users/wggglggg/OneDrive/venvs/JavaProjects/Spring/SGGSpring6/spring-03-make-a-ico/target/classes/com/sggspring6
            String filePath = URLDecoder.decode(url.getFile(), "utf-8");

            //获取包前面路径部分，字符串截取 rootPath = /C:/Users/wggglggg/OneDrive/venvs/JavaProjects/Spring/SGGSpring6/spring-03-make-a-ico/target/classes/
            rootPath = filePath.substring(0, filePath.length() - basePackage.length());

            //包扫描
            loadBean(new File(filePath));
            loadDi();
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

    }

    //包扫描过程，实例化
    private void loadBean(File filePath) {
        //1 判断当前是否文件夹
        if (filePath.isDirectory()){
            //2 获取文件夹里面所有内容
            File[] files = filePath.listFiles();

            //3 判断文件夹里面为空，直接返回
            if (files == null || files.length == 0){
                return;
            }

            //4 如果文件夹里面不为空，遍历文件夹所有内容
            for(File file : files){
                //4.1 遍历得到每个File对象，继续判断，如果还是文件夹，递归
                if (file.isDirectory()){
                    //递归
                    loadBean(file);

                } else {
                    //4.2 遍历得到File对象不是文件夹，是文件，
                    //4.3 得到包路径+类名称部分-字符串截取  com.sggspring6.xxxxx.xxxxx.class
                    String pathWithClass = file.getAbsolutePath().substring(rootPath.length() - 1);

                    //4.4 判断当前文件类型是否.class
                    if (pathWithClass.endsWith(".class")){
                        //4.5 如果是.class类型，把路径\替换成.  把.class去掉
                        // com.atguigu.service.UserServiceImpl

                        String NoSuffixClassPath = pathWithClass.replaceAll("\\\\", ".").replace(".class", "");

                        try {
                            //4.6 判断类上面是否有注解 @Bean，如果有实例化过程
                            //4.6.1 获取类的Class
                            Class<?> clazz = Class.forName(NoSuffixClassPath);
                            //4.6.2 判断不是接口
                            if (!clazz.isInterface()){
                                //4.6.3 判断类上面是否有注解 @Bean
                                Bean annotation = clazz.getAnnotation(Bean.class);
                                if (annotation != null){    // 不为Null，说明有@Bean
                                    //4.6.4 实例化
                                    Object instance = clazz.getDeclaredConstructor().newInstance();
                                    //4.7 把对象实例化之后，放到map集合beanFactory
                                    //4.7.1 判断当前类如果有接口，让接口class作为map的key
                                    if (clazz.getInterfaces().length > 0){
                                        beanFactory.put(clazz.getInterfaces()[0], instance);
                                    }else {
                                        beanFactory.put(clazz, instance);
                                    }
                                }
                            }
                        } catch (ClassNotFoundException e) {
                            throw new RuntimeException(e);
                        } catch (InstantiationException e) {
                            throw new RuntimeException(e);
                        } catch (IllegalAccessException e) {
                            throw new RuntimeException(e);
                        } catch (InvocationTargetException e) {
                            throw new RuntimeException(e);
                        } catch (NoSuchMethodException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
        }
    }

    //属性注入
    public void loadDi() throws IllegalAccessException {
        //实例化对象在beanFactory的map集合里面
        //1 遍历beanFactory的map集合
        Set<Map.Entry<Class<?>, Object>> entries = beanFactory.entrySet();

        for(Map.Entry<Class<?>, Object> entry : entries){
            //2 获取map集合每个对象（value），每个对象属性获取到
            Object obj = entry.getValue();

            //获取对象Class
            Class<?> clazz = obj.getClass();

            //获取每个对象属性获取到
            Field[] fields = clazz.getDeclaredFields();
            //3 遍历得到每个对象属性数组，得到每个属性
            for (Field field : fields){
                //4 判断属性上面是否有@Di注解
                Di annotation = field.getAnnotation(Di.class);
                if (annotation != null){        // 不为Null，说明有@Di
                    //如果私有属性，设置可以设置值,先要获取权限，因为有的属性private
                    field.setAccessible(true);

                    try {
                        //5 如果有@Di注解，把对象进行设置（注入）
                        field.set(obj, beanFactory.get(field.getType()));
                    } catch (IllegalArgumentException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}

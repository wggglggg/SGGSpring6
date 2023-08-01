package com.sggspring6.anno_context;

/**
 * ClassName: ApplicationContext
 * Description:
 *
 * @Author wggglggg
 * @Create 2023/7/30 19:16
 * @Version 1.0
 */
public interface ApplicationContext {

    // 获取bean
    Object getBean(Class clazz);
}

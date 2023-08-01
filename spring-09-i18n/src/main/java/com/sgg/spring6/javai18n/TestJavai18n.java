package com.sgg.spring6.javai18n;

import java.util.Locale;
import java.util.ResourceBundle;


/**
 * ClassName: TestJavai18n
 * Description:
 *
 * @Author wggglggg
 * @Create 2023/8/1 9:08
 * @Version 1.0
 */
public class TestJavai18n {

    public static void main(String[] args) {
        // 查找文件名为messages开头,zh_CN的配置, 读取配置中Location的值 ,达到一键语言切换
        System.out.println(ResourceBundle.getBundle("messages", new Locale("zh", "CN")).getString("Location"));
    }
}

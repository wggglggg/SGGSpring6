package com.sgg.spring6;

/**
 * ClassName: User
 * Description:
 *
 * @Author wggglggg
 * @Create 2023/7/31 15:01
 * @Version 1.0
 */
public class User {

    private String name;
    private Person person;

    //无参数构造
    public User() {
        System.out.println("0: 无参数构造执行了..");
    }

    public void add(){
        System.out.println("add.....");
    }
}

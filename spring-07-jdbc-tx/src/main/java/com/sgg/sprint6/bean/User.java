package com.sgg.sprint6.bean;

/**
 * ClassName: User
 * Description:
 *
 * @Author wggglggg
 * @Create 2023/7/31 16:35
 * @Version 1.0
 */
public class User {
    private int user_id;
    private String userName;
    private int balance;

    public User() {
    }

    public User(int user_id, String userName, int balance) {
        this.user_id = user_id;
        this.userName = userName;
        this.balance = balance;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", userName='" + userName + '\'' +
                ", balance=" + balance +
                '}';
    }
}

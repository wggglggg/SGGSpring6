package com.sgg.sprint6.dao;

/**
 * ClassName: BookDAO
 * Description:
 *
 * @Author wggglggg
 * @Create 2023/7/31 16:45
 * @Version 1.0
 */
public interface BookDAO {

    //根据图书id查询图书价格
    Integer getBookPriceById(Integer bookId);

    //更新图书表库存量 -1
    void updateBookStock(Integer bookId);

    //更新用户表用户余额 -图书价格
    void updateUserBalance(Integer userId, Integer price);
}

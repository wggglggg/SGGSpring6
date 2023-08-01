package com.sgg.sprint6.dao.impl;

import com.sgg.sprint6.dao.BookDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


/**
 * ClassName: BookDAOImpl
 * Description:
 *
 * @Author wggglggg
 * @Create 2023/7/31 16:45
 * @Version 1.0
 */
@Repository
public class BookDAOImpl implements BookDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    //根据图书id查询价格
    @Override
    public Integer getBookPriceById(Integer bookId) {
        String sql = "select price from t_book where book_id = ?";
        Integer price = jdbcTemplate.queryForObject(sql, Integer.class, bookId);
        return price;
    }

    //更新库存
    @Override
    public void updateBookStock(Integer bookId) {
        String sql = "update `t_book` set stock=stock-1 where book_id = ?";

        jdbcTemplate.update(sql, bookId);
    }

    //更新用户表用户余额 -图书价格
    @Override
    public void updateUserBalance(Integer userId, Integer price) {
        String sql = "update t_user set balance=balance-? where user_id = ?";
        jdbcTemplate.update(sql, price, userId);
    }


}

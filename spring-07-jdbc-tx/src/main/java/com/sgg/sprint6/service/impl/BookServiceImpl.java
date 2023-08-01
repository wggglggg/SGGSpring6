package com.sgg.sprint6.service.impl;

import com.sgg.sprint6.dao.BookDAO;
import com.sgg.sprint6.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * ClassName: BookServiceImpl
 * Description:
 *
 * @Author wggglggg
 * @Create 2023/7/31 16:42
 * @Version 1.0
 */


@Service
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class BookServiceImpl implements BookService {
    @Autowired
    private BookDAO bookDAO;

    //买书的方法：图书id和用户id

    @Override
    public void buyBook(Integer bookId, Integer userId) {
        //根据图书id查询图书价格
        Integer bookPrice = bookDAO.getBookPriceById(bookId);

        //更新图书表库存量 -1
        bookDAO.updateBookStock(bookId);

        //更新用户表用户余额 -图书价格
        bookDAO.updateUserBalance(userId, bookPrice);
    }

}

package com.sgg.sprint6.service.impl;

import com.sgg.sprint6.dao.BookDAO;
import com.sgg.sprint6.service.BookService;
import com.sgg.sprint6.service.CheckoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * ClassName: CheckoutServiceImpl
 * Description:
 *
 * @Author wggglggg
 * @Create 2023/7/31 20:11
 * @Version 1.0
 */
@Service
@Transactional
public class CheckoutServiceImpl implements CheckoutService {

    @Autowired
    private BookService bookService;

    public void checkout(Integer[] booksId, Integer userId){
        for (Integer bookId : booksId){
            bookService.buyBook(bookId, userId);
        }
    }
}

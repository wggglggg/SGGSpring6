package com.sgg.sprint6.controllers;

import com.sgg.sprint6.service.BookService;
import com.sgg.sprint6.service.CheckoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

/**
 * ClassName: BookController
 * Description:
 *
 * @Author wggglggg
 * @Create 2023/7/31 16:39
 * @Version 1.0
 */
@Controller
public class BookController {

    @Autowired
    private BookService bookService;
    @Autowired
    private CheckoutService checkoutService;


    public void buyBook(Integer bookId, Integer userId){
        bookService.buyBook(bookId, userId);
    }



    public void buyMoreBooks(Integer[] booksId, Integer userId){
        checkoutService.checkout(booksId, userId);
    }
}

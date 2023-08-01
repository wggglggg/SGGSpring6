package com.sgg.sprint6.service;

/**
 * ClassName: BookService
 * Description:
 *
 * @Author wggglggg
 * @Create 2023/7/31 16:42
 * @Version 1.0
 */
public interface BookService {

    //买书的方法：图书id和用户id
    void buyBook(Integer bookId, Integer userId);

}

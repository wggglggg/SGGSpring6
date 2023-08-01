package com.sgg.sprint6;

import com.sgg.sprint6.controllers.BookController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.transaction.annotation.Transactional;


/**
 * ClassName: TestBook
 * Description:
 *
 * @Author wggglggg
 * @Create 2023/7/31 16:57
 * @Version 1.0
 */

@SpringJUnitConfig(locations = "classpath:beans.xml")
public class TestBook {

    @Autowired
    private BookController bookController;


    @Test
    public void testBuyBook(){
//        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
//        BookController bookController = context.getBean("bookController", BookController.class);

//        bookController.buyBook(1, 1);
        Integer[] booksId = {1,2};
        bookController.buyMoreBooks(booksId, 1);
    }
}

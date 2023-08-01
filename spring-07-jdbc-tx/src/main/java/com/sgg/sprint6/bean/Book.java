package com.sgg.sprint6.bean;

/**
 * ClassName: Book
 * Description:
 *
 * @Author wggglggg
 * @Create 2023/7/31 16:35
 * @Version 1.0
 */
public class Book {

    private Integer id;
    private String bookName;
    private Integer bookStatus;

    public Book() {
    }

    public Book(int id, String bookName, int bookStatus) {
        this.id = id;
        this.bookName = bookName;
        this.bookStatus = bookStatus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(int bookStatus) {
        this.bookStatus = bookStatus;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", bookName='" + bookName + '\'' +
                ", bookStatus=" + bookStatus +
                '}';
    }
}

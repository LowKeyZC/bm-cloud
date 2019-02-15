package com.zc.usercloud.bean;

public class Book {
    //图书ID
    private String bookId;
    //图书名称
    private String bookName;
    //图书内容
    private String bookContent;
    //价格
    private Integer bookValue;

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookContent() {
        return bookContent;
    }

    public void setBookContent(String bookContent) {
        this.bookContent = bookContent;
    }

    public Integer getBookValue() {
        return bookValue;
    }

    public void setBookValue(Integer bookValue) {
        this.bookValue = bookValue;
    }
}

package com.zc.bookcloud.resp;

public class BookResp {

    private String bookId;
    private String bookName;
    private String bookContent;
    private Integer bookValue;
    private String orderStatus;

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

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }
}

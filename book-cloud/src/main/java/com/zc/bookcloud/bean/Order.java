package com.zc.bookcloud.bean;

import com.zc.common.util.Md5Utils;

import java.util.Date;

public class Order {
    private String id;
    private String userId;
    private String bookId;
    private Date createTm;
    private Date modifyTm;
    private String status;
    private String detail;

    public Order() {}

    public Order(String userId, String bookId) {
        this.id = Md5Utils.hash(userId + bookId);
        this.userId = userId;
        this.bookId = bookId;
        this.createTm = new Date();
        this.modifyTm = new Date();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public Date getCreateTm() {
        return createTm;
    }

    public void setCreateTm(Date createTm) {
        this.createTm = createTm;
    }

    public Date getModifyTm() {
        return modifyTm;
    }

    public void setModifyTm(Date modifyTm) {
        this.modifyTm = modifyTm;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}

package com.zc.usercloud.service;

import com.zc.usercloud.bean.Book;
import com.zc.usercloud.client.BookClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class BookService {

    @Resource
    private BookClient bookClient;

    public Book selectBookById(String bookId){
        long start = System.currentTimeMillis();
        Book book = bookClient.selectById(bookId);
        System.out.println("查询图书耗时：" + (System.currentTimeMillis() - start));
        return book;
    }
}

package com.zc.usercloud.service;

import com.zc.usercloud.bean.Book;
import com.zc.usercloud.client.BookClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    private BookClient bookClient;

    public Book selectBookById(String bookId){
        return bookClient.selectById(bookId);
    }
}

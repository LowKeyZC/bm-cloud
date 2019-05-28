package com.zc.bookcloud.service;

import com.zc.bookcloud.bean.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookServiceTest {

    @Autowired
    private BookService bookService;

    @Test
    public void insertBook() throws Exception {
        Book book = new Book();
        book.setBookName("西游");
        book.setBookContent("开花开花");
        book.setBookValue(123);

        bookService.insertBook(book);
    }

}
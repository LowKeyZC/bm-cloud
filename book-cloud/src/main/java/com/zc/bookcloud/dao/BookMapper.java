package com.zc.bookcloud.dao;

import com.zc.bookcloud.bean.Book;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface BookMapper {

    List<Book> getAllBook();

    Book selectBookById(String bookId);

    void updateBook(Book book);

    void insertBook(Book book);

    void delBookById(String bookId);
}

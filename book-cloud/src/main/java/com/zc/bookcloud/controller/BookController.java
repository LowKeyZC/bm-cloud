package com.zc.bookcloud.controller;

import com.zc.bookcloud.bean.Book;
import com.zc.bookcloud.bean.User;
import com.zc.bookcloud.resp.BookResp;
import com.zc.bookcloud.service.BookService;
import com.zc.common.result.ZcResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("book")
public class BookController {

    @Autowired
    private BookService bookService;

    @RequestMapping(value = "list",method = RequestMethod.POST)
    public List<BookResp> listBook(@RequestParam(value = "userId") String userId) {
        return bookService.getAllBookAndStatus(userId);
    }

    @RequestMapping(value = "selectById", method = RequestMethod.POST)
    public Book selectById(@RequestParam(value = "bookId") String bookId) {
        return bookService.selectBookById(bookId);
    }

    @RequestMapping(value = "add",method = RequestMethod.POST)
    public ZcResult addBook(@RequestBody Book book) {
        bookService.insertBook(book);
        return ZcResult.success();
    }

    /*@RequestMapping(value = "play", method = RequestMethod.POST)
    @ResponseBody
    public String playBook(String bookId) {
        Book book = bookService.selectBookById(bookId);
        return book.getBookContent();
    }

    @RequestMapping(value = "buy", method = RequestMethod.POST)
    @ResponseBody
    public String buyBook(HttpSession session, String bookId) {
        String userId = session.getAttribute("userId").toString();
        User user = userService.selectUserById(userId);
        Integer money = user.getHasMoney();

        Book book = bookService.selectBookById(bookId);

        if (money < book.getValue()) {
            return Result.NOMONEY.getCode();
        }

        user.setHasMoney(money- book.getValue());
        userService.updateUser(user);

        UserBookStatus ums = new UserBookStatus(userId,bookId);

        ubStatusService.insertUserBookStatus(ums);

        return Result.SUCCESS.getCode();
    }*/
}

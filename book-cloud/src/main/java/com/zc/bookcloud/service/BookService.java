package com.zc.bookcloud.service;

import com.zc.bookcloud.bean.Book;
import com.zc.bookcloud.bean.Order;
import com.zc.bookcloud.bean.User;
import com.zc.bookcloud.dao.BookMapper;
import com.zc.bookcloud.resp.BookResp;
import com.zc.common.constant.Constant;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

@Service
public class BookService {

    @Resource
    private BookMapper bookMapper;
    @Resource
    private UserService userService;
    @Resource
    private OrderService orderService;

    public List<BookResp> getAllBookAndStatus(String userId) {
        List<BookResp> resps = new ArrayList<>();
        List<Book> books = this.getAllBook();
        User user = userService.selectByUserId(userId);
        if (null == user) {
            return resps;
        }
        Map<String,Order> orderMap = new HashMap<>();

        if (user.getRoleId().equals(Constant.CONSUMER)) {
            orderMap = orderService.getOrderMapByUserId(userId);
        }

        if (null != books) {
            for (Book book : books) {
                BookResp bookResp = new BookResp();
                BeanUtils.copyProperties(book,bookResp);
                if (user.getRoleId().equals(Constant.CONSUMER)) {
                    Order order = orderMap.get(user.getUserId() + "-" + book.getBookId());
                    if (null != order) {
                        bookResp.setOrderStatus(order.getStatus());
                    } else {
                        bookResp.setOrderStatus(Constant.NOBUY + "");
                    }
                }
                resps.add(bookResp);
            }
        }
        return resps;

    }

    public List<Book> getAllBook() {
        return bookMapper.getAllBook();
    }

    public Book selectBookById(String bookId){
        return bookMapper.selectBookById(bookId);
    }

    public void insertBook(Book book) {
        String bookId = UUID.randomUUID().toString().replaceAll("-", "");
        book.setBookId(bookId);
        bookMapper.insertBook(book);
    }

    public void updateBook(Book book) {
        bookMapper.updateBook(book);
    }

    public void delBookById(String bookId) {
        bookMapper.delBookById(bookId);
    }
}

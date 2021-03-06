package com.zc.usercloud.controller;

import com.zc.common.result.ResultEnum;
import com.zc.common.result.ZcResult;
import com.zc.usercloud.bean.Book;
import com.zc.usercloud.bean.User;
import com.zc.usercloud.service.BookService;
import com.zc.usercloud.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@RestController
@RequestMapping("user")
@RefreshScope //需要热更新的类打上这个标签，bus总线通知微服务更新
public class UserController {

    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

    @Value("${proptest}")
    private String proptest;
    @Resource
    private UserService userService;
    @Resource
    private BookService bookService;

    @RequestMapping(value = "selectById", method = RequestMethod.POST)
    public User selectById(@RequestParam(value = "userId") String userId) {
        System.out.println("user-cloud:selectById,userId=" + userId);
        return userService.selectUserById(userId);
    }

    /**
     * 购买图书
     * @param userId
     * @param bookId
     * @return
     */
    @RequestMapping(value = "buy", method = RequestMethod.POST)
    public ZcResult buyBook(String userId, String bookId) {
        LOGGER.info("user-cloud:controller:/user/buy");
        ZcResult result = userService.buy(userId, bookId);
        LOGGER.info("user-cloud:controller:/user/buy:end:" + result.getMsg());
        return result;
    }

    public ZcResult busyBuy(String userId, String bookId){
        return ZcResult.busy();
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public ZcResult login(@RequestParam(value = "userId") String userId, @RequestParam(value = "userPwd") String userPwd){
        return userService.login(userId, userPwd);
    }

    /**
     * 查看图书
     */
    @RequestMapping(value = "play",method = RequestMethod.POST)
    public ZcResult palyBook(@RequestParam(value = "bookId") String bookId,@RequestParam(value = "userId") String userId) {
        LOGGER.info("/user/play,userId = " + userId + " bookId=" + bookId);

        Book book = bookService.selectBookById(bookId);
        if (null == book) {
            return ZcResult.result(ResultEnum.NOBOOK);
        }
        return ZcResult.success(book.getBookContent());
    }

    /**
     * 配置修改测试
     */
    @RequestMapping(value = "test", method = RequestMethod.POST)
    public ZcResult test() {
        return ZcResult.success(proptest);
    }


}

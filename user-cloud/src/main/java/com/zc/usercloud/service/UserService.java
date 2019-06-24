package com.zc.usercloud.service;


import com.zc.common.result.ResultEnum;
import com.zc.common.result.ZcResult;
import com.zc.usercloud.bean.Book;
import com.zc.usercloud.bean.User;
import com.zc.usercloud.dao.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService {

    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

    @Resource
    private UserMapper userMapper;

    @Resource
    private BookService bookService;

    @Resource
    private OrderService orderService;

    public ZcResult buy(String userId, String bookId) {
        LOGGER.info("user-cloud:service:buy:start");

        //查询用户余额
        User user = this.selectUserById(userId);
        Integer userHasMoney = user.getHasMoney();

        //调用图书微服务，查询图书价格
        LOGGER.info("user-cloud:service:buy:调用book-cloud");
        Book book = bookService.selectBookById(bookId);
        if (null == book) {
            return ZcResult.result(ResultEnum.NOBOOK);
        }

        Integer bookValue = book.getBookValue();
        if (userHasMoney < bookValue) {
            return ZcResult.result(ResultEnum.NOMONEY);
        }

        user.setHasMoney(userHasMoney - bookValue);
        this.updateUser(user);

        //调用订单微服务，保存订单
        LOGGER.info("user-cloud:service:buy:调用order-cloud");
        return orderService.insertOrder(userId, bookId);
    }

    public User selectUserById(String userId) {
        return userMapper.selectUserById(userId);
    }

    public void updateUser(User user) {
        userMapper.updateUser(user);
    }

    public ZcResult login(String userId, String userPwd) {
        User user = this.selectUserById(userId);
        if (null == user) {
            System.out.println(ResultEnum.NOUSER.getMsg());
            return ZcResult.result(ResultEnum.NOUSER);
        } else if (!userPwd.equals(user.getUserPwd())) {
            System.out.println(ResultEnum.WRONGPWD);
            return ZcResult.result(ResultEnum.WRONGPWD);
        } else {
            System.out.println(ResultEnum.SUCCESS);
            return ZcResult.success(user);
        }
    }
}

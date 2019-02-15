package com.zc.ordercloud.controller;

import com.zc.common.constant.Constant;
import com.zc.common.result.ZcResult;
import com.zc.ordercloud.bean.Order;
import com.zc.ordercloud.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping("selectByUserId")
    public List<Order> selectByUserId(@RequestParam(value = "userId") String userId) {
        return orderService.selectByUserId(userId);
    }

    @RequestMapping(value = "insertOrder")
    public ZcResult insertOrder(@RequestParam(value = "userId") String userId, @RequestParam(value = "bookId") String bookId) {
        Order order = new Order(userId, bookId);
        order.setStatus(Constant.HASBUY+"");
        order.setDetail(Constant.buyDetail);
        orderService.insert(order);
        return ZcResult.success();
    }
}

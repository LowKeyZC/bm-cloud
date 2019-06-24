package com.zc.bookcloud.service;

import com.zc.bookcloud.bean.Order;
import com.zc.bookcloud.clients.OrderClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OrderService {

    @Resource
    private OrderClient orderClient;

    public Map<String,Order> getOrderMapByUserId(String userId){
        List<Order> orders = orderClient.selectByUserId(userId);
        Map<String, Order> orderMap = new HashMap<>();

        if (null != orders) {
            for (Order order:orders) {
                orderMap.put(order.getUserId() + "-" + order.getBookId(), order);
            }
        }

        return orderMap;
    }
}

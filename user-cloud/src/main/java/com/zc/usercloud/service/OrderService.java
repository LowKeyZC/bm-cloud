package com.zc.usercloud.service;

import com.zc.common.result.ZcResult;
import com.zc.usercloud.client.OrderClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private OrderClient orderClient;

    public ZcResult insertOrder(String userId, String bookId) {
        return orderClient.insertOrder(userId, bookId);
    }
}

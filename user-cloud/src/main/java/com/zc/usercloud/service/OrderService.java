package com.zc.usercloud.service;

import com.zc.common.result.ZcResult;
import com.zc.usercloud.client.OrderClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class OrderService {

    @Resource
    private OrderClient orderClient;

    public ZcResult insertOrder(String userId, String bookId) {
        return orderClient.insertOrder(userId, bookId);
    }
}

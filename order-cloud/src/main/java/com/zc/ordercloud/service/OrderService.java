package com.zc.ordercloud.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.zc.ordercloud.bean.Order;
import com.zc.ordercloud.dao.OrderMapper;

@Service
public class OrderService {

    @Resource
    private OrderMapper orderMapper;

    public List<Order> selectByUserId(String userId) {
        Order order = new Order();
        order.setUserId(userId);
        return select(order);
    }

    public int insert(Order pojo){
        return orderMapper.insert(pojo);
    }

    public int insertList(List< Order> pojos){
        return orderMapper.insertList(pojos);
    }

    public List<Order> select(Order pojo){
        return orderMapper.select(pojo);
    }

    public int update(Order pojo){
        return orderMapper.update(pojo);
    }

}

package com.zc.bookcloud.clients;

import com.zc.bookcloud.bean.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
public class OrderClientHystrix implements OrderClient{

    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

    @Override
    public List<Order> selectByUserId(String userId) {
        LOGGER.info("book-cloud:client:OrderClientHystrix:selectByUserId:order-cloud系统繁忙~");
        return Collections.emptyList();
    }
}

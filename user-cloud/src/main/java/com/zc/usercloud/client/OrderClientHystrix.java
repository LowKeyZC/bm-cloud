package com.zc.usercloud.client;

import com.zc.common.result.ZcResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class OrderClientHystrix implements OrderClient {

    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

    @Override
    public ZcResult insertOrder(String userId, String bookId) {
        LOGGER.info("user-cloud:client:OrderClientHystrix:insertOrder:order-cloud系统繁忙~");
        return ZcResult.busy();
    }
}

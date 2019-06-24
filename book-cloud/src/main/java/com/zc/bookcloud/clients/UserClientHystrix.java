package com.zc.bookcloud.clients;

import com.zc.bookcloud.bean.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class UserClientHystrix implements UserClient {

    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

    @Override
    public User selectById(String userId) {
        LOGGER.error("book-cloud:client:UserClientHystrix:selectById:user-cloud系统繁忙~");
        return null;
    }
}

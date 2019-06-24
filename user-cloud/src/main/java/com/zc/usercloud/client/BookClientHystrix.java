package com.zc.usercloud.client;

import com.zc.common.result.ZcResult;
import com.zc.usercloud.bean.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class BookClientHystrix implements BookClient{
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public Book selectById(String bookId) {
        logger.error("user-cloud:client:BookClientHystrix:selectById:book-cloud系统繁忙~");
        return null;
    }
}

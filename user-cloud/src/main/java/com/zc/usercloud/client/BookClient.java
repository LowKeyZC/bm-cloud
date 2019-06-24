package com.zc.usercloud.client;

import com.zc.usercloud.bean.Book;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "book-cloud", fallback = BookClientHystrix.class)
public interface BookClient {

    @RequestMapping(value = "/book/selectById", method = RequestMethod.POST)
    public Book selectById(@RequestParam(value = "bookId") String bookId);
}

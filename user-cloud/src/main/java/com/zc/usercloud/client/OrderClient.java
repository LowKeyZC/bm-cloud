package com.zc.usercloud.client;

import com.zc.common.result.ZcResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "order-cloud",fallback = OrderClientHystrix.class)
public interface OrderClient {

    @RequestMapping(value = "/order/insertOrder")
    public ZcResult insertOrder(@RequestParam(value = "userId") String userId,@RequestParam(value = "bookId") String bookId);
}

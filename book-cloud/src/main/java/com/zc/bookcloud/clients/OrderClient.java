package com.zc.bookcloud.clients;

import com.zc.bookcloud.bean.Order;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "order-cloud", fallback = OrderClientHystrix.class)
public interface OrderClient {

    @RequestMapping("/order/selectByUserId")
    public List<Order> selectByUserId(@RequestParam(value = "userId") String userId);


}

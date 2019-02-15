package com.zc.bookcloud.clients;

import com.zc.bookcloud.bean.User;
import com.zc.common.result.ZcResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "user-cloud")
public interface UserClient {

    @RequestMapping(value = "/user/selectById", method = RequestMethod.POST)
    public User selectById(@RequestParam(value = "userId") String userId);
}

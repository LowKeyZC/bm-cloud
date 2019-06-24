package com.zc.bookcloud.service;

import com.zc.bookcloud.bean.User;
import com.zc.bookcloud.clients.UserClient;
import com.zc.common.result.ZcResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService {

    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

    @Resource
    private UserClient userClient;

    public User selectByUserId(String userId) {
        return userClient.selectById(userId);
    }
}

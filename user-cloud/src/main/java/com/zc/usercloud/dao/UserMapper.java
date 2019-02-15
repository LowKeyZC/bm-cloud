package com.zc.usercloud.dao;


import com.zc.usercloud.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
public interface UserMapper {

    /**
     * 查询
     * @param userId
     */
    User selectUserById(String userId);

    /**
     * 更新
     * @param user
     */
    void updateUser(User user);
}

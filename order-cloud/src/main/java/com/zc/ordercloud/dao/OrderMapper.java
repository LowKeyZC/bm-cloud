package com.zc.ordercloud.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import com.zc.ordercloud.bean.Order;

@Mapper
public interface OrderMapper {

    int insert(@Param("pojo") Order pojo);

    int insertList(@Param("pojos") List< Order> pojo);

    List<Order> select(@Param("pojo") Order pojo);

    Order selectById(@Param("pojo") String id);

    int update(@Param("pojo") Order pojo);

    int delete(@Param("id") String id);

}

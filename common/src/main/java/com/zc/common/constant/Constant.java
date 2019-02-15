package com.zc.common.constant;

import java.util.Date;

/**
 * 常量
 */
public class Constant {
    //用户
    public static final String CONSUMER = "1";
    //电影院经历
    public static final String MANAGER = "2";
    //已购买
    public static final Integer HASBUY = 1;
    //未购买
    public static final Integer NOBUY = 2;
    //购买详情
    public static final String buyDetail = "状态：购买,时间：" + new Date();
}

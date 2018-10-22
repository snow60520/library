package com.snow.service;

import org.apache.ibatis.annotations.Param;

/**
 * @author 刘大猫 E-mail：snow60520@163.com
 * @version 创建时间：2018/10/7 0007
 */
public interface ISysPerService {

    /**
     * 1,权限确认
     * @param userName 用户帐号
     * @param perName  拥有权限
     * @return true
     */
    Boolean isUserPer(@Param("userName")String userName, @Param("perName")String perName);
}

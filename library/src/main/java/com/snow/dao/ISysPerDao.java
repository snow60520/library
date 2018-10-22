package com.snow.dao;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;



/**
 * @author 刘大猫 E-mail:snow60520@163.com
 * @version 创建时间：2018/9/30 0030
 */
@Repository
public interface ISysPerDao {
    /**
     * 1,权限确认
     * @param userName 用户帐号
     * @param perName  拥有权限
     * @return true
     */
    Boolean isUserPer(@Param("userName")String userName, @Param("perName")String perName);

}

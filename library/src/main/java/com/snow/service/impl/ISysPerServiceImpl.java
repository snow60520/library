package com.snow.service.impl;

import com.snow.dao.ISysPerDao;
import com.snow.service.ISysPerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author 刘大猫 E-mail：snow60520@163.com
 * @version 创建时间：2018/10/7 0007
 */
@Service
public class ISysPerServiceImpl implements ISysPerService {
    @Resource
    private ISysPerDao perDao;

    /**
     * 1,权限确认
     * @param userName 用户帐号
     * @param perName  拥有权限
     * @return true
     */
    @Override
    public Boolean isUserPer(String userName, String perName) {
        Boolean isPer= false;
        try {
            isPer = perDao.isUserPer(userName,perName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isPer;
    }
}

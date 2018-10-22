package com.snow.service.impl;


import com.snow.service.ISysPerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


/**
 * @author 刘大猫 E-mail：snow60520@163.com
 * @version 创建时间：2018/10/7 0007
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-mybatis.xml"})
public class ISysPerServiceImplTest {
    @Autowired
    private ISysPerService perService;
    @Test
    public void isUserPer() {
        String userName="snow1";
        String perName="查询用户";
       Boolean isPer=perService.isUserPer(userName,perName);
        System.out.println("isPer:"+isPer);
    }
    @Test
    public  void aabcc(){
        System.out.println("懵右");
    }
}
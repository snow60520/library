package com.snow.utils;

import com.snow.dao.IUtilsDao;
import com.snow.model.PageEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;
// 加载spring配置文件
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-mybatis.xml"})
public class PageUtilTest {
    @Autowired
    private IUtilsDao utilsDao;
    @Test
    public  void selTableRowCount(){
        Integer rowsCount=utilsDao.selTableRowCount("sys_role_perm");
        System.out.println("返回总数数据条数:"+rowsCount);
    }
    @Test
    public void showPage() {
        PageUtil pageUtil=new PageUtil();
    //  PageEntity page=pageUtil.getPage(30,6,5);
      //  System.out.println("page:"+page);
    }
}
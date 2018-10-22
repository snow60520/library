package com.snow.utils;

import javax.servlet.ServletContext;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 刘大猫 E-mail：snow60520@163.com
 * @version 创建时间：2018/10/6 0006
 */
public class util {
    //1,时间
    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:MM:ss");
       String time=sdf.format(new Date());

    //2,在线人数
//    ServletContext ctx =request.getSession().getServletContext();
//    Integer userCounts=(Integer)ctx.getAttribute("userCounts");
//    System.out.println("在线人数:"+userCounts);
}

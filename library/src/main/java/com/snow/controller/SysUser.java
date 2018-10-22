package com.snow.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.snow.dao.ISysUserDao;
import com.snow.model.SessionUser;
import com.snow.model.SysUserEnt;
import com.snow.service.ISysUserService;
import com.snow.utils.IpUtils;
import com.snow.utils.SessionListener;
import com.snow.utils.WRjson;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import netscape.javascript.JSObject;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.json.JsonArray;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.InetAddress;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author 刘大猫 E-mail:snow60520@163.com
 * @version 创建时间：2018/9/30 0030
 */
@Controller
@RequestMapping
public class SysUser {
    @Resource
    private ISysUserService userService;
    @Autowired
    private ISysUserDao userDao;
    /**
     * @param request userId账号ID
     * @param response 返回查询的账号信息
     * @throws IOException
     */
    @RequestMapping("/selectUser")
    public void selectUser(HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.setContentType("text/html;charset=UTF-8");//返回数据为utf-8
        request.setCharacterEncoding("utf-8");//设置中文编码

        Integer userId = Integer.parseInt(request.getParameter("user_id"));
        System.out.println("输入ID:"+userId);
        //
        List<SysUserEnt> list=userDao.selectUserAll();
        SysUserEnt userEnt=userService.selLogin(request,"snow1","12345678");


        SysUserEnt  loginUserEnt=(SysUserEnt)request.getSession().getAttribute("loginUserEnt");
        System.out.println("userEnt:"+userEnt);
        System.out.println("userEnt:"+loginUserEnt);

        //在线人数
        int onlNum=SessionListener.getOnlNum();
        System.out.println("在线人数:"+onlNum);
        ObjectMapper mapper = new ObjectMapper();
        response.getWriter().write(mapper.writeValueAsString(loginUserEnt));
        response.getWriter().close();


     String ip=IpUtils.getIpFromRequest(request);
        System.out.println("IP1:"+ip);
        String ip2=IpUtils.getIpAddr(request);
        System.out.println("IP2:"+ip2);


    }
    //注销帐号
    @RequestMapping("/selLogOut")
    public  void selLogOut(HttpServletRequest request,HttpServletResponse response){
        boolean logOut=userService.isLogout(request);
        System.out.println("logOut:"+logOut);
    }


}

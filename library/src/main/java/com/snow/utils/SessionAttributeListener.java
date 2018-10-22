package com.snow.utils;

import com.snow.model.SessionUser;
import com.snow.model.SysUserEnt;
import net.sf.json.JSONObject;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;

/**
 * @author 刘大猫 E-mail：snow60520@163.com
 * @version 创建时间：2018/10/7 0007
 * HttpSessionListener 监听器:监听的是session创建和销毁事件，
 * 比如用户通过浏览器访问项目时(创建session)或者session失效等时会触发该监听
 *HttpSessionAttributeListener监听的是session属性的事件，
 * 比如调用session的setAttribute方法或removeAttribute时会触发该监听器
 */
@WebListener
public class SessionAttributeListener implements HttpSessionAttributeListener {
    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {
        //时间
       SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:MM:ss");
        SysUserEnt loginUserEnt=(SysUserEnt)event.getSession().getAttribute("loginUserEnt");
        System.out.println("创建session:"+loginUserEnt);

        SessionUser user=new SessionUser();
        user.setSessionId(event.getSession().getId());
        user.setSessionUserName(loginUserEnt.getUserName());
        try {
            user.setSessionIP(SessionAttributeListener.ipStr());
        } catch (SocketException e) {
            e.printStackTrace();
        }
        user.setSessionFirstTime(sdf.format(new Date()));

        JSONObject jsonObject = JSONObject.fromObject(user);
        WRjson wr=new WRjson();
        wr.saveDataToFile("jon",jsonObject.toString());
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent event) {
        SysUserEnt loginUserEnt=(SysUserEnt)event.getSession().getAttribute("loginUserEnt");
        System.out.println("删除session:"+loginUserEnt);
    }
    @Override
    public void attributeReplaced(HttpSessionBindingEvent event) {

    }
    public static String ipStr() throws SocketException {
    String ipstr=null;
    InetAddress ip = null;
    Enumeration allNetInterfaces = NetworkInterface.getNetworkInterfaces();
    while (allNetInterfaces.hasMoreElements()){
        NetworkInterface netInterface = (NetworkInterface) allNetInterfaces.nextElement();
        System.out.println(netInterface.getName());
        Enumeration addresses = netInterface.getInetAddresses();
        while (addresses.hasMoreElements()){
            ip = (InetAddress) addresses.nextElement();
            if (ip != null && ip instanceof Inet4Address){
                System.out.println("本机的IP = " + ip.getHostAddress());
                ipstr=ip.getHostAddress();
            }
        }}
        return ipstr;
    }
}

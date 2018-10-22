package com.snow.utils;

import com.snow.model.SysUserEnt;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * HttpSessionListener 监听器:监听的是session创建和销毁事件，
 * 比如用户通过浏览器访问项目时(创建session)或者session失效等时会触发该监听
 *HttpSessionAttributeListener监听的是session属性的事件，
 * 比如调用session的setAttribute方法或removeAttribute时会触发该监听器
 */
@WebListener
public class SessionListener implements HttpSessionListener{
    //当前用户数
    private static  int onlNum=0;
    public static  int getOnlNum() {
        return onlNum;
    }
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        //sessionCreated  用户数+1
        SessionListener.onlNum++;
        System.out.println("创建session："+onlNum);

    }
    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        //sessionDestroyed  用户数-1
        SessionListener.onlNum--;
        System.out.println("销毁session："+onlNum);
    }

}


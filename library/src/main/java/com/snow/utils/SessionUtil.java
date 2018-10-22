package com.snow.utils;

/**
 * @author 刘大猫 E-mail：snow60520@163.com
 * @version 创建时间：2018/10/6 0006
 */

import com.snow.model.SessionUser;

import java.util.ArrayList;



public class SessionUtil {
    //根据sessionId判断当前用户是否存在在集合中  如果存在 返回当前用户  否则返回null
    public static SessionUser getUserBySessionId(ArrayList<SessionUser> userList, String sessionId) {
        for (SessionUser sessionUser : userList) {
            if(sessionId.equals(sessionUser.getSessionId())){
                return sessionUser;
            }
        }
        return null;
    }
}

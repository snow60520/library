package com.snow.utils;

import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Md5加密
 * @author 刘大猫 E-mail：snow60520@163.com
 * @version 创建时间：2018/10/3 0003
 */
public class Md5 {
    /**
     * 1，利用MD5进行加密
     * @param str 要加密字符
     * @return String 返回md5加密后的字符串
     * @throws NoSuchAlgorithmException
     * @throws UnsupportedEncodingException
     */
    public static String getMd5Str(String str) throws Exception{
        //确定计算方法
        MessageDigest md5=MessageDigest.getInstance("MD5");
        BASE64Encoder base64en = new BASE64Encoder();
        //加密后的字符串
        String newStr=base64en.encode(md5.digest(str.getBytes("utf-8")));
        return newStr;
    }

}

package com.snow.controller;

import com.snow.model.PageEntity;
import com.snow.model.SysUserEnt;
import com.snow.service.ISysUserService;
import com.snow.utils.PageUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 刘大猫 E-mail：snow60520@163.com
 * @version 创建时间：2018/10/12 0012
 */
@Controller
@RequestMapping("Admin")
public class SysUserCon {
    @Resource
    private ISysUserService userService;
    @RequestMapping("/getListUser")
    public void getListUser(HttpServletRequest request, HttpServletResponse response){
        String userIdentity="admin";//身份
        String likeName="";
        Integer curPage=1;
        Integer curPageSize=1;
        Integer totalRows=0;
//        PageEntity page=new PageEntity();
//        page.setCurPage(curPage);
//        page.setCurPageSize(curPageSize);

        List<SysUserEnt> listUser=userService.getListUser(userIdentity,likeName,curPage,curPageSize);
         totalRows=userService.getUserCount(userIdentity,likeName);//总行
        PageEntity pageEnt=PageUtil.getPage(totalRows,curPage,curPageSize);//获取分页各参数
        System.out.println("分页:"+pageEnt);
        //分页数据
        List<PageEntity> listPage=new ArrayList<PageEntity>();
        listPage.add(pageEnt);
        Map<String, List> map=new HashMap<String, List>();
        map.put("a",listUser);
        map.put("b",listPage);
        System.out.println("Map:"+map);
        //JSONArray jsonArray=JSONArray.fromObject(map);

        JSONObject jsonArray=JSONObject.fromObject(map);
        response.setContentType("text/plain;charset=UTF-8");//返回数据为utf-8
        try {
            PrintWriter out=response.getWriter();
            out.print(jsonArray);//传回ajax
            System.out.println("jsonArray:"+jsonArray);
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}

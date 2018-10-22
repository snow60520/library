package com.snow.service.impl;

import com.snow.dao.IUtilsDao;
import com.snow.model.SysUserEnt;
import com.snow.service.ISysUserService;
import com.snow.utils.PageUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import java.util.List;


/**
 * @author 刘大猫 E-mail：snow60520@163.com
 * @version 创建时间：2018/10/3 0003
 */
// 加载spring配置文件
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-mybatis.xml"})
public class SysUserServiceImplTest {
    @Autowired
    private ISysUserService userService;
    @Resource
    private IUtilsDao utilsDao;
    //1,验证用户(userName)是否存在
    @Test
    public void isUserName() {
        String userName="snow1";
        boolean isName=userService.isUserName(userName);
        System.out.println("用户是否存在:"+isName);
    }
    //2,验证用户(userTel)是否存在
    @Test
    public void isUserTel() {
        String userTel="12345678901";
        boolean isName=userService.isUserName(userTel);
        System.out.println("手机号是否存在:"+isName);
    }
    //3,用户注册,用户实体类(userName,userPwd,userTel),userState(默认Y)，userTime（默认当前时间）,
    @Test
    public void isAddUser() {
        SysUserEnt userEnt=new SysUserEnt();
        userEnt.setUserName("snow8");
        userEnt.setUserPwd("12345678");
        userEnt.setUserTel("18280078264");
        userEnt.setUserIdentity("员工");
        userEnt.setUserState("Y");
        boolean isSave=userService.isAddUser(userEnt);//添加
        System.out.println("是否添加成功:"+isSave);
    }

    //4,登陆，传入(账号与密码)
    @Test
    public void isLogin() throws Exception {
        HttpServletRequest request;
        String userName="snow1";
        String userPwd="12345678";
       // SysUserEnt userEnt=userService.selLogin(request,userName,userPwd);
       // System.out.println("userEnt:"+userEnt);
    }

    @Test
    public void getListUser() {
//       Integer totalRows=utilsDao.selTableRowCount("sys_user");//总行
//        System.out.println(totalRows);
        String userIdentity="超管";
        String  likeName="";
        Integer curPage=1;
        Integer curPageSize=2;
        List<SysUserEnt> listUser=userService.getListUser(userIdentity,likeName,curPage,curPageSize);
        System.out.println("listUser:"+listUser);
    }

    /**
     * 7,根据userId查询一条帐号，权限组，权限的一条信息
     * @param userId
     * @return
     */
    @Test
    public void getUserRolePerId() {
        Long userId=1L;
        SysUserEnt userEnt=userService.getUserRolePerId(userId);
        System.out.println("userEnt:"+userEnt);
    }
    //8,修改个人密码
    @Test
    public void isUpdateUserPwd() {
        Boolean isUserPwd=false;
        Long userId=2L;
        String userPwdOld="12345678";
        String userPwdNew="1234";
        isUserPwd=userService.isUpdateUserPwd(userId,userPwdOld,userPwdNew);
        System.out.println("修改个人密码:"+isUserPwd);
    }
     //9,根据id查询账号身份
    @Test
    public void getIdentity() {
        String userName="snow9";
        String identity=userService.getIdentity(userName);
        System.out.println("identity:"+identity);
    }
    //10,修改密码传入账号userName
    @Test
    public void isResetUserPwd() throws Exception {
        HttpServletRequest request = null;
        Boolean isResetPwd=false;
        String userName="snow9";
        isResetPwd=userService.isResetUserPwd(request,userName);
        System.out.println("修改为默认密码:"+isResetPwd);
    }
    //11,根据userId根改userState账号的状态Y,N
    @Test
    public void isUpdeUserState() {
        Boolean isUserState=false;
        Long userId=4L;
        String userState="N";
        isUserState=userService.isUpdateUserState(userId,userState);
        System.out.println("更改账号的状态Y,N:"+isUserState);
    }

    //11,给一人用户添加一个权限组
    @Test
    public void isInsertUserAddRole() {
        Boolean isInsertRole=false;
        Long userId=2L;
        Long roleId=7L;
        isInsertRole=userService.isInsertUserAddRole(userId,roleId);
        System.out.println("添加一个权限组:"+isInsertRole);
    }


    //删除用户的一个权限组
    @Test
    public void isDeleteUserDelRole() {
        Boolean isDelRole=false;
        Long userID=2L;
        Long roleId=7L;
        isDelRole=userService.isDeleteUserDelRole(userID,roleId);
        System.out.println("删除用户的一个权限组:"+isDelRole);

    }
    //分页查询
    @Test
    public void getListUser1() {
        String userIdentity="admin";
        String likeName="";
        Integer curPage=1;
        Integer curPageSize=2;
        List<SysUserEnt> list=userService.getListUser(userIdentity,likeName,curPage,curPageSize);
        System.out.println("list:"+list);
        System.out.println();
    }
}
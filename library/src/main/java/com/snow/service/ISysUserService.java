package com.snow.service;


import com.snow.model.SysUserEnt;
import org.apache.ibatis.annotations.Param;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

/**
 * @author 刘大猫 E-mail:snow60520@163.com
 * @version 创建时间：2018/9/30 0030
 */
public interface ISysUserService {
    /**---------------------------1,用户注册----------------------------------------------*/
    /**
     * //1,验证用户(userName)是否存在
     * @param 用户帐号:String userName
     * @return 成功:true,失败:false
     */
    boolean isUserName(String userName);

    /**
     * //2,验证用户(userTel)是否存在
     * @param 手机号:String userTel
     * @return 成功:true,失败:false
     */
    boolean isUserTel(String userTel);
    /**
     * //3,用户注册,用户实体类(传入参数:userName,userPwd,userTel),userState(默认Y)，userTime（默认当前时间）,
     * @param SysUserEnt userEnt(传入参数:Stirng userName,String userPwd,String userTel)
     * @return 成功:true,失败:false
     */
    boolean isAddUser(SysUserEnt userEnt);

    /**
     * //4,登陆，传入(账号与密码)
     * @param 帐号：String userName
     * @param 密码：String userPwd
     * @return 用户类：SysUserEnt
     */
    SysUserEnt  selLogin(@Param("request")HttpServletRequest request, @Param("userName")String userName, @Param("userPwd")String userPwd) throws UnsupportedEncodingException, NoSuchAlgorithmException, Exception;

    Integer getUserCount(@Param("userIdentity")String userIdentity,@Param("likeName")String likeName);

    /**
     *6,查询全部或模糊查询用户名的账号列表 likeName=null为全部
     * @param userIdentity 用户类型，员工，会员
     * @param likeName 模糊查询帐号
     * @param 分页各参数 //1,表名,,2显示第几页,每页显示多少条
     * @curPage    显示页数
     * @curPageSize 每页显示条数
     * @return
     */
    List<SysUserEnt> getListUser(@Param("userIdentity")String userIdentity,@Param("likeName")String likeName,@Param("curPage")Integer curPage,@Param("curPageSize")Integer curPageSize);

    /**
     * 7,根据userId查询一条帐号，权限组，权限的一条信息
     * @param userId
     * @return
     */
    SysUserEnt getUserRolePerId(Long userId);

    /**
     * 8,修改个人密码
     * @param userId
     * @param userPwdOld
     * @param userPwdNew
     * @return
     */
    Boolean isUpdateUserPwd(Long userId,String userPwdOld,String userPwdNew);

    /**
     * 9,根据id查询账号身份
     * @param userName
     * @return identity账号身份,超管,员工,会员
     */
    String getIdentity(String userName);

    /**
     * 10,根据userId根改userState账号的状态Y,N
     * @param userId
     * @param userState
     * @return
     */
    Boolean isUpdateUserState(Long userId,String userState);

    /**
     * 11,给一人用户添加一个权限组
     * @param userId SysUserEnt 用户
     * @param roleId SysRoleEnt 权限组
     * @return true,false
     */
    Boolean isInsertUserAddRole(Long userId,Long roleId);

    /**
     * 12,删除用户的一个权限组
     * @param userId
     * @param roleId
     * @return true,false
     */
    Boolean isDeleteUserDelRole(Long userId,Long roleId);





    /*----------------------------------下外用直接调用接口-------------------------------------------*/
    //1,整合注销账号
    /***
     * //1,注销帐号
     * @param request
     * @return 成功:true,失败:false
     */
    boolean isLogout(HttpServletRequest request);
    //2，isUpdeUserPwd和9，getIdentity整合调用(会员，员工恢复初始密码12345678)
    /**
     * 2，传入request，和要修改的账号userName，
     * @param request
     * @param userName
     * @return
     */
    Boolean isResetUserPwd(HttpServletRequest request,String userName) throws Exception;


    /*---------------------------------上--------------------------------------------*/



}

package com.snow.model;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


/**
 * @author 刘大猫 E-mail:snow60520@163.com
 * @version 创建时间：2018/9/24 0024
 * -- 1,创建用户表sys_user
 */
public class SysUserEnt {
    /**ID*/
    private  Long userId;
    /**不能为空帐户唯一*/
    private  String userName;
    /**不能为空手机号唯一*/
    private String userTel;
    /**不能为空密码*/
    private  String userPwd;
    /**默认帐号:1会员,2员工,3超管*/
    private String userIdentity;
    /**默认帐号:Y启用,N不启用*/
    private  String userState;
    /**默认时间*/
    private Timestamp userTime;

    /** 2,用户帐号与用户角色的关系表user_role*/
   private List<SysRoleEnt> roles=new ArrayList<SysRoleEnt>();
   /*----------------------------------------------------------------------------------------------------------------*/

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserTel() {
        return userTel;
    }

    public void setUserTel(String userTel) {
        this.userTel = userTel;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getUserIdentity() {
        return userIdentity;
    }

    public void setUserIdentity(String userIdentity) {
        this.userIdentity = userIdentity;
    }

    public String getUserState() {
        return userState;
    }

    public void setUserState(String userState) {
        this.userState = userState;
    }

    public Timestamp getUserTime() {
        return userTime;
    }

    public void setUserTime(Timestamp userTime) {
        this.userTime = userTime;
    }

    public List<SysRoleEnt> getRoles() {
        return roles;
    }

    public void setRoles(List<SysRoleEnt> roles) {
        this.roles = roles;
    }

    public SysUserEnt() {
        super();
    }

    public SysUserEnt(Long userId, String userName, String userTel, String userPwd, String userIdentity, String userState, Timestamp userTime, List<SysRoleEnt> roles) {
        this.userId = userId;
        this.userName = userName;
        this.userTel = userTel;
        this.userPwd = userPwd;
        this.userIdentity = userIdentity;
        this.userState = userState;
        this.userTime = userTime;
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "SysUserEnt{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userTel='" + userTel + '\'' +
                ", userPwd='" + userPwd + '\'' +
                ", userIdentity='" + userIdentity + '\'' +
                ", userState='" + userState + '\'' +
                ", userTime=" + userTime +
                ", roles=" + roles +
                '}';
    }
}

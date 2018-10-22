package com.snow.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 刘大猫 E-mail:snow60520@163.com
 * @version 创建时间：2018/9/24 0024
 * -- 2,创建用户角色表user_role
 */
public class SysRoleEnt {
    /**角色ID*/
    private  Long roleId;
    /**不能为空角色名字唯一*/
    private  String roleName;

    /**3,创建权限表sys_permission*/
        List<SysPerEnt> perm=new ArrayList<SysPerEnt>();

    /**------------------------------------------------------------------------*/
    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public List<SysPerEnt> getPerm() {
        return perm;
    }

    public void setPerm(List<SysPerEnt> perm) {
        this.perm = perm;
    }

    public SysRoleEnt() {
        super();
    }

    public SysRoleEnt(Long roleId, String roleName, List<SysPerEnt> perm) {
        this.roleId = roleId;
        this.roleName = roleName;
        this.perm = perm;
    }

    @Override
    public String toString() {
        return "SysRoleEnt{" +
                "roleId=" + roleId +
                ", roleName='" + roleName + '\'' +
                ", perm=" + perm +
                '}';
    }
}

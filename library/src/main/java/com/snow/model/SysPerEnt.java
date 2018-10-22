package com.snow.model;

/**
 * @author 刘大猫 E-mail:snow60520@163.com
 * @version 创建时间：2018/9/24 0024
 * -- 3,创建权限表sys_permission
 */
public class SysPerEnt {
    /**权限ID*/
private  Integer perId;
/**不能为空权限名字唯一*/
private  String perName;

/*-------------------------------------------------------------------------------*/

    public Integer getPerId() {
        return perId;
    }

    public void setPerId(Integer perId) {
        this.perId = perId;
    }

    public String getPerName() {
        return perName;
    }

    public void setPerName(String perName) {
        this.perName = perName;
    }

    public SysPerEnt() {
        super();
    }

    public SysPerEnt(Integer perId, String perName) {
        this.perId = perId;
        this.perName = perName;
    }

    @Override
    public String toString() {
        return "SysPerEnt{" +
                "perId=" + perId +
                ", perName='" + perName + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

}

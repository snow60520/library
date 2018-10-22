package com.snow.dao;

import com.snow.model.PageEntity;
import com.snow.model.SysUserEnt;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * @author 刘大猫 E-mail:snow60520@163.com
 * @version 创建时间：2018/9/30 0030
 */
@Repository
public interface ISysUserDao {
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
  * //3,用户注册,用户实体类(传入参数:userName,userPwd,userTel),userIdentity(默认会员),userState(默认Y)，userTime（默认当前时间）,
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
 SysUserEnt  selLogin(@Param("userName")String userName, @Param("userPwd")String userPwd);

 /**
  *5,查询全部或模糊查询用户名的总条数和账号列表
  * @param likeName 模糊查询帐号
  * @param likeName 模糊查询帐号
  * @param pageEnt 分页各参数
  * @param userIdentity 身份参数
  * @return
  */
 Integer getUserCount(@Param("userIdentity")String userIdentity,@Param("likeName")String likeName);
 List<SysUserEnt> getListUser(@Param("userIdentity")String userIdentity,@Param("likeName")String likeName,@Param("pageEnt")PageEntity pageEnt);

 /**
  * 7,根据userId查询一条帐号，权限组，权限的一条信息
  * @param userId
  * @return
  */
 SysUserEnt getUserRolePerId(Long userId);

 /**
  * 9,根据id查询账号身份
  * @return identity账号身份,超管,员工,会员
  */
 String getIdentity(String userName);

 /**------------------------------ 一,添加区(insert)------------------------------------*/
 //1,固定添加有的方法
 /**
  * 1,固定添加有的方法
  * 必须有传入的参数userName,userTel,userPwd,userIdentity
  * @param userEnt
  * @return
  */
 Boolean insertAll(SysUserEnt userEnt);

 //2,有选择性的添加
 /**
  * 2,有选择性的添加
  * userName,userTel,userPwd,userIdentity,userState,userTime任意
  * @param userEnt
  * @return
  */
 Boolean insertSelective(SysUserEnt userEnt);
                     //sys_user和sys_role表共同
//3,给用户添加一个权限组
 Boolean insertUserAddRole(@Param("userId")Long userId,@Param("roleId")Long roleId);

 /**------------------------------ 二,删除区(delete)------------------------------------*/
                          //sys_user和sys_role表共同
//3,给用户添加一个权限组
 Boolean deleteUserDelRole(@Param("userId")Long userId,@Param("roleId")Long roleId);
 /**------------------------------ 三,更改区(update)------------------------------------*/
 //1,根据传入userID和userName,userTel,userPwd,userIdentity,userState,userTime任意
 /**
  * 1,根据传入userID和userName,userTel,userPwd,userIdentity,userState,userTime任意
  * 进行更改
  * @param userEnt
  * @return
  */
 Boolean updateByUserIdSelective(SysUserEnt userEnt);
 //2,根据传入userName和userTel,userPwd,userIdentity,userState,userTime任意
 /**
  * 2,根据传入userName和userTel,userPwd,userIdentity,userState,userTime任意
  * 进行更改
  * @param userEnt
  * @return
  */
 Boolean updateByUserNameSelective(SysUserEnt userEnt);

                             //sys_user和sys_role表共同
//1,给用户添加一个权限组
 Boolean updateUserRole(@Param("userId")Long userId,@Param("roleId1")Long roleId1,@Param("roleId2")Long roleId2);

 /**------------------------------ 四,查询区(select)------------------------------------*/
 /**
  * 1,查询表某一列值是否为真，根据表一列或多列条件
  * @param userEnt
  * @return true,false
  */
 Boolean selectUserLineByUserEntSelective(SysUserEnt userEnt);

 /**
  * 2,查询表列全部值，根据表一列或多列条件
  * @param userEnt
  * @return true,false
  */
 List<SysUserEnt> selectUserAllByUserEntSelective(SysUserEnt userEnt);





 List<SysUserEnt> selectUserAll();
}

package com.snow.service.impl;

import com.snow.dao.ISysUserDao;
import com.snow.model.PageEntity;
import com.snow.model.SysUserEnt;
import com.snow.service.ISysUserService;
import com.snow.utils.Md5;
import com.snow.utils.PageUtil;
import com.snow.utils.SessionListener;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author 刘大猫 E-mail:snow60520@163.com
 * @version 创建时间：2018/9/30 0030
 */
@Service
public class SysUserServiceImpl implements ISysUserService {
    @Resource
    private ISysUserDao userDao;



    /**
     * //1,验证用户(userName)是否存在
     * @param  userName 用户帐号:String
     * @return 成功:true,失败:false
     */
    @Override
    public boolean isUserName(String userName) {
        boolean isName=false;
        try {
            isName=userDao.isUserName(userName);
        }catch (Exception e) {e.printStackTrace();}
            return isName;
    }

    /**
     * //2,验证用户(userTel)是否存在
     * @param  userTel 手机号:
     * @return 成功:true,失败:false
     */
    @Override
    public boolean isUserTel(String userTel) {
        boolean isTel=false;
        try {
            isTel=userDao.isUserTel(userTel);
        }catch (Exception e) { e.printStackTrace();}
        return isTel;
    }

    /**
     * //3,用户注册,用户实体类(传入参数:userName,userPwd,userTel),userState(默认Y)，userTime（默认当前时间）,
     * @param userEnt(传入参数:userName,String userPwd,String userTel)
     * @return 成功:true,失败:false
     */
    @Override
    public boolean isAddUser(SysUserEnt userEnt) {
        boolean isSave=false;
        String newPwd;
        try {
            newPwd=Md5.getMd5Str(userEnt.getUserPwd());//给密码添加MD5加密
            userEnt.setUserPwd(newPwd);
            isSave=userDao.isAddUser(userEnt);
        }catch (Exception e) {e.printStackTrace();}
        return isSave;
    }

    /**
     * //4,登陆，传入(账号与密码)
     * @param  userName 帐号：
     * @param  userPwd 密码：
     * @return 用户类：SysUserEnt(账号表，权限组表，权限表)
     */
    @Override
    public SysUserEnt selLogin(HttpServletRequest request,String userName, String userPwd) throws Exception {
        SysUserEnt userEnt=null;
        try {
            userPwd=Md5.getMd5Str(userPwd);//把登录密码加密
            userEnt=userDao.selLogin(userName,userPwd);
            request.getSession().setAttribute("loginUserEnt",userEnt);//添加登录session
        }catch (Exception e){e.printStackTrace();}
        return userEnt;
    }


    /**
     * 6,查询全部或模糊查询用户名的账号列表 likeName=null为全部
     *  * @param userIdentity 超管，员工，会员
     * @param likeName 模糊查询帐号
     * @param curPage
     * @param curPageSize
     * @return
     */
    public List<SysUserEnt> getListUser(String userIdentity,String likeName,Integer curPage,Integer curPageSize) {

        //1,表名,,2显示第几页,每页显示多少条
        //获取分页page
        List<SysUserEnt> listUser= null;
        try {
            Integer totalRows=userDao.getUserCount(userIdentity,likeName);//总行
            PageUtil page=new PageUtil();
            PageEntity pageEnt=page.getPage(totalRows,curPage,curPageSize);//获取分页各参数
            //查询详细
            listUser = userDao.getListUser(userIdentity,likeName,pageEnt);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listUser;
    }

    //返回查询总条数
    @Override
    public Integer getUserCount(String userIdentity,String likeName) {
        Integer totalRows=userDao.getUserCount(userIdentity,likeName);
        return totalRows;
    }


    /**
     * 7,根据userId查询一条帐号，权限组，权限的一条信息
     * @param userId
     * @return
     */
    @Override
    public SysUserEnt getUserRolePerId(Long userId) {
        SysUserEnt userEnt= null;

        try {
            userEnt = userDao.getUserRolePerId(userId);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return userEnt;
    }

    /**
     * 8,修改个人密码
     * @param userId
     * @param userPwdOld
     * @param userPwdNew
     * @return
     */
    @Override
    public Boolean isUpdateUserPwd(Long userId,String userPwdOld, String userPwdNew) {
        Boolean isUserPwd=false;
        SysUserEnt userEntOld=new SysUserEnt();
        SysUserEnt userEntNew=new SysUserEnt();
        try {
            userEntOld.setUserId(userId);//账号id
            userEntOld.setUserPwd(Md5.getMd5Str(userPwdOld));//旧密码
            userEntNew.setUserId(userId);//账号id
            userEntNew.setUserPwd(Md5.getMd5Str(userPwdNew));//新密码
            //1,查询旧密码是否正确
            if (userDao.selectUserLineByUserEntSelective(userEntOld)){
                isUserPwd=userDao.updateByUserIdSelective(userEntNew);//修改密码
            }else {
                System.out.println("旧密码不正确!");
            }
        } catch (Exception e) { e.printStackTrace(); }

        return isUserPwd;
    }

    /**
     * 9,根据id查询账号身份
     * @param userId
     * @return
     */
    @Override
    public String getIdentity(String userName) {

        String  identity= null;
        try {
            identity = userDao.getIdentity(userName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return identity;
    }

    /**
     * 10,根据userId根改userState账号的状态Y,N
     * @param userId
     * @param userState
     * @return
     */
    @Override
    public Boolean isUpdateUserState(Long userId, String userState) {
        Boolean isUserState=false;
        SysUserEnt userEnt=new SysUserEnt();
        try {
            if (userState.equals("Y")||userState.equals("N")) {
                userEnt.setUserId(userId);//账号id
                userEnt.setUserState(userState);//账号状态
                isUserState = userDao.updateByUserIdSelective(userEnt);
            }
        } catch (Exception e) { e.printStackTrace(); }

        return isUserState;
    }
    /**
     * 11,给一人用户添加一个权限组
     * @param userId SysUserEnt 用户
     * @param roleId SysRoleEnt 权限组
     * @return true,false
     */
    @Override
    public Boolean isInsertUserAddRole(Long userId, Long roleId) {
        Boolean isInsertRole=false;
        try {
            isInsertRole=userDao.insertUserAddRole(userId,roleId);//给一人用户添加一个权限组
        } catch (Exception e) { e.printStackTrace(); }
        return isInsertRole;
    }

    /**
     * 12,删除用户的一个权限组
     * @param userId
     * @param roleId
     * @return true,false
     */
    @Override
    public Boolean isDeleteUserDelRole(Long userId, Long roleId) {
        Boolean isDelRole=false;
        try {
            isDelRole=userDao.deleteUserDelRole(userId, roleId);
        } catch (Exception e) { e.printStackTrace(); }
        return isDelRole;
    }

    /**--------------------------------下外用直接调用接口------------------------------------*/
    /***
     * //1,注销帐号
     * @param request
     * @return 成功:true,失败:false
     */
    @Override
    public boolean isLogout(HttpServletRequest request) {
        boolean logOut=false;
        try {
            request.getSession().invalidate();//销毁session
            int onlNum= SessionListener.getOnlNum();//在线人数
            System.out.println("在线人数:"+onlNum);
            logOut=true;
        }catch (Exception e){ e.printStackTrace();}

        return logOut;
    }

    /**
     * //2，传入request，和要修改的账号userName
     * @param request
     * @param userName
     * @return
     */
    @Override
    public Boolean isResetUserPwd(HttpServletRequest request, String userName) throws Exception {
        Boolean isResetPwd=false;
        String userPwd="12345678";//初始密码
        String sysIdentity=null;//登录身份
        String userIdentity=null;//要修改帐号身份

         sysIdentity="超管";//当前登录身份,超管或员工
        SysUserEnt userEnt=new SysUserEnt();
        try {
            //SysUserEnt  loginUserEnt=(SysUserEnt)request.getSession().getAttribute("loginUserEnt");
            //sysIdentity=loginUserEnt.getUserIdentity();//1,登录身份
            userIdentity=userDao.getIdentity(userName);//2,获取要修改账号的身份
            userPwd=Md5.getMd5Str(userPwd);//3,初始密码加密
            userEnt.setUserName(userName);
            userEnt.setUserPwd(userPwd);
        }catch (Exception e) { e.printStackTrace(); }

        //1，超管修改员工或会员
        if ("超管".equals(sysIdentity) &&("员工".equals(userIdentity)||"会员".equals(userIdentity))){
            try {
                isResetPwd=userDao.updateByUserNameSelective(userEnt);
            } catch (Exception e) { e.printStackTrace(); }
            //2，员工修改会员
        }else if ("员工".equals(sysIdentity)&&"会员".equals(userIdentity)){
            try {
                isResetPwd=userDao.updateByUserNameSelective(userEnt);
            } catch (Exception e) { e.printStackTrace(); }
        }

        return isResetPwd;
    }

    /**-----------------------------------上外用直接调用接口------------------------------------------*/
}

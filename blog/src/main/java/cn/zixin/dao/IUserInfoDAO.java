package cn.zixin.dao;


import cn.zixin.entity.UserInfo;

/**
 * Created by Happy on 2017-06-30.
 */
public interface IUserInfoDAO {
    //判定用户是否登录成功！
    public boolean isLogin(UserInfo info) throws Exception;
}

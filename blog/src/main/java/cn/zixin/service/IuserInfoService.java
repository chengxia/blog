package cn.zixin.service;

import cn.zixin.entity.UserInfo;

/**
 * Created by benxin on 2017/7/2.
 */
public interface IuserInfoService {
    //判定用户是否登录成功！
        public boolean isLogin(UserInfo info) throws Exception;

}

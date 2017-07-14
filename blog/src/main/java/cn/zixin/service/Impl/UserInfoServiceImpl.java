package cn.zixin.service.Impl;

import cn.zixin.dao.IUserInfoDAO;
import cn.zixin.dao.impl.UserInfoDAOImpl;
import cn.zixin.entity.UserInfo;
import cn.zixin.service.IuserInfoService;

/**
 * Created by benxin on 2017/7/2.
 */
public class UserInfoServiceImpl implements IuserInfoService{

IUserInfoDAO dao=new UserInfoDAOImpl();
    public boolean isLogin(UserInfo info) throws Exception {
        return dao.isLogin(info);
    }
}

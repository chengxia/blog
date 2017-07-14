package cn.zixin.dao.impl;

import cn.zixin.dao.BaseDao;
import cn.zixin.dao.IvisitLogDao;
import cn.zixin.entity.VisitLog;

/**
 * Created by benxin on 2017/7/5.
 */
public class VisitLogDaoImpl extends BaseDao implements IvisitLogDao {
    public boolean addLog(VisitLog info) throws Exception {
        boolean flog=false;
        String sql="insert into visitLog(IpAddress,VisitTime) values(?,?)";
        Object[] para={info.getIpAddress(),info.getVisitTime()};
        int update = executeUpdate(sql, para);
        if (update>0){
            flog=true;
        }
        return flog;
    }
}

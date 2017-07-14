package cn.zixin.service.Impl;

import cn.zixin.dao.IvisitLogDao;
import cn.zixin.dao.impl.VisitLogDaoImpl;
import cn.zixin.entity.VisitLog;
import cn.zixin.service.IvisitLogService;

/**
 * Created by benxin on 2017/7/5.
 */
public class VisitLogServiceImpl implements IvisitLogService{
    IvisitLogDao dao=new VisitLogDaoImpl();
    public boolean addLog(VisitLog info) throws Exception {
        return dao.addLog(info);
    }
}

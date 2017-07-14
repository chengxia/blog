package cn.zixin.dao;

import cn.zixin.entity.VisitLog;

/**
 * Created by benxin on 2017/7/5.
 */
public interface IvisitLogDao {

    public  boolean addLog(VisitLog info) throws Exception;
}

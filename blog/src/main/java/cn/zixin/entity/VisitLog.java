package cn.zixin.entity;

import java.util.Date;

/**
 * Created by benxin on 2017/7/5.
 */
public class VisitLog {

    private int logid;
    private String IpAddress;
    private String ProvinceAndCity;
    private Date VisitTime;
    private boolean IsDel;

    public int getLogid() {
        return logid;
    }

    public void setLogid(int logid) {
        this.logid = logid;
    }

    public String getIpAddress() {
        return IpAddress;
    }

    public void setIpAddress(String ipAddress) {
        IpAddress = ipAddress;
    }

    public String getProvinceAndCity() {
        return ProvinceAndCity;
    }

    public void setProvinceAndCity(String provinceAndCity) {
        ProvinceAndCity = provinceAndCity;
    }

    public Date getVisitTime() {
        return VisitTime;
    }

    public void setVisitTime(Date visitTime) {
        VisitTime = visitTime;
    }

    public boolean isDel() {
        return IsDel;
    }

    public void setDel(boolean del) {
        IsDel = del;
    }
}

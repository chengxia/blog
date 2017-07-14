package cn.blog.entity;

import java.util.Date;

/**
 * Created by benxin on 2017/7/7.
 */
public class HomeWork {

    private  Integer homeId;
    private String homeGrage;
    private String homeTeacher;
    private String homeChapter;
    private String homeContent;
    private Date homeTime;



    public Integer getHomeId() {
        return homeId;
    }

    public void setHomeId(Integer homeId) {
        this.homeId = homeId;
    }

    public String getHomeTeacher() {
        return homeTeacher;
    }

    public void setHomeTeacher(String homeTeacher) {
        this.homeTeacher = homeTeacher;
    }

    public String getHomeChapter() {
        return homeChapter;
    }

    public void setHomeChapter(String homeChapter) {
        this.homeChapter = homeChapter;
    }

    public String getHomeContent() {
        return homeContent;
    }

    public void setHomeContent(String homeContent) {
        this.homeContent = homeContent;
    }

    public Date getHomeTime() {
        return homeTime;
    }

    public void setHomeTime(Date homeTime) {
        this.homeTime = homeTime;
    }

    public String getHomeGrage() {return homeGrage;}

    public void setHomeGrage(String homeGrage) {this.homeGrage = homeGrage;}
}

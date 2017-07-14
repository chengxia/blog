package cn.blog.dao.iimpl;


import cn.blog.dao.BaseDao;
import cn.blog.dao.IHomeWorkDao;
import cn.blog.entity.HomeWork;
import org.junit.Test;


import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by benxin on 2017/7/7.
 */
public class HomeWorkDao extends BaseDao implements IHomeWorkDao{


    public boolean Addwork(HomeWork work) throws Exception {
        boolean flag=false;
        String  sql="insert into homework(homeGrage,homeTeacher,homeChapter,homeContent,homeTime) values(?,?,?,?,?)";
        Object[] paras={work.getHomeGrage(),work.getHomeTeacher(),work.getHomeChapter(),work.getHomeContent(),work.getHomeTime()};
        int counts = executeUpdate(sql, paras);
        if (counts>0){
            flag=true;
        }
        return flag;
    }

    public List<HomeWork> findall() throws Exception {
        List<HomeWork> list=new ArrayList<HomeWork>();
        String sql="select * from homework";
        ResultSet rs = executeQuery(sql);
        while (rs.next()){
            HomeWork work=new HomeWork();
            work.setHomeGrage(rs.getString("homeGrage"));
            work.setHomeTeacher(rs.getString("homeTeacher"));
            work.setHomeChapter(rs.getString("homeChapter"));
            work.setHomeContent(rs.getString("homeContent"));
            work.setHomeTime(rs.getTimestamp("homeTime"));
            list.add(work);
        }
        return list;
    }
}

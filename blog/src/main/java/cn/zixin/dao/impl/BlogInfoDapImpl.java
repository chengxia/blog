package cn.zixin.dao.impl;


import cn.zixin.dao.BaseDao;
import cn.zixin.dao.IblogInfoDao;
import cn.zixin.entity.BlogInfo;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by benxin on 2017/7/2.
 */
public class BlogInfoDapImpl extends BaseDao implements IblogInfoDao {
    //列表
    public List<BlogInfo> getAll() throws Exception {
//       List<BlogInfo> list=new ArrayList<BlogInfo>();
//        String sql="select * from bloginfo where blogDel=0";
//        ResultSet rs=executeQuery(sql);
//        while (rs.next()){
//            BlogInfo info=new BlogInfo();
//            info.setBlogid(rs.getInt("blogid"));
//            info.setBlogAuthor(rs.getString("blogAuthor"));
//            info.setBlogAdress(rs.getString("blogAdress"));
//            info.setBlogDel(rs.getBoolean("blogDel"));
//            list.add(info);
//        }
        return null;
    }
    //增加
    public boolean addBlog(BlogInfo info) throws Exception {
        boolean flag=false;
        String sql="insert into bloginfo(blogAuthor,blogAdress) value(?,?)";
        Object[] para={info.getBlogAuthor(),info.getBlogAdress()};
        int count = executeUpdate(sql, para);
        if (count>0){
            flag=true;
        }
        return flag;
    }
    //修改
    public boolean editBlog(BlogInfo info) throws Exception {
        boolean flag=false;
        String sql="update bloginfo set blogAuthor=?,blogAdress=? where blogid=?";
        Object[] para={info.getBlogAuthor(),info.getBlogAdress(),info.getBlogid()};
        int count = executeUpdate(sql, para);
        if (count>0){
            flag=true;
        }
        return flag;
    }
    //删除
    public boolean getDel(int id) throws Exception {
        boolean flag=false;
        String sql="delete from bloginfo where blogid=?";
        int count = executeUpdate(sql,id);
        if (count>0){
            flag=true;
        }
        return flag;
    }
    //分页加列表
    public List<BlogInfo> getAllPage(int pageIndex, int pageSize) throws Exception {
        List<BlogInfo> list=new ArrayList<BlogInfo>();
        String sql="select * from bloginfo limit ?,?";
        Object[] para={(pageIndex-1)*pageSize,pageSize};
        ResultSet rs = executeQuery(sql, para);
        if (rs!=null){
          while (rs.next()){
              BlogInfo info=new BlogInfo();
              info.setBlogid(rs.getInt("blogid"));
              info.setBlogAuthor(rs.getString("blogAuthor"));
              info.setBlogAdress(rs.getString("blogAdress"));
              info.setBlogDel(rs.getBoolean("blogDel"));
              list.add(info);
          }
        }
        return list;
    }
    //得到总数
    public int getCount() throws Exception {
        int result=0;
        String sql="select count(*) as num from bloginfo";
        ResultSet query = executeQuery(sql);
        if (query!=null){
            if (query.next()){
                result = query.getInt("num");
            }
        }
        return result;
    }
}

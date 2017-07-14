package cn.zixin.service;

import cn.zixin.entity.BlogInfo;

import java.util.List;

/**
 * Created by benxin on 2017/7/3.
 */
public interface IBlogInfoService {
    //显示所有博客记录
    public List<BlogInfo> getAll() throws Exception;
    //添加博客
    public boolean addBlog(BlogInfo info) throws Exception;
    //修改博客
    public boolean editBlog(BlogInfo info) throws Exception;
    //删除博客
    public boolean getDel(int id)throws Exception;
    //博客列表+分页
    public List<BlogInfo> getAllPage(int pageIndex,int pageSize) throws Exception;
    //查询总记录数
    public int getCount() throws Exception;

}

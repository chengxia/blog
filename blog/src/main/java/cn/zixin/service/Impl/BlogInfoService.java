package cn.zixin.service.Impl;

import cn.zixin.dao.IblogInfoDao;
import cn.zixin.dao.impl.BlogInfoDapImpl;
import cn.zixin.entity.BlogInfo;
import cn.zixin.service.IBlogInfoService;

import java.util.List;

/**
 * Created by benxin on 2017/7/3.
 */
public class BlogInfoService implements IBlogInfoService {
    IblogInfoDao dao=new BlogInfoDapImpl();
    public List<BlogInfo> getAll() throws Exception {
        return dao.getAll();
    }
    public boolean addBlog(BlogInfo info) throws Exception {
        return dao.addBlog(info);
    }

    public boolean editBlog(BlogInfo info) throws Exception {
        return dao.editBlog(info);
    }

    public boolean getDel(int id) throws Exception {
        return dao.getDel(id);
    }

    public List<BlogInfo> getAllPage(int pageIndex, int pageSize) throws Exception {
        return dao.getAllPage(pageIndex, pageSize);
    }

    public int getCount() throws Exception {
        return dao.getCount();
    }
}

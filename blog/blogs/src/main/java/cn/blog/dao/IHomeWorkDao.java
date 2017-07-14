package cn.blog.dao;


import cn.blog.entity.HomeWork;

import java.util.List;

/**
 * Created by benxin on 2017/7/7.
 */
public interface IHomeWorkDao {
    public boolean Addwork(HomeWork work) throws Exception;

    public List<HomeWork> findall() throws  Exception;
}

package cn.zixin.servlet;

import cn.zixin.dao.IblogInfoDao;
import cn.zixin.dao.impl.BlogInfoDapImpl;
import cn.zixin.entity.BlogInfo;
import cn.zixin.service.IBlogInfoService;
import cn.zixin.service.Impl.BlogInfoService;
import cn.zixin.service.Impl.UserInfoServiceImpl;
import cn.zixin.service.IuserInfoService;
import cn.zixin.util.Page;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by benxin on 2017/7/2.
 */
@WebServlet(name = "BlogInfoServlet")
public class BlogInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        //1.实例化博客dao
        IBlogInfoService dao = new BlogInfoService();
        //拆解action
        String action = request.getParameter("action");
        if (action != null && action != "") {
            if (action.equals("add")) {
                BlogInfo info = new BlogInfo();
                String author = request.getParameter("blogAuthor");
                String adress = request.getParameter("blogAdress");
                info.setBlogAuthor(author);
                info.setBlogAdress(adress);
                try {
                    boolean blog = dao.addBlog(info);
                    if (blog) {
                        request.getRequestDispatcher("BlogHtTemplate-master/html/main.html").forward(request, response);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (action.equals("update")) {
                BlogInfo binfo = new BlogInfo();
                String author = request.getParameter("blogAuthor");
                String adress = request.getParameter("blogAdress");
                int blogid = Integer.parseInt(request.getParameter("blogId"));
                binfo.setBlogAuthor(author);
                binfo.setBlogAdress(adress);
                binfo.setBlogid(blogid);
                try {
                    boolean flog = dao.editBlog(binfo);
                    if (flog) {
                        request.getRequestDispatcher("BlogInfoServlet?action=list").forward(request, response);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if ("list".equals("action")) {
                //分页加列表
                Page page = new Page();
                //每页显示的记录数
                int pageSize = 6;
                page.setPageSize(pageSize);
                //当前页数
                int MyIndex = 1;
                String pageIndex = request.getParameter("pageIndex");
                if (pageIndex != null) {
                    MyIndex = Integer.parseInt(pageIndex);
                } else {
                    MyIndex = 1;
                }
                page.setPageIndex(MyIndex);
                //计算总页数
                int totapages;
                try {
                    int count = dao.getCount();
                    if (count % pageSize == 0) {
                        totapages = count / pageSize;
                    } else {
                        totapages = count / pageSize + 1;
                    }
                        page.setTotapages(totapages);
                } catch (Exception e) {
                        e.printStackTrace();
                }
                //装载集合
                try {
                    List<BlogInfo> list = dao.getAllPage(page.getPageIndex(), page.getPageSize());
                    page.setBloglist(list);
                    request.setAttribute("page", page);
                    request.getRequestDispatcher("BlogHtTemplate-master/html/blog/bloglist.jsp").forward(request, response);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }else{
               //列表+分页
                   Page page=new Page();
              //每页显示的记录数
                   int pageSize=3;
                   page.setPageSize(pageSize);
              //当前页数
                   int MyIndex=1;
                   String pageIndex=request.getParameter("pageIndex");
                   if (pageIndex!=null){
                       MyIndex=Integer.parseInt(pageIndex);
                    }else{
                        MyIndex=1;
                    }
                     page.setPageIndex(MyIndex);
                  //计算总页数
                     int totapages;
                     try {
                         int count = dao.getCount();
                         if (count%pageSize==0){
                             totapages=count/pageSize;
                         }else{
                             totapages=count/pageSize+1;
                         }
                             page.setTotapages(totapages);
                         } catch (Exception e) {
                              e.printStackTrace();
                         } //装载集合
            try {
                    List<BlogInfo> list = dao.getAllPage(page.getPageIndex(), page.getPageSize());
                    page.setBloglist(list);
                    request.setAttribute("page",page);
                    request.getRequestDispatcher("BlogHtTemplate-master/html/blog/bloglist.jsp").forward(request,response);
            } catch (Exception e) {
                e.printStackTrace();
            }
         }
        }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
             doPost(request,response);
    }
}

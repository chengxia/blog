package cn.blog.servlet;

import cn.blog.dao.IHomeWorkDao;
import cn.blog.dao.iimpl.HomeWorkDao;
import cn.blog.entity.HomeWork;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * Created by benxin on 2017/7/7.
 */

public class HomeWorkServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        IHomeWorkDao dao = new HomeWorkDao();
        //对Action做判断
        String action = request.getParameter("action");

        if (action.equals("add")) {
            request.setCharacterEncoding("utf-8");
            String homeGrage = request.getParameter("homeGrage");
            String homeTeacher = request.getParameter("homeTeacher");
            String homeChapter = request.getParameter("homeChapter");
            String homeContent = request.getParameter("homeContent");
            HomeWork work = new HomeWork();
            work.setHomeGrage(homeGrage);
            work.setHomeTeacher(homeTeacher);
            work.setHomeChapter(homeChapter);
            work.setHomeContent(homeContent);
            work.setHomeTime(new Date());
            try {
                boolean flag = dao.Addwork(work);
                if (flag) {
                    request.getRequestDispatcher("/BlogHtTemplate-master/html/blog/main.jsp").forward(request, response);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }




        } else if (action.equals("list")) {  //走列表
            try {
                List<HomeWork> list = dao.findall();
                //放入request作用域
                request.setAttribute("list", list);
                //转发
                request.getRequestDispatcher("/BlogHtTemplate-master/html/teacher/homeworklist.jsp").forward(request, response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           doPost(request,response);
    }
}

package cn.zixin.servlet;

import cn.zixin.dao.IUserInfoDAO;
import cn.zixin.dao.impl.UserInfoDAOImpl;
import cn.zixin.entity.UserInfo;
import cn.zixin.entity.VisitLog;
import cn.zixin.service.Impl.UserInfoServiceImpl;
import cn.zixin.service.Impl.VisitLogServiceImpl;
import cn.zixin.service.IuserInfoService;
import cn.zixin.service.IvisitLogService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * Created by Happy on 2017-06-30.
 */
public class UserInfoServlet extends HttpServlet {

    public String getIPAddress(HttpServletRequest request){
        String ip = request.getHeader("x-forwarded-for");
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //write code here please ,oK?
        //使用dao实现类
        IuserInfoService dao=new UserInfoServiceImpl();
        String userCode=request.getParameter("userCode");
        String userPwd=request.getParameter("userPwd");
        IvisitLogService visit=new VisitLogServiceImpl();
        UserInfo info=new UserInfo();
        System.out.println(userCode+"===================");
        info.setUserName(userCode);
        info.setUserPwd(userPwd);
        try {
            boolean flag = dao.isLogin(info);
            if (flag){
                System.out.println("aaaaaaaaaaaaaaaaa");
                String IpAddress=getIPAddress(request);
                System.out.println("ccccccccccccccccc");
                VisitLog vs=new VisitLog();
                vs.setIpAddress(IpAddress);
                vs.setVisitTime(new Date());
                visit.addLog(vs);
                System.out.println("bbbbbbbbbbbbbbbbb");
                request.getRequestDispatcher("/BlogHtTemplate-master/html/main.html").forward(request,response);
            }else{
                response.sendRedirect("/BlogHtTemplate-master/html/index.html");
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        //  dao.isLogin();
        //跳转
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doPost(request,response);
    }
}

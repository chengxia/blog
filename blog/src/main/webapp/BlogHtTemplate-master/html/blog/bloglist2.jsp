<%--
  Created by IntelliJ IDEA.
  User: benxin
  Date: 2017/7/4
  Time: 12:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0"/>
    <title>博客列表</title>
    <link  rel="stylesheet"  href="/BlogHtTemplate-master/bootstrap/css/bootstrap.css"></link>
    <link  rel="stylesheet"  href="/BlogHtTemplate-master/css/myCSS.css"></link>
    <link  rel="stylesheet"  href="/BlogHtTemplate-master/css/blogAdd.css"></link>
    <script type="text/javascript"  src="/BlogHtTemplate-master/bootstrap/js/jquery-1.12.4.js"></script>
    <script type="text/javascript"  src="/BlogHtTemplate-master/bootstrap/js/bootstrap.js"></script>
    <script type="text/javascript">
        function editBlog(id,obj){
            $("#rid").val(id);
          }
        function del(myid) {
            location.href="BlogInfoServlet?action=del&id="+myid;
          }
    </script>
</head>
<body>
<div class="clearfix" id="home_partner">
    <div class="container">
        <h2 class="btitle">
            路漫漫其修远兮  吾将上下而求索
        </h2>
        <h4 class="subtitle">
            <span>
                不要让青春偷偷从身边溜走  认真过好每一天  好好学习
            </span>
        </h4>
        <br>
        <div class="row text-center">
            <c:forEach items="${all}" var="item">
            <div class="col-sm-4">
                <div class="partneritem" style="position:relative;">
                    <div>
                        <h4>
                                ${item.blogAuthor}
                        </h4>
                       <%--<img width="319px" height="319px" class="img-responsive" src="/BlogHtTemplate-master/images/${item.blogAuthor}.jpg" alt=""/>--%>
                    </div>
                    <div id="operation" style="position:absolute;background:#f1fdff;opacity:0.5;filter:alpha(opacity=50);text-align:center;margin-top:-50px;z-index:20;width: 290px;height: 40px;border: 1px solid red;">
                        <a href="#mymodal" data-toggle="modal" onclick="editBlog(${item.blogid},this)">修改</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="javascript:del(${item.blogid})">删除</a>
                    </div>

                    <p>
                        <a target="_blank" href="${item.blogAdress}">${item.blogAdress}</a>
                    </p>
                </div>
            </div>
            </c:forEach>
        </div>
    </div>
</div>

<div style="text-align: center">
    <a href="<%=path%>/BlogInfoServlet?pageIndex=1">首页</a> &nbsp;&nbsp;&nbsp;
    当前页:${page.pageIndex} / ${page.totapages} &nbsp;&nbsp;&nbsp;
    <a href="<%=path%>/BlogInfoServlet?pageIndex=${page.pageIndex-1}">上一页</a> &nbsp;&nbsp;&nbsp;
    <a href="<%=path%>/BlogInfoServlet?pageIndex=${page.pageIndex+1}">下一页</a> &nbsp;&nbsp;&nbsp;
    <a href="<%=path%>/BlogInfoServlet?pageIndex=${page.totapages}">尾页</a>
</div>
<!--弹出的模态框-->
<div id="mymodal" class="modal fade bs-examlpe-modal-sm"><!-- modal固定布局，上下左右都是0表示充满全屏，支持移动设备上使用触摸方式进行滚动。。-->
    <div class="modal-dialog modal-sm"><!-- modal-dialog默认相对定位，自适应宽度，大于768px时宽度600，居中-->
        <div class="modal-content"><!-- modal-content模态框的边框、边距、背景色、阴影效果。-->
            <div class="modal-header">
                <button clas="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">
                    修改
                    <small>孤独患者</small>
                </h4>
            </div>
            <div class="media-body">
                <form action="BlogInfoServlet?action=update" method="post">
                    <input type="hidden" name="blogId" value="" id="rid"/>
                    <div class="col-md-10 col-md-offset-1 myMP">
                        博客作者：<input name="blogAuthor" class="form-control" type="text" placeholder="博客作者"/>
                    </div>
                    <div class="col-md-10 col-md-offset-1 myMP">
                        博客地址： <input name="blogAdress" class="form-control" type="text" placeholder="博客地址"/>
                    </div>

                    <div class="col-md-12 myB">
                        <input class="btn btn-danger form-control" type="submit" value="修改"/>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
            </div>
        </div>
    </div>
</div>
</body>
</html>

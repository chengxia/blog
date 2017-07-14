<%--
  Created by IntelliJ IDEA.
  User: benxin
  Date: 2017/7/2
  Time: 14:48
  To change this template use File | Settings | File Templates.
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  isELIgnored="false"%>
<html>
<head>
    <title>数据列表页面</title>
    <link href="../plugin/layui/css/layui.css" rel="stylesheet" />
    <style>
        .layui-btn-small {
            padding: 0 15px;
        }

        .layui-form-checkbox {
            margin: 0;
        }

        tr td:not(:nth-child(0)),
        tr th:not(:nth-child(0)) {
            text-align: center;
        }

        #dataConsole {
            text-align: center;
        }
        /*分页页容量样式*/
        /*可选*/
        .layui-laypage {
            display: block;
        }

        /*可选*/
        .layui-laypage > * {
            float: left;
        }
        /*可选*/
        .layui-laypage .laypage-extend-pagesize {
            float: right;
        }
        /*可选*/
        .layui-laypage:after {
            content: ".";
            display: block;
            height: 0;
            clear: both;
            visibility: hidden;
        }

        /*必须*/
        .layui-laypage .laypage-extend-pagesize {
            height: 30px;
            line-height: 30px;
            margin: 0px;
            border: none;
            font-weight: 400;
        }
        /*分页页容量样式END*/
    </style>
    <link  rel="stylesheet"  href="/BlogHtTemplate-master/bootstrap/css/bootstrap.css"></link>
    <script type="text/javascript"  src="/BlogHtTemplate-master/bootstrap/js/jquery-1.12.4.js"></script>
    <script type="text/javascript"  src="/BlogHtTemplate-master/bootstrap/js/bootstrap.js"></script>

</head>
<body>

<div class="panel panel-default">
    <!-- Default panel contents -->
    <div class="panel-heading">博客管理</div>

    <!-- Table -->
    <table class="table">
        <tr>
            <td>博客作者</td>
            <td>博客路径</td>
        </tr>
        <c:forEach items="${all}" var="item">
            <tr>
                <td>${item.blogAuthor}</td>
                <td>${item.blogAdress}</td>
            </tr>
        </c:forEach>


    </table>
</div>
</body>
</html>

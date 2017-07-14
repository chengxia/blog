<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>添加作业</title>
    <link  rel="stylesheet"  href="/BlogHtTemplate-master/bootstrap/css/bootstrap.css"></link>
    <script type="text/javascript"  src="/BlogHtTemplate-master/bootstrap/js/jquery-1.12.4.js"></script>
    <script type="text/javascript"  src="/BlogHtTemplate-master/bootstrap/js/bootstrap.js"></script>
    <script>window._bd_share_config={"common":{"bdSnsKey":{},"bdText":"","bdMini":"2","bdMiniList":false,"bdPic":"","bdStyle":"0","bdSize":"16"},"image":{"viewList":["qzone","tsina","tqq","renren","weixin","douban"],"viewText":"分享到：","viewSize":"24"}};with(document)0[(getElementsByTagName('head')[0]||body).appendChild(createElement('script')).src='http://bdimg.share.baidu.com/static/api/js/share.js?v=89860593.js?cdnversion='+~(-new Date()/36e5)];</script>

</head>
<body>
<div class="panel panel-default">
    <!-- Default panel contents -->
    <div class="panel-heading">作业列表</div>
    <!-- Table -->
    <table class="table">
        <tr>
            <td>年级</td>
            <td>授课教员</td>
            <td>作业所属章节</td>
            <td>作业内容</td>
            <td>布置时间</td>
        </tr>
        <c:forEach var="item" items="${list}">
            <tr>
                <td>${item.homeGrage}</td>
                <td>${item.homeTeacher}</td>
                <td>${item.homeChapter}</td>
                <td>${item.homeContent}</td>
                <td>${item.homeTime}</td>
            </tr>
        </c:forEach>
    </table>
</div>
</form>
</body>
</html>

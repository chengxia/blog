<%--
  Created by IntelliJ IDEA.
  User: benxin
  Date: 2017/7/14
  Time: 9:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="js/jquery-1.12.4.js"></script>
    <script type="text/javascript">
        $(function () {
            $("[name=uname]").blur(function () {
                //向server发送一个Ajax
                //1.构建出一个核心对象XMLHttprequest
                //进行能力检测
                var xhr=null;
                if (window.XMLHttpRequest){ //非IE浏览器
                    xhr=new  XMLHttpRequest();
                }else{
                    xhr=new ActiveXObject("Microsoft.XMLHTTP");
                }
                //open准备请求的地址  open(method,url,async)
                xhr.open("GET","/FirstServlet?uname="+$("[name=uname]").val(),true);
                xhr.onreadystatechange=function () {
                    if(xhr.readyState==4&&xhr.status==200){
                        //成功响应
                        var data=xhr.responseText;
                        var dom=document.getElementById("msg");
                        dom.innerText=data;
                    }
                }
                xhr.send(null);
            });
        });

    </script>
</head>
<body>
    <input name="uname"/><span id="msg"></span>
</body>
</html>

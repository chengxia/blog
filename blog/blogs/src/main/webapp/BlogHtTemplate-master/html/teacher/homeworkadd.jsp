<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加作业</title>
    <link  rel="stylesheet"  href="/B
    logHtTemplate-master/bootstrap/css/bootstrap.css"></link>
    <script type="text/javascript"  src="/BlogHtTemplate-master/bootstrap/js/jquery-1.12.4.js"></script>
    <script type="text/javascript"  src="/BlogHtTemplate-master/bootstrap/js/bootstrap.js"></script>
    <script>window._bd_share_config={"common":{"bdSnsKey":{},"bdText":"","bdMini":"2","bdMiniList":false,"bdPic":"","bdStyle":"0","bdSize":"16"},"image":{"viewList":["qzone","tsina","tqq","renren","weixin","douban"],"viewText":"分享到：","viewSize":"24"}};with(document)0[(getElementsByTagName('head')[0]||body).appendChild(createElement('script')).src='http://bdimg.share.baidu.com/static/api/js/share.js?v=89860593.js?cdnversion='+~(-new Date()/36e5)];</script>

    <%--引入百度文本编辑器--%>
    <script type="text/javascript"  src="/BlogHtTemplate-master/ueditor/ueditor.config.js"></script>
    <script type="text/javascript"  src="/BlogHtTemplate-master/ueditor/ueditor.all.min.js"> </script>
    <!--建议手动加在语言，避免在ie下有时因为加载语言失败导致编辑器加载失败-->
    <!--这里加载的语言文件会覆盖你在配置项目里添加的语言类型，比如你在配置项目里配置的是英文，这里加载的中文，那最后就是中文-->
    <script type="text/javascript"  src="/BlogHtTemplate-master/ueditor/lang/zh-cn/zh-cn.js"></script>

    <style type="text/css">
        div{
            width:100%;
        }
    </style>

</head>
<body>
<form class="navbar-form navbar-left" action="/HomeWorkServlet?action=add" method="post" role="search">
    <img width="220px" height="220px" src="/BlogHtTemplate-master/image/2.jpg">
    <%--<img width="100px" height="100px" src="/BlogHtTemplate-master/image/logo.JPG">--%>
    <div class="form-group">
        年级：<input type="text" name="homeGrage" class="form-control" placeholder="请输入年级">
        授课教员：<input type="text" name="homeTeacher" class="form-control" placeholder="请输入授课教员">
        作业所属章节：<input type="text" name="homeChapter" class="form-control" placeholder="请输入章节">
        <br/><br/>  作业内容：
        <div>
            <script id="editor" type="text/plain" name="homeContent"></script>
        </div>
        <input type="text" name="homeContentxxxx" class="form-control" placeholder="请输入内容">
    </div>
    <br/> <button type="submit" class="btn btn-danger">添加</button>

</form>

<script type="text/javascript">

    //实例化编辑器

    var ue = UE.getEditor( 'editor', {
        autoHeightEnabled: true,
        autoFloatEnabled: true,
        initialFrameWidth: 690,
        initialFrameHeight:483
    });

</script>
</body>
</html>

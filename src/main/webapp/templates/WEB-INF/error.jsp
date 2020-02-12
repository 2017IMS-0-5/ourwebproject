<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>错误提示</title>

    <style type="text/css">
        body{margin:0; font-family: 微软雅黑;background-color:white;}
        .bg1{height: 10%;position: relative;}
        .left{
            background-color:rgba(72,81,174,1);border:none;border-bottom-right-radius: 20px;border-top-right-radius: 20px;
            color: white;font-size: 15px;letter-spacing: 1px;
            padding:5px 20px 5px 40px;position: absolute;bottom: 0;
        }

        .bg2{height: 45%;width:100%;text-align: center;vertical-align:bottom;}
        .bg2 img{height:100%;vertical-align:bottom;}

        .bg3{height:45%;width:100%;text-align: center;}
        .p1{font-size: 20px;color:black;letter-spacing: 2px;}
        .p2{font-size: 13px;color:grey;}
        .button{color:black;font-size: 15px;background-color:#c6d5f2;border:none;border-radius: 20px;text-align: center;padding:10px 30px;}
        .bg3 a{text-decoration: none;letter-spacing: 3px;}

    </style>
</head>
<body>

<div class="bg1">
    <span class="left">政府管理学院信息资源整合平台</span>
</div>
<div class="bg2">
    <img src="${pageContext.request.contextPath}/static/img/errorlogo.png">
</div>
<div class="bg3">
    <p class="p1">哎呀，页面出错啦 ...</p>
    <p class="p2">您访问的页面出现了错误，请重新加载！</p><br><br>
    <a href="${pageContext.request.contextPath}/main"><span class="button">返回首页</span> </a>
</div>

</body>
</html>

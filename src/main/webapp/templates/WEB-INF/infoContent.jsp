<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>infoContent</title>
    <style type="text/css">
        body{margin:0;font-family: "微软雅黑";}
        .title{text-align: center; font-size: 17px;  font-weight: bold;letter-spacing: 1pt;}
        #con_line hr{color: royalblue}
        .sub{color: grey; font-size: 13px;letter-spacing: 1pt;text-align: center}
        .content{color: black;font-size: 13px;letter-spacing: 1pt;text-align: left}
        .relation{color: grey; font-size: 13px; letter-spacing: 1pt;padding-left: 10px;text-align: left}
        .info_a{text-decoration: none;color: black}
        .info_a:hover{color:royalblue;}
    </style>
</head>
<body>
<p class="title">标题${info.title}</p>
<hr id="con_line">
<p class="sub">发布时间：${info.createTime}    发布者：${info.author} </p><br>
<pre class="content">内容${info.content}</pre><br><br>
<p class="relation">附件：<a href="#" class="info_a">fujian${info.relation}</a></p>
</body>
</html>

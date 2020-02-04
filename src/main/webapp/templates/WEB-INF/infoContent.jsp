<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>infoContent</title>
    <style type="text/css">
        body{margin:0;font-family: "微软雅黑";}
        .title{text-align: center; font-size: 20px;  font-weight: bold;letter-spacing: 1pt;white-space: pre-line;}
        #con_line hr{color: royalblue}
        .sub{color: grey; font-size: 16px;letter-spacing: 1pt;text-align: center}
        .content{
            color: black;
            font-size: 16px;
            letter-spacing: 1.3pt;
            line-height:28px;
            text-align: left;
            white-space: pre-line;
            padding-left: 40px;padding-right: 40px;
        }
        .relation{color: grey; font-size: 16px;
            letter-spacing: 1pt;line-height:28px;text-align: left;
            padding-left: 40px;padding-right: 40px;
        }
        .info_a{text-decoration: none;color: black}
        .info_a:hover{color:royalblue;}
    </style>
</head>
<body>
<p class="title">${info.title}</p>
<hr id="con_line">
<p class="sub">发布时间：<fmt:formatDate value="${info.createTime}" pattern="yyyy-MM-dd"/>  &nbsp&nbsp&nbsp&nbsp  发布者：${info.author} </p><br>
<p class="content">${info.content}</p><br><br>
<%
   if(!((String)request.getAttribute("relation")).equals("")){
%>
<p class="relation">附件：<a href="#" class="info_a">${info.relation}</a></p>
<%
    }
%>
</body>
</html>

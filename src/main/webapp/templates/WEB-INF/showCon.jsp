<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    switch((String) request.getAttribute("field")){
        case "job":request.setAttribute("field","就业信息");break;
        case "policy":request.setAttribute("field","政策制度");break;
        case "notice":request.setAttribute("field","通知公告");break;
        case "other":request.setAttribute("field","其它信息");break;
    }
%>
<html>
<head>
    <title>${info.title}</title>

    <style type="text/css">
        /** 总 **/
        body{margin:0;font-family: "微软雅黑";background-color: white;}
        .bg2_1{height:115px;width: 100%;margin:0;}
        .bg2_1 img{width: 100%;height: 100%}
        .bg2_2{width: 100%;margin:0;overflow:hidden;}
        .bg2_3{width: 100%;margin-top:10%; clear: both;position: relative;}
        .clearfix{clear: both;}

        /** 左侧导航**/
        .bg3_1{width: 25%;padding-top: 35px;float: left;margin:0;
        }
        .bg3_1:after{content: "";display: block;height: 0;visibility: hidden;clear: both;}

        .bg3_1 ul { list-style: none;width: 190px; margin: 0 auto; background-color: #f2f2f2; position: relative; padding: 0; }
        .bg3_1 ul li { height: 40px; line-height: 40px; text-align: center; border-bottom: 1px solid #F8F8F8; }
        .bg3_1 ul li p{background-color: #5187C5;color: white;font-size: 15px;font-weight: bold;letter-spacing: 4pt;}
        .bg3_1 ul li a { color:black; display: block; font-size: 12px;letter-spacing: 1pt;text-decoration:none;}
        .bg3_1 ul li a:hover { background-color: #5187C5;color: white; text-decoration: none; }

        /** 右侧标题展示 **/
        .bg3_2{ width: 75%; padding-top: 30px; float: left;margin:0;min-height: 500px;}
        .bg3_2:after{content: "";display: block;height: 0;visibility: hidden;clear: both;}
        .bg4{width: 90%;padding-top:20px;padding-bottom:30px;background-color: #c6d5f2;}

        .bg6{width: 96%;margin-left: 2%;margin-right: 2%;height: 40px;border-bottom: 2px solid darkblue;}
        .span1{text-align: left;letter-spacing: 2pt; font-size: 15px; color: darkblue;font-weight: bold;float: left;}
        .span2{text-align: right;font-size: 13px; color: black;font-weight: normal;float: right;}


        .bg5{padding-top: 10px;padding-right: 30px;padding-left: 30px;padding-bottom: 30px;}
        .input_submit{width: 80px;height:30px;color:white;font-size: 15px;font-weight: bold;background-color:rgb(4,130,200);border:none;border-radius: 5px; }



    </style>

</head>
<body>
<%@ include file="header.jsp"%>

<div class="bg2_1">
    <img src="../../static/img/topback.jpg" >
</div>
<div class="bg2_2">
    <div class="bg3_1">
        <ul>
            <li><p ><a href="/info${fieldValue}">${field}</a></p> </li>
            <c:forEach var="sub" items="${subjectList}">
                <li><a href="/info${fieldValue}/${sub.subValue}">${sub.subject}</a></li>
            </c:forEach>
        </ul>
    </div>
    <div class="bg3_2">
        <div class="bg4">
            <div class="bg6">
                <span class="span1">${field}</span>
                <span class="span2">当前位置：<a href="/index">首页</a>/<a href="/info${fieldValue}">${field}</a>/<a href="/info${fieldValue}${subjectValue}">${subject}</a>/${info.title} </span>
            </div>
            <div class="clearfix"></div>
            <div class="bg5">
                <%@ include file="infoContent.jsp"%>
            </div>
            <div align="center">
                <form action="" method="post" name="PageForm" style="align-self: center">
                    <input type="submit" name="shoucang" value="收 藏" class="input_submit">
                </form>
            </div>
        </div>
    </div>
</div>
<div class="clearfix"></div>
<div class="bg2_3">
    <%@ include file="footer.jsp"%>
</div>





</body>
</html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <title>信息展示</title>

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
        .bg4 table{width: 95%;border-collapse:collapse;}
        .bg4_tr1{height: 40px;border-bottom: 2px solid darkblue;}
        .bg4_th1{width:65%;text-align: left;letter-spacing: 2pt; font-size: 15px; color: darkblue;font-weight: bold;}
        .bg4_th2{width:35%;text-align: right;font-size: 13px; color: black;font-weight: normal;}

        .bg4_tr2{height:33px;border-bottom: 1px dashed darkblue;font-size: 13px;border-bottom: 1px dashed darkblue;}
        .bg4_td1{ text-align:left; vertical-align: bottom;padding-bottom: 2px; text-overflow: ellipsis;}
        .bg4_td1 a{text-decoration: none;color: black}
        .bg4_td1 a:hover{color:royalblue;}
        .bg4_td2{text-align: right;vertical-align: bottom;padding-bottom: 2px; text-overflow: ellipsis;}

        .bg4_tr3{font-size:13px;height:70px;text-align: center;vertical-align: bottom;}

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
            <table align="center" valign="middle">
                <tr class="bg4_tr1">
                    <th class="bg4_th1">${field}</th>
                    <th class="bg4_th2">当前位置：<a href="/index">首页</a>/<a href="/info${fieldValue}">${field}</a>/<a href="/info${fieldValue}${subjectValue}">${subject}</a> </th>
                </tr>
                <c:forEach var="infor" items="${infoList}">
                    <tr class="bg4_tr2">
                        <td class="bg4_td1"><a href="/info/information?infoId=${infor.id}">${infor.title}</a></td>
                        <td class="bg4_td2"><fmt:formatDate value="${infor.createTime}" pattern="yyyy-MM-dd"/></td>
                    </tr>
                </c:forEach>


                <tr class="bg4_tr3">
                    <td colspan="2">
                        <input id="size" name="size" type="hidden" value="${pageTotal}">
                        <input id="index" type="hidden" value="${pageIndex}">
                        第${pageIndex}页&nbsp;
                        共${pageTotal}页&nbsp;&nbsp;&nbsp;
                        <a href="/info${fieldValue}${subjectValue}?pageIndex=0">首页</a>&nbsp;
                        <%if((int)request.getAttribute("pageIndex")>1){ %>
                        <a href="/info${fieldValue}${subjectValue}?pageIndex=${pageIndex-2}">上一页</a>&nbsp;
                        <% }%>
                        <% if((int)request.getAttribute("pageIndex")<(int)request.getAttribute("pageTotal")){%>
                        <a href="/info${fieldValue}${subjectValue}?pageIndex=${pageIndex}">下一页</a>&nbsp;
                        <% }%>
                        <a href="/info${fieldValue}${subjectValue}?pageIndex=${pageTotal-1}">尾页</a>
                    </td>
                </tr>
            </table>
        </div>
    </div>
</div>
<div class="clearfix"></div>
<div class="bg2_3">
    <%@ include file="footer.jsp"%>
</div>





</body>
</html>

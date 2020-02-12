<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <title>就业信息</title>

    <style type="text/css">
        /** 总 **/
        body{margin:0;font-family: "微软雅黑";background-color: white;}
        .bg2_1{height:120px;width: 100%;margin:0;}
        .bg2_1 img{width: 100%;height: 100%}
        .bg2_2{width: 100%;
            overflow:hidden;
            margin: 0 0 30px;
            min-height: 600px;}
        .bg2_3{width: 100%;margin-top:10%; clear: both;position: relative;}
        .clearfix{clear: both;}

        /** 左侧导航**/
        .bg3_1{width: 25%;padding-top: 15px;float: left;margin:0
        }
        .bg3_1:after{content: "";display: block;height: 0;visibility: hidden;clear: both;}

        .bg3_1 ul { list-style: none;width: 75%; margin: 0 30px; background-color: #f2f2f2; position: relative; padding: 0; }
        .bg3_1 ul li { height: 40px; line-height: 40px; text-align: left; border-bottom: 1px solid #F8F8F8;padding-left: 10px; }
        .bg3_1 ul li p{background-color: #5187C5;color: white;font-size: 15px;font-weight: bold;letter-spacing: 4pt;}
        .bg3_1 ul li a {
            width: 85%;
            color:black;
            display: block;
            font-size: 12px;
            letter-spacing: 1pt;
            text-decoration:none;
            overflow: hidden;
            text-overflow: ellipsis;}
        .bg3_1 ul li a:hover { background-color: #5187C5;color: white; text-decoration: none; }

        /** 右侧标题展示 **/
        .bg3_2{ width: 73%; padding-top: 30px; float: left;margin:0;}
        .bg3_2:after{content: "";display: block;height: 0;visibility: hidden;clear: both;}
        .bg4{width: 100%;min-height:400px;padding-top:20px;padding-bottom:30px;background-color: #c6d5f2;position: relative;}
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



<div class="bg2_2">
    <div class="bg3_1">
        <ul>
            <li style="background-color: #5187C5;"><p >热门信息榜</p> </li>
            <c:forEach var="hot" items="${hotList}">
                <li><a href="${pageContext.request.contextPath}/info/information?infoId=${hot.id}"><NOBR>${hot.title}</NOBR></a></li>
            </c:forEach>
        </ul>
    </div>
    <div class="bg3_2">
        <div class="bg4">
            <table align="center" valign="middle">
                <tr class="bg4_tr1">
                    <th class="bg4_th1">检索结果</th>
                    <th class="bg4_th2"></th>
                </tr>
                <c:forEach var="infor" items="${infoList}">
                    <tr class="bg4_tr2">
                        <td class="bg4_td1"><a href="${pageContext.request.contextPath}/info/information?infoId=${infor.id}">${infor.title}</a></td>
                        <td class="bg4_td2"><fmt:formatDate value="${infor.createTime}" pattern="yyyy-MM-dd"/>. . . . . .
                            <c:choose>
                                <c:when test="${infor.field == 'job'}">就业信息</c:when>
                                <c:when test="${infor.field == 'notice'}">通知公告</c:when>
                                <c:when test="${infor.field == 'policy'}">政策制度</c:when>
                                <c:when test="${infor.field == 'other'}">其它信息</c:when>
                                <c:otherwise>${infor.field}</c:otherwise>
                            </c:choose>
                        </td>
                    </tr>
                </c:forEach>
            </table>
            <table align="center" valign="middle" style="position: absolute;bottom: 10px;">
                <tr class="bg4_tr3" >
                    <td colspan="2">
                        <input id="size" name="size" type="hidden" value="${pageTotal}">
                        <input id="index" type="hidden" value="${pageIndex}">
                        第${pageIndex}页&nbsp;
                        共${pageTotal}页&nbsp;&nbsp;&nbsp;
                        <a href="${pageContext.request.contextPath}/info/${searchType}?${formulation}&pageIndex=0">首页</a>&nbsp;
                        <c:if test="${ pageIndex>=2 }">
                            <a href="${pageContext.request.contextPath}/info/${searchType}?${formulation}&pageIndex=${pageIndex-2}">上一页</a>&nbsp;
                        </c:if>
                        <c:if test="${pageIndex<pageTotal}">
                            <a href="${pageContext.request.contextPath}/info/${searchType}?${formulation}&pageIndex=${pageIndex}">下一页</a>&nbsp;
                        </c:if>
                        <a href="${pageContext.request.contextPath}/info/${searchType}?${formulation}&pageIndex=${pageTotal-1}">尾页</a>
                </td>
                </tr>
        </table>
        </div>
    </div>
</div>






</body>
</html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <title>${info.title}</title>
    <style type="text/css">
        /** 总 **/
        body{margin:0;font-family: "微软雅黑";background-color: white;}
		.topback{width: 100%;height:auto;}
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
		.hover{color: white; background-color: #5187C5;}

        /** 右侧标题展示 **/
        .bg3_2{ width: 75%; padding-top: 30px; float: left;margin:0;min-height: 500px;}
        .bg3_2:after{content: "";display: block;height: 0;visibility: hidden;clear: both;}
        .bg4{width: 90%;padding-top:20px;padding-bottom:30px;background-color: #c6d5f2;}

        .bg6{width: 96%;margin-left: 2%;margin-right: 2%;height: 40px;border-bottom: 2px solid darkblue;}
        .span1{text-align: left;letter-spacing: 2pt; font-size: 15px; color: darkblue;font-weight: bold;float: left;}
        .span2{text-align: right;font-size: 13px; color: black;font-weight: normal;float: right;}


        .bg5{padding-top: 10px;padding-right: 30px;padding-left: 30px;padding-bottom: 30px;}
        .input_submit{width: 80px;height:30px;color:white;font-size: 15px;font-weight: bold;background-color:rgb(4,130,200);border:none;border-radius: 5px; }
        .input_no{width: 80px;height:30px;color:white;font-size: 15px;font-weight: bold;background-color:orange;border:none;border-radius: 5px; }

        /**Content**/
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
        .tag{
            color:grey;font-size: 16px; letter-spacing: 1pt;line-height:28px;
            text-align: left;padding-left: 40px;padding-right: 40px;
        }
        .info_a{text-decoration: none;color: black}
        .info_a:hover{color:royalblue;}

    </style>
	
	<script>
        window.onload=function(){
            var obj=document.getElementById('nav');
            var lis=obj.getElementsByTagName('li');

            obj.onclick=function(event){
                var e=event||window.event;
                var obj=e.srcElement?e.srcElement:e.target;
                for(var i=0, l=lis.length; i < l; i++){
                    lis[i].className="";
                }
                switch(obj.tagName){
                    case 'LI':
                        obj.className="hover";
                        break;
                    case 'A':
                        obj.parentNode.className="hover";
                        break;
                }
            }
        }
    </script>

</head>
<body>
<%@ include file="header.jsp"%>

<div>
    <img src="${pageContext.request.contextPath}/static/img/topback.jpg" class="topback" >
</div>
<div class="bg2_2">
    <div class="bg3_1">
        <ul id="nav">
            <li>
                <p >
                <a href="${pageContext.request.contextPath}/info${fieldValue}">
                    <c:choose>
                        <c:when test="${field == 'job'}">就业信息</c:when>
                        <c:when test="${field == 'notice'}">通知公告</c:when>
                        <c:when test="${field == 'policy'}">政策制度</c:when>
                        <c:when test="${field == 'other'}">其它信息</c:when>
                        <c:otherwise>${field}</c:otherwise>
                    </c:choose>
                </a>
                </p>
            </li>
            <c:forEach var="sub" items="${subjectList}">
                <li><a href="${pageContext.request.contextPath}/info${fieldValue}/${sub.subValue}">${sub.subject}</a></li>
            </c:forEach>
        </ul>
    </div>
    <div class="bg3_2">
        <div class="bg4">
            <div class="bg6">
                <span class="span1">
                    <c:choose>
                        <c:when test="${field == 'job'}">就业信息</c:when>
                        <c:when test="${field == 'notice'}">通知公告</c:when>
                        <c:when test="${field == 'policy'}">政策制度</c:when>
                        <c:when test="${field == 'other'}">其它信息</c:when>
                        <c:otherwise>${field}</c:otherwise>
                    </c:choose>
                </span>
                <span class="span2">当前位置：<a href="/index">首页</a>/
                    <a href="${pageContext.request.contextPath}/info${fieldValue}">
                         <c:choose>
                             <c:when test="${field == 'job'}">就业信息</c:when>
                             <c:when test="${field == 'notice'}">通知公告</c:when>
                             <c:when test="${field == 'policy'}">政策制度</c:when>
                             <c:when test="${field == 'other'}">其它信息</c:when>
                             <c:otherwise>${field}</c:otherwise>
                         </c:choose>
                    </a>/<a href="${pageContext.request.contextPath}/info${fieldValue}${subjectValue}">${subject}</a>/${info.title} </span>
            </div>
            <div class="clearfix"></div>
            <div class="bg5">
                <p class="title">${info.title}</p>
                <hr id="con_line">
                <p class="sub">发布时间：<fmt:formatDate value="${info.createTime}" pattern="yyyy-MM-dd"/>  &nbsp&nbsp&nbsp&nbsp  发布者：${info.author}&nbsp&nbsp&nbsp&nbsp 阅读量：${info.readSize} </p><br>
                <p class="content">${info.content}</p><br><br>
                <c:if test="${ info.relation!='' }">
                    <p class="relation">附件：<a href="#" class="info_a">${info.relation}</a></p>
                </c:if>
                <c:if test="${ info.labels!='' }">
                <p class="tag">标签：
                    <c:forTokens var="label" items="${info.labels}" delims=", ">
                        <a href="${pageContext.request.contextPath}/info/genSearchV?keyword=${label}" class="info_a">${label}&nbsp&nbsp</a>
                    </c:forTokens>
                </p><br>
                </c:if>
            </div>
            <div align="center">
                <form action="${pageContext.request.contextPath}/info/favor" method="post" name="PageForm" style="align-self: center">
                    <input type="hidden" name="infoId" value="${info.id}">
                    <c:choose>
                        <c:when test="${ favored =='false' }">
                            <input type="submit" name="shoucang" value="收 藏" class="input_submit">
                        </c:when>
                        <c:otherwise>
                            <input type="button" name="shoucang" value="已收藏" disabled="true" class="input_no">
                        </c:otherwise>
                    </c:choose>
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

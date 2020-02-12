<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by Ingrid
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org"
      xmlns:layout="http://www.ultraq.net.nz/thymeleaf/layout">
	<head>
		<title>留言板</title>
		<style type="text/css">
			#bg{
				position:relative;
				background-image:url(${pageContext.request.contextPath}/static/img/bg1.jpg);
				background-size:cover;
				align:center;
				height:600px;
				font-size:20px;
				font-family:"微软雅黑";
				color:#fff;
				margin: 0; 
			}
			#bg1{
				position:relative;
				margin: 0 auto;
				top:3%;
				width:80%;
				height:65%;
				background-size:contain;
				background:rgba(128,128,192,.6);
				border-radius: 10px;
				font-size:15px;
				font-family:"微软雅黑";
				text-align:center;
			}
			#bg1 h1{
				font-family:"微软雅黑";
				font-size:24px;
				color: #fff;
			}
			#bg2{
				position:relative;
				margin: 0 auto;
				top:1%;
				width:80%;
				height:28%;
				background-size:contain;
				background:rgba(255,255,255,.6);
				border-radius: 10px;
				font-size:18px;
				font-family:"微软雅黑";
				color:#7373B9;
			}
			#bg2 input:not([type="submit"]){
				position: relative;
				width: 90%; 
				height:30px; 
				padding: 10px;  
				font-size: 12px;  
				color: #000;  
				border-top: 2px solid #7373B9;  
				border-left: 2px solid #7373B9;  
				border-right: 2px solid #7373B9;  
				border-bottom: 2px solid #7373B9;  
				background-color: rgba(0,0,0,0);  
			}
			#bg2 p{
				font-size:24px;
				font-weight:600;
				margin-left:3%;
				height:10px;
			}
		</style>
	</head>
	<body>
	<%@include file="header.jsp"%>
	<div id="bg">
		<div id="bg1">
			<h1>留 言 区</h1>
			<table width="740" border="1" cellspacing="0" cellpadding="6" align="center">
				<c:forEach var="comm" items="${commList}" varStatus="status">
					<tr>
						<td height="40" valign="middle" rowspan="2"><img src="${pageContext.request.contextPath}/static/img/photo.jpg"></td>
						<td>第${row-status.count+1-pageSize*(pageIndex-1)}楼：${comm.userAccount}</td>
						<td>${comm.createTime}</td>
					</tr>
					<tr>
						<td colspan="2" style="font-weight:600;">${comm.content}</td>
					</tr>
				</c:forEach>
			</table>
			<input id="size" name="size" type="hidden" value="${pageTotal}">
			<input id="index" type="hidden" value="${pageIndex}">
			第${pageIndex}页&nbsp;
			共${pageTotal}页&nbsp;&nbsp;&nbsp;
			<a href="${pageContext.request.contextPath}/usersp/lyb?pageIndex=0">首页</a>&nbsp;
			<c:if test="${ pageIndex>=2 }">
			<a href="${pageContext.request.contextPath}/usersp/lyb?pageIndex=${pageIndex-2}">上一页</a>&nbsp;
			</c:if>
			<c:if test="${pageIndex<pageTotal}">
			<a href="${pageContext.request.contextPath}/usersp/lyb?pageIndex=${pageIndex}">下一页</a>&nbsp;
			</c:if>
			<a href="${pageContext.request.contextPath}/usersp/lyb?pageIndex=${pageTotal-1}">尾页</a>
		</div>
	
		<div id="bg2">
			<p></p>
		    <p>留言</p>
		    <form  action="${pageContext.request.contextPath}/usersp/addComment" method="get">
			<p><input type="text" name="comment" placeholder="请输入内容..."></p>
			<p><input type="submit" value="我要发布留言" style="background-color:#7373B9;margin-top:2%;"></p>
			</form>
		</div>
	</div>
	<%@include file="footer.jsp"%>
	</body>
</html>
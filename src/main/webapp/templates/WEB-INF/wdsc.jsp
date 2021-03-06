<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2020/1/19
  Time: 18:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>个人主页——我的收藏</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/homepage.css">
    <style type="text/css">
		.bg1 img{
				float:left;
				margin-left:15%;
				margin-top:2%;
			}
	</style>
</head>
<body>
	<%@include file="header.jsp"%>
	<div class="bg1">
	<img src="${pageContext.request.contextPath}/static/img/photo.jpg">
		<div id="bg2">
			<table cellpadding="3" cellspacing="3">
				<tr>
					<td  colspan="2" style="font-size:17px;font-weight:800;">${user.name}</td>
				</tr>
				<tr>
					<td>年级：${user.grade}</td>
					<td>专业：${user.major}</td>
				</tr>
				<tr>
					<td>学号：${user.account}</td>
					<td>电子邮箱：${user.email}</td>
				</tr>
			</table>
		</div>
	</div>
	
	<div style="width:100%">
		<div class="bg3" style="float:left;">
			<table>
				<tr>
					<td style="font-size:20px;font-weight:600;height:50px;">常用应用</td>
				</tr>
				<tr>
					<td><input required="required"  type="button" value="最新通知" onclick="window.location.href='${pageContext.request.contextPath}/usersp/zxtz'")></td>
				</tr>
				<tr>
					<td><input required="required"  type="button" value="我的收藏" onclick="window.location.href='${pageContext.request.contextPath}/usersp/wdsc'") style="background-color:#8080C0;"></td>
				</tr>
				<tr>
					<td><input required="required"  type="button" value="我发布过的留言" onclick="window.location.href='${pageContext.request.contextPath}/usersp/fbly'")></td>
				</tr>
				<tr>
					<td><input required="required"  type="button" value="编辑资料" onclick="window.location.href='${pageContext.request.contextPath}/usersp/bjzl'")></td>
				</tr>
			</table>
		</div>

		<div class="bg4" style="float:left;">
			<table cellspacing="30">
				<tr>
					<td><h1>收藏内容</h1></td>
					<td><h1>操作</h1></td>
				</tr>
				<c:forEach var="infor" items="${infoList}">
					<tr>
						<td><a href="${pageContext.request.contextPath}/info/information?infoId=${infor.id}">${infor.title}</a></td>
						<td><input type="button" value="取消收藏" οnclick="location.href='${pageContext.request.contextPath}/deleteUF?infold=${infor.id}"></td>
					</tr>
				</c:forEach>
		</table>
			<div id="form2">
				<input id="size" name="size" type="hidden" value="${pageTotal}">
				<input id="index" type="hidden" value="${pageIndex}">
				第${pageIndex}页&nbsp;
				共${pageTotal}页&nbsp;&nbsp;&nbsp;
				<a href="${pageContext.request.contextPath}/usersp/wdsc?pageIndex=0">首页</a>&nbsp;
                <c:if test="${ pageIndex>=2 }">
				<a href="${pageContext.request.contextPath}/usersp/wdsc?pageIndex=${pageIndex-2}">上一页</a>&nbsp;
                </c:if>
                <c:if test="${pageIndex<pageTotal}">
				<a href="${pageContext.request.contextPath}/usersp/wdsc?pageIndex=${pageIndex}">下一页</a>&nbsp;
                </c:if>
				<a href="${pageContext.request.contextPath}/usersp/wdsc?pageIndex=${pageTotal-1}">尾页</a>
			</div>

		</div>
	</div>
	
	<div style="width:100%;float:left">
		<%@include file="footer.jsp"%>
	</div>
</body>
</html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html;charset=UTF-8" language="java" %>
<html>
	<head>
	    <title>个人主页-最新通知</title>
	    <link rel="stylesheet" type="text/css" href="../../static/css/homepage.css">
	    <style type="text/css">
			#foot{
				width:100%;
				float:left;
			}
	    </style>
	</head>
	<body>
	<%@include file="header.jsp" %>
	<div class="bg1">
		<div id="bg2">
			<table cellpadding="3" cellspacing="3">
				<tr>
					<td rowspan="3" style="text-align:center;"><img src="../../static/img/photo.jpg"></td>
					<td  colspan="2" style="font-size:17px;font-weight:800;">${stu.name}李华</td>
				</tr>
				<tr>
					<td>年级：${stu.grade}2017级本科生</td>
					<td>专业：${stu.major}信息管理与信息系统</td>
				</tr>
				<tr>
					<td>学号：${stu.account}201711260000</td>
					<td>电子邮箱：${stu.email}201711260000@mail.bnu.edu.cn</td>
				</tr>
			</table>
		</div>
	</div>
	
	<div style="width:100%">
		<div class="bg3">
			<table>
				<tr>
					<td style="font-size:20px;font-weight:600;height:50px;">常用应用</td>
				</tr>
				<tr>
					<td><input required="required"  type="button" value="最新通知" onclick="window.location.href='/usersp/zxtz'") style="background-color:#8080C0;"></td>
				</tr>
				<tr>
					<td><input required="required"  type="button" value="我的收藏" onclick="window.location.href='/usersp/wdsc'")></td>
				</tr>
				<tr>
					<td><input required="required"  type="button" value="我发布过的留言" onclick="window.location.href='/usersp/fbly'")></td>
				</tr>
				<tr>
					<td><input required="required"  type="button" value="编辑资料" onclick="window.location.href='/usersp/bjzl'")></td>
				</tr>
			</table>
		</div>
		
		<div class="bg4">
			<table cellspacing="40">
				<c:forEach var="infor" items="${infoList}">
					<tr>
						<td><a href="/info/information?infoId=${infor.id}">${infor.title}</a></td>
					</tr>
				</c:forEach>
			</table>
			<div id="form2">
				<input id="size" name="size" type="hidden" value="${pageTotal}">
				<input id="index" type="hidden" value="${pageIndex}">
				第${pageIndex}页&nbsp;
				共${pageTotal}页&nbsp;&nbsp;&nbsp;
				<a href="/usersp/zxtz?pageIndex=0">首页</a>&nbsp;
				<%if((int)request.getAttribute("pageIndex")>1){ %>
				<a href="/usersp/zxtz?pageIndex=${pageIndex-2}">上一页</a>&nbsp;
				<% }%>
				<% if((int)request.getAttribute("pageIndex")<(int)request.getAttribute("pageTotal")){%>
				<a href="/usersp/zxtz?pageIndex=${pageIndex}">下一页</a>&nbsp;
				<% }%>
				<a href="/usersp/zxtz?pageIndex=${pageTotal-1}">尾页</a>
			</div>
		</div>
	</div>
	
	<%@include file="footer.jsp" %>
</body>
</html>

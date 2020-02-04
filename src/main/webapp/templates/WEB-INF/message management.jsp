<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>北京师范大学政府管理学院</title>
	<!-- 信息管理 -->
	<style  type="text/css">
		div.content
		{
			background-color:White;
			width:68%;
			min-width:1190px;
			-moz-border-radius:5px;
			-webkit-border-radius:5px;
			border-radius:5px;
			height:400px;
			margin-left:320px;
		}
		div.search
		{
			background-color:rgba(143,130,188,1);
			width:68%;
			min-width:1190px;
			height:30px;
			float:left;
			position:absolute;
			margin:0px 0px;
			padding:0px 0px 0px 0px;
			border-radius:5px;
		}
		div.search1
		{
			float:left;
			padding:0;
			list-style:none;
		}
		div.list1
		{
			background-color:rgba(143,130,188,1);
			width:68%;
			min-width:1190px;
			height:400px;
			float:left;
			position:absolute;
			margin:50px 0px;
			border-radius:5px;
		}
		p.black
		{
			font-family:"微软雅黑";
			font-size:100%;
			color:Black;
		}
		.button
		{
			text-decoration:none;
			background:Gainsboro;color:Black;
			padding:2px 2px 2px 2px;
			height:20px;width:50px;
			font-family:"微软雅黑";font-size:80%;font-weight:bold;border:none;border-radius:5px;align:center;
			-webkit-transition:all linear 0.30s;
			-moz-transition:all linear 0.30s;
			transition:all linear 0.30s;
		}
	</style>
</head>
<body>
	<div class="container">
		<%@ include file="managerheader.jsp"%>
		<br>
		<%@ include file="Administratornavigatorbar.jsp"%>
		<div class="content">
		<div class="search">
			<img src="images/search.jpg" style="float:left;"/>
			<div class="search1" style="margin:-12px 15px;">
				<p class="black" style="float:left;border-radius:5px;">信息类型：</p>
			</div>
			<div class="search1" style="margin:5px 7px;">
				<select style="float:left;">
					<option value="全部">全部</option>
					<option value="就业信息">就业信息</option>
					<option value="政策规章">政策规章</option>
					<option value="通知公告">通知公告</option>
					<option value="其它信息">其它信息</option>
				</select>
			</div>
			<div class="search1" style="margin:-12px 10px;">
				<p class="black" style="float:left;">检索方式：</p>
			</div>
			<div class="search1" style="margin:5px 7px;">
				<select style="float:left;border-radius:5px;">
					<option value="按二级标题检索">按二级标题检索</option>
					<option value="按文章标题检索">按文章标题检索</option>
					<option value="按发布者检索">按发布者检索</option>
					<option value="按关键词检索">按关键词检索</option>
				</select>
			</div>
			<div class="search1" style="margin:-12px 10px;">
				<p class="black" style="float:left;">检索词：</p>
			</div>
			<div class="search1" style="margin:3px 7px;">
				<input type="text" style="height:18px;width:100px;float:left;border-radius:5px;" >
			</div>
			<div class="search1" style="margin:3px 7px;">
				<input type="submit" value="搜索" class="button" >
			</div>
			<div class="search1" style="margin:4px 10px;">
				<input type="submit" value="导出" class="button" >
			</div>
		</div>
		<div class="list1">
			<c:forEach var="inform" items="${infoAll}">
				${inform.title}<br>
			</c:forEach>
			<%//@ include file="list_message.jsp"%>
		</div>
	</div>
		<%@ include file="footer.jsp"%>
	</div>
</body>
</html>
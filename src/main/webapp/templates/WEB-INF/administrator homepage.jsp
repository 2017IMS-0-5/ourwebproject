<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>北京师范大学政府管理学院</title>
	<!-- 管理员首页 -->
	<style  type="text/css">
		.content
		{
			background-color:White;
			width:68%;
			min-width:1190px;
			-moz-border-radius:5px;
			-webkit-border-radius:5px;
			border-radius:5px;
			height:550px;
			maigin-bottom:30px;
			margin-left:260px;
		}
		.information
		{
			font-family: "微软雅黑";
			background-color:GhostWhite;
			width:20%;
			min-width:300px;
			height:120px;
			-moz-border-radius: 5px;
			-webkit-border-radius: 5px;
			border-radius:5px;
			float:left;
			position: absolute;
			padding:20px 20px 20px 20px;
			display:inline
		}
		.piple
		{
			font-size:150%;
			color:MediumPurple;
		}
		.gray
		{
			font-size:100%;
			color:Gray;
		}
	</style>
</head>
<body>
	<%@ include file="managerheader.jsp"%>
	<br>
	<%@ include file="Administratornavigatorbar.jsp"%>
	<div class="content">
		<div class="information" style="margin: 0 0;">
			<img src="${pageContext.request.contextPath}/static/img/book.png" style="float:left;"/>
			<p class="piple"><a href="${pageContext.request.contextPath}/admin/userstatistics">人员信息</a></p>
			<p class="gray"><a href="${pageContext.request.contextPath}/admin/userstatistics">当前共有${student}名师生使用本系统</a></p>
		</div>
		<div class="information" style="margin: 0 360px;">
			<img src="${pageContext.request.contextPath}/static/img/book.png" style="float:left;"/>
			<p class="piple"><a href="${pageContext.request.contextPath}/admin/infoStatistics">消息信息</a></p>
			<p class="gray"><a href="${pageContext.request.contextPath}/admin/infoStatistics">当前系统中已发布${information}条消息</a></p>
		</div>
	</div>
	<%@ include file="footer.jsp"%>
</body>
</html>
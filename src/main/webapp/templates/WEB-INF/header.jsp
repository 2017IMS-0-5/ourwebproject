<%@ page import="com.example.webproject.entity.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<style type="text/css">
		body{
			margin:0;
			font-family: "微软雅黑", serif
		}
		.welcome{
			width: 100%;
			height:30px;
			background-color: rgba(72,81,174,1);
			padding-top: 3px;
		}
		.welcome h{
			color: white;
			float: left;
			margin-top: 1px;
			margin-left: 50px;
		}
		.search{
			position: relative;
			margin-right: 150px;
			text-align: right;
			font-size: 18px;
		}
		.keywords{
			height:25px;
			vertical-align:bottom;
			border:none;
			padding-left: 10px;
		}
		.search u{
			font-size: 12px;
			color: white;
		}
		.navigator{
			position: relative;
			height: 100px;
			width: 40%;
			padding-left: 465px;
			background-image: url(${pageContext.request.contextPath}/static/img/schoollogo.JPG);
			background-repeat: no-repeat;
			background-position: center;
			background-position-x:0;
		}
		.navigator table{
			position:absolute;
			border:none;
			bottom:13px;
		}
		.navigator a{
			text-decoration: none;
			color: black;
		}
		.navigator td{
			color: black;
			width: 173px;
			font-size: 20px;
		}
		.genbut{
			height: 25px;
		}
	</style>
</head>
<body>
<%User user=(User) session.getAttribute("user");
String name=user.getName();%>
	<form>
		<div class="welcome">
			<h>欢迎访问政府管理学院信息资源整合平台</h>
		    <div class="search">
				<input type="search" id="ky" name="keyword" class="keywords" placeholder="站内搜索" />
					<input type="button" name="" onclick="toGenSearch()" value="检索" class="genbut">
		    	<a href="${pageContext.request.contextPath}/info/advancedSearch"><u>高级检索</u></a>
		    	<a href="${pageContext.request.contextPath}/usersp/zxtz"><u>欢迎你,<%=name%></u></a>
				<input type="button" name="" value="退出登录" class="exit" onclick="exit()"/>
		    </div>
	    </div>
	</form>
	<div class="navigator">
		<table>
			<td><a href="${pageContext.request.contextPath}/main">首页</a></th>
			<td><a href="${pageContext.request.contextPath}/info/job">就业信息</a></th>
			<td><a href="${pageContext.request.contextPath}/info/policy">政策规章</a></th>
			<td><a href="${pageContext.request.contextPath}/info/notice">通知公告</a></th>
			<td><a href="${pageContext.request.contextPath}/info/other">其他信息</a></th>
			<td><a href="${pageContext.request.contextPath}/usersp/lyb">留言板</a></th>
		</table>
	</div>
</body>
</html>
<script type="text/javascript">
	function exit(){
		var r=confirm("请问您确定退出吗");
		if (r==true){
			window.location.href="${pageContext.request.contextPath}/sessionout/userout";
		}
	}
	function toGenSearch() {
			var ky = document.getElementById("ky").value;
			window.location.href= "${pageContext.request.contextPath}/info/genSearchV?keyword="+ky;
			window.event.returnvalue = false;
	}
</script>
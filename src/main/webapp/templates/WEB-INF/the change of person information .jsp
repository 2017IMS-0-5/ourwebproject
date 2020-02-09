<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>个人主页——编辑资料</title>
	<style type="text/css">
		div.container
		{
			width:360px;
			height:520px;
			padding-left:20px;
			padding-right:20px;
			padding-top:10px;
			margin-left:38%;
			margin-top:10px;
			border:1px Lavender;
			border-radius: 5px;
			background-color:Lavender;
			text-align:center;
		}
		div.box 
		{
			height:45px;
			border-style:solid;
			border-color:Gray;
			margin-top:-10px;
		}
		p.title
		{
			font-family: "微软雅黑";
			font-size:150%;
			text-align:center;
			margin-top:-5px;
		}
		p.normal
		{
			font-family: "微软雅黑";
			font-size:100%;
			text-align:center;
		}
		.new_button1
		{
			text-decoration:none;
			background:Lavender;
			font-family: "微软雅黑";font-size:100%;font-weight:bold;border:none;
		}
		.new_button2
		{
			text-decoration:none;
			background:rgba(143,130,188,1);color:White;
			padding:10px 30px 10px 30px;
			font-family: "微软雅黑";font-size:100%;font-weight:bold;border:none;border-radius: 5px;align:center;
			-webkit-transition:all linear 0.30s;
			-moz-transition:all linear 0.30s;
			transition:all linear 0.30s;
		}
		.new_text
		{
			width:60%;
			height:25px;
			font-family: "微软雅黑";
			background-color:white;
			border:none;
		}
	</style>
</head>
<body>
	<%@ include file="header.jsp"%>
	<div style="background-color:rgba(143,130,188,1);width:100%;height:570px;padding-top:15px;">
	<div class="container">
		<img src="../../static/img/photo.jpg" style="text-align:center;"/>
		<p class="title">编辑资料</p>
		<div class="box">
			<div style="width:20%;float:left;text-align:center;margin-top:-5px;"><p class="normal">性别</p></div>
			<div style="width:80%;float:right;text-align:center;margin-top:-5px;"><p class="normal">女</p></div>
		</div>
		<br>
		<div class="box">
			<div style="width:20%;float:left;text-align:center;margin-top:-5px;"><p class="normal">姓名</p></div>
			<div style="width:80%;float:right;text-align:center;margin-top:-5px;"><p class="normal">李歆然</p></div>
		</div>
		<br>
		<div class="box">
			<div style="width:20%;float:left;text-align:center;margin-top:-5px;"><p class="normal">年级</p></div>
			<div style="width:80%;float:right;text-align:center;margin-top:-5px;"><p class="normal">2017</p></div>
		</div>
		<br>
		<div class="box">
			<div style="width:20%;float:left;text-align:center;margin-top:-5px;"><p class="normal">专业</p></div>
			<div style="width:80%;float:right;text-align:center;margin-top:-5px;"><p class="normal">信息管理与信息系统</p></div>
		</div>
		<br>
		<div class="box">
			<form action="/usersp/xgmm" method="get">
			<div style="width:20%;float:left;text-align:center;margin-top:-5px;"><p class="normal">密码</p></div>
			<div style="width:80%;float:right;text-align:center;margin-top:10px;"><button type="submit" class="new_button1">修改密码</button></div>
			</form>
		</div>
		<br>
		<div class="box">
			<div style="width:20%;float:left;text-align:center;margin-top:-5px;"><p class="normal">邮箱</p></div>
			<div style="width:80%;float:right;text-align:center;margin-top:-5px;"><p class="normal">201711260115@mail.bnu.edu.cn</p></div>
		</div>
		<br>
		<div style="text-align:center;margin-top:-10px;">
			<button type="button" class="new_button2" onclick="window.location.href='/usersp/zxtz'">返回</button>
		</div>
		<br>
	</div>
	</div>
	<%@ include file="footer.jsp"%>
</body>
</html>
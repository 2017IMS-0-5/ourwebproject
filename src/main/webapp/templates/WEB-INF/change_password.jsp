<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>个人主页——修改密码</title>
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
			maigin-bottom:10px;
			border:1px Lavender;
			border-radius: 5px;
			background-color:Lavender;
			text-align:center;
		}
		div.box
		{
			height:55px;
			border-style:solid;
			border-color:Gray;
		}
		p.title
		{
			font-family:"微软雅黑";
			font-size:150%;
			text-align:center;
		}
		p.normal
		{
			font-family:"微软雅黑";
			font-size:100%;
			text-align:center;
		}
		.new_button1
		{
			text-decoration:none;
			background:Lavender;
			padding:10px 30px 10px 30px;
			font-family:"微软雅黑";font-size:100%;font-weight:bold;border:none;
			-webkit-transition:all linear 0.30s;
			-moz-transition:all linear 0.30s;
			transition:all linear 0.30s;
		}
		.new_button2
		{
			text-decoration:none;
			background:MediumPurple;color:White;
			padding:10px 30px 10px 30px;
			font-family:"微软雅黑";font-size:100%;font-weight:bold;border:none;border-radius: 5px;align:center;
			-webkit-transition:all linear 0.30s;
			-moz-transition:all linear 0.30s;
			transition:all linear 0.30s;
		}
		.new_text
		{
			width:60%;
			height:25px;
			font-family:"微软雅黑";
			background-color:white;
			border:none;
		}
	</style>
	<script>
		function jump()
		{
			window.location.href="";//提交
		}
		function display_alert()
		{
			var con;
			con=confirm("请问您确定要重置您的账户密码吗？");
			if(con==true)
				window.location.href="${pageContext.request.contextPath}/usersp/resetPassword";
				alert("密码重置成功！");
		}
	</script>
</head>
<body>
    <%@ include file="header.jsp"%>
    <div style="background-color:rgba(143,130,188,1);width:100%;height:570px;padding-top:15px;">
	<div class="container">
		<form method=get action="${pageContext.request.contextPath}/usersp/changepassword">
			<p class="title">修改密码</p>
			<br>
			<div class="box">
				<div><p class="normal">原密码：<input type="password" name="old_password" class="new_text" placeholder="请输入原密码"></p></div>
			</div>
			<br>
			<div class="box">
				<div><p class="normal">新密码：<input type="password" name="new_password" class="new_text" placeholder="请输入新密码"></p></div>
			</div>
			<br>
			<div class="box">
				<div><p class="normal">密码确认：<input type="password" name="verify_new" class="new_text" placeholder="再次请输入新密码"></p></div>
			</div>
			<br>
			<div style="maigin-top:90px;text-align:center">
				<button type="submit" class="new_button2">提交</button>
				<button type="button" name="reset" class="new_button2" onclick="display_alert()">重置</button>
				<button type="button" class="new_button2" onclick="window.location.href='${pageContext.request.contextPath}/usersp/bjzl'">返回</button>
		</div>
		<br>
		</form>
	</div>
	</div>
	<%@ include file="footer.jsp"%>
</body>
</html>
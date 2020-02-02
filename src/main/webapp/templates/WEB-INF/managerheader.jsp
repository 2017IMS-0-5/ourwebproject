<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<style type="text/css">
		body{
			margin:0;
			font-family: "微软雅黑"
		}
		.welcome{
			width: 100%;
			height:30px;
			min-width:1364px;
			background-color: rgba(143,130,188,1);
			padding-top: 3px;
		}
		h{
			color: white;
			float: left;
			margin-top: 1px;
			margin-left: 50px;
		}
		b{
			margin-bottom: 0;
			color: rgba(143,130,188,1);
			font-size: 20px;
		}
		.manager_apt{
			position: relative;
			height: 100px;
			width: 40%;
			padding-right: 70px;
			min-width:964px;
			padding-left: 465px;
			background-image: url(../../static/img/schoollogo.JPG);
			background-repeat: no-repeat;
			background-position: center;
			background-position-x:0;
			text-align: right;
			display:table-cell; 
            vertical-align:bottom;
            padding-bottom: 12px;
		}
		.infrontpage{
			background-color: rgba(143,130,188,1);
			background-image: url(../../static/img/flo.png);
			background-repeat: no-repeat;
			background-position: center;
			background-position-x:8px;
			-moz-border-radius: 10px;
			-webkit-border-radius: 10px;
			border-radius: 10px;
			width: 270px;
			float: left;
			margin-left: 30px;
			margin-right: 40px;
			height: 32px;
			padding-left: 68px;
			padding-top: 3px;
		}
		.colunm{
			background-color: rgba(143,130,188,1);
			width:auto;
			min-width: 1190px;
			-moz-border-radius: 5px;
			-webkit-border-radius: 5px;
			border-radius: 5px;
			height: 35px; 
			margin-left: 380px;
			padding-left: 30px;
		}
		.fh{
			color: black;
			font-size: 18px;
			font-weight: bold;
			margin: 0;
			
		}
		.current{
			background-color: white;
			-moz-border-radius: 10px;
			-webkit-border-radius: 10px;
			border-radius: 10px;
			width: 102px;
			height: 35px;
			padding-top: 5px;
			text-align:center;
		}
	</style>
</head>
<body>
		<div class="welcome">
			<h>欢迎访问政府管理学院信息资源整合平台管理员界面</h>
	    </div>
	    <div class="manager_apt">
	    	<b>你好，管理员<span>部门：学术实践部</span></b>
	    </div>
	    <div class="infrontpage">
	    	<h class="fh">系统首页</h>
	    </div>
	    <div class="colunm">
	    	<div class="current"><p class="fh">通知上传</p></div>
	    </div>
</body>
</html>
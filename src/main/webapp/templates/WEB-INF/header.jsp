<%@ page contentType= "text/html; charset = utf-8"%>
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
			min-width:1364px;
			background-color: rgba(72,81,174,1);
			padding-top: 3px;
		}
		h{
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
		.searchbotton{
			height:25px;
			vertical-align:bottom;
			border:none;
		}
		u{
			font-size: 12px;
			color: white;
		}
		.navigator{
			position: relative;
			height: 100px;
			width: 40%;
			min-width:964px;
			padding-left: 465px;
			background-image: url(../../static/img/schoollogo.JPG);
			background-repeat: no-repeat;
			background-position: center;
			background-position-x:0;
		}
		table{
			position:absolute;
			border:none;
			bottom:13px;
		}
		a{
			text-decoration: none;
			color: black;
		}
		td{
			color: black;
			width: 173px;
			font-size: 20px;
		}
	</style>
</head>
<body>
	<form>
		<div class="welcome">
			<h>欢迎访问政府管理学院信息资源整合平台</h>
		    <div class="search">
				<input type="search" id="ky" name="keyword" class="keywords" placeholder="站内搜索" />
					<button onclick="toGenSearch()">检索</button>
		    	<a href="/info/advancedSearch"><u>高级检索</u></a>
		    	<a href="/usersp/zxtz"><u>欢迎你,李华</u></a>
		    </div>
	    </div>
	</form>
	<div class="navigator">
		<table>
			<td><a href="/info/index">首页</a></th>
			<td><a href="/info/jyxx">就业信息</a></th>
			<td><a href="/info/zczd">政策规章</a></th>
			<td><a href="/info/tzgg">通知公告</a></th>
			<td><a href="/info/qtxx">其他信息</a></th>
			<td><a href="/usersp/lyb">留言板</a></th>
		</table>
	</div>
</body>
</html>
<script type="text/javascript">
	function toGenSearch() {

			var ky = document.getElementById("ky").value;
			window.location.href = "/index";
			window.event.returnvalue = false;
	}
</script>
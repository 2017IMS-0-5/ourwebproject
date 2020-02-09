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
			min-width:1364px;
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
			background-image: url(../../static/img/schoollogo.JPG);
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
	<form>
		<div class="welcome">
			<h>欢迎访问政府管理学院信息资源整合平台</h>
		    <div class="search">
				<input type="search" id="ky" name="keyword" class="keywords" placeholder="站内搜索" />
					<input type="button" name="" onclick="toGenSearch()" value="检索" class="genbut">
		    	<a href="/info/advancedSearch"><u>高级检索</u></a>
		    	<a href="/usersp/zxtz"><u>欢迎你,李华</u></a>
		    </div>
	    </div>
	</form>
	<div class="navigator">
		<table>
			<td><a href="/main">首页</a></th>
			<td><a href="/info/job">就业信息</a></th>
			<td><a href="/info/policy">政策规章</a></th>
			<td><a href="/info/notice">通知公告</a></th>
			<td><a href="/info/other">其他信息</a></th>
			<td><a href="/usersp/lyb">留言板</a></th>
		</table>
	</div>
</body>
</html>
<script type="text/javascript">
	function toGenSearch() {
			var ky = document.getElementById("ky").value;
			window.location.href= "/info/genSearchV?keyword="+ky;
			window.event.returnvalue = false;
	}
</script>
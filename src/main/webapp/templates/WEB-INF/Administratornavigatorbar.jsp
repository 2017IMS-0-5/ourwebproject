<%@ page contentType= "text/html; charset = utf-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>北京师范大学政府管理学院</title>
	<!-- 管理员导航栏 -->
		 <style type="text/css">
		 *
		 {
			 margin:0;
			 padding:0;
			 list-style:none;
		 }
		.menu
		{
			background-color:rgba(143,130,188,1);
			background-repeat:no-repeat;
			background-position:center;
			background-position-x:8px;
			background-attachment:fixed;
			-moz-border-radius:10px;
			-webkit-border-radius:10px;
			border-radius:10px;
			height:400px;
			width:238px; 
			float:left;
			margin-left:30px;
			margin-right:30px;
			padding-left:10px;
			padding-right:20px;
			
			padding-bottom:10px;
		}
		.menu box
		{
			background-color:Lavender;
			background-attachment:fixed;
			color:white;
			-moz-border-radius:10px;
			-webkit-border-radius:10px;
			border-radius:10px;
			height:25px;
			width:210px;
			font-size:145%;
		  	font-weight:bold;
		  	line-height:25px;
		 	border-bottom:1px solid #ccc;
		 	cursor:pointer;
		 	text-align:left;
		 	float:left;
		 	margin-left:10px;
			margin-right:10px;
			margin-top: 6px;
			padding-left:20px;
			padding-top:10px;
			padding-bottom:10px;
		}
		.menu div ul
		{
			display:none;
			cursor:pointer;
		 	text-align:left;
		 	float:left;
		 	margin-left:10px;
			margin-right:10px;
			padding-left:20px;
			padding-top:10px;
		}
		.menu li
		{
		  	font-weight:bold;
		  	font-size: 18px;
		}
	</style>
 	<script type="text/javascript">
 		window.onload=function()
 		{
	 		// 将所有点击的标题和要显示隐藏的列表取出来
			var ps = document.getElementsByTagName("box");
			var uls = document.getElementsByTagName("ul");
			// 遍历所有要点击的标题且给它们添加索引及绑定事件
			for(var i = 0, n = ps.length; i <n; i += 1)
			{
				ps[i].id = i;
				ps[i].onclick = function()
				{
					for(var j = 0; j < n ; j += 1)
					{
			    		uls[j].style.display = "none";
					}
					uls[this.id].style.display = "block";
				}
				// 获取点击的标题上的索引属性，根据该索引找到对应的列表
			}
			// 判断该列表，如果是显示的则将其隐藏，如果是隐藏的则将其显示出来
		}
	</script>
</head>
<body>
	<div class="container">
		
		<br>
		<div class="menu" id="menu">
			<div>
				<box>信息管理</box>
				<ul style="display:block">
					<li>> 信息发布</li>
					<li>> 查看已发布的信息</li>
				</ul>
			<div>
			<div>
				<box>人员管理</box>
				<ul style="display:block">
					<li>> 管理员管理</li>
				    <li>> 教师管理</li>
				    <li>> 学生管理</li>
				</ul>
			</div>
			<div>
				<box>留言管理</box>
				<ul style="display:block">
				    <li>> 留言发布</li>
				    <li>> 查看已发布的留言</li>
				</ul>
			</div>
		</div>
		
</body>
</html>
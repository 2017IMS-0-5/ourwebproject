<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
	<head>
		<title>head</title>
		<style type="text/css">
			body{
					margin:0;
					font-family: "微软雅黑";
				}
			.welcome{
					width: 100%;
					height:30px;
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
						margin-top:-15px;
						height: 70px;
						padding-left: 370px;
						background-image: url(../../../../../../web/web_yry（师生信息统计界面，消息信息统计界面）/web_yry/WebContent/webapp/static/img/schoollogo.jpg);
						background-repeat: no-repeat;
						background-position: center;
						background-position-x:0px;
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
			.navigator a:hover{
							background-color:#8080C0;
						}
			.navigator td{
						color: black;
						width: 140px;
						text-align:right;
						font-size: 20px;
					}
		</style>
	</head>
	
	<body>
	<form>
		<div class="welcome">
			<h>欢迎访问政府管理学院信息资源整合平台</h>
		    <div class="search">
		    	<input type="search" name="keywords" class="keywords" placeholder="模糊查询" />
		    	<input type="image" class="searchbotton" src="../../../../../../web/web_yry（师生信息统计界面，消息信息统计界面）/web_yry/WebContent/webapp/static/img/search.jpg" />
		    	<a href=""><u>高级检索</u></a>
		    	<a href=""><u>欢迎你,李华</u></a>
		    </div>
	    </div>
	</form>
	<div class="navigator">
		<table>
			<td><a href="">首页</a></th>
			<td><a href="">就业信息</a></th>
			<td><a href="">政策规章</a></th>
			<td><a href="">通知公告</a></th>
			<th>
				<td><a href="">其他信息</a></td>
			</th>
			<th><td><a href="">留言板</a></th>
		</table>
	</div>
	</body>
</html>
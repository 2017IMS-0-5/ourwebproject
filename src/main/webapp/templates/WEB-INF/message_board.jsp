<%--
  Created by Ingrid
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org"
      xmlns:layout="http://www.ultraq.net.nz/thymeleaf/layout">
	<head>
		<title>留言板</title>
		<style type="text/css">
			#bg{
				position:relative;
				background-image:url(../../static/img/bg1.jpg);
				background-size:cover;
				align:center;
				height:600px;
				font-size:20px;
				font-family:"微软雅黑";
				color:#fff;
				margin: 0; 
			}
			#bg1{
				position:relative;
				margin: 0 auto;
				top:3%;
				width:80%;
				height:65%;
				background-size:contain;
				background:rgba(128,128,192,.6);
				border-radius: 10px;
				font-size:15px;
				font-family:"微软雅黑";
				text-align:center;
			}
			#bg1 h1{
				font-family:"微软雅黑";
				font-size:24px;
				color: #fff;
			}
			#bg2{
				position:relative;
				margin: 0 auto;
				top:1%;
				width:80%;
				height:28%;
				background-size:contain;
				background:rgba(255,255,255,.6);
				border-radius: 10px;
				font-size:18px;
				font-family:"微软雅黑";
				color:#7373B9;
			}
			#bg2 input:not([type="submit"]){
				position: relative;
				width: 90%; 
				height:30px; 
				padding: 10px;  
				font-size: 12px;  
				color: #000;  
				border-top: 2px solid #7373B9;  
				border-left: 2px solid #7373B9;  
				border-right: 2px solid #7373B9;  
				border-bottom: 2px solid #7373B9;  
				background-color: rgba(0,0,0,0);  
			}
			#bg2 p{
				font-size:24px;
				font-weight:600;
				margin-left:3%;
				height:10px;
			}
		</style>
	</head>
	
	<body>
	<%@include file="header.jsp"%>
	<div id="bg">
		<div id="bg1">
			<h1>留 言 区</h1>
			<table width="740" border="1" cellspacing="0" cellpadding="6" align="center">
				<tr>
			      <td height="40" valign="middle" rowspan="2"><img src="../../static/img/photo.jpg"></td>
			      <td>第1楼：201711260125${comm.userAccount}</td>
			      <td>2019-11-24${comm.date}</td>
			    </tr>
			    <tr>
			    	<td colspan="2" style="font-weight:600;">组队组队</td>
			    </tr>
			    <tr>
			      <td height="40" valign="middle" rowspan="2"><img src="../../static/img/photo.jpg"></td>
			      <td>第2楼：201711260125${comm.userAccount}</td>
			      <td>2019-11-24${comm.date}</td>
			    </tr>
			    <tr>
			    	<td colspan="2" style="font-weight:600;">组队组队</td>
			    </tr>
			    <tr>
			      <td height="40" valign="middle" rowspan="2"><img src="../../static/img/photo.jpg"></td>
			      <td>第3楼：201711260125${comm.userAccount}</td>
			      <td>2019-11-24${comm.date}</td>
			    </tr>
			    <tr>
			    	<td colspan="2" style="font-weight:600;">组队组队</td>
			    </tr>
			</table>
			
			<form action="message_board.jsp" method="post" name="PageForm">
				当前页1&nbsp;
				共100页&nbsp;
				<a href="">首页</a>&nbsp;
				<a href="">上一页</a>&nbsp;
				<a href="">下一页</a>&nbsp;
				<a href="">尾页</a>
		 	</form>
		</div>
	
		<div id="bg2">
			<p></p>
		    <p>留言</p>
		    <form  action="lyb.jsp" method="get">
			<p><input type="text" name="comment" placeholder="请输入内容..."></p>
			<p><input type="submit" value="我要发布留言" style="background-color:#7373B9;margin-top:2%;"></p>
			</form>
		</div>
	</div>
	<%@include file="footer.jsp"%>
	</body>
</html>
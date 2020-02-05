<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2020/1/19
  Time: 18:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>test</title>
    <link rel="stylesheet" type="text/css" href="../../static/homepage.css">
</head>
<body>
	<%@include file="header.jsp"%>
	<div class="bg1">
		<div id="bg2">
			<table cellpadding="3" cellspacing="3">
				<tr>
					<td rowspan="3" style="text-align:center;"><img src="../../static/img/photo.jpg"></td>
					<td  colspan="2" style="font-size:17px;font-weight:800;">${stu.name}李华</td>
				</tr>
				<tr>
					<td>年级：${stu.grade}2017级本科生</td>
					<td>专业：${stu.major}信息管理与信息系统</td>
				</tr>
				<tr>
					<td>学号：${stu.account}201711260000</td>
					<td>电子邮箱：${stu.email}201711260000@mail.bnu.edu.cn</td>
				</tr>
			</table>
		</div>
	</div>
	
	<div style="width:100%">
		<div class="bg3" style="float:left;">
			<table>
				<tr>
					<td style="font-size:20px;font-weight:600;height:50px;">常用应用</td>
				</tr>
				<tr>
					<td><input required="required"  type="button" value="最新通知" onclick='window.open("zxtz.jsp")'></td>
				</tr>
				<tr>
					<td><input required="required"  type="button" value="我的收藏" onclick='window.open("wdsc.jsp")' style="background-color:#8080C0;"></td>
				</tr>
				<tr>
					<td><input required="required"  type="button" value="我发布过的留言" onclick='window.open("fbly.jsp")'></td>
				</tr>
				<tr>
					<td><input required="required"  type="button" value="编辑资料" onclick='window.open("bjzl.jsp")'></td>
				</tr>
			</table>
		</div>
		
		<div class="bg4" style="float:left;">
		<table cellspacing="40">
				<tr>
					<td><a href="">【政策】2017级信息管理与信息系统专业保研条例</a></td>
				</tr>
				<tr>
					<td><a href="">我的收藏2</a></td>
				</tr>
				<tr>
					<td><a href="">我的收藏3</a></td>
				</tr>
				<tr>
					<td><a href="">我的收藏4</a></td>
				</tr>
			</table>
		
			<div id="form2">
				<form action="wdsc.jsp" method="post" name="PageForm">
						 当前页1&nbsp;
						 共3页&nbsp;
						<a href="">首页</a>&nbsp;
					    <a href="">上一页</a>&nbsp;
					    <a href="">下一页</a>&nbsp;
					    <a href="">尾页</a>
				</form>
			</div>
		</div>
	</div>
	
	<div style="width:100%;float:left">
		<%@include file="footer.jsp"%>
	</div>
</body>
</html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>北京师范大学政府管理学院</title>
	<!-- 人员管理 -->
	<style  type="text/css">
		div.content
		{
			background-color:White;
			width:68%;
			min-width:1190px;
			-moz-border-radius:5px;
			-webkit-border-radius:5px;
			border-radius:5px;
			height:550px;
			maigin-bottom:30px;
			margin-left:390px;
		}
		div.search
		{
			background-color:rgba(143,130,188,1);
			width:70%;
			min-width:1200px;
			height:30px;
			float:left;
			position:absolute;
			margin:0px 0px;
			padding:0px 0px 0px 0px;
			border-radius:5px;
		}
		div.search1
		{
			float:left;
			padding:0;
			list-style:none;
		}
		div.list_title
		{
			background-color:rgba(143,130,188,1);
			width:70%;
			min-width:1200px;
			height:30px;
			float:left;
			position:absolute;
			margin:40px 0px;
			padding:0px 0px 0px 0px;
			border-radius:5px;
		}
		div.title
		{
			height:30px;
			float:left;
			padding:0;
			list-style:none;
			font-weight:bold;
			border-radius:5px;
			text-align:center;
		}
		div.list1
		{
			background-color:White;
			width:70%;
			min-width:1200px;
			height:450px;
			float:left;
			position:absolute;
			margin:80px 0px;
			border-radius:5px;
		}
		p.black
		{
			font-family:"微软雅黑";
			font-size:100%;
			color:Black;
		}
		.button
		{
			text-decoration:none;
			background:Gainsboro;color:Black;
			padding:2px 2px 2px 2px;
			height:20px;width:50px;
			font-family:"微软雅黑";font-size:80%;font-weight:bold;border:none;border-radius:5px;align:center;
			-webkit-transition:all linear 0.30s;
			-moz-transition:all linear 0.30s;
			transition:all linear 0.30s;
		}
	</style>
	<style>
        .black_overlay
        { 
            display: none; 
            position: absolute; 
            top: 0%; 
            left: 0%; 
            width: 100%; 
            height: 100%; 
            background-color: black; 
            z-index:1001; 
            -moz-opacity: 0.8; 
            opacity:.80; 
            filter: alpha(opacity=88); 
        } 
        .white_content
		{ 
            display: none; 
            position: absolute; 
            top: 25%; 
            left: 25%; 
            width: 55%; 
            height: 55%; 
            padding: 20px; 
            border: 4px solid black; 
            background-color: white; 
            z-index:1002; 
            overflow: auto; 
        } 
    </style>
    <script type="text/javascript" src="../../static/js/infoUpload.js"> </script>
	<script>
		var cont = document.getElementById("li");
	    var i = 1;
	</script>
	<script type="text/javascript">
        $(function(){
        })
        function openDialog(){
            document.getElementById('light').style.display='block';
            document.getElementById('fade').style.display='block'
        }
        function closeDialog(){
            document.getElementById('light').style.display='none';
            document.getElementById('fade').style.display='none'
        }
    </script>
</head>
<body>
	<div class="container">
		<%@ include file="managerheader.jsp"%>
		<br>
		<%@ include file="Administratornavigatorbar.jsp"%>
		<div class="content">
		<div class="search">
		<form action="" method="get">
			<img src="../../static/img/search.jpg" style="float:left;"/>
			<div class="search1" style="margin:-12px 15px;">
				<p class="black" style="float:left;border-radius:5px;">人员类型：</p>
			</div>
			<div class="search1" style="margin:5px 7px;">
				<select name="role" style="float:left;border-radius:5px;">
					<option value="学生">学生</option>
					<option value="教师">教师</option>
					<option value="管理员" selected="selected">管理员</option>
					<option value="超级管理员">超级管理员</option>
				</select>
			</div>
			<div class="search1" style="margin:-12px 10px;">
				<p class="black" style="float:left;">检索方式：</p>
			</div>
			<div class="search1" style="margin:5px 7px;">
				<select name="searchWay" style="float:left;border-radius:5px;">
					<option value="按姓名检索">按姓名检索</option>
					<option value="按年级检索">按年级检索</option>
					<option value="按专业检索">按专业检索</option>
					<option value="按账号检索">按账号检索</option>
				</select>
			</div>
			<div class="search1" style="margin:-12px 10px;">
				<p class="black" style="float:left;">检索词：</p>
			</div>
			<div class="search1" style="margin:3px 7px;">
				<input type="text" name="searchWord" style="height:18px;width:100px;float:left;border-radius:5px;" >
			</div>
			<div class="search1" style="margin:3px 7px;">
				<input type="submit" value="搜索" class="button" >
			</div>
			<div class="search1" style="margin:4px 10px;">
				<input type="submit" value="导出" class="button" >
			</div>
		</form>
		</div>
		<div class="list_title">
			<div class="title" style="margin:-12px 10px;">
				<p class="black" style="width:200px;">账号</p>
			</div>
			<div class="title" style="margin:-12px 10px;">
				<p class="black" style="width:80px;">用户名</p>
			</div>
			<div class="title" style="margin:-12px 10px;">
				<p class="black" style="width:150px;">身份</p>
			</div>
			<div class="title" style="margin:-12px 10px;">
				<p class="black" style="width:120px;">操作</p>
			</div>
		</div>
		<div class="list1">
			<table style="text-align:center;">
				<c:forEach var="mana" items="${userList}">
					<tr>
						<td style="width:210px;height:30px;">${mana.account}
						</td>
						<td style="width:100px;height:30px;">${mana.name}
						</td>
						<td style="width:160px;height:30px;">${mana.role}
						</td>
						<td style="width:170px;height:30px;">
							<p><a href = "JavaScript:void(0)" onclick = "openDialog()">修改</a>/<a href="/admin/adminDelete?id=${mana.id}">删除</a></p>
						</td>
					</tr>
				</c:forEach>
			</table>
			<div id="light" class="white_content">
				<div class="noteuploadzone">
					<form action="/admin/adminSubmit" method="post" class="form" onsubmit="return deal()">
			            <dl id="li" class="list">
			                <dt class="items">
			                    <label>账号：</label><input type="text" name="account" value="管理员" disabled="true" class="uploadinput">
			                </dt>
			                <dt class="items">
			                    <label>姓名：</label><input type="text" name="name" value="" disabled="true" class="uploadinput">
			                </dt>
			                <dt class="items" id="tags">
			                    <label>身份：</label><input type="text" name="role" value="管理员" disabled="true" class="uploadinput">
		                    </dt>
			            </dl>
			            <div style="text-align:center;">
			                <label></label><input type="submit" name="" value="提交" class="submitbut">
			                <button type="button" class="new_button2" href = "javascript:void(0)" onclick="closeDialog()">返回</button>
			            </div>
					</form>
				</div>
			</div>
		    <div id="fade" class="black_overlay"></div>
		</div>
	</div>
		<%@ include file="footer.jsp"%>
	</div>
</body>
</html>
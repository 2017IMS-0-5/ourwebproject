<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>北京师范大学政府管理学院</title>
	<!-- 信息管理 -->
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
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/infoUpload.js"> </script>
	<script>
		var cont = document.getElementById("li");
	    var i = 1;
	</script>
	<script type="text/javascript">
        $(function(){
        })
        function openDialog(){
            document.getElementById('light').style.display='block';
            document.getElementById('fade').style.display='block';
            
            var first_tt=document.getElementById("first_tt");
            var txt_first_tt=document.getElementById("txt_firsttt").value;
            txt_first_tt=txt_first_tt+first_tt;
            document.getElementById("txt_firsttt").value=txt_first_tt;
            
            var second_tt=document.getElementById("second_tt");
            txt_secondtt.options[txt_secondtt.electedIndex].text=txt_second_tt;
            
            var tt=document.getElementById("tt");
            var txt_tt=document.getElementById("txt_tt").value;
            txt_tt=txt_tt+tt;
            document.getElementById("txt_tt").value=txt_tt;
            
            var label=document.getElementById("label");
            var txt_label=document.getElementById("txt_label").value;
            txt_label=txt_label+label;
            document.getElementById("txt_label").value=txt_label;
            
            var relation=document.getElementById("relation");
            var txt_relation=document.getElementById("txt_relation").value;
            txt_relation=txt_relation+relationt;
            document.getElementById("txt_relation").value=txt_relation;
            
        }
        function closeDialog(){
            document.getElementById('light').style.display='none';
            document.getElementById('fade').style.display='none';
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
		<form action="/admin/checkInfoSearch" method="get">
			<img src="${pageContext.request.contextPath}/static/img/search.jpg" style="float:left;"/>
			<div class="search1" style="margin:-12px 15px;">
				<p class="black" style="float:left;border-radius:5px;">信息类型：</p>
			</div>
			<div class="search1" style="margin:5px 7px;">
				<select name="field" style="float:left;border-radius:5px;">
					<option value="全部">全部</option>
					<option value="就业信息">就业信息</option>
					<option value="政策规章">政策规章</option>
					<option value="通知公告">通知公告</option>
					<option value="其它信息">其它信息</option>
				</select>
			</div>
			<div class="search1" style="margin:-12px 10px;">
				<p class="black" style="float:left;">检索方式：</p>
			</div>
			<div class="searchWay" style="margin:5px 7px;">
				<select name="type2" style="float:left;border-radius:5px;">
					<option value="按二级标题检索">按二级标题检索</option>
					<option value="按文章标题检索">按文章标题检索</option>
					<option value="按发布者检索">按发布者检索</option>
					<option value="按关键词检索">按关键词检索</option>
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
		</form>
		</div>
		<div class="list_title">
			<div class="title" style="margin:-12px 10px;">
				<p class="black" style="width:80px;">一级标题</p>
			</div>
			<div class="title" style="margin:-12px 10px;">
				<p class="black" style="width:80px;">二级标题</p>
			</div>
			<div class="title" style="margin:-12px 10px;">
				<p class="black" style="width:250px;">文章标题</p>
			</div>
			<div class="title" style="margin:-12px 10px;">
				<p class="black" style="width:80px;">发布者</p>
			</div>
			<div class="title" style="margin:-12px 10px;">
				<p class="black" style="width:100px;">发布时间</p>
			</div>
			<div class="title" style="margin:-12px 10px;">
				<p class="black" style="width:150px;">关键词</p>
			</div>
			<div class="title" style="margin:-12px 10px;">
				<p class="black" style="width:150px;">附件地址</p>
			</div>
			<div class="title" style="margin:-12px 10px;">
				<p class="black" style="width:150px;">操作</p>
			</div>
		</div>
		<div class="list1">
			<table style="text-align:center;">
				<c:forEach var="info" items="${infoList}">
					<tr>
						<td id="first_tt" style="width:90px;height:30px;">${info.field}
						</td>
						<td id="second_tt" style="width:90px;height:30px;">${info.subject}
						</td>
						<td id="tt"style=" width:280px;height:30px;">${info.title}
						</td>
						<td id="publisher" style="width:90px;height:30px;">${info.author}
						</td>
						<td id="pub_time" style="width:110px;height:30px;">${info.createTime}
						</td>
						<td id="label" style="width:170px;height:30px;">${info.labels}
						</td>
						<td id="relation" style="width:170px;height:30px;">${info.relation}
						</td>
						<td style="width:170px;height:30px;">
							<p><a href = "JavaScript:void(0)" onclick = "openDialog()">修改</a>/<a href="${pageContext.request.contextPath}/admin/infoDelete?id=${info.id}">删除</a></p>
						</td>
					</tr>
				</c:forEach>
			</table>
			<!-- 修改按钮的弹窗 -->
			<div id="light" class="white_content">
				<div class="noteuploadzone">
					<form action="/admin/infoSubmit" method="post" class="form" onsubmit="return deal()">
			            <dl id="li" class="list">
			                <dt class="items">
			                    <label>一级标题：</label><input type="text" name="field" id="txt_firsttt">
			                </dt>
			                <dt class="items">
			                    <label>二级标题：</label><input type="text" name="subject" id="txt_secondtt">
			                </dt>
			                <dt class="items">
			                    <label>文章标题：</label><input type="text" name="title" id="txt_tt">
			                </dt>
			                <dt class="items" id="tags">
			                    <label>文件标签：</label><input type="text" name="labels" id="txt_label"><input type="button" name="add" class="funcbutadd" value="+" onclick="addBotton()"><span>增加</span><input type="button" class="funcbutdel" name="del" value="x" onclick="delBotton()"><span>删除</span>
			                </dt>
			                <dt class="items">
			                    <label>附件地址：</label></label><input type="text" name="relation" id="txt_relation">
			                </dt>
			            </dl>
			            <div style="text-align:center;">
			                <label></label><input type="submit" name="submit" value="提交" class="submitbut">
			                <button type="button" name="return" class="new_button2" href = "javascript:void(0)" onclick="closeDialog()">返回</button>
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
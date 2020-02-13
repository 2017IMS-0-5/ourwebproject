<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
	<title>北京师范大学政府管理学院</title>
	<!-- 管理员导航栏 -->
	<style type="text/css">
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
			min-height:500px;
			height: auto;
			width:340px; 
			float:left;
			margin-left:30px;
			margin-right:30px;
			margin-bottom:50px;
			padding-bottom: 30px;
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
			width:250px;
			font-size:145%;
		  	font-weight:bold;
		  	line-height:25px;
		 	border-bottom:1px solid #ccc;
		 	cursor:pointer;
		 	text-align:left;
		 	float:left;
		 	margin-left:25px;
			margin-right:10px;
			margin-top: 14px;
			margin-bottom:10px;
			padding-left:20px;
			padding-right:20px;
			padding-top:10px;
			padding-bottom:10px;
		}
		.menu div ul
		{
			display:none;
			cursor:pointer;
		 	text-align:left;
		 	margin:0;
			padding:0;
			list-style:none;
		 	margin-left:10px;
		 	margin-top:10px;
			margin-right:10px;
			padding-left:20px;
			padding-top:8px;
		}
		.menu div ul a{
			text-decoration: none;
			color: black;
		}
		.menu li
		{
			font-family:"微软雅黑";
			font-size:115%;
		  	font-weight:bold;
		  	padding-bottom: 8px;
		}
	</style>
 	<script type="text/javascript">
 		window.onload=function()
 		{
	 		
			var jians = document.getElementsByClassName("jian");
			var uls = document.getElementsByTagName("ul");
			
			for(var i = 0, n = jians.length; i <n; i += 1)
			{
				jians[i].id=i;
				jians[i].flag=1;
				jians[i].onclick = function()
				{
					if(this.flag==1){
					jians[this.id].setAttribute("src","${pageContext.request.contextPath}/static/img/jia.png");
					uls[this.id].style.display="none";
					this.flag=0;
				}
				else{
					jians[this.id].setAttribute("src","${pageContext.request.contextPath}/static/img/jian.png");
					uls[this.id].style.display="block";
					this.flag=1;
				}
			}
				
			}
			var up = document.getElementById("upload");
			up.flag=0;
			up.onclick=function(){
				var upchi = new Array();
				var names = ['> 通知公告','> 就业实习','> 政策制度','> 其他信息'];
				var urls=['${pageContext.request.contextPath}/admin/noticeupload',
					'${pageContext.request.contextPath}/admin/jobupload',
					'${pageContext.request.contextPath}/admin/policyupload',
					'${pageContext.request.contextPath}/admin/otherupload'];
				if(this.flag==0){
				for (var i = 0; i <= names.length - 1; i++) {
					upchi[i]=document.createElement("a");
					upchi[i].setAttribute("style","padding-left:35px;font-size:85%;");
					upchi[i].innerText=names[i];
					upchi[i].setAttribute("href",urls[i]);
					this.innerText='Ⅴ';
					this.parentElement.appendChild(document.createElement("br"));
					this.parentElement.appendChild(upchi[i]);	
				}
			    this.flag=1;}
				else{
					for (var i = 0; i <= names.length - 1; i++) {
					this.innerText='>';
					h=this.parentElement;
					h.removeChild(h.lastChild);
				}
				this.flag=0;
				}
			}
			
		}
	</script>
</head>
<body>
	<div class="container">
		<br>
		<div class="menu" id="menu">
			<div>
				<box>信息管理
				<img src="${pageContext.request.contextPath}/static/img/jian.png" style="float:right;" class="jian" />
				</box>
				<ul style="display:block">
					<li><span id="upload" >></span> 信息发布</li>
					<li><span>></span><a href="${pageContext.request.contextPath}/admin/infoSearch"> 查看已发布的信息</a></li>
				</ul>
			</div>
			<div>
				<box>人员管理
				<img src="${pageContext.request.contextPath}/static/img/jian.png" style="float:right;" class="jian" />
				</box>
				<ul>
					<li><span>></span><a href="${pageContext.request.contextPath}/admin/adminSearch">管理员管理</a></li>
				
				    <li><span>></span><a href="${pageContext.request.contextPath}/admin/teachSearch">教师管理</a></li>
				
				    <li><span>></span><a href="${pageContext.request.contextPath}/admin/userSearch">学生管理</a></li>
				</ul>
			</div>
			<div>
				<box>留言管理
				<img src="${pageContext.request.contextPath}/static/img/jian.png" style="float:right;" class="jian" />
				</box>
				<ul style="display:block">
				    <li><span>></span> <a href="${pageContext.request.contextPath}/usersp/addComment">留言发布</a></li>
				
				    <li><span>></span> <a href="${pageContext.request.contextPath}/admin/commentSearch">查看已发布的留言</a></li>
				</ul>
			</div>
		</div>
	</div>
</body>
</html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
			margin-bottom:30px;
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
			margin:40px 0px;
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
		.managetable{
            table-layout: fixed;
        }
        .managetable>tbody>tr,.table>thead{
            display: table;
            width: 100%;
            table-layout: fixed; /* 重要  表格固定算法 */
        }
        .managetable tr:nth-child(even){
        	background: #ccc;
        }
        .managetable td{
    text-align: center;
    white-space:nowrap;overflow:hidden;text-overflow: ellipsis;
    width: 120px;
    }
    .managetable>tbody{
  height:450px;
  width: 1200px;
  overflow: hidden;
  display: block;
  overflow: hidden;
  overflow-y: auto;
  overflow-x: auto;
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
		<form action="${pageContext.request.contextPath}/admin/checkInfoSearch" method="get">
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
		<div class="list1">
			<table class="managetable">
                
                    <tr style="background-color:rgba(143,130,188,1); ">
                        <th>一级标题</th>
                        <th>二级标题</th>
                        <th>文章标题</th>
                        <th>发布者</th>
                        <th>发布时间</th>
                        <th>关键词</th>

                        <th>操作</th>
                    </tr>

				<c:forEach var="info" items="${infoList}">
					<tr>
						<td id="first_tt" style="width:90px;height:30px;">
							<c:choose>
								<c:when test="${info.field == 'job'}">就业信息</c:when>
								<c:when test="${info.field == 'notice'}">通知公告</c:when>
								<c:when test="${info.field == 'policy'}">政策制度</c:when>
								<c:when test="${info.field == 'other'}">其它信息</c:when>
								<c:otherwise>${info.field}</c:otherwise>
							</c:choose>
						</td>
						<td id="second_tt" style="width:90px;height:30px;">
							${info.subject}
						</td>
						<td id="tt" style=" width:280px;height:30px;">${info.title}
						</td>
						<td id="publisher" style="width:90px;height:30px;">
							学术实践
						</td>
						<td id="pub_time" style="width:110px;height:30px;">
							<fmt:formatDate value="${info.createTime}" pattern="yyyy-MM-dd"/>
						</td>
						<td id="label" style="width:170px;height:30px;">
							<c:forTokens var="label" items="${info.labels}" delims=", ">
								${label}&nbsp
							</c:forTokens>
						</td>
						<td style="width:170px;height:30px;">
							<p><a href="${pageContext.request.contextPath}/admin/infoDelete?id=${info.id}">删除</a></p>
						</td>
					</tr>
				</c:forEach>
			</table>
		    <div id="fade" class="black_overlay"></div>
		</div>
	</div>
		<%@ include file="footer.jsp"%>
	</div>
</body>
</html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>北京师范大学政府管理学院</title>
	<!-- 留言管理 -->
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
			margin:0;
			padding-left:0;
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
	<script src="../../static/js/jquery.min.js"></script>
	<script src="../../static/js/jedate.min.js"></script>
	<script>
	$(document).ready(function () {
		jeDate('#startTime', {
			minDate: '1990-01-01',
			isinitVal: true,
			format: 'YYYY-MM-DD',
			onClose: false,
			donefun:function(obj){
				// console.log(obj)
				var saliDate=obj.val.split("-");
				// console.log(saliDate)
				var riNum=0;
				var yueNum=0;
				var nianNum=saliDate[0];
				// console.log(saliDate[1]-1)
				// //判断月 同时判断年
				if(saliDate[1]-1<=0&&saliDate[2]=="01"){
					yueNum=12;
					riNum=31;
					nianNum=nianNum;
					// console.log(nianNum,yueNum,riNum)
					$("#endTime").val(nianNum+"-"+yueNum+"-"+riNum)
					return false;
				}else {
					yueNum=saliDate[1];
					nianNum=nianNum-0+1;
				}
				//当 日 是01 的时候要判断当前下一个月是否为31 还是30天  在判断一个是否为闰年  2月份是29 还是28
				if(saliDate[2]=="01"){
					switch(saliDate[1]-1){
						case 1:
						case 3:
						case 5:
						case 7:
						case 8:
						case 10:
						case 0://0就是12月  因为是只有点击的是2019-01-01  才会是2018-12-31
							riNum=31;
							yueNum="0"+(saliDate[1]-1);
							break;
						case 4:
						case 6:
						case 9:
						case 11:
							riNum=30;
							yueNum="0"+(saliDate[1]-1);
							break;
					}
					if(saliDate[1]-1==2){
						yueNum="0"+(saliDate[1]-1);
						//判断是否为闰年
						if(isLeap(saliDate[0])==1){
							riNum=29;
						}else{
							riNum=28;
						}
					}
				}else{
					if(saliDate[2]-1<=9){
						riNum="0"+(saliDate[2]-1);
					}else{
						riNum=saliDate[2]-1;
					}
				}
				$("#endTime").val(nianNum+"-"+yueNum+"-"+riNum)
				// console.log(nianNum,yueNum,riNum)
			}
		});
		jeDate('#endTime', {
			minDate: '1990-01-01',
			isinitVal: true,
			format: 'YYYY-MM-DD',
			onClose: false
		});
		
	   //判断是否为闰年  若为闰年，返回1，反之则返回0
		function isLeap(year) {
			if((year%4==0 && year%100!=0)||(year%400==0)){
				return 1;
			}
			return 0;
		}
	})
	</script>
	<link rel="stylesheet" type="text/css" href="../../static/jedate.css">
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
    <script type="text/javascript" src="../../static/js/infoupload.js"> </script>
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
			<div class="search1" style="margin:-12px 10px;">
				<p class="black" style="float:left;">账号：</p>
			</div>
			<div class="search1" style="margin:3px 7px;">
				<input type="text" name="userAccount" style="height:18px;width:100px;float:left;border-radius:5px;" >
			</div>
			<div class="search1">
				<p class="black" style="float:left;margin:3px 10px;">留言时间：</p>
			</div>
			<div class="search1" style="margin:3px 7px;">
				<input type="date" name="createTime" id="startTime" value="" readonly="">
			</div>
			<div class="search1" style="margin:4px 10px;">
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
				<p class="black" style="width:100px;">留言时间</p>
			</div>
			<div class="title" style="margin:-12px 10px;">
				<p class="black" style="width:670px;">留言内容</p>
			</div>
			<div class="title" style="margin:-12px 10px;">
				<p class="black" style="width:120px;">操作</p>
			</div>
		</div>
		<div class="list1">
			<table style="text-align:center;">
				<c:forEach var="comm" items="${commList}">
					<tr>
						<td style="width:210px;height:30px;">${comm.userAccount}
						</td>
						<td style="width:120px;height:30px;">${comm.createTime}
						</td>
						<td style="width:680px;height:30px;">${comm.content}
						</td>
						<td style="width:170px;height:30px;">
							<p><a href="/admin/commentDelete?id=${comm.id}">删除</a></p>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
		<%@ include file="footer.jsp"%>
	</div>
</body>
</html>
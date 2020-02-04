﻿<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<!--引入My97DatePicker日期组件的js文件 -->
	<script type="text/javascript" src="../../static/js/My97DatePicker/WdatePicker.js"> </script>

	<style type="text/css">
		body{
			margin:0;
			font-family: "微软雅黑"
		}
		.topback{
			width: 100%;
			height:auto;
			min-width:1364px;
		}
		.keyinputs{
			margin-top: 15px;
			margin-right: 30px;
			margin-left: 30px;
			height: auto;
			width: 94%;
			display:inline-block !important;
			display:inline;
			background-color: rgba(235,235,235,1);
			padding: 15px;
		}
		.searchtitle{
			font-size: 16px;
		}
		.butts{
			text-align:center;
			line-height:14px;
			height:14px;
			width: 14px;
			padding:0;
			font-size: 14px;
			font-weight: bold;
			color: rgba(90,150,223,1);
			vertical-align:middle;
			border-color: rgba(90,150,223,1);
			border-width: 1.5px;
			background: white;
			margin-left: 20px;
			margin-right: 16px;
			border-radius: 0;
		}
		.sel{
			height:  25.5px;
			width: 120px;
			margin-right: 2px;
			margin-left: 15px;
			padding:2px;
			font-size: 15px;
		}
		.sel1{
			height:  25.5px;
			width: 120px;
			margin-right: 2px;
			margin-left: 44px;
			padding:2px;
			font-size: 15px;
		}
		.inputtype{
			width: 200px;
			height:  25px;
			border:0.5px solid rgba(240,243,247,1);
			padding: 2px;
			font-size: 15px;
			margin-left: 6px;

		}
		.inputkey{
			width: 280px;
			height:  25px;
			border:0.5px solid rgba(240,243,247,1);
			padding: 2px;
			font-size: 15px;
			margin-left: 6px;
		}
		.items{
			margin-left: 85px;
			margin-bottom: 8px;
		}
		.searchbut{
			position: relative;
			background-color: orange;
			padding: 2px;
			font-size: 16px;
			font-weight: bold;
			color: white;
			width: 80px;
			height: 30px;
			letter-spacing:5px;
		}
		.searchbutzone{
			text-align: right;
			padding-right: 210px;
		}
	</style>
</head>
<body>
<%@include file="header.jsp"%>
<div>
	<img src="../../static/img/topback.jpg" class="topback">
</div>
<div class="keyinputs">
	<b class="searchtitle">输入检索条件:</b>
	<dl id="li">
		<dt class="items" >
			<input type="button" value="+" class="butts" onclick="addBotton()"/>
			<input type="button" value="-" class="butts" onclick="deletBotton()"/>
			<select class="sel1">
				<option value="field">信息类型</option>
				<option value="subject">主题</option>
				<option value="author">发布者</option>
				<option value="label">标签</option>

			</select>
			<input type="text" name="" class="inputtype">
			<select class="sel">
				<option value=" AND ">并含</option>
				<option value=" OR ">或含</option>
				<option value=" NOT ">不含</option>
			</select>
			<input type="text" name="" class="inputkey">
		</dt>
	</dl>
	<dl >
		<dt class="items" >
			<label for="publishdate_from">发表时间：</label>
			从
			<input id="publishdate_from" name="from" size="20" maxlength="20" type="text" onClick="WdatePicker()" readonly="readonly"/>
			到
			<input id="publishdate_to" name="to" size="20" maxlength="20" type="text" onClick="WdatePicker()" readonly="readonly"/>
		</dt>
	</dl>
	<dt class="searchbutzone">
		<input type="button" class="searchbut" value="检索" onclick="tores()">
	</dt>
</div>
</body>
</html>
<script type="text/javascript">
	var cont = document.getElementById("li");
	var i = 1;
	function addBotton(){
		if (i>=5) {
			window.alert("最多只能有五个检索项");
		}
		else{
			var ddt=document.createElement("dt");
			ddt.setAttribute("class","items");
			var sel1 = document.createElement("select");
			sel1.setAttribute("class","sel");
			var sel2 = document.createElement("select");
			sel2.setAttribute("class","sel");
			var sel3 = document.createElement("select");
			sel3.setAttribute("class","sel");

			var o1=document.createElement("option");
			o1.innerText="并且";
			var o2=document.createElement("option");
			o2.innerText="或者";
			var o3=document.createElement("option");
			o3.innerText="不含";
			var o4=document.createElement("option");
			o4.innerText="并含";
			var o5=document.createElement("option");
			o5.innerText="信息类型";
			var o6=document.createElement("option");
			o6.innerText="发布者";
			var o7=document.createElement("option");
			o7.innerText="标签";
			var o8=document.createElement("option");
			o8.innerText="或者";
			var o9=document.createElement("option");
			o9.innerText="不含";
			var o10=document.createElement("option");
			o9.innerText="主题";


			sel1.appendChild(o1);
			sel1.appendChild(o2);
			sel1.appendChild(o3);
			ddt.appendChild(sel1);

			sel2.appendChild(o5);
			sel2.appendChild(o10);
			sel2.appendChild(o6);
			sel2.appendChild(o7);
			ddt.appendChild(sel2);

			var input1=document.createElement("input");
			input1.setAttribute("type","text");
			input1.setAttribute("class","inputtype");
			input1.setAttribute("style","margin-left:12px;");
			ddt.appendChild(input1);

			sel3.appendChild(o8);
			sel3.appendChild(o9);
			sel3.appendChild(o4);
			sel3.setAttribute("style","margin-left:18px;");
			ddt.appendChild(sel3);

			var input2=document.createElement("input");
			input2.setAttribute("type","text");
			input2.setAttribute("class","inputkey");
			input2.setAttribute("style","margin-left:12px;");
			ddt.appendChild(input2);

			cont.appendChild(ddt);
			i++;}
	}
	function deletBotton(){
		if (i<=1) {
			window.alert("至少需要一个检索项");
		}
		else {cont.removeChild(cont.lastChild);i--;}
	}
	function getva(n){
		var index = n.selectedIndex ;
		var text = n.options[index].text;
		return n.options[index].value;

	}
	function tores(){
		var obj=document.getElementsByClassName("items");

		var text= '';
		var chi=obj[0].childNodes;

		for(var i=0; i<chi.length;i++){
			if(chi[i].nodeName === "#text" && !/\s/.test(chi.nodeValue)){
				obj[0].removeChild(chi[i]);
			}
		}

		var value=getva(chi[4]);

		if(value=='并含'){

			text=text+getva(chi[2])+'=='+chi[3].innerText+" AND "+chi[5].innerText;
		}
		else if(value=='或含'){
			text=text+getva(chi[2])+'=='+chi[3].innerText+" OR "+chi[5].innerText;
		}
		else if(value=='不含'){
			text=text+getva(chi[2])+'=='+chi[3].innerText+" NOT "+chi[5].innerText;
		}
		for (var i = 1; i < obj.length-1; i++) {
			chi=obj[i].childNodes;
			for(var j=0; j<chi.length;j++){
				if(chi[j].nodeName == "#text" && !/\s/.test(chi.nodeValue)){
					obj[i].removeChild(chi[j]);
				}
			}
			var value=getva(chi[3]);

			if(value=='并含'){
				text=text+'&'+getva(chi[1])+'=='+chi[2].innerText+"AND"+chi[4].innerText;
			}
			else if(value=='或者'){
				text=text+'&'+getva(chi[1])+'=='+chi[2].innerText+"OR"+chi[4].innerText;
			}
			else if(value=='不含'){
				text=text+'&'+getva(chi[1])+'=='+chi[2].innerText+"NOT"+chi[4].innerText;
			}}
		chi=obj[i].childNodes;
		text=text+'&时间 == '+chi[2].innerText;
		window.location.href= "/info/adSearch"+text;
	}
</script>
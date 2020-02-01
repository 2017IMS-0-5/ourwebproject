<%@ page contentType= "text/html; charset = utf-8"%>
<html>
<head>
	<style type="text/css">
		body{
			margin:0;
			font-family: "微软雅黑"
		}
		
		.noteuploadzone{
			width: auto;
			min-width: 1190px;
			-moz-border-radius: 5px;
			-webkit-border-radius: 5px;
			border-radius: 5px;
			height: auto;
			margin-left: 280px;
			margin-top: 28px;
			padding-left: 25%;

		}
		label{
			width: 150px;
			display:inline-block;
			letter-spacing:2px;
			font-size: 20px;
		}
		.sel{
			height:  32px;
			width: 35%;
			padding:2px;
			font-size: 18px;
			-moz-border-radius: 2px;
			-webkit-border-radius: 2px;
			border-radius: 2px;
			border: 1px solid gray;
			padding-left: 12px;
		}
		.items{
			margin-left: 85px;
			margin-bottom: 15px;
		}
		.uploadinput{
			width: 35%;
			height:  32px;
			padding-left: 12px;
			letter-spacing: 1px;
			font-size: 18px;
			-moz-border-radius: 2px;
			-webkit-border-radius: 2px;
			border-radius: 2px;
			border: 1px solid gray;
		}
		.filezone{
			margin-top: 0;
		}
		.filepath{
			width: 35%;
			height:  32px;
			padding-left: 10px;
			letter-spacing: 1px;
			font-size: 18px;
			margin-left: 233px;
			-moz-border-radius: 2px;
			-webkit-border-radius: 2px;
			border-radius: 2px;
			border: 1px solid gray;
		}
		.filebut{
			width: 35%;
			height:  32px;
			width: 70px;
			-moz-border-radius: 2px;
			-webkit-border-radius: 2px;
			border-radius: 2px;
			border: 1px solid gray;
			font-size: 18px;
		}
		.funcbutadd{
			border-radius: 50%;
			border: none;
			background-color: green;
			color: white;
			height: 20px;
			width: 20px;
			margin-left: 34px;
			font-weight:  bold;
			font-size: 18px;
			text-align: center;
            

           }
		.funcbutdel{
			border-radius: 50%;
			border: none;
			background-color: red;
			color: white;
			height: 20px;
			width: 20px;
			margin-left: 15px;
			font-weight:  bold;
			font-size: 18px;
			text-align: center;
		
		}
		span{
			margin-left: 9px;
		}
		.butzone{
			margin-top: 18px;
		}
		.submitbut{
			position: relative;
			padding: 2px;
			font-size: 18px;
			font-weight: bold;
			color: white;
			width: 8%;
			height: 34px;
			letter-spacing:5px;
			margin-left: 230px;
			background-color: green;
			text-align: center;
			-moz-border-radius: 2px;
			-webkit-border-radius: 2px;
			border-radius: 2px;
		}
		.resetbut{
			position: relative;
			padding: 2px;
			font-size: 18px;
			font-weight: bold;
			color: white;
			width: 8%;
			height: 34px;
			margin-left: 60px;
			letter-spacing:5px;
			background-color: red;
			-moz-border-radius: 2px;
			-webkit-border-radius: 2px;
			border-radius: 2px;
		}
		.list{
			height: 350px;
			
		}
	</style>
</head>
<body>
	<%@include file="managerheader.jsp"%>
	<%@include file="Administratornavigatorbar.jsp"%>
	<div class="noteuploadzone">
		<dl id="li" class="list">
			<dt class="items">
				<label>文件名:</label><input type="text" name="" class="uploadinput">
			</dt>
			<dt class="items">
				<label>文件类型:</label><select class="sel"><option>通知公告</option><option>政策规章</option><option>其他信息</option><option>就业实习</option></select>
			</dt>
			<dt class="items" id="tags">
				<label>文件标签:</label><input type="text" name="" class="uploadinput"><input type="button" name="" class="funcbutadd" value="+" onclick="addBotton()"><span>增加</span><input type="button" class="funcbutdel" name="" value="x" onclick="delBotton()"><span>删除</span>
			</dt>
		</dl>
		<div class="filezone">
			<input type="text" name="" placeholder="选择文件" class="filepath"><input type="button" value="上传" class="filebut" name=""><br>
		</div>
		
		<div class="butzone">
		<input type="button" name="" value="提交" class="submitbut"><input type="button" class="resetbut" value="重置" name=""></div>
	</div>
</body>
</html>
<script type="text/javascript">
    var cont = document.getElementById("li");
    var i = 1;
    function addBotton(){
        if (i<5) {
        var ddt=document.createElement("dt");
        ddt.setAttribute("class","items");
        var input2=document.createElement("input");
        input2.setAttribute("type","text");
        input2.setAttribute("class","uploadinput");
        input2.setAttribute("style","margin-left:149px;");
        
        ddt.appendChild(input2);

        cont.appendChild(ddt);
        i++;}
        else window.alert("不可添加多与5个标签");
    }
    function delBotton(){
    	if (i>1) {
    	cont.removeChild(cont.lastChild);
    	i--;
    }
    else{
    	 window.alert("至少应该有一个标签");
    }
    }
</script>
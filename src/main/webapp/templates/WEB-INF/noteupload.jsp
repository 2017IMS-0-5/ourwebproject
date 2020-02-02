<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<style type="text/css">
		body{
			margin:0;
			font-family: "微软雅黑"
		}
		.mantainer{
			height: 600px;
			margin-bottom: 40px;
		}
		.noteuploadzone{
			width: auto;
			-moz-border-radius: 5px;
			-webkit-border-radius: 5px;
			border-radius: 5px;
			height: auto;
			margin-left: 280px;
			margin-top: 28px;
			padding-left: 18%;

		}
		label{
			width: 15%;
			min-width: 150px;
			display:inline-block;
			letter-spacing:2px;
			font-size: 20px;
		}
		.sel{
			height:  34px;
			width: 40%;
			min-width: 400px;
			padding:2px;
			font-size: 18px;
			-moz-border-radius: 2px;
			-webkit-border-radius: 2px;
			border-radius: 2px;
			border: 1px solid gray;
			padding-left: 12px;
		}
		.items{
			
			margin-bottom: 15px;
		}
		.uploadinput{
			width: 40%;
			min-width: 400px;
			height:  34px;
			padding-left: 12px;
			letter-spacing: 1px;
			font-size: 18px;
			-moz-border-radius: 2px;
			-webkit-border-radius: 2px;
			border-radius: 2px;
			border: 1px solid gray;
		}
		.abs{
			width: 40%;
			min-width: 400px;
			height: 96px;
			font-size: 18px;
			padding-left: 12px;
		}
		.filezone{
			margin-top: 0;

		}
		.filepath{
			width: 400px;
			height:  34px;
			padding-left: 10px;
			letter-spacing: 1px;
			font-size: 18px;
			
			-moz-border-radius: 2px;
			-webkit-border-radius: 2px;
			border-radius: 2px;
			border: 1px solid gray;
		}
		.filebut{
			height:  34px;
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
			width: 100%;
			text-align: center;
		}
		.submitbut{
			padding: 2px;
			font-size: 18px;
			font-weight: bold;
			color: white;
			width: 100px;
			min-width: 90px;
			height: 34px;
			letter-spacing:5px;
			background-color: green;
			text-align: center;
			-moz-border-radius: 2px;
			-webkit-border-radius: 2px;
			border-radius: 2px;
		}
		.resetbut{
			padding: 2px;
			font-size: 18px;
			font-weight: bold;
			color: white;
			width: 100px;
			min-width: 90px;
			height: 34px;
			letter-spacing:5px;
			background-color: red;
			-moz-border-radius: 2px;
			-webkit-border-radius: 2px;
			border-radius: 2px;
		}
		.list{
			
			height: auto;
			
		}

	</style>
</head>
<body>
		<%@include file="managerheader.jsp"%>	
	<div class="mantainer">
	<%@include file="Administratornavigatorbar.jsp"%>
	<div class="noteuploadzone">
		<form action="" method="post" class="form">
		<dl id="li" class="list">
			<dt class="items">
				<label>文件名:</label><input type="text" name="" class="uploadinput">
			</dt>
			<dt class="items">
				<label>文件类别:</label><select class="sel"><option>通知公告</option><option>政策规章</option><option>其他信息</option><option>就业实习</option></select>
			</dt>
			<dt class="items">
				<label>文件类型:</label><input type="text" name="" class="uploadinput">
			</dt>
			<dt class="items" id="tags">
				<label>文件标签:</label><input type="text" name="" class="uploadinput"><input type="button" name="" class="funcbutadd" value="+" onclick="addBotton()"><span>增加</span><input type="button" class="funcbutdel" name="" value="x" onclick="delBotton()"><span>删除</span>
			</dt>	
		</dl>
		<dt class="items" style="margin-bottom: 60px;">
			<label style="vertical-align: top;">通知摘要：</label><textarea class="abs"></textarea>
		</dt>
		<div class="filezone">
			<label></label><input type="file" name="" placeholder="选择文件" class="filepath"><br>
		</div>
		
		<div class="butzone">
		<input type="button" name="" value="提交" class="submitbut">
			<input type="button" class="resetbut" value="重置" name="">
	    </div>
		</form>
	</div>
</div>
	<%@include file="footer.jsp"%>
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
        var l=document.createElement("label");
        input2.setAttribute("type","text");
        input2.setAttribute("class","uploadinput");
       
        ddt.appendChild(l);
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
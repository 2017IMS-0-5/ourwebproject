<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="../../static/css/upload.css">
</head>
<body>
	<%@include file="managerheader.jsp"%>	
	<div class="mantainer">
	<%@include file="Administratornavigatorbar.jsp"%>
	<div class="noteuploadzone">
		<form action="/admin/tzggsubmit" method="get" class="form" onsubmit="deal()">
            <dl id="li" class="list">
                <dt class="items">
                    <label>文件名:</label><input type="text" name="title" class="uploadinput">
                </dt>
                <dt class="items">
                    <label>文件类别:</label><input type="text" name="field" value="其他信息" contenteditable="false" class="uploadinput">
                </dt>
                
                <dt class="items" id="tags">
                    <label>文件标签:</label><input type="text" name="label" class="uploadinput"><input type="button" name="" class="funcbutadd" value="+" onclick="addBotton()"><span>增加</span><input type="button" class="funcbutdel" name="" value="x" onclick="delBotton()"><span>删除</span>
                </dt>
            </dl>
            <dt class="items" style="margin-bottom: 60px;">
                <label style="vertical-align: top;">通知内容：</label><textarea name="content" class="abs"></textarea>
            </dt>
            <input type="hidden" name="labels" id="labels"/>
            <div class="filezone">
                <label></label><input type="file" name="relationFile" placeholder="选择文件" class="filepath"><br>
            </div>

            <div class="butzone">
                <label></label><input type="submit" name="" value="提交" class="submitbut">
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
            input2.setAttribute("name","label");
       
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

    function  deal(){
        var labelList=document.getElementsByName("label");
        var labels;
        for (var i=0;i<labelList.length;i++){
            labels+=","+labelList[i].value();
        }
        document.getElementById("labels").value=labels;
        return true;
    }
</script>
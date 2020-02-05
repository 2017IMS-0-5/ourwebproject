
<html>
<head>
	<head>
	<link rel="stylesheet" type="text/css" href="../../static/css/upload.css">
</head>
<body>
	<%@include file="managerheader.jsp"%>	
	<div class="mantainer" style="height: 870px;">
	<%@include file="Administratornavigatorbar.jsp"%>
	<div class="noteuploadzone">
		<form action="/admin/infosubmit" method="post" class="form" onsubmit="return deal()">
            <dl id="li" class="list">
                <dt class="items">
                    <label>文件标题:</label><input type="text" name="title" id="title" class="uploadinput">
                </dt>
                <dt class="items">
                    <label>文件类别:</label><input type="text" name="fieldName" value="就业实习" disabled="true" class="uploadinput">
                    <input type="hidden" name="field" value="job" />
                </dt>
                <dt class="items">
                    <label>文件主题:</label>
                    <select name="subject" class="sel">
                        <option value="sxxx">实习信息</option>
                        <option value="xdxx">选调信息</option>
                        <option value="zphxx">招聘会信息</option>
                        <option value="wnjyxx">往年就业信息</option>
                </select>
                </dt>
                <dt class="items" id="tags">
                    <label>文件标签:</label><input type="text" name="label" class="uploadinput"><input type="button" name="" class="funcbutadd" value="+" onclick="addBotton()"><span>增加</span><input type="button" class="funcbutdel" name="" value="x" onclick="delBotton()"><span>删除</span>
                </dt>
            </dl>
            <dt class="items">
                <label>公司名称：</label><input type="text" id="corporation" class="uploadinput">
            </dt>
            <dt class="items">
                <label>公司地址：</label><input type="text" id="address" class="uploadinput">
            </dt>
            <dt class="items">
                <label>薪资待遇：</label><input type="text" id="salary" class="uploadinput">
            </dt>
            <dt class="items">
                <label>联系方式：</label><input type="text" id="call" class="uploadinput">
            </dt>
            <dt class="items" style="margin-bottom: 60px;">
                <label style="vertical-align: top;">文件内容：</label><textarea id="content" name="content" class="abs"></textarea>
            </dt>
            <input type="hidden" name="labels" id="labels"/>
            <div class="items" style="margin-bottom: 60px;">
                <label style="vertical-align: top;">附&nbsp&nbsp件：</label>
                <input type="file" name="relationFile" placeholder="选择文件" class="filepath"><br>
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

    function validate_required(field,alerttxt)
    {
        with (field)
        {
            if (value==null||value=="")
            {alert(alerttxt);return false}
            else {return true}
        }
    }

    function  deal(){
        var labelList=document.getElementsByName("label");
        var labels="";
        for (var i=0;i<labelList.length;i++){
            labels+=","+labelList[i].value;
        }
        document.getElementById("labels").value=labels;
        var content=document.getElementById("content").value;
        var corporation=document.getElementById("corporation").value;
        var address=document.getElementById("address").value;
        var salary=document.getElementById("salary").value;
        var call=document.getElementById("call").value;
        if(corporation!=""||corporation!=null){
            content="【公司名称】 "+corporation+"\n"+content;
        }
        if(address!=""||address!=null){
            content="【公司地址】 "+address+"\n"+content;
        }
        if(salary!=""||salary!=null){
            content="【薪资待遇】 "+salary+"\n"+content;
        }
        if(call!=""||call!=null){
            content="【联系方式】 "+call+"\n"+content;
        }

        if (validate_required(document.getElementById("title"),"标题不可为空!")==false)
        {
            document.getElementById("title").focus();
            return false;
        }
        if (validate_required(content,"内容不可为空!")==false)
        {
            document.getElementById("content").focus();
            return false;
        }

        return true;
    }
</script>
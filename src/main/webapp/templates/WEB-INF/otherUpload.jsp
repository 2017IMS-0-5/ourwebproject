<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>信息上传</title>
    <script type="text/javascript" src="../../static/js/infoUpload.js"> </script>
	<link rel="stylesheet" type="text/css" href="../../static/css/upload.css">
</head>
<body>
	<%@include file="managerheader.jsp"%>	
	<div class="mantainer">
	<%@include file="Administratornavigatorbar.jsp"%>
	<div class="noteuploadzone">
		<form action="/admin/infosubmit" method="post" class="form" onsubmit="deal()">
            <dl id="li" class="list">
                <dt class="items">
                    <label>文件标题:</label><input type="text" name="title" class="uploadinput">
                </dt>
                <dt class="items">
                    <label>文件类别:</label><input type="text" name="fieldName" value="其他信息" disabled="true" class="uploadinput">
                    <input type="hidden" name="field" value="other" />
                    <input type="hidden" name="subject" value="qtxx" />
                </dt>
                
                <dt class="items" id="tags">
                    <label>文件标签:</label><input type="text" name="label" class="uploadinput"><input type="button" name="" class="funcbutadd" value="+" onclick="addBotton()"><span>增加</span><input type="button" class="funcbutdel" name="" value="x" onclick="delBotton()"><span>删除</span>
                </dt>
            </dl>
            <dt class="items" style="margin-bottom: 60px;">
                <label style="vertical-align: top;">文件内容：</label><textarea name="content" class="abs"></textarea>
            </dt>
            <input type="hidden" name="labels" id="labels"/>
            <div class="filezone">
                <label style="vertical-align: top;">(如有)附件：</label>
                <input type="file" name="relationFile" placeholder="选择文件" class="filepath"><br>
            </div>

            <div class="butzone">
                <label></label><input type="submit" name="" value="提交" class="submitbut">
                <input type="reset" class="resetbut" value="重置" name="">
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
</script>
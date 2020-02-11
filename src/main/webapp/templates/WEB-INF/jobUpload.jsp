
<html>
<head>
    <title>信息上传</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/infoUpload.js"> </script>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/upload.css">
</head>
<body>
	<%@include file="managerheader.jsp"%>	
	<div class="mantainer" style="height: auto">
	<%@include file="Administratornavigatorbar.jsp"%>
	<div class="noteuploadzone">
		<form action="${pageContext.request.contextPath}/admin/infosubmit" method="post" class="form" onsubmit="return deal()">
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
            <dt class="items" style="margin-bottom: 20px;">
                <label style="vertical-align: top;">公司名称：</label><textarea type="text" name="corporation" class="abs" style="height:60px;"></textarea>
            </dt>
            <dt class="items" style="margin-bottom: 20px;">
                <label style="vertical-align: top;">公司地址：</label><textarea type="text" name="address" class="abs" style="height:60px;"></textarea>
            </dt>
            <dt class="items" style="margin-bottom: 20px;">
                <label style="vertical-align: top;">薪资待遇：</label><textarea type="text" name="salary" class="abs" style="height:60px;"></textarea>
            </dt>
            <dt class="items" style="margin-bottom: 20px;">
                <label style="vertical-align: top;">联系方式：</label><textarea type="text" name="call" class="abs" style="height:60px;"></textarea>
            </dt>
            <dt class="items" style="margin-bottom: 20px;">
                <label style="vertical-align: top;">正文内容：</label><textarea id="content" name="content" class="abs" ></textarea>
            </dt>
            <input type="hidden" name="labels" id="labels"/>
            <div class="items" style="margin-bottom: 60px;">
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
<script>
    var cont = document.getElementById("li");
    var i = 1;
</script>
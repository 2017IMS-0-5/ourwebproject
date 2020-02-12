<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>北京师范大学政府管理学院</title>
    <!-- 人员管理 -->
    <style  type="text/css">
        div.content
        {
            background-color:white;
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
        .changelabel{
            width: 89px;
            display:inline-block;
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
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/infoUpload.js"> </script>
    <script src="${pageContext.request.contextPath}/static/js/jquery.min.js"></script>
    <script type="text/javascript">
        function openDialog(){
            document.getElementById('light').style.display='block';
            document.getElementById('fade').style.display='block';

        }
        function closeDialog(){
            document.getElementById('light').style.display='none';
            document.getElementById('fade').style.display='none';
        }
        function getva(n){
        var index = n.selectedIndex ;
        var text = n.options[index].text;
        return n.options[index].value;

    }
        function tocheck(){
            var x1=document.getElementById("role");
            var x2=document.getElementById("indexitem");
            var x3=document.getElementById("peoplesearchword").value;
            window.location.href="/admin/"+getva(x1)+getva(x2)+"?"+getva(x2).toLowerCase()+"="+encodeURIComponent(x3);
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
            <form>
                <img src="${pageContext.request.contextPath}/static/img/search.jpg" style="float:left;"/>
                <div class="search1" style="margin:-12px 15px;">
                    <p class="black" style="float:left;border-radius:5px;">人员类型：</p>
                </div>
                <div class="search1" style="margin:5px 7px;">
                    <select name="role" style="float:left;border-radius:5px;" id="role">
                        <option value="userByStuAnd" selected="selected">学生</option>
                        <option value="userByTeaAnd">教师</option>
                    </select>
                </div>
                <div class="search1" style="margin:-12px 10px;">
                    <p class="black" style="float:left;">检索方式：</p>
                </div>
                <div class="search1" style="margin:5px 7px;">
                    <select name="searchWay" style="float:left;border-radius:5px;" id="indexitem">
                        <option value="Name">按姓名检索</option>
                        <option value="Grade">按年级检索</option>
                        <option value="Major">按专业检索</option>
                        <option value="Account">按账号检索</option>
                    </select>
                </div>
                <div class="search1" style="margin:-12px 10px;">
                    <p class="black" style="float:left;">检索词：</p>
                </div>

                <div class="search1" style="margin:3px 7px;">
                    <input type="text" name="searchWord" style="height:18px;width:100px;float:left;border-radius:5px;" id="peoplesearchword">
                </div>

                <div class="search1" style="margin:3px 7px;">
                    <input type="button" value="搜索" class="button" onclick="tocheck()">
                </div>
                <div class="search1" style="margin:4px 10px;">
                    <input type="button" value="新增" class="button" onclick="openDialog()">
                </div>
                
            </form>
        </div>
        
        <div class="list1">
            <table class="managetable">
                
                    <tr style="background-color:rgba(143,130,188,1); ">
                        <th>身份</th>
                        <th>年级</th>
                        <th>专业</th>
                        <th>账号</th>
                        <th>姓名</th>
                        <th>性别</th>
                        <th>电子邮箱</th>
                        <th>操作</th>
                    </tr>
                    <c:forEach var="stu" items="${userList}">
                        <tr class="detailinfor">
                            <td><c:if test="${stu.role==1}"><c:out value="学生"/></c:if><c:if test="${stu.role==2}"><c:out value="教师"/></c:if>
                            </td>
                            <td>${stu.grade}
                            </td>
                            <td>${stu.major}
                            </td>
                            <td >${stu.account}
                            </td>
                            <td >${stu.name}
                            </td>
                            <td>${stu.gender}
                            </td>
                            <td >${stu.email}
                            </td>
                            <td>
                                <p><a href="${pageContext.request.contextPath}/admin/userDelete?id=${stu.id}">删除</a></p>
                            </td>
                        </tr>
                    </c:forEach>
            </table>
            <div id="light" class="white_content">
                <div class="noteuploadzone">
                    <form action="/admin/userInsert" method="post" class="form" onsubmit="return deal()">
                        <dl id="li" class="list" id="changeuplist">
                            <dt class="items">
                                <label class="changelabel">身份：</label><input type="text" name="role" value="" class="uploadinput">
                            </dt>
                            <dt class="items">
                                <label class="changelabel">年级：</label><input type="text" name="grade" value="" class="uploadinput">
                            </dt>
                            <dt class="items">
                                <label class="changelabel">专业：</label><input type="text" name="major" value="" class="uploadinput">
                            </dt>
                            <dt class="items">
                                <label class="changelabel">账号：</label><input type="text" name="account" value="" class="uploadinput">
                            </dt>
                            <dt class="items">
                                <label class="changelabel">姓名：</label><input type="text" name="name" value="" class="uploadinput">
                            </dt>
                            <dt class="items">
                                <label class="changelabel">性别：</label><input type="text" name="gender" value="" class="uploadinput">
                            </dt>
                            <dt class="items">
                                <label class="changelabel">邮箱：</label><input type="text" name="email" value="" class="uploadinput">
                            </dt>
                            <dt class="items">
                                <label>password：</label><input type="text" name="password"  disabled="true" class="uploadinput">
                            </dt>
                        </dl>
                        <div style="text-align:center;">
                            <label></label><input type="submit" name="submit" value="提交" class="submitbut">
                            <button type="button" class="new_button2" href = "javascript:void(0)" onclick="closeDialog()">返回</button>
                        </div>
                    </form>
                </div>
            </div>
            <div id="fade" class="black_overlay"></div>
        </div>
    </div>
    <%@ include file="footer.jsp"%>
</div>
</body>
</html>
    <script type="text/javascript">
        window.onload=function()
        {
            var changes = document.getElementsByClassName("changeinfo");
            var detailinfors = document.getElementsByClassName("detailinfor");   
            for(var i = 0, n = changes.length; i <n; i += 1)
            {
                changes[i].id=i;
                changes[i].onclick = function()
                {
                    document.getElementById('light').style.display='block';
                    document.getElementById('fade').style.display='block';
                    var changedetails = document.getElementsByClassName("uploadinput");
                    var origion = detailinfors[this.id];
                    var origiondetails = origion.childNodes;
                    

                    for (var j = 0,x=0; j <= changedetails.length - 3; j++,x++) {
                        while(origiondetails[x].innerHTML == undefined){
                            x++;}
                        changedetails[j].value=origiondetails[x].innerHTML;
                    }
                    
            }                
            }
        }
</script>
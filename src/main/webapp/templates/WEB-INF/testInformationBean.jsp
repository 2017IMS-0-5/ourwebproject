
<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2020/1/19
  Time: 18:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body >
<div style="white-space: pre-line;">
HelloJSP!<br><br>
    <div>
        ***以下展示infoId="${info.id}"的文章<br>
        【文章标题】${info.title}<br>
        【一级标题】${info.field} &nbsp;&nbsp;&nbsp;&nbsp;【二级标题】${info.subject}<br>
        【发布者】${info.author}  &nbsp;&nbsp;&nbsp;&nbsp;【发布时间】${info.createTime}<br>
        【正文内容】<br>
        ${info.content}<br>
        【附件】${info.relation}<br>
        【阅读量】${info.readSize}<br>
    </div>
    <div>
        ***以下展示一级标题代号“job”,二级标题代号“sxxx”的文章List<br>
        <c:forEach var="infor" items="${infoList}">
            <div>
                【文章标题】${infor.title}<br>
                【一级标题】${infor.field} &nbsp;&nbsp;
                【二级标题】${infor.subject}&nbsp;&nbsp;
                【发布者】${infor.author}  &nbsp;&nbsp;
                【发布时间】${infor.createTime} &nbsp;&nbsp;
                【阅读量】${infor.readSize}<br>
            </div>
        </c:forEach>
    </div>
</div>
</body>
</html>

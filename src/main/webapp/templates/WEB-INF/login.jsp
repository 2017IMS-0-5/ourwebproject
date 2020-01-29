<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2020/1/29
  Time: 19:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
请登录<br>
<form action="/checkLogin" method="get" name="form">
    Account:<input type="text" name="account"/><br>
    Password:<input type="password" name="password"/><br>
    <input type="submit" value="提交">
</form>
</body>
</html>

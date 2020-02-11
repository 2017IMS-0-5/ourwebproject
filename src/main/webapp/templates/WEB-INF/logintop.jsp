<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>logintop</title>
    <style type="text/css">
        body{margin:0;font-family: 微软雅黑;}
        .lt_bg1{height: 100px; background-color:rgb(240,240,240)}
        .lt_bg1 table{width: 100%;height: 100%}
        .lt_td1{width: 25%;text-align: center;}
        .lt_td1 img{height:95px;vertical-align: center;}
        .lt_td2{width: 75%;text-align: center;}
        .lt_td2 p{font-size: 22px;font-weight: bold; letter-spacing :3pt; color:darkblue;}
    </style>
</head>
<body>
<div class="lt_bg1">
    <table align="center">
        <tr>
            <td class="lt_td1">
                <img src="${pageContext.request.contextPath}/static/img/logintop.png">
            </td>
            <td class="lt_td2">
                <p>欢迎登录政府管理学院信息资源集合平台</p>
            </td>
        </tr>
    </table>
</div>
</body>
</html>

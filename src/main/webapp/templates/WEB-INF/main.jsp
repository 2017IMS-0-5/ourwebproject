<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>首页</title>
    <style type="text/css">
        body{margin:0; font-family: 微软雅黑;}
        .bg0{background-image: url(../../static/img/back.png);background-size:cover; background-repeat:no-repeat;overflow: hidden;margin: 0;}
        .bg1{height: 50%;width:100%;text-align: center;}
        .bg1 img{height:60%;padding-top:40px;}

        .bg2{height:50%;width:100%;}
        .bg2 td{height:120px;width: 225px; text-align: center;}
        .bg2 img{height: 120px;width: 120px;}
    </style>
</head>

<body>
<%@include file="header.jsp"%>

<div class="bg0">
    <div class="bg1">
        <img src="../../static/img/mainlogo.png">
    </div>
    <div class="bg2">
    <table align="center">
        <tr>
            <td>
                <a href="/info/notice"><img src="../../static/img/item_tzgg.png"></a>
            </td>
            <td>
                <a href="/info/policy"><img src="../../static/img/item_zczd.png"></a>
            </td>
            <td>
                <a href="/info/job"><img src="../../static/img/item_jyxx.png"></a>
            </td>
            <td>
                <a href="/info/other"><img src="../../static/img/item_qtxx.png"></a>
            </td>
        </tr>
    </table>
    </div>
</div>

<%@ include file="footer.jsp"%>



</body>
</html>

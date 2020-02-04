<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>首页</title>
</head>
<body style="margin: 0">
<%@ include file="header.jsp"%>
<div style="height: 290px;width:100%;background-image: url(../../static/img/back3.png);background-position:center top;background-size:100%; background-repeat:no-repeat;padding-top: 400px;">
    <div style="height:auto;width:100%;text-align: center">
        <div style="width:600px;text-align: center;display: inline-block;">
                    <div style="width: 150px;float:left;">
                        <a href="/info/notice"><img src="../../static/img/item_tzgg.png" name="tzgg" style="height:120px;width: 120px;"></a>
                    </div>

                    <div style="width: 150px;float:left;">
                        <a href="/info/policy"><img src="../../static/img/item_zczd.png" name="zczd" style="height:120px;width: 120px;"></a>
                    </div>

                    <div style="width: 150px;float:left;">
                        <a href="/info/job"><img src="../../static/img/item_jyxx.png" name="jyxx" style="height:120px;width: 120px;"></a>
                    </div>

                    <div style="width: 150px;float:left;">
                        <a href="/info/other"><img src="../../static/img/item_qtxx.png" name="qtxx" style="height:120px;width: 120px;"></a>
                    </div>
        </div>
    </div>
</div>
<%@ include file="footer.jsp"%>
</body>
</html>

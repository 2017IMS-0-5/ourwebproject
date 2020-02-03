<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录界面</title>
    <style type="text/css">
        .input_text{width:96%;height: 38px;margin-bottom:17px;font-family: "微软雅黑";font-size:16px;background-color: white;border:none;border-radius: 5px;padding-bottom: 5px;padding-top: 5px;padding-left:15px;  }
        .input_radio{width:43%;height: 38px;margin-bottom: 25px;font-family: "微软雅黑";font-size:16px;background:rgba(242, 242, 242, 0.7);border-radius: 5px;padding-top: 5px;margin-right: 16px;margin-left: 5px; float:left;}
        .input_submit{width: 96%;height:38px;margin-top:24px; color:white;font-size: 18px;font-weight: bold;font-family: "微软雅黑";background-color:rgb(4,130,200);padding-bottom: 5px;border:none;border-radius: 5px;align:center }

        .a-radio{display: none;}
        .b-radio{display: inline-block;border:1px solid #ccc;width:16px;height: 16px;border-radius:2px;vertical-align: middle;margin-right: 5px;position: relative;}
        .b-radio:before{content: '';font-size: 0;width: 10px;height: 10px;background: rgb(143, 188, 238);position: relative;left:50%;top:50%;margin-left: -5px;margin-top: -5px;display: none;}
        .a-radio:checked~.b-radio:before{display: block;}
    </style>
</head>
<body style="margin: 0">
<%@ include file="logintop.jsp"%>
<div style="height: 500px;width:100%;background-image: url(../../static/img/back.png);background-size:100%; background-repeat:no-repeat;padding-top: 130px;">
    <div style="height: 360px;width:300px;background:rgba(242, 242, 242, 0.5);padding-left: 21px;padding-right: 21px;padding-bottom: 21px;padding-top:1px;margin-left:60%;border-radius: 5px;">
        <p style="font-size: 30px;font-weight: bold; align:left; padding-left:5px; font-family:微软雅黑; color:darkblue">平台登录</p>

        <form method=post action="/checkLogin" align="center">
            <div class="input_radio">
                <label>
                    <input type="radio" checked name="role" value="user" class="a-radio" >
                    <span class="b-radio"></span>   用户
                </label>
            </div>
            <div class="input_radio">
                <label>
                    <input type="radio" name="role" value="manager" class="a-radio">
                    <span class="b-radio"></span>   管理员
                </label>
            </div>
            <input type="text" name="account" class="input_text" placeholder="请输入校园卡号"><br>
            <input type="password" name="password" class="input_text" placeholder="请输入密码">
            <input type="button" onclick=explainPassword() name="pswinfo" style="font-size: 12px; font-family:微软雅黑;background-color:rgb(0,0,0,0);border:none ;float:left" value="密码说明">
            <input type="submit" value="点击登录" class="input_submit">
        </form>
    </div>
</div>
<%@ include file="footer.jsp"%>
</body>
</html>
<script type="text/javascript">
    function explainPassword() {
        alert("初始密码为学号后六位");
    }
</script>

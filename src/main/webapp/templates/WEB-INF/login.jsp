<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录界面</title>

    <style type="text/css">
        body{margin:0;font-family: 微软雅黑;}
        .bg1{height: 100%;width:100%;background-image: url(../../static/img/back.png);background-size:cover; background-repeat:no-repeat;overflow: hidden;margin: 0;}
        .bg2{height: 360px;width:300px;background:rgba(242, 242, 242, 0.5);padding-left: 21px;padding-right: 21px;padding-bottom: 21px;padding-top:1px;margin-left:63%;margin-top:11%;border-radius: 5px;}
        .bg2 p{font-size: 30px;font-weight: bold; align:left; padding-left:5px; color:darkblue}
        .bg2 a{font-size: 12px;color:dimgray;text-decoration: none;float: left;padding-left: 8px;}
        .bg2 a:hover{color:darkblue;}
        .bg2 span{font-size: 12px;color:black;text-decoration: none;text-align: left;}

        .input_text{width:96%;height: 38px;margin-bottom:17px;font-size:16px;background-color: white;border:none;border-radius: 5px;padding-bottom: 5px;padding-top: 5px;padding-left:15px;  }
        .input_radio{width:43%;height: 38px;margin-bottom: 25px;font-size:16px;background:rgba(242, 242, 242, 0.7);border-radius: 5px;padding-top: 5px;margin-right: 16px;margin-left: 5px; float:left;}
        .input_submit{width: 96%;height:38px;margin-top:24px; color:white;font-size: 18px;font-weight: bold;background-color:rgb(4,130,200);padding-bottom: 5px;border:none;border-radius: 5px;align:center }
        .psd{width: 100%;text-align: left;}

        .a-radio{display: none;}
        .b-radio{display: inline-block;border:1px solid #ccc;width:16px;height: 16px;border-radius:2px;vertical-align: middle;margin-right: 5px;position: relative;}
        .b-radio:before{content: '';font-size: 0;width: 10px;height: 10px;background: rgb(143, 188, 238);position: relative;left:50%;top:50%;margin-left: -5px;margin-top: -5px;display: none;}
        .a-radio:checked~.b-radio:before{display: block;}
    </style>
    <script>
        function show(){
            var show = document.getElementById("showContent");
            var content = "&nbsp&nbsp:&nbsp&nbsp初始密码为学工号后六位";//弹出的文字
            show.innerHTML = content;
        }
    </script>
</head>
<body>
<%@ include file="logintop.jsp"%>
<div class="bg1">
    <div class="bg2">
        <p>平台登录</p>

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
            <div class="psd">
                <a href="#1" onclick="show()">密码说明</a><span id="showContent"></span>
            </div>
            <input type="submit" value="点击登录" class="input_submit">
        </form>
    </div>
</div>
<%@ include file="footer.jsp"%>
</body>
</html>

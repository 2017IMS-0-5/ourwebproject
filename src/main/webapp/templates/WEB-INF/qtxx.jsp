<html>
<head>
    <title>其他信息</title>

    <style type="text/css">
        /** 总 **/
        body{margin:0;font-family: "微软雅黑";}
        .img{width: 100%;height: 100%}
        .bg1{height: 700px;background-color: white;}
        .bg2_1{height: 15%;width: 100%;background-color: white;}
        .bg2_2{height: auto;width: 100%;;margin:0;background-color: white;}

        /** 左侧导航**/
        .bg3_1{width: 19%; height: 100%;padding-top: 35px;float: left;margin:0;}
        :focus { outline: 1; }
        article, aside, canvas, details, figcaption, figure, footer, header, hgroup, menu, nav, section, summary { display: block; }
        nav ul, ul, li { list-style: none; }
        blockquote, q { quotes: none; }
        blockquote:before, blockquote:after, q:before, q:after { content: ''; content: none; }
        a { margin: 0; padding: 0; border: 0; font-size: 100%; vertical-align: baseline; background: transparent; text-decoration: none; }
        a:hover { text-decoration: underline; }
        ins { background-color: #ff9; color: #000; text-decoration: none; }
        mark { background-color: #ff9; color: #000; font-style: italic; font-weight: bold; }
        del { text-decoration: line-through; }
        abbr[title], dfn[title] { border-bottom: 1px dotted #000; cursor: help; }
        table { border-collapse: collapse; border-spacing: 0; }
        hr { display: block; height: 1px; border: 0; border-top: 1px solid #cccccc; margin: 1em 0; padding: 0; }
        input, select { vertical-align: middle; }
        html { font-size: 62.5%; /* 10÷16=62.5% */ }
        ul { width: 250px; margin: 0 auto; background-color: #f2f2f2; position: relative; padding: 0; }
        ul li { height: 50px; line-height: 40px; text-align: center; border-bottom: 1px solid #F8F8F8; }
        ul li p{background-color: #5187C5;color: white;font-size: 18px;font-weight: bold;letter-spacing: 4pt;}
        ul li a { color:black; display: block; font-size: 16px;letter-spacing: 1pt;}
        ul li a:hover { background-color: #5187C5;color: white; text-decoration: none; }

        /** 右侧标题展示 **/
        .bg3_2{width:78%; height: 100%;padding-top: 35px;float: left;margin:0;float:left;padding-right:3%}
        .bg4_1{height: 50px;width: 100%; border-bottom: 2px solid darkblue;float: left;background-color: #c6d5f2;border-radius: 5px;}
        .bg4_1 table{width: 100%; margin: 0 auto; align:center;}
        .bg4_1_td1{padding-top:15px;width:47%;text-align: left;padding-left: 3%;letter-spacing: 2pt; font-size: 16px; color: darkblue;font-weight: bold;float:left;}
        .bg4_1_td2{padding-top:15px;width:47%;text-align: right;padding-right:3%;font-size: 14px; color: black;float:left;}
        .bg4_2{height: 500px;width: 100%;padding-top: 20px;float: left;background-color: #c6d5f2;border-radius: 5px;}
        .bg4_2_td1{width:80%;height:35px;font-size:18px; text-align:left; align:left;vertical-align: bottom;padding-bottom: 4px; text-overflow: ellipsis;float:left;}
        .bg4_2_td2{width:20%; height:35px;font-size:18px;text-align: right;vertical-align: bottom;padding-bottom: 4px; text-overflow: ellipsis;float:left;}
        .bg5{font-size:16px;padding-top:40px;text-align: center;}
        .choices{height:400px;width=100%;padding-left:5%;padding-right:5%;}
    </style>

    <script src="js/jquery.min.js"></script>
    <script>
        /** 左侧导航**/
        $(function(){
            $('#lanPos').css('top',$('.hover').offset().top);
            $('ul li').hover(function(){
                $('#lanPos').css('top',$(this).offset().top);
            },function(){
                $('#lanPos').css('top',$('.hover').offset().top);
            })
            $('ul li').click(function(){
                for(var i=0;i<$('ul li').size();i++){
                    if(this==$('ul li').get(i)){
                        $('ul li').eq(i).children('a').addClass('hover');
                    }else{
                        $('ul li').eq(i).children('a').removeClass('hover');
                    }
                }
            })
        })
    </script>

</head>
<body>
<%@ include file="header.jsp"%>

<div class="bg1">
    <div class="bg2_1">
        <img src="../../static/img/topback.jpg" class="img">
    </div>
    <div class="bg2_2">
        <div class="bg3_1">
            <ul>
                <li><p >就业信息</p> </li>
                <li><A href="#">实习信息</A></li>
                <li><A href="#">选调相关信息</A></li>
                <li><A href="#">招聘会信息</A></li>
                <li><A href="#">往年就业信息</A></li>
            </ul>
        </div>
        <div class="bg3_2">
            <div class="bg4_1">
                <div class="">
                    <div class="bg4_1_td1">就业信息</div>
                    <div class="bg4_1_td2">当前位置：<a href="/index">首页</a>/就业信息 </div>
                </div>
            </div>
            <div class="bg4_2">
                <div class="choices">

                    <div class="choice">
                        <div class="bg4_2_td1"><a href="">关于近期防控新冠疫情居家需求调研问题的回复</a></div>
                        <div class="bg4_2_td2">2020-01-02</div>
                    </div>
                    <div class="choice">
                        <div class="bg4_2_td1"><a href="">关于近期防控新冠疫情居家需求调研问题的回复</a></div>
                        <div class="bg4_2_td2">2020-01-02</div>
                    </div>
                    <div class="choice">
                        <div class="bg4_2_td1"><a href="">关于近期防控新冠疫情居家需求调研问题的回复</a></div>
                        <div class="bg4_2_td2">2020-01-02</div>
                    </div>
                    <div class="choice">
                        <div class="bg4_2_td1"><a href="">关于近期防控新冠疫情居家需求调研问题的回复</a></div>
                        <div class="bg4_2_td2">2020-01-02</div>
                    </div>
                    <div class="choice">
                        <div class="bg4_2_td1"><a href="">关于近期防控新冠疫情居家需求调研问题的回复</a></div>
                        <div class="bg4_2_td2">2020-01-02</div>
                    </div>
                    <div class="choice">
                        <div class="bg4_2_td1"><a href="">关于近期防控新冠疫情居家需求调研问题的回复</a></div>
                        <div class="bg4_2_td2">2020-01-02</div>
                    </div>
                    <div class="choice">
                        <div class="bg4_2_td1"><a href="">关于近期防控新冠疫情居家需求调研问题的回复</a></div>
                        <div class="bg4_2_td2">2020-01-02</div>
                    </div>
                    <div class="choice">
                        <div class="bg4_2_td1"><a href="">关于近期防控新冠疫情居家需求调研问题的回复</a></div>
                        <div class="bg4_2_td2">2020-01-02</div>
                    </div>
                    <div class="choice">
                        <div class="bg4_2_td1"><a href="">关于近期防控新冠疫情居家需求调研问题的回复</a></div>
                        <div class="bg4_2_td2">2020-01-02</div>
                    </div>
                    <div class="choice">
                        <div class="bg4_2_td1"><a href="">关于近期防控新冠疫情居家需求调研问题的回复</a></div>
                        <div class="bg4_2_td2">2020-01-02</div>
                    </div>


                </div>
                <div class="bg5">
                    <form action="" method="get" name="PageForm">
                        当前页1&nbsp;
                        共3页&nbsp;&nbsp;&nbsp;
                        <a href="">首页</a>&nbsp;
                        <a href="">上一页</a>&nbsp;
                        <a href="">下一页</a>&nbsp;
                        <a href="">尾页</a>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

<%@ include file="footer.jsp"%>
</body>
</html>

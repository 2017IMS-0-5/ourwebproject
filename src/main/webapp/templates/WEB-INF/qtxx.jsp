<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
--%>

<html>
<head>
    <title>其他信息</title>

    <style type="text/css">
        /** 总 **/
        body{margin:0;font-family: "微软雅黑";}
        .img{width: 100%;height: 100%}
        .bg1{height: 700px;background-color: white;}
        .bg2_1{height: 15%;width: 100%;background-color: white;}
        .bg2_2{height: 85%;width: 100%;;margin:0px;background-color: white;}

        /** 左侧导航**/
        .bg3_1{width: 25%; height: 100%;padding-left: 15px;padding-top: 35px;float: left;margin:0px}
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
        ul { width: 190px; margin: 0 auto; background-color: #f2f2f2; position: relative; padding: 0px; }
        ul li { height: 40px; line-height: 40px; text-align: center; border-bottom: 1px solid #F8F8F8; }
        ul li p{background-color: #5187C5;color: white;font-size: 15px;font-weight: bold;letter-spacing: 4pt;}
        ul li a { color:black; display: block; font-size: 12px;letter-spacing: 1pt;}
        ul li a:hover { background-color: #5187C5;color: white; text-decoration: none; }

        /** 右侧标题展示 **/
        .bg3_2{width: 68%; height: 100%;padding-top: 30px;float: left;margin:0px;}
        .bg4_1{height: 7%;width: 100%; border-bottom: 2px solid darkblue;float: left;background-color: #c6d5f2;border-radius: 5px;}
        .bg4_1 table{width: 100%; margin: 0 auto; align:center;}
        .bg4_1_td1{padding-top:15px;width:50%;text-align: left;padding-left: 16px;letter-spacing: 2pt; font-size: 15px; color: darkblue;font-weight: bold;}
        .bg4_1_td2{padding-top:15px;width:50%;text-align: right;padding-right:16px;font-size: 13px; color: black;}
        .bg4_2{height: 80%;width: 100%;padding-top: 20px;float: left;background-color: #c6d5f2;border-radius: 5px;}
        .bg4_2 table{width: 90%; margin: 0 auto; align:center;}
        .bg4_2 tr{height:35px;border-bottom: 1px dashed royalblue ;font-size: 13px;}
        .bg4_2_td1{width:80%; text-align:left; align:left;vertical-align: bottom;padding-bottom: 4px; text-overflow: ellipsis;}
        .bg4_2_td2{width:20%; text-align: right;vertical-align: bottom;padding-bottom: 4px; text-overflow: ellipsis;}
        .bg5{font-size:13px;padding-top:40px;text-align: center;}
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
        <img src="static/img/back2.png" class="img">
    </div>
    <div class="bg2_2">
        <div class="bg3_1">
            <ul>
                <li><p>其他信息</p> </li>
            </ul>
        </div>
        <div class="bg3_2">
            <div class="bg4_1">
                <table>
                    <tr>
                        <td class="bg4_1_td1">其他信息</td>
                        <td class="bg4_1_td2">当前位置：<a href="/info/main">首页</a>/其他信息 </td>
                    </tr>
                </table>
            </div>
            <div class="bg4_2">
                <table>
                    <tr>
                        <td class="bg4_2_td1">文章标题1</td>
                        <td class="bg4_2_td2">创建时间1</td>
                    </tr>
                    <tr>
                        <td class="bg4_2_td1"> 文章标题2</td>
                        <td class="bg4_2_td2">创建时间2</td>
                    </tr>
                    <tr>
                        <td class="bg4_2_td1">文章标题3</td>
                        <td class="bg4_2_td2">创建时间3</td>
                    </tr>
                    <tr>
                        <td class="bg4_2_td1">文章标题4</td>
                        <td class="bg4_2_td2">创建时间4</td>
                    </tr>
                    <tr>
                        <td class="bg4_2_td1">文章标题5</td>
                        <td class="bg4_2_td2">创建时间5</td>
                    </tr>
                    <tr>
                        <td class="bg4_2_td1">文章标题6</td>
                        <td class="bg4_2_td2">创建时间6</td>
                    </tr>
                    <tr>
                        <td class="bg4_2_td1">文章标题7</td>
                        <td class="bg4_2_td2">创建时间7</td>
                    </tr>
                    <tr>
                        <td class="bg4_2_td1">文章标题8</td>
                        <td class="bg4_2_td2">创建时间8</td>
                    </tr>
                    <tr>
                        <td class="bg4_2_td1">文章标题9</td>
                        <td class="bg4_2_td2">创建时间9</td>
                    </tr>
                    <tr>
                        <td class="bg4_2_td1">文章标题10</td>
                        <td class="bg4_2_td2">创建时间10</td>
                    </tr>
                    <tr>
                        <td class="bg4_2_td1">文章标题11</td>
                        <td class="bg4_2_td2">创建时间11</td>
                    </tr>
                </table>



<%--
                <c:forEach var="infor" items="${infoList}">
                    <div class="bg4_2">
                        <table>
                            <tr>
                                <td class="bg4_2_td1"> ${infor.title}</td>
                                <td class="bg4_2_td2">${infor.createTime}</td>
                            </tr>
                        </table>
                    </div>
                </c:forEach>
--%>
                <div class="bg5">
                    <form action="" method="post" name="PageForm">
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

<%@ include file="foot.jsp"%>
</body>
</html>

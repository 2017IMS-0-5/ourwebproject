<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>首页</title>
    <style type="text/css">
        body{margin:0; font-family: 微软雅黑;}
        .bg0{background-image: url(../../static/img/back.png);background-size:cover; background-repeat:no-repeat;overflow: hidden;margin: 0;}
        .bg1{height: 45%;width:100%;text-align: center;}
        .bg1 img{height:85%;padding-top:40px;}

        .bg2{height:35%;width:100%;}
        .bg2 td{height:120px;width: 250px; text-align: center;}
        .bg2 img{height: 180px;width: 180px;}
        .index_h {
        margin-top: 0;
        color: #2E64D1;
        font-size: 125%;
        border-bottom: 2px solid #2E64D1;
        padding-bottom: 5px;
        }
        .index_h em {
        font-size: 87.5%;
        color: #000;
    }
        .info{
            width:85%;
            height: 330px;
            padding-right: 20px;
           padding-left: 20px;
    margin-right: auto;
    margin-left: auto;
    position: relative;
    
            
        }
        .rec{
            box-sizing:border-box;
            -moz-box-sizing:border-box; /* Firefox */
            -webkit-box-sizing:border-box; /* Safari */
            width:50%;
            float:left;
            margin: 20px auto;
            min-height: 1px;
    padding-right: 15px;
    padding-left: 15px;
    position: relative;
        }
        .pull-right {
    float: right!important;
}
.bg4{width: 100%;height: auto;padding-top:20px;padding-bottom:30px;background-color: #c6d5f2;position: relative;}
        .bg4 table{width: 95%;border-collapse:collapse;}
        
        .bg4_tr2{height:33px;border-bottom: 1px dashed darkblue;font-size: 13px;border-bottom: 1px dashed darkblue;}
        .bg4_td1{ text-align:left; vertical-align: bottom;padding-bottom: 2px; text-overflow: ellipsis;}
        .bg4_td1 a{text-decoration: none;color: black}
        .bg4_td1 a:hover{color:royalblue;}
        .bg4_td2{text-align: right;vertical-align: bottom;padding-bottom: 2px; text-overflow: ellipsis;}

        .bg4_tr3{font-size:13px;height:70px;text-align: center;vertical-align: bottom;}
    </style>
</head>

<body>
<%@include file="header.jsp"%>

<div class="bg0">
    <div class="bg1">
        <img src="${pageContext.request.contextPath}/static/img/mainlogo.png">
    </div>
    <div class="bg2">
    <table align="center">
        <tr>
            <td>
                <a href="${pageContext.request.contextPath}/info/notice">
                    <img src="${pageContext.request.contextPath}/static/img/item_tzgg.png">
                </a>
            </td>
            <td>
                <a href="${pageContext.request.contextPath}/info/policy"><img src="${pageContext.request.contextPath}/static/img/item_zczd.png"></a>
            </td>
            <td>
                <a href="${pageContext.request.contextPath}/info/job"><img src="${pageContext.request.contextPath}/static/img/item_jyxx.png"></a>
            </td>
            <td>
                <a href="${pageContext.request.contextPath}/info/other"><img src="${pageContext.request.contextPath}/static/img/item_qtxx.png"></a>
            </td>
        </tr>
    </table>
    </div>
</div>
<div class="info">
    <div class="rec">
        <h3 class="index_h"><b>最新消息</b><em>/Lasted News</em><a class="pull-right" href=""></a></h3>
        <div class="bg4">
            <table align="center" valign="middle">
                <c:forEach var="infor" items="${infoList}">
                    <tr class="bg4_tr2">
                        <td class="bg4_td1"><a href="${pageContext.request.contextPath}/info/information?infoId=${infor.id}">${infor.title}</a></td>
                        <td class="bg4_td2">
                            <fmt:formatDate value="${infor.createTime}" pattern="yyyy-MM-dd"/>
                            . . . . . .
                            <c:choose>
                                <c:when test="${infor.field == 'job'}">就业信息</c:when>
                                <c:when test="${infor.field == 'notice'}">通知公告</c:when>
                                <c:when test="${infor.field == 'policy'}">政策制度</c:when>
                                <c:when test="${infor.field == 'other'}">其它信息</c:when>
                                <c:otherwise>${infor.field}</c:otherwise>
                            </c:choose>
                        </td>
                    </tr>
                </c:forEach>
            </table> 
        </div>
    </div>
    <div class="rec">
        <h3 class="index_h"><b>友情链接</b><em>/Links</em><a class="pull-right" href=""></a></h3>
        <div class="bg4">
            <table align="center" valign="middle">
                
                <tr class="bg4_tr2">
                    <td class="bg4_td1"><a href="http://www.sg.bnu.edu.cn/">北师大政府管理学院官网</a></td>
                    
                </tr>
                <tr class="bg4_tr2">
                    <td class="bg4_td1"><a href="http://cogs.bnu.edu.cn/">京师政管创新实验室</a></td>
                    
                </tr> 
                <tr class="bg4_tr2">
                    <td class="bg4_td1"><a href="https://www.bnu.edu.cn/">北京师范大学</a></td>
                    
                </tr> 
                <tr class="bg4_tr2">
                    <td class="bg4_td1"><a href="http://www.lib.bnu.edu.cn/">北京师范大学图书馆</a></td>
                    
                </tr> 
                <tr class="bg4_tr2">
                    <td class="bg4_td1"><a href="http://jwb.bnu.edu.cn/index">北京师范大学教务部</a></td>
                    
                </tr>     
            </table> 
        </div>
    </div>
</div>

<%@ include file="footer.jsp"%>



</body>
</html>

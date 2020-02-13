<%@page contentType="text/html;charset=UTF-8" language="java" %>
<html>
	<head>
	    <title>师生信息统计页面</title>
	    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/homepage.css">
	    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/jquery.jqchart.css" />
	    
	    <script src="${pageContext.request.contextPath}/static/js/jquery-1.11.1.min.js" type="text/javascript"></script>
	    <script src="${pageContext.request.contextPath}/static/js/jquery.jqChart.min.js" type="text/javascript"></script>
	    <script lang="javascript" type="text/javascript">
	        $(document).ready(function () {
	
	            var background = {
	                type: 'linearGradient',
	                x0: 0,
	                y0: 0,
	                x1: 0,
	                y1: 1,
	            };
	
	            $('#jqChart1').jqChart({
	                title: { text: '系统成员图' },
	                legend: { title: '人员' },
	                border: { strokeStyle: '#d0d0d0' },
	                background: background,
	                animation: { duration: 1 },
	                shadows: {
	                    enabled: true
	                },
	                series: [
	                    {
	                        type: 'pie',
	                        fillStyles: ['#418CF0', '#FCB441'],
	                        labels: {
	                            stringFormat: '%.1f%%',
	                            valueType: 'percentage',
	                            font: '18px "微软雅黑"',
	                            fillStyle: 'white'
	                        },
	                        explodedRadius: 10,
	                        explodedSlices: [1],
	                        data: [['老师', ${dataOfTea}], ['学生', ${dataOfStu}]]//可以换成数据库中统计的学生和老师的人数
	                    }
	                ]
	            });
	
	            $('#jqChart1').bind('tooltipFormat', function (e, data) {
	                var percentage = data.series.getPercentage(data.value);
	                percentage = data.chart.stringFormat(percentage, '%.2f%%');
	
	                return '<b>' + data.dataItem[0] + '</b><br />' +
	                       data.value + ' (' + percentage + ')';
	            });
	        });
	        
	        $(document).ready(function () {
	        	
	            var background = {
	                type: 'linearGradient',
	                x0: 0,
	                y0: 0,
	                x1: 0,
	                y1: 1,
	            };
	
	            $('#jqChart2').jqChart({
	                title: { text: '系统用户年级分布图' },
	                legend: { title: '人员' },
	                border: { strokeStyle: '#d0d0d0' },
	                background: background,
	                animation: { duration: 1 },
	                shadows: {
	                    enabled: true
	                },
	                series: [
	                    {
	                        type: 'pie',
	                        fillStyles: ['#E0400A', '#056492'],
	                        labels: {
	                            stringFormat: '%.1f%%',
	                            valueType: 'percentage',
	                            font: '18px "微软雅黑"',
	                            fillStyle: 'white'
	                        },
	                        explodedRadius: 10,
	                        explodedSlices: [1],
	                        data: [['2019级', ${dataOfGrade1}], ['2018级', ${dataOfGrade2}],['2017级', ${dataOfGrade3}],['2016级', ${dataOfGrade4}]]//可以换成数据库中统计的学生和老师的人数
	                    }
	                ]
	            });
	
	            $('#jqChart2').bind('tooltipFormat', function (e, data) {
	                var percentage = data.series.getPercentage(data.value);
	                percentage = data.chart.stringFormat(percentage, '%.2f%%');
	
	                return '<b>' + data.dataItem[0] + '</b><br />' +
	                       data.value + ' (' + percentage + ')';
	            });
	        });
	        
$(document).ready(function () {
	        	
	            var background = {
	                type: 'linearGradient',
	                x0: 0,
	                y0: 0,
	                x1: 0,
	                y1: 1,
	            };
	
	            $('#jqChart3').jqChart({
	                title: { text: '管理员人数分配图' },
	                legend: { title: '人员' },
	                border: { strokeStyle: '#d0d0d0' },
	                background: background,
	                animation: { duration: 1 },
	                shadows: {
	                    enabled: true
	                },
	                series: [
	                    {
	                        type: 'pie',
	                        fillStyles: ['#1A3B69', '#005757'],
	                        labels: {
	                            stringFormat: '%.1f%%',
	                            valueType: 'percentage',
	                            font: '18px "微软雅黑"',
	                            fillStyle: 'white'
	                        },
	                        explodedRadius: 10,
	                        explodedSlices: [1],
	                        data: [['一级管理员', ${dataOfSAdmin}], ['二级管理员', ${dataOfAdmin}]]//可以换成数据库中统计的学生和老师的人数
	                    }
	                ]
	            });
	
	            $('#jqChart3').bind('tooltipFormat', function (e, data) {
	                var percentage = data.series.getPercentage(data.value);
	                percentage = data.chart.stringFormat(percentage, '%.2f%%');
	
	                return '<b>' + data.dataItem[0] + '</b><br />' +
	                       data.value + ' (' + percentage + ')';
	            });
	        });
    	</script>
    	
	    <style type="text/css">
	    	.welcome{
				width: 100%;
				height:30px;
				background-color: rgba(143,130,188,1);
				padding-top: 3px;
			}
			.welcome h{
				color: white;
				float: left;
				margin-top: 1px;
				margin-left: 50px;
			}
            .manager_apt{
                width: 100%;
                height: 100px;
                background-image: url(${pageContext.request.contextPath}/static/img/schoollogo.JPG);
                background-repeat: no-repeat;
                text-align: right;
                vertical-align:bottom;
            }
            .manager_apt b{
                color: rgba(143,130,188,1);
                font-size: 20px;
                text-align:right;
                line-height:100px;
            }
		    #foot{
				float:left;
				width:100%;
			}
			.bg4{
				position:relative;
				margin-right:2%;
				margin-bottom:2%;
				width:83%;
				height:65%;
				background-size:contain;
				background-color:#d0d0d0;
				font-size:18px;
				font-family:"微软雅黑";
			}
			.bg6{
				font-family:"微软雅黑";
				color:#fff;
			}
			.bg6 table{
				background-color:#D8D8EB;
				width:150px;
				height:200px;
				margin-left:2%;
				text-align:center;
				color:#fff;
				border-radius: 10px;  
			}
			.bg6 input{
				height:80px;
				width:80%;
				background-color:#D8D8EB;
				font-size:15px;
				border:0;
				border-radius: 10px;  
			}
			.bg6 input:hover{
				background-color:#8080C0;
			}
			#line{
				height:20px;
				background-color:#8080C0;
				margin-left:18%;
				margin-bottom:1%;
				border-radius: 8px;
			}
			#line p{
				margin-left:15%;
				width:150px;
				font-size:18px;
				font-weight:600;
				background-color:#fff;
			}
	    </style>
	</head>
	<body>
	
	<div class="welcome">
		<h>欢迎访问政府管理学院信息资源整合平台管理员界面</h>
	</div>
	<div class="manager_apt">
	    <b>你好，管理员  <span>部门：${admin.name}</span></b>
	</div>
	
	<div id="line"><p>师生信息统计</p></div>
		
	<div class="bg6"  style="float:left;">
		<table>
			<tr>
				<td><input required="required"  type="button" value="师生信息统计" onclick='window.open("userStatistics.jsp")' style="background-color:#8080C0;"></td>
			</tr>
			<tr>
				<td><input required="required"  type="button" value="消息信息统计" onclick='window.open("infoStatistics.jsp")'></td>
			</tr>
		</table>
	</div>

    <div class="bg4"  style="float:right;">
        <div style="margin-left:12%;">
            <div id="jqChart1" style="width: 25%; height: 250px;float:left;"></div>
            <div id="jqChart2" style="width: 25%; height: 250px;float:left;"></div>
            <div id="jqChart3" style="width: 25%; height: 250px;float:left;"></div>
        </div>
    </div>
	
	<div style="float:left;width:100%;">
		<%@include file="footer.jsp" %>
	</div>
	</body>
</html>

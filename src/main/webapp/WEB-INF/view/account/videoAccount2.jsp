<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>ECharts</title>
     <link href="${pageContext.request.contextPath }/css/bootstrap.css" rel="stylesheet">
     <script src="${pageContext.request.contextPath }/js/jquery-1.12.4.min.js"></script>
 
    <script src="${pageContext.request.contextPath }/js/echarts-all.js"></script>
</head>
<body>

 <jsp:include page="/header.jsp">
		<jsp:param value="statistics" name="fromJsp"/>
	</jsp:include> 
	
	
	
	<div class="container" style="background-color: gainsboro;"> 
     <div  class="row">
        	<div class="col-md-12 col-sm-offset-1">
	         <h1>统计-统计分析</h1>
		    </div>
		</div>
	</div>

	
	
	
	
	
	
    <div id="main" style="width: 2500px;height:800px;"></div>
    <script type="text/javascript">
        
        var myChart = echarts.init(document.getElementById('main'));
        var option = {
            title: {
                text: 'ECharts 入门示例'
            },
            tooltip: {},
            legend: {
                data:['销量']
            },
            xAxis: {
                data:[]
            },
            yAxis: {},
            series: [{
                name: '销量',
                type: 'bar',
                data: []
            }]
        }; 
        
        myChart.setOption(option);
        
        
        var namex=[];
        var num=[]; 
        
        function  loadDATA(){
        $.ajax({
        	type:"post",
       
        	dataType:"Json",
        	data:{},
        	url:"${pageContext.request.contextPath}/course/sub.action",
        	success:function(msg){
        		
              
                if(msg){
        		for(var i=0;i<msg.length;i++){
        			 namex.push(msg[i].name);
        			 num.push(msg[i].avergeNum);
        		}
        		
        		
        	}
        	}
        	
        });	
        
        myChart.setOption({        //加载数据图表
            xAxis: {
                data: namex
            },
            yAxis: {},
            series: [{
                name: '播放次数',
                data: num
            }]
        });

        }	 
        
       
        
        
        
        
        
        
        
        
        
        
        
        
        
        

    </script>
    <input type="submit" value="ajax加载图表"onclick="loadDATA()">
</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>报表</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/echarts-all.js"></script>

<script type="text/javascript">
seajs.use("project/data/operation/adOperation.js",function (page) {  
    page.init();  
}); 




define("project/data/operation/adOperation.js",function(require, exports, module) {  
	function init () {  
	   // 基于准备好的dom，初始化echarts图表    
	    var myChart = echarts.init(document.getElementById('main'));  
	    option = {  
	            title : {  
	                text: '广告投放近7天趋势',  
	                subtext: '趋势图'  
	            },  
	            tooltip : {  
	                trigger: 'axis'  
	            },  
	            legend: {  
	                data:['展示','点击','下载','下载成功','安装成功','激活成功']  
            },  
	            toolbox: {  
	                show : true,  
	                feature : {  
	                    dataView : {show: true, readOnly: false},  
	                    magicType : {show: true, type: ['line', 'bar', 'stack', 'tiled']},  
	                    restore : {show: true},  
	                    saveAsImage : {show: true}  
	                }  
	            },  
            calculable : true,  
	            xAxis : [  
	                {  
	                    boundaryGap : false,  
	                    data : []  
	                }  
	            ],  
	            yAxis : [  
	                {  
	                    type : 'value'  
	                }  
	            ],  
            series : [  
	                {  
	                    name:'展示',  
	                    type:'line',  
	                    smooth:true,  
	                    itemStyle: {normal: {areaStyle: {type: 'default'}}},  
                    data:[]  
	               },  
	               {  
	                    name:'点击',  
	                    type:'line',  
	                    smooth:true,  
	                    itemStyle: {normal: {areaStyle: {type: 'default'}}},  
	                    data:[]  
	                },  
	                {  
	                    name:'下载',  
	                    type:'line',  
	                    smooth:true,  
	                    itemStyle: {normal: {areaStyle: {type: 'default'}}},  
	                    data:[]  
	               },  
	                {  
	                    name:'下载成功',  
	                    type:'line',  
	                    smooth:true,  
	                    itemStyle: {normal: {areaStyle: {type: 'default'}}},  
	                    data:[]  
	                },  
	                {  
	                    name:'安装成功',  
	                    type:'line',  
	                    smooth:true,  
	                    itemStyle: {normal: {areaStyle: {type: 'default'}}},  
	                    data:[]  
	                },  
	                {  
	                    name:'激活成功',  
	                    type:'line',  
	                    smooth:true,  
	                    itemStyle: {normal: {areaStyle: {type: 'default'}}},  
	                    data:[]  
	                }  
	            ]  
	        };  
	    getChartData('');  
	    function getChartData(params) {  
	        $.ajax({  
	            url: contextLocation + "data/operation/reportAdQuery.html",  
	            data: params,  
	            type: "get",  
	            dataType: "json",  
	            success: function(data) {  
	                if (data.return_code === '1') {  
	                    option.xAxis[0].data = data.report.date;  
	                    option.series[0].data = data.report.showCount;  
	                    option.series[1].data = data.report.clickCount;  
	                    option.series[2].data = data.report.downloadCount;  
	                    option.series[3].data = data.report.dsCount;  
	                    option.series[4].data = data.report.installCount;  
	                   option.series[5].data = data.report.isCount;  
	                    //comAverageList = data.comAverageList;  
	                    myChart.setOption(option);  
	                } else {  
	                    option.xAxis[0].data = [];  
	                    option.series[0].data = [];  
	                    option.series[1].data = [];  
	                    option.series[2].data = [];  
	                    option.series[3].data = [];  
	                    option.series[4].data = [];  
	                    option.series[5].data = [];  
	                    myChart.setOption(option);  
	                }  
	            }  
	        });  
	    }  
	}  
	  
	return {  
	   init: init  
	};  
	});  




</script>

</head>
<body>
<div id="main" style="width:900px;height:400px"></div> 
</body>
</html>



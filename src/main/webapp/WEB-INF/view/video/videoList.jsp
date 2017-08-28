<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fy" uri="http://zhiyou100.com/common/" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-CN">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title> 

<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>Bootstrap 101 Template</title>

    <!-- Bootstrap -->
    <link href="${pageContext.request.contextPath }/css/bootstrap.min.css" rel="stylesheet">

     <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="${pageContext.request.contextPath }/js/jquery-1.12.4.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="${pageContext.request.contextPath }/js/bootstrap.min.js"></script>
    
    
    <script type="text/javascript">
    
    function addVideo(){
    	//location.href = "<c:url value = "/deleteBuMen?id="/>${str.d_id}";
    	location.href = "<c:url value="/videoEdit.action"/>";
    }
    
    function piLiangDelete(){
    	//location.href = "<c:url value = "/deleteBuMen?id="/>${str.d_id}";
    	var con = confirm("确认删除吗？");
		alert(con);
    	
    	document.getElementsByTagName("form")[1].submit()
    	
    }
    
 
 
	 var count = 0;
 function chkSon(v){
	 count = v.checked == true ? ++count: --count;
	 
	 $("#dianJiShu").html(count)
	
 } 


 $(function(){
	 $("#chkAll").click(function(){
		 
		 /* alert(this); */
		 
		 var chkstate = this.checked;
		 /* alert(chkstate); */
			
		/*  input[type=checkbox] */
		 var $a = $(":checkbox"); 
		 $a.each(function(index,domElement){
			 
			 domElement.checked = chkstate
		 });
		 
		 count = $a.size()-1;
		 if(chkstate==true){
			 $("#dianJiShu").html(count);
		 }else{
			 $("#dianJiShu").html('');
			 count = 0;
		 };
		 
			
	 });
 });
 


    </script>
    
</head>
<body>


<nav class="navbar navbar-inverse">
  		<div class="container">
  			 <ul class="nav navbar-nav">
        		
	            <li><a href="#">视频管理系统</a></li>
	            <li><a href="#">视频管理</a></li>
	            <li><a href="<c:url value="/speaker/speakerList.action"/>">主讲人管理</a></li>
	            <li><a href="<c:url value="/course/courseList.action"/>">课程管理</a></li>
	            <li><a href="<c:url value="/accountList.action"/>">统计分析</a></li>
	            <p class="navbar-text navbar-right" style="margin-left: 500px;">admin<a href="#" class="glyphicon glyphicon-share">退出</a></p>
	            
          </ul>
        </li>
      </ul>

  		</div>
	</nav>
   
   
   <div class="container">
   	
   	<div class="jumbotron">
  		<div class="container">
    		<h1>视频列表-视频管理</h1>
  		</div>
		</div>
   
   <br><br>
   
  
   <div class="container">
		   	<div class="row">
			   	<div class="col-md-5">
			   		<button type="button" class="btn btn-primary" onclick="addVideo()">添加视频</button>
			   		<button type="button" class="btn btn-primary" onclick="piLiangDelete()">批量删除(<span id="dianJiShu"></span>)</button>	
			   	</div>
		   	
		   		
		   		<div class="col-md-7">
			   		<form class="form-inline" action="${pageContext.request.contextPath}/videoList.action" method="post">
			   			<div class="form-group ">
						    <!--<input type="text" placeholder="视频标题">-->
						    <input type="text" class="form-control" id="exampleInputName2" placeholder="视频标题" name="shiPinMing">
				   		</div>
						  <div class="form-group ">
						    <select class="form-control" placeholder="请选择主讲人" name="zhuJiangRen">
								  <option>张强</option>
								  <c:forEach items="${speakers}" var="speaker" varStatus="statu2">
								  	
								  		<option value="${speaker.speakerName}" ${speaker.speakerName eq zhuJiangRen ? "selected" :""} >${speaker.speakerName}</option>
								  </c:forEach>
								  
								</select>
						  </div>
						  <div class="form-group ">
						    
						    <select class="form-control" placeholder="请选择课程" name="keCheng">
								  <option>UI基础入门</option>
								  <c:forEach items="${courses}" var="course" varStatus="statu3">
								  	
								  		<option value="${course.courseName}" ${course.courseName eq keCheng ? "selected" :""}>${course.courseName}</option>
								  </c:forEach>
								</select>
						  </div>
						  <input type="submit" class="btn btn-default" value="查询"></input>
						  
						  <%-- <fy:page url="${pageContext.request.contextPath}/WEB-INF/view/video/videoList.jsp"></fy:page> --%>
						 
						</form>
					</div>
		   		
		   </div>
   </div>
   
  <form action="${pageContext.request.contextPath}/videosDelete.action">  
   <div class="container">
   	<table class="table table-hover">
  		<tr>
  			<div class="row">
	  			<!--<th class="col-md-1"><input type="checkbox"/></th>
				  <th class="col-md-1">序号</th>-->
				  <div class="col-md-1">
	  				<th><input type="checkbox" name="chkAll" id="chkAll" onclick="chkAll(this)"/></th>
				  	<th>序号</th>
	  			</div>
				  <th class="col-md-1">名称</th>
				  <th class="col-md-5">介绍</th>
				  <th class="col-md-1">讲师</th>
				  <th class="col-md-1">课程</th>
				  <th class="col-md-1">时长(秒)</th>
				  <th class="col-md-1">播放次数</th>
				  
				  <div class="col-md-1 col-sm-offset-2">
					  <th >编辑</th>
					  <th >删除</th>
				  </div>
			</div>

  		</tr>
  		
  		
  		
	  		<c:forEach items="${page.rows}" varStatus="statu1" var="video">
		  		<tr>
		  			<div class="row">
			  			<div class="col-md-1">
			  				<td><input id="chkson" type="checkbox" name="ids" value="${video.id}" onclick="chkSon(this)"/></td>
						  	<td>${statu1.count}</td>
			  			</div>
			  			
						  <td class="col-md-1">${video.videoTitle}</td>
						  <td class="col-md-5">${video.videoDescr}</td>
						  <td class="col-md-1">${video.speakerName}</td>
						  <td class="col-md-1">${video.courseName}</td>
						  <td class="col-md-1">${video.videoLength}</td>
						  <td class="col-md-1">${video.videoPlayTimes}</td>
						  
						  <div class="col-md-1 col-sm-offset-2">
							  <td><a class="glyphicon glyphicon-pencil" href="<c:url value="/videoUpdate.action?id=${video.id}"/>"></a></td>
							  <td><a class="glyphicon glyphicon-trash" href="<c:url value="/videoDelete.action?id=${video.id}"/>"></a></td>
							  
						  </div>
						  
					</div>
		
		  		</tr>
	  		
	  		</c:forEach>
  		
  		

   		
	</table>
	
   </div>
</form> 
 
    <fy:page url="${pageContext.request.contextPath}/videoList.action"></fy:page>
</body>
</html>
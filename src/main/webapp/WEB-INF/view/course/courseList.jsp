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
    	
    	function addCourse(){
    		location.href = "<c:url value="/course/courseEdit.action"/>";
    	}
    
    </script>
    
</head>
<body>

<nav class="navbar navbar-inverse">
  		<div class="container">
  			 <ul class="nav navbar-nav">
        		
	            <li><a href="#">视频管理系统</a></li>
	            <li><a href="#">视频管理</a></li>
	            <li><a href="#">主讲人管理</a></li>
	            <li><a href="#">课程管理</a></li>
	            <li><a href="#">统计分析</a></li>
	            <p class="navbar-text navbar-right" style="margin-left: 500px;">admin<a href="#" class="glyphicon glyphicon-share">退出</a></p>
	            
          </ul>
        </li>
      </ul>

  		</div>
	</nav>
   
   <div class="container">
   	
   	<div class="jumbotron">
  		<div class="container">
    		<h1>课程列表-课程管理</h1>
  		</div>
		</div>
   	<br><br><br><br>
   	
   
   <br><br>
   <div class="container">
   	<p><button type="button" class="btn btn-primary" onclick="addCourse()">添加课程</button></p>
   </div>
   
   
   <div class="container">
   	<table class="table table-hover">
  		<tr>
  			<div class="row">
			  <th class="col-md-1">序号</th>
			  <th class="col-md-1">标题</th>
			  <th class="col-md-1">学科</th>
			  <th class="col-md-6">简介</th>
			  
			  <th class="col-md-1 col-sm-offset-2">编辑</th>
			  <th class="col-md-1">删除</th>
			</div>

  		</tr>
  		
  		<c:forEach items="${courses}" var="course" varStatus="status1">
  		<tr>
  			<div class="row">
			  <td class="col-md-1">${status1.count}</td>
			  <td class="col-md-1">${course.courseName}</td>
			  <td class="col-md-1">${course.subjectId}</td>
			  <td class="col-md-6">${course.courseDescr}</td>
			  
			  <td class="col-md-1 col-sm-offset-2"><a class="glyphicon glyphicon-pencil" href="<c:url value="/course/courseUpdate.action?id=${course.id}"/>"></a></td>
			  <td class="col-md-1 "><a class="glyphicon glyphicon-trash" href="<c:url value="/course/courseDelete.action?id=${course.id}"/>"></a></td>
			</div>

  		</tr>
  		</c:forEach>
  		
	</table>
   </div>

</body>
</html>
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
    	function addSpeaker(){
    		location.href = "<c:url value="/speaker/speakerEdit.action"/>";
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
    		<h1>主讲人列表-主讲人管理</h1>
  		</div>
		</div>
   	<br><br><br><br>
   	
   </div>
   <br><br>
   
   
   <div class="container">
		   	<div class="row">
			   	<div class="col-md-4">
			   		<button type="button" class="btn btn-primary" onclick="addSpeaker()">添加主讲人</button>
			   		
			   	</div>
		   	
		   		
		   		<div class="col-md-8">
			   		<form class="form-inline" action="#">
			   			<!--<div class="form-group ">-->
						    <div class="form-group">
							    <label for="inputEmail3" class="col-md-1 control-label">名称</label>
							    <div class="col-sm-10">
							      <input type="text" name="mingCheng" value="${mingCheng}" class="form-control" id="inputEmail3" placeholder="主讲人名称">
							    </div>
							</div>
							<div class="form-group">
							    <label for="inputEmail3" class="col-md-1 control-label">职位</label>
							    <div class="col-sm-10">
							      <input type="text" name="zhiWei" value="${zhiWei}" class="form-control" id="inputEmail3" placeholder="主讲人职位">
							    </div>
							</div>
				   		
						  <input type="submit" value="查询" class="btn btn-default"/>
					</form>
				</div>
		   		
		   </div>
   </div>
   
   
   <div class="container">
   	<table class="table table-hover">
  		<tr>
  			<div class="row">
	  			  <th class="col-md-1">序号</th>
					  <th class="col-md-1">名称</th>
					  <th class="col-md-5">职位</th>
					  <th class="col-md-1">简介</th>
				  
				  
				  <div class="col-md-1 col-sm-offset-2">
					  <th >编辑</th>
					  <th >删除</th>
				  </div>
			</div>

  		</tr>
  		<c:forEach items="${page.rows}" var="speaker" varStatus="statu1">
  		<tr>
  			<div class="row">
	  			
	  			<td class="col-md-1">${statu1.count}</td>
					<td class="col-md-1">${speaker.speakerName}</td>
					<td class="col-md-1">${speaker.speakerJob}</td>
					<td class="col-md-5">${speaker.speakerDescr}</td>
				
				  
				<div class="col-md-1 col-sm-offset-2">
					<td><a class="glyphicon glyphicon-pencil" href="<c:url value="/speaker/speakerUpdate.action?id=${speaker.id}"/>"></a></td>
					<td><a class="glyphicon glyphicon-trash" href="<c:url value="/speaker/speakerDelete.action?id=${speaker.id}"/>"></a></td>
				</div>
				  
			</div>

  		</tr>
  		</c:forEach>
  		

  		
	</table>
   </div>
			<fy:page url="${pageContext.request.contextPath}/speaker/speakerList.action"></fy:page>
</body>
</html>
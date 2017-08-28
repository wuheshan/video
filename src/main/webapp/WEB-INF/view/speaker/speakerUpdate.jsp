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
    		<h1>编辑主讲人-主讲人管理</h1>
  		</div>
		</div>
   
   <br><br>
   <div class="container">
   	
   	
   	<form class="form-horizontal" action="${pageContext.request.contextPath}/speaker/speakerUpdate2.action">
		  <div class="form-group">
		    <label for="inputEmail3" class="col-sm-2 control-label">名字</label>
		    <div class="col-sm-10">
		      <input type="text" name="speakerName" value="${speaker.speakerName }" class="form-control" id="inputEmail3" placeholder="请输入主讲人姓名">
		    </div>
		  </div>
		  
		    
		  <div class="form-group">
		    <label for="inputEmail3" class="col-sm-2 control-label">职业</label>
		    <div class="col-sm-10">
		      <input type="text" name="speakerJob" value="${speaker.speakerJob }" class="form-control" id="inputEmail3" placeholder="请输入主讲人职业">
		    </div>
		  </div>
		  <div class="form-group">
		    <label for="inputEmail3" class="col-sm-2 control-label">图像图片</label>
		    <div class="col-sm-10">
		      <input type="text" name="speakerHeadUrl" value="${speaker.speakerHeadUrl }" class="form-control" id="inputEmail3" placeholder="主讲人图像地址，网络图片">
		    </div>
		  </div>
		  
		  <div class="form-group">
		    <label for="inputEmail3" class="col-sm-2 control-label">简介</label>
		    <div class="col-sm-10">
		      <textarea class="form-control" rows="3" name="speakerDescr" value="${speaker.speakerDescr }"></textarea>
		    </div>
		  </div>
		  
		  <input type="hidden" name="id" value="${speaker.id }">
		  
		  <div class="form-group">
		    <div class="col-sm-offset-2 col-sm-10">
		      <input type="submit" class="btn btn-primary" value="保存"/>
		      <button type="button" class="btn btn-success">返回列表</button>
		    </div>
		  </div>
		  
	</form>
   	
   	
   </div>

</body>
</html>
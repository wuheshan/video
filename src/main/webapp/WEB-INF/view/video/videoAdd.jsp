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
    
    /* function addVideo(){
    	//location.href = "<c:url value = "/deleteBuMen?id="/>${str.d_id}";
    	location.href = "<c:url value="/addVideo.action"/>";
    }
     */
    
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
   
   <div class="container" style="background-color: grey;">
   	<p><h1>添加视频信息-视频管理</h1></p>
   	
   	<br><br><br><br>
   	
   </div>
   <br><br>
   <div class="container">
   	
   	
   	<form class="form-horizontal" action="${pageContext.request.contextPath}/videoAdd.action" method="post">
		  <div class="form-group">
		    <label for="inputEmail3" class="col-sm-2 control-label">视频标题</label>
		    <div class="col-sm-10">
		      <input type="text" class="form-control"  placeholder="视频标题">
		    </div>
		  </div>
		  <!--<div class="form-group">
		    <label for="inputPassword3" class="col-sm-2 control-label">Password</label>
		    <div class="col-sm-10">
		      <input type="password" class="form-control" id="inputPassword3" placeholder="Password">
		    </div>-->
		    
		  <div class="form-group">
		    <label for="inputPassword3" class="col-sm-2 control-label">主讲人</label>
		    <div class="col-sm-10">
		       <select class="form-control" placeholder="请选择主讲人" name="speakerId">
					<option>请选择主讲人</option>
					<c:forEach items="${speakers1}" var="speaker" >
								  	
						<option value="${speaker.id}" >${speaker.speakerName}</option>
					</c:forEach>
								  
			  </select>
		    </div>
		  </div>
		    
		  <div class="form-group">
		    <label for="inputPassword3" class="col-sm-2 control-label">所属课程</label>
		    <div class="col-sm-10">
		      <select class="form-control" placeholder="请选择课程" name="courseId">
				<option>请选择课程</option>
				<c:forEach items="${courses1}" var="course">
								  	
					<option value="${course.id}" >${course.courseName}</option>
				</c:forEach>
			 </select>
		    </div>
		  </div>
		    
		  <div class="form-group">
		    <label for="inputEmail3" class="col-sm-2 control-label">视频时长</label>
		    <div class="col-sm-10">
		      <input type="text" name="videoLength" class="form-control" id="inputEmail3" placeholder="视频时长(秒)">
		    </div>
		  </div>
		  <div class="form-group">
		    <label for="inputEmail3" class="col-sm-2 control-label">封面图片</label>
		    <div class="col-sm-10">
		      <input type="text" name="videoImageUrl" class="form-control" id="inputEmail3" placeholder="视频封面图片地址，网络图片">
		    </div>
		  </div>
		  <div class="form-group">
		    <label for="inputEmail3" class="col-sm-2 control-label">视频播放地址</label>
		    <div class="col-sm-10">
		      <input type="text" name="videoUrl" class="form-control" id="inputEmail3" placeholder="视频播放地址，网络地址">
		    </div>
		  </div>
		  <div class="form-group">
		    <label for="inputEmail3" class="col-sm-2 control-label">视频简介</label>
		    <div class="col-sm-10">
		      <textarea name="videoDescr" class="form-control" rows="3"></textarea>
		    </div>
		  </div>
		    
		    
		    
		    
		  
		  <div class="form-group">
		    <div class="col-sm-offset-2 col-sm-10">
		      <input type="submit" value="保存" class="btn btn-primary"></input>
		      <button type="button" class="btn btn-success">返回列表</button>
		    </div>
		  </div>
	</form>
   	
   	
   </div>

</body>
</html>
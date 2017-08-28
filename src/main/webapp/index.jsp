<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-CN">
<head>
<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    
    <title>Bootstrap 101 Template</title>

    <!-- Bootstrap -->
    <link href="${pageContext.request.contextPath }/css/bootstrap.min.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath }/js/jquery-1.12.4.min.js"></script>
    
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.validate.min.js"></script>
    
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/messages_zh.min.js"></script>

    
    <script src="${pageContext.request.contextPath }/js/bootstrap.min.js"></script>
    	<style>
    	* {
			box-sizing: border-box;
			font-family: 微软雅黑;
		}
		
    	body {
			margin: 0;
    		background-color: #ddd;
    		display: flex;
    		justify-content: center;
    		align-items: center;
    		margin-top:200px;
		}
    	
    	</style>
    	
    	
    	<script type="text/javascript">
    	$(function(){
    		 $("#checkForm").validate({
    			 rules:{
    				 login_name:{
    					 required:true
    					 
    				 },
    				 login_pwd:{
    					 required:true,
    					 maxlength:6
    				 },
    				 login_rpwd:{
    					 required:true,
    					 equalTo:"[name=login_pwd]"
    				 }
    			 },
    			 messages:{
    				 login_name:{
    					 required:"用户名不能为空"
    					 
    				 },
    				 login_pwd:{
    					 required:"密码不能为空",
    					 maxlength:"不能多于6位"
    				 },
    				 login_rpwd:{
    					 required:"确认密码不能为空",
    					 equalTo:"两次密码不一致"
    				 }
    			 }
    		 });
    	 });
    	
    	</script>
</head>
<body>
<div class="col-sm-offset-1 col-sm-3">
		<!--<div class="col-sm-offset-1 col-sm-2">-->
        
       
        <form class="form-horizontal" id="checkForm" action="${pageContext.request.contextPath}/loginAdmin.action" method="post">
        	<div class="col-sm-8">
        		
        		<img src="${pageContext.request.contextPath }/img/logo.png" alt="智游" >
        	</div>
		  <div class="form-group">
		    <!--<label for="inputEmail3" class="col-sm-4 control-label">用户名</label>-->
		    <div class="col-sm-10">
		      <input type="text" class="form-control" id="inputEmail3" name="login_name" placeholder="请输入用户名">
		    </div>
		  </div>
		  <div class="form-group">
		    <!--<label for="inputPassword3" class="col-sm-4 control-label">密码</label>-->
		    <div class="col-sm-10">
		      <input type="password" class="form-control" id="inputPassword3" name="login_pwd" placeholder="请输入密码">
		    </div>
		    <!-- <p style=" color: red;font-size: 15px;"></p> -->
		  </div>
		  
		  
		  <div class="form-group">
		    <!--<label for="inputPassword3" class="col-sm-4 control-label">密码</label>-->
		    <div class="col-sm-10">
		      <input type="password" class="form-control" id="inputPassword3" name="login_rpwd" placeholder="请确认输入密码">
		    </div>
		    <!-- <p style=" color: red;font-size: 15px;"></p> -->
		  </div>
		  
		  
		  <div class="form-group">
		    <div class="col-sm-10">
		      <div class="checkbox">
		        <label>
		          <input type="checkbox"> Remember me
		        </label>
		      </div>
		    </div>
		  </div>
		  <div class="form-group">
		    <div class="col-sm-10">
		      <button type="submit" class="btn btn-primary  btn-block" style="background-color: green;">登录</button>
		      
		    </div>
		  </div>
	</form>
    </div>
</body>
</html>
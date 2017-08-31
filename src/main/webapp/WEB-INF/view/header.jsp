<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   
<%-- created by zhouyanchao on 2017年7月14日 下午3:18:23 --%>    

<nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">视频管理系统
          </a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
          <ul class="nav navbar-nav">
            <li ${param.fromJsp=="video"?"class='active'":""}><a href="${pageContext.request.contextPath }/videoList.action">视频管理</a></li>
            <li ${param.fromJsp=="speaker"?"class='active'":""}><a href="${pageContext.request.contextPath }/speaker/speakerList.action">主讲人管理</a></li>
            <li ${param.fromJsp=="course"?"class='active'":""}><a href="${pageContext.request.contextPath }/course/courseList.action">课程管理</a></li>
            <li ${param.fromJsp=="statistics"?"class='active'":""}><a href="${pageContext.request.contextPath }/accountList.action">统计分析</a></li>
          </ul>
          <ul class="nav navbar-nav navbar-right">
        <li><a href="admin/logout.do" title="点击退出登录">${user.loginName }<i class="glyphicon glyphicon-log-out" aria-hidden="true"></i></a></li>
      </ul>
        </div>
      </div>
    </nav>
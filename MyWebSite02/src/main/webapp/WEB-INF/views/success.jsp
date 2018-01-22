<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="/static/bootstrap/css/bootstrap.min.css" >
<script src="/static/jquery/jquery.min.js"></script>
<script src="/static/bootstrap/js/bootstrap.min.js"></script>
<title>登陆成功页面</title>
<style type="text/css">
	body{background: url('/static/images/header-bg_1.jpg') no-repeat;background-size:cover;font-size: 15px;}
	.container{margin-top: 30px;}
	.navbar{border: none;}
	.navbar-default{background-color:#dff0d880;}
</style>
</head>
<body>
	<nav class="navbar navbar-default" role="navigation">
	  <div class="container-fluid">
	    <div class="navbar-header">
	      <a class="navbar-brand" href="#">登陆成功</a>
	    </div>
	  </div>
	</nav>

	<%-- <div class="container">
		<div class="row col-sm-offset-3 col-md-offset-3 col-xs-offset-3">
			<div class="col-sm-8 col-md-8 col-xs-8">
				<ul class="list-group">
					<li class="list-group-item">用户名列表</li>
					<c:forEach items="${sysUserList}" var="sysUser">
						<li class="list-group-item">
							<!-- <span class="badge">删除</span> -->
							${sysUser.userName}
						</li>
					</c:forEach>
				</ul>
			</div>
		</div>
	</div> --%>
</body>
</html>
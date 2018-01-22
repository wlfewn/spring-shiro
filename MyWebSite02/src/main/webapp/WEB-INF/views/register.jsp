<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>用户注册</title>
<link rel="stylesheet" href="/static/bootstrap/css/bootstrap.min.css" >
<link rel="stylesheet" href="/static/font/css/font-awesome.min.css" >
<link rel="stylesheet" href="/static/pages/css/common/common.css?v=2" > 
<script type="text/javascript" src="/static/jquery/jquery.min.js"></script>
<script type="text/javascript" src="/static/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/static/pages/js/register.js?v=5"></script>
<script type="text/javascript" src="/static/pages/js/common/bootstrapMessage.js"></script>
<style type="text/css">
body{background: url('/static/images/25a02ace6807a4c739e575d942427fff.jpg') no-repeat;background-size:cover;font-size: 16px;}
.form{background: rgba(255,255,255,0.5);margin: 100px auto;width: 400px;}
.form-title{margin-left: 20px;}
.tips{font-size: 14px;}
</style> 
</head>
<body>

	<c:if test="${not empty sysMessage && not empty sysMessage.status}">
		<!-- 可以根据状态变换提示框颜色 -->
		<div class="alert alert-${sysMessage.status} position-absolute text-center">
			${sysMessage.message}
			<span class="fa fa-remove fa-lg" onclick="$.message.remove(this)"></span>
		</div>
	</c:if>

	<div class="container">
	    <div class="form row">
	        <form action="/registerUser" method="post" class="form-horizontal col-sm-offset-2 col-md-offset-2 col-xs-offset-2" >
	            <h3 class="form-title">请输入用户名密码</h3>
	            <div class="col-sm-10 col-md-10 col-xs-10">
	            	<div class="form-group has-feedback">
		                <label for="username">用户名</label>
		                <div class="input-group">
		                    <span class="input-group-addon"><span class="fa fa-user fa-lg"></span></span>
		                    <input id="username" name="userName" class="form-control" 
		                    	placeholder="请输入用户名" maxlength="20" type="text" value="${sysUser.userName}">
		                </div>
		
		                <span style="color:red;display: none;" class="tips"></span>
		            </div>
		
		            <div class="form-group has-feedback">
		                <label for="password">密码</label>
		                <div class="input-group">
		                    <span class="input-group-addon"><span class="fa fa-lock fa-lg"></span></span>
		                    <input id="password" name="password" class="form-control" 
		                    	placeholder="请输入密码" maxlength="20" type="password" value="${sysUser.password}">
		                </div>
		
		                <span style="color:red;display: none;" class="tips"></span>
		            </div>
		
		            <div class="form-group has-feedback">
		                <label for="passwordConfirm">确认密码</label>
		                <div class="input-group">
		                    <span class="input-group-addon"><span class="fa fa-lock fa-lg"></span></span>
		                    <input id="passwordConfirm" class="form-control" 
		                    	placeholder="请再次输入密码" maxlength="20" type="password" value="${sysUser.password}">
		                </div>
		                <span style="color:red;display: none;" class="tips"></span>
		            </div>
		
		            <div class="form-group">
		                <input class="form-control btn btn-primary" id="submit" value="立&nbsp;&nbsp;即&nbsp;&nbsp;注&nbsp;&nbsp;册" type="submit">
		            </div>
		
		            <div class="form-group">
		                <input value="重置" id="reset" class="form-control btn" type="reset">
		            </div>
	            </div>
	        </form>
	    </div>
	</div>
</body>
<script type="text/javascript">


</script>
</html>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>用户登陆</title>
<!-- Bootstrap 核心 CSS 文件 -->  
<link rel="stylesheet" href="/static/bootstrap/css/bootstrap.min.css" >  
<!--font-awesome 核心CSS 文件-->  
<link rel="stylesheet" href="/static/font/css/font-awesome.min.css" >  
<link rel="stylesheet" href="/static/pages/css/common/common.css?v=2" > 
<!-- 在bootstrap.min.js 之前引入 -->  
<script src="/static/jquery/jquery.min.js"></script>  
<!-- Bootstrap 核心 JavaScript 文件 -->  
<script src="/static/bootstrap/js/bootstrap.min.js"></script>
<!-- 引入bootstrap validator验证插件 -->
<link rel="stylesheet" href="/static/bootstrap/css/boostrapValidator.css" >
<script src="/static/bootstrap/js/boostrapValidator.js"></script>
<script type="text/javascript" src="/static/pages/js/common/bootstrapMessage.js"></script>
<script src="/static/pages/js/common/bootstrapValidatorStart.js"></script>
<script src="/static/languages/zh_CN.js"></script>
<style type="text/css">
body{background: url('/static/images/25a02ace6807a4c739e575d942427fff.jpg') no-repeat;background-size:cover;font-size: 16px;}  
.form{background: rgba(255,255,255,0.5);width:400px;margin:100px auto;}  
#login_form{display: block;}  
#register_form{display: none;}  
.color-ccc{display: inline-block;top: 27px;left: 6px;position: relative;}
input[type="text"],input[type="password"]{padding-left:26px;}  
.checkbox{padding-left:21px;} 
</style>
</head>
<body>
<!--  
            基础知识：  
            网格系统:通过行和列布局  
            行必须放在container内  
            手机用col-xs-*  
            平板用col-sm-*  
            笔记本或普通台式电脑用col-md-*  
            大型设备台式电脑用col-lg-*  
            为了兼容多个设备，可以用多个col-*-*来控制；  
-->  
	<c:if test="${not empty sysMessage && not empty sysMessage.status}">
		<!-- 可以根据状态变换提示框颜色 -->
		<div class="alert alert-${sysMessage.status} position-absolute text-center">
			${sysMessage.message}
			<span class="fa fa-remove fa-lg" onclick="$.message.remove(this)"></span>
		</div>
	</c:if>
	
	<div class="container">
        <div class="form row">  
        	<!-- 加上required-validate启动bootstrap validator表单验证插件 -->
            <form action="/login" method="post" class="form-horizontal required-validate col-sm-offset-3 col-md-offset-3 col-xs-offset-3" id="login_form">  
                <h3 class="form-title">请输入用户名密码</h3>  
                <div class="col-sm-9 col-md-9 col-xs-9">  
                    <div class="form-group">  
                        <i class="fa fa-user fa-lg color-ccc"></i>  
                        <input class="form-control required" type="text" 
                        	placeholder="用户名" name="username" autofocus="autofocus" maxlength="20" 
                        	data-bv-notempty/><!-- data-bv-notempty为bootstrap表单验证插件需要 --> 
                    </div>  
                    <div class="form-group">  
                         <i class="fa fa-lock fa-lg color-ccc"></i>  
                         <input class="form-control required" type="password" 
                         	placeholder="密码" name="password" maxlength="8" data-bv-notempty/>  
                    </div>  
                    <div class="form-group">
                        <!-- <label class="checkbox">  
                            <input type="checkbox" name="remember" value="1"/> Remember me  
                        </label>  --> 
                        <a href="/register" id="register_btn" >注册用户</a>  
                    </div>  
                    <div class="form-group">  
                        <input id="submit" type="submit" class="btn btn-primary pull-right" value="登陆"/>     
                    </div>  
                </div>  
            </form>  
        </div>  
    </div>    
</body>
</html>
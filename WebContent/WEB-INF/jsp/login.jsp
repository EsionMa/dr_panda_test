<!DOCTYPE HTML>
<html>
<head>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
<link type="text/css" rel="stylesheet"
	href="<%=request.getContextPath()%>/css/bootstrap.min.css">
<link type="text/css" rel="stylesheet"
	href="<%=request.getContextPath()%>/css/styles.css">
<link type="text/css" rel="stylesheet"
	href="<%=request.getContextPath()%>/css/login/login.css">
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/jquery-3.2.0.min.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/login/login.js"></script>
<script language="JavaScript">
	if (window != top)
		top.location.href = location.href;
</script>
</head>
<body>
	<div class="wrapper">
		<div class="container">
			<input type="hidden" id="errorMsg" value="${errorMsg}">
			<form class="form" action="<%=request.getContextPath()%>/login/jump"
				id="loginForm" method="post">
				<input class="form-control" type="text" name="userName" data-toggle="data-toggle" 
				value="${userLoginValue.userName}" placeholder="请输入账号" /> 
				<input class="form-control" type="password" name="password" data-toggle="data-toggle"
					value="${userLoginValue.password}" placeholder="请输入密码" /> <br />
				<button class="btn-login" type="button" id="login-button">
					<strong>登录</strong>
				</button>
			</form>
		</div>
		<ul class="bg-bubbles">
			<li></li>
			<li></li>
		</ul>
	</div>
</body>
</html>
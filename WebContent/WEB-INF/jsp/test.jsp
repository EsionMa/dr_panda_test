<!DOCTYPE HTML>
<html>
<head>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>App接口测试（post请求）</title>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/jquery-3.2.0.min.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/test.js"></script>
</head>
<body>
	<div style="color: red;">注意:测试APP地址前，先登录(默认地址)</div>
	<br></br>
	<div>请求地址：http://localhost:8080/schoolbbs/app/login</div>
	<div>
		<textarea id="rqAddr" style="width: 100%; min-height: 50px;">http://localhost:8080/schoolbbs/app/login</textarea>
	</div>
	<span>userAccount=admin&amp;userPassword=123456</span>
	<div>
		<textarea id="rqParameter" style="width: 100%; min-height: 50px;">userAccount=admin&amp;userPassword=123456</textarea>
	</div>
	<div>返回值：</div>
	<div id="receiveMsg"></div>
	<button id="testSubmit">提交</button>
</body>
</html>
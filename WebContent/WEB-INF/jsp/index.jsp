<!DOCTYPE HTML>
<html>
<head>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Dr.Panda CMS</title>
<link type="text/css" rel="stylesheet"
	href="<%=request.getContextPath()%>/css/adminStyle.css">
<link type="text/css" rel="stylesheet"
	href="<%=request.getContextPath()%>/css/bootstrap.min.css" />
<link type="text/css" rel="stylesheet"
	href="<%=request.getContextPath()%>/css/bootstrap-responsive.min.css" />
<link type="text/css" rel=" "
	href="<%=request.getContextPath()%>/css/style.css" />
<link type="text/css" rel="stylesheet"
	href="<%=request.getContextPath()%>/css/index/index.css">
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/jquery-3.2.0.min.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/ckform.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/common.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/index/index.js"></script>
</head>
<body>

	<div class="top1">
		<marquee scrollAmount=2 width=300>数据无价，请谨慎操作！</marquee>
	</div>
	<div class="top2">
		<div class="logo">
			<img src="images/admin_logo.png" title="在哪儿" />
		</div>
		<div class="title">
			<h3>Dr.Panda CMS</h3>
		</div>
		<div class="fr top-link">
			<a href="javascript:void(0);" target="mainCont" title="AdminiStrator"><i
				class="adminIcon"></i><span>管理员：AdminiStrator</span></a>
		</div>
	</div>

	<div class="left">
		<div class="div1">
			<div class="left_top">
				<img src="images/bbb_01.jpg"> <img src="images/bbb_02.jpg">
				<img src="images/bbb_03.jpg"> <img src="images/bbb_04.jpg">
			</div>

			<a class="a1" href="javascript:void(0);"
				onclick="openurl('<%=request.getContextPath()%>/user/list');">
				<div class="div2">
					<div class="tcht">
						<img title="用户管理" src="images/4.png" />
					</div>
					User List
				</div>
			</a> <a class="a1" href="javascript:void(0)" onclick="logout('${userId}')">
				<div class="div2">
					<div class="tcht">
						<img title="退出系统" src="images/2.png" />
					</div>
					Logout
				</div>
			</a>
		</div>
	</div>

	<div class="right">
		<iframe id="rightFrame" width="100%" height="100%" scrolling="auto"
			align="middle" style="border: 0px solid #CCC; margin: 0; padding: 0;">
		</iframe>
	</div>
	<form action="<%=request.getContextPath()%>/logout" id="logoutForm">
		<input type="hidden" name="userId">
	</form>
</body>
</html>

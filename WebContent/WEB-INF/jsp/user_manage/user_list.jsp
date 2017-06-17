<!DOCTYPE HTML>
<html>
<head>
<title></title>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet"
	href="<%=request.getContextPath()%>/css/bootstrap.min.css" />
<link type="text/css" rel="stylesheet"
	href="<%=request.getContextPath()%>/css/common.css">
<link type="text/css" rel="stylesheet"
	href="<%=request.getContextPath()%>/css/user_manage/user_list.css" />
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/jquery-3.2.0.min.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/user_manage/user_list.js"></script>
</head>

<body>

	<div class="search-box">
		<strong>user name：</strong> <input class="form-control abc input-default"
			type="text" id="searchKey" value="${searchKey}"
			placeholder="请输入要查询的用户账号"> &nbsp;&nbsp;
		<button type="button" class="btn btn-primary btn-search">query</button>
	</div>
	<table class="table table-bordered table-hover">
		<thead>
			<tr>
				<th>user name</th>
				<th>first name</th>
				<th>last name</th>
				<th>create time</th>
				<th>operating</th>
			</tr>
		</thead>
		<tbody>
			<c:if test="${userListValue.totalCount>0}">
				<c:forEach var="userValue" items="${userListValue.userList}"
					varStatus="status">
					<tr>
						<input type="hidden" name="id" value="${userValue.userId}">
						<td>${userValue.userName}</td>
						<td>${userValue.firstName}</td>
						<td>${userValue.lastName}</td>
						<td>${userValue.createTime}</td>
						<td>
							<button class="btn btn-user-edit btn-warning" type="button">编辑</button>
							<button class="btn btn-user-detail btn-primary" type="button">详情</button>
							<button class="btn btn-user-delete btn-danger" type="button" >删除</button>
						</td>
					</tr>
				</c:forEach>
			</c:if>
		</tbody>
	</table>
	<c:if test="${userListValue.totalPages>0}">
		<div class="row">
			<div class="col-xs-6 vertical-center">
				<span>合计</span>${userListValue.totalCount}<span>个</span>
			</div>
			<div class="col-xs-6 text-right">
				<nav class="in-same-row">
					<ul class="pagination">
						<input type="hidden" value="${userListValue.pageNum}" id="pageNum">
						<li
							class="privious <c:if test="${!userListValue.previous}">disabled</c:if>"><a>&laquo;</a></li>
						<c:forEach var="page" items="${userListValue.pageList}">
							<li class="page-num"><a>${page}</a></li>
						</c:forEach>
						<li
							class="next <c:if test="${!userListValue.next}">disabled</c:if>"><a>&raquo;</a></li>
					</ul>
				</nav>
				<div class="vertical-center page-selector">
					<input class="form-control input-box" type="text"
						title="输入页码，按GO快速跳转" />
					<button class="btn btn-primary page-go" type="button">GO</button>
				</div>
			</div>
		</div>
	</c:if>
	<c:if test="${userListValue.totalCount==0 }">
		<div class="row">
			<div class="col-xs-12">暂无相关数据</div>
		</div>
	</c:if>
	<form id="userListForm"
		action="<%=request.getContextPath()%>/user/list" method="get">
		<input type="hidden" name="searchKey"> <input type="hidden"
			name="pageNum">
	</form>
	<form id="userEditForm"
		action="<%=request.getContextPath()%>/user/edit" method="post">
		<input type="hidden" name="userId">
	</form>
	<form id="userDetailForm"
		action="<%=request.getContextPath()%>/user/detail" method="post">
		<input type="hidden" name="userId">
	</form>
	<form id="userDeleteForm"
		action="<%=request.getContextPath()%>/user/delete" method="post">
		<input type="hidden" name="userId">
	</form>
</body>
</html>
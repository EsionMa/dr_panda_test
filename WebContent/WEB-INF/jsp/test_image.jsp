<!DOCTYPE HTML>
<html>
<head>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>图片上传测试</title>
</head>
<body>
	<table>
		<tbody>
			<form enctype="multipart/form-data"
				action="<%=request.getContextPath()%>/app/user/edit"
				method="post">
				<tr>
					<td><input type="file" name="file" /></td>
					<td><input type="hidden" name="nickname" value="系统管理员666" /></td>
					<td><button type="submit">提交</button></td>
				</tr>
			</form>
		</tbody>
	</table>
</body>
</html>
$(function() {
	var errorMsg = $("#errorMsg").val();
	if (errorMsg != null && $.trim(errorMsg) != "") {
		alert(errorMsg);
	}
	$('[data-toggle="tooltip"]').tooltip();
	// 登录跳转
	$(".btn-login").click(function() {
		var userName = $("input[name='userName']").val();
		var password = $("input[name='password']").val();
		// 参数检验
		// 账号
		if (userName == null || $.trim(userName) == "") {
			$("input[name='userName']").tooltip({
				'title' : "请输入账号"
			}).focus();
			return;
		}
		// 密码
		if (password == null || $.trim(password) == "") {
			$("input[name='password']").tooltip({
				'title' : '请输入密码'
			}).focus();
			return;
		}
		$("#loginForm").submit();
	});
});
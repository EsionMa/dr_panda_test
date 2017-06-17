$(function() {
	var searchKey = $("#searchKey").val();
	// 搜索关键字
	$(".btn-search").click(function() {
		searchKey = $("#searchKey").val();
		$("input[name='searchKey']").val(searchKey);
		$("input[name='pageNum']").val(1);
		$("#userListForm").submit();
	});
	// 当前页active
	$(".page-num").each(function() {
		var pageNum = $("#pageNum").val();
		var $pageNum = $(this).children().text();
		if (pageNum == $pageNum) {
			$(this).addClass("active");
		}
	});
	// 点击导航页
	$(".page-num").click(function() {
		var $pageNum = $(this).children().text();
		$("input[name='searchKey']").val(searchKey);
		$("input[name='pageNum']").val($pageNum);
		$("#userListForm").submit();
	});
	// 点击上一页
	$(".privious").click(function() {
		if (!$(this).hasClass("disabled")) {
			var $pageNum = $(this).parent().children(".page-num.active").children().text();
			$("input[name='searchKey']").val(searchKey);
			$("input[name='pageNum']").val(parseInt($pageNum) - 1);
			$("#userListForm").submit();
		}
	});
	// 点击下一页
	$(".next").click(function() {
		if (!$(this).hasClass("disabled")) {
			var $pageNum = $(this).parent().children(".page-num.active").children().text();
			$("input[name='searchKey']").val(searchKey);
			$("input[name='pageNum']").val(parseInt($pageNum) + 1);
			$("#userListForm").submit();
		}
	});
	// 跳转页码
	$(".page-go").click(function() {
		var pageGo = $(this).parent().children(".input-box").val();
		$("input[name='searchKey']").val(searchKey);
		$("input[name='pageNum']").val(pageGo);
		$("#userListForm").submit();
	});
	// 编辑
	$(".btn-user-edit").click(function() {
		var userId = $(this).parent().parent().children("input[name='id']").val();
		alert("编辑用户" + userId);
	});
	// 详情
	$(".btn-user-detail").click(function() {
		var userId = $(this).parent().parent().children("input[name='id']").val();
		alert("查看用户" + userId);
	});
	// 删除
	$(".btn-user-delete").click(function() {
		var userId = $(this).parent().parent().children("input[name='id']").val();
		alert("删除用户" + userId);
	});
});
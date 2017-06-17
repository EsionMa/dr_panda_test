$(function() {
	var rframe = parent.document.getElementById("rightFrame");
	rframe.src = "/dr_panda_test/user/list";
})

function openurl(url) {
	// var rframe = $("#rightFrame");
	var rframe = parent.document.getElementById("rightFrame");
	rframe.src = url;
}
function logout(userId) {
	$("input[name='userId']").val(userId);
	$("#logoutForm").submit();
}
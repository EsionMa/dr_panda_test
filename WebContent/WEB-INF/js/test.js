$(function(){
	
	$("#testSubmit").click(function(){
		var url=$("#rqAddr").val();
		var parameter = $('#rqParameter').val();
		if(parameter.length>0){
			url = url+"?"+parameter;
		}
		if(url == '') {
			alert("请输入请求地址。");
			return
		}
		var params = {};
		$.post(url, params, function(data, status) {
			if (status == "success") {
				$('#receiveMsg').html(data);
			}
		});
		
	});
});
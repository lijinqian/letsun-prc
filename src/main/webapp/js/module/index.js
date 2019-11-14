$(function(){
	$('.form-signin').submit(function(){
		
		var tips = Tips.process('正在校验登录信息，请稍候...');
		$(this).ajaxSubmit({
			success: function(re){
				tips.close();
				if (re.success) {
					location = path + '/main';
				} else {
					Tips.tips(re.msg, re.success);
				}
			}
		});
		return false;
	});
});
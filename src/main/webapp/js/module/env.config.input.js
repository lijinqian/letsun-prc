$(function(){
	
	$('.input-form').submit(function(){
		var process = Tips.process('正在保存，请稍候...');
		$(this).ajaxSubmit({
			success: function(re){
				process.close();
				Tips.tips(re.msg, re.success, function(){
					if(re.success) {
						location = path + '/env_config/index';
					}
				});
			}
		});
		return false;
	});
});
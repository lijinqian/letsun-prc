$(function(){
	
	$(function(){
		$('[data-toggle="tooltip"]').tooltip();
	});
	
	$('.start-btn').click(function(){
		var key = $(this).attr('data-key');
		var process = Tips.process('正在启动任务，请稍候...');
		$.getJSON(path + '/job/start', {code: key}, function(re){
			process.close();
			Tips.tips(re.msg, re.success, function(){
				if(re.success) {
					$('.query-form').submit();
				}
			});
		});
	});
	
	$('.stop-btn').click(function(){
		var key = $(this).attr('data-key');
		var process = Tips.process('正在停止任务，请稍候...');
		$.getJSON(path + '/job/stop', {code: key}, function(re){
			process.close();
			Tips.tips(re.msg, re.success, function(){
				if(re.success) {
					$('.query-form').submit();
				}
			});
		});
	});
});
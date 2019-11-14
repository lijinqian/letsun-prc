$(function(){
	
	$('.remove-link').click(function(){
		var key = $(this).attr('data-key');
		var tips = Tips.process('正在清空缓存数据，请稍候...');
		$.post(path + '/cache/remove', {key: key}, function(re){
			tips.close();
			Tips.tips(re.msg, re.success, function(){
				location.reload();
			});
		});
	});
});
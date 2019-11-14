$(function(){
	
	$('[name="type"]').change(function(){
		var val = $(this).val();
		var placeholder = '';
		if (val == 1) {
			placeholder = 'xx.xxx.Test';
		} else if (val == 2) {
			placeholder = 'http://xxx.xx.com/xx?id=1&pid=2';
		} else {
			placeholder = '请输入sql语句';
		}
		$('[name="content"]').attr('placeholder', placeholder);
	});
	
	$('[name="type"]').change();
	
	$('[name="triggerType"]').change(function(){
		var val = $(this).val();
		$('.tt').not('tt' + val).hide();
		$('.tt' + val).show();
	});
	
	$('[name="triggerType"]').change();
	
	$('.input-form').submit(function(){
		var process = Tips.process('正在保存，请稍候...');
		$(this).ajaxSubmit({
			success: function(re){
				process.close();
				Tips.tips(re.msg, re.success, function(){
					if(re.success) {
						location = path + '/job/index';
					}
				});
			}
		});
		return false;
	});
});
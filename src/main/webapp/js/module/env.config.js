$(function(){
	
	$(function(){
		$('[data-toggle="tooltip"]').tooltip();
	});
	
	$('.editable-td').dblclick(function(){
		var obj = $(this);
		var id = obj.parent().attr('data-id');
		var field = obj.attr('data-field');
		var text = $.trim($(this).text());
		var node = $('<input type="text" class="form-control" value="' + text + '">');
		obj.html(node);
		obj.addClass('form-background');
		node.blur(function(){
			var val = $(this).val();
			if (text != val) {
				var param = {
					field: field, 
					value: val,
					id: id
				};
				$.post(path + '/env_config/edit', param, function(re){
					Tips.tips(re.msg, re.success, function(){
						if(re.success) {
							obj.text(val);
						}
					});
				});
			}
			obj.text(text);
			obj.removeClass('form-background');
		});
	});
	
	$('.delete-link').click(function(){
		var id = $(this).parent().parent().attr('data-id');
		if (id) {
			Tips.confirm('您确定要删除吗？', function(){
				var tips = Tips.process('正在删除数据，请稍候...');
				$.post(path + '/env_config/delete/' + id, function(re){
					tips.close();
					Tips.tips(re.msg, re.success, function(){
						if (re.success) {
							location.reload();
						}
					});
				});	
			});
		}
	});
});
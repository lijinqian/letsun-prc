Tips = {
	tips: function(content, success, closeCallback){
		var callback = function(){};
		if(closeCallback) {
			callback = closeCallback;
		}
		var icon = '';
		if(success){
			icon = '<i class="icon-ok-sign success-icon"></i> ';
		} else{
			icon = '<i class="icon-warning-sign fail-icon"></i> ';
		}
		var obj = $.confirm({
		    title: false,
		    cancelButton: false,
		    confirmButton: false,
		    closeIcon: false,
		    backgroundDismiss: true,
		    content: icon + content,
		    onClose: callback
		});
		return obj;
	},
	process: function(content){
		var obj = $.confirm({
		    title: false,
		    cancelButton: false,
		    confirmButton: false,
		    closeIcon: false,
		    backgroundDismiss: true,
		    content: '<i class="icon-spinner icon-spin icon-process"></i> ' + content
		});
		return obj;
	},
	confirm: function(msg, confirmCallback) {
		$.confirm({
		    title: false,
		    confirmButton: '确定',
		    cancelButton: '取消',
		    content: '<i class="icon-question-sign text-danger"></i> ' + msg,
		    confirm: confirmCallback
		});
	}
};
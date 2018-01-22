/**
 * 公众号"夜说时间鱼"提供
 * 动态添加bootstrap message
 */
$(function() {
	//扩展方法
    $.extend({
    	message: {
    		show: function(data){
    			console.log('data',data);
    			if(!data){
    				return;
    			}
    			var sysMessage = data.sysMessage;
            	if(sysMessage.status == 'success' && data.url ){
            		window.location.href = data.url;//跳转
            	}else{//显示结果
            		var html = '<div class="alert alert-'+sysMessage.status+' position-absolute text-center">';
            		html += sysMessage.message;
            		html +='<span class="fa fa-remove fa-lg" onclick="$.message.remove(this)"></span></div>';
            		$("body").append(html);
            	}
    		},
    		remove: function(obj){
    			var parent = $(obj).parent();
    			parent.slideUp('slow',function(){
    				parent.remove();
    			});
    		}
    	}
    }) 
});
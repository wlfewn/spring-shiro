/**
 * 公众号"夜说时间鱼"提供
 * 启动bootstrapValidator 类
 * 要求 form表单需要有required-validate class样式,
 * 这里写法只支持提交一个表单
 * 改插件依赖 bootstrapMessage.js
 */
$(function() {
    var $form = $("form.required-validate");
    $form.bootstrapValidator();
    
    // 修复bootstrap validator重复向服务端提交bug
    $form.on('success.form.bv', function(e) {
        // Prevent form submission
        e.preventDefault();
        //这里做表单提交,使用ajax
        //$form.submit(); //使用submit会重复触发表单验证
        //使用ajax提交表单数据
        $.post($form[0].action, $form.serialize(), function (data) {
        	return $.message.show(data);
        });
    });
});


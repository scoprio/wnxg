/**
 * Created by liqiao on 8/10/15.
 */

/**
 * _config comes from server-side template. see views/index.jade
 */

dd.config({
			agentId :_config.agentId,
			corpId : _config.corpId,
			timeStamp : _config.timeStamp,
			nonceStr : _config.nonceStr,
			signature : _config.signature,
			type : 0,
			jsApiList : [ 'runtime.info',
						  'biz.contact.choose',
						  'device.notification.confirm',
						  'device.notification.alert',
						  'device.notification.prompt',
						  'biz.ding.post',
						  'biz.util.openLink',
						  'device.geolocation.get']
		});


dd.ready(function() {
    dd.biz.navigation.setTitle({
        title: '万能小哥',
        onSuccess: function(data) {
        },
        onFail: function(err) {
            log.e(JSON.stringify(err));
        }
    });

});


dd.error(function(err) {
	alert('dd error: ' + JSON.stringify(err));
});



/**
 * Created by liqiao on 8/10/15.
 */

/**
 * _config comes from server-side template. see views/index.jade
 */
var dingdingUserInfo;
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
						  'biz.map.locate']
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

	dd.runtime.permission.requestAuthCode({
			  corpId : _config.corpId,
			  onSuccess : function(info) {
				  $.ajax({
							 url : '/dingding/authCode.shtml?code=' + info.code + '&corpid='
								   + _config.corpId,
							 type : 'GET',
							 success : function(data, status, xhr) {
								 dingdingUserInfo = JSON.parse(data);
							 },
							 error : function(xhr, errorType, error) {
								 logger.e("未授权的公司:" + _config.corpId);
								 alert(errorType + ', ' + error);
							 }
						 });

			  },
			  onFail : function(err) {
				  alert('fail: ' + JSON.stringify(err));
			  }
		  });

});


dd.error(function(err) {
	alert('dd error: ' + JSON.stringify(err));
});



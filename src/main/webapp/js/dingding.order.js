/**
 * Created by liqiao on 8/10/15.
 */

/**
 * _config comes from server-side template. see views/index.jade
 */
dd.config({
			agentId :localStorage.agentId,
			corpId : localStorage.corpId,
			timeStamp : localStorage.timeStamp,
			nonceStr : localStorage.nonceStr,
			signature : localStorage.signature,
			type : 0,
			jsApiList : [ 'runtime.info',
						  'biz.contact.choose',
						  'device.notification.confirm',
						  'device.notification.alert',
						  'device.notification.prompt',
						  'biz.map.locate',
						  'biz.alipay.pay']
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

	dd.biz.util.share({
		  type: 1,//分享类型，0:全部组件 默认； 1:只能分享到钉钉；2:不能分享，只有刷新按钮
		  url: "http://lwurl.to/7Iia0",
		  title: "万能小哥",
		  content: "万能小哥为您提供完善的企业电器维修保障服务",
		  image: "/images/shareLogo.png",
		  onSuccess : function() {
			  //onSuccess将在分享完成之后回调
			  /**/
		  },
		  onFail : function(err) {
			  alert('share error: ' + JSON.stringify(err));
		  }
	  });

});


dd.error(function(err) {

	location.reload();
	// alert('dd error: ' + JSON.stringify(err));
});



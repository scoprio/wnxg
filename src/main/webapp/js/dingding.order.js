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
						  'biz.telephone.showCallMenu',
						  'biz.alipay.pay']
		});


dd.ready(function() {

	dd.biz.navigation.setRight({
		   show: true,//控制按钮显示， true 显示， false 隐藏， 默认true
		   control: true,//是否控制点击事件，true 控制，false 不控制， 默认false
		   text: '分享',//控制显示文本，空字符串表示显示默认文本
		   onSuccess : function(result) {
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
		   },
		   onFail : function(err) {}
	   });




});


dd.error(function(err) {

	location.reload();
	// alert('dd error: ' + JSON.stringify(err));
});



$(function() {

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

	// $.ajax({
	// 	   url : '/dingding/access.shtml?corpId=' + localStorage.corpId +'&appid=3919',
	// 	   type : 'GET',
	// 	   success : function(data) {
	// 		   alert(JSON.stringify(data));
	// 		   dd.config({
	// 						 agentId :data.agentId,
	// 						 corpId : data.corpId,
	// 						 timeStamp : data.timeStamp,
	// 						 nonceStr : data.nonceStr,
	// 						 signature : data.signature,
	// 						 type : 0,
	// 						 jsApiList : []
	// 					 });
    //
    //
	//
    //
    //
	// 		   dd.error(function(err) {
    //
	// 			   location.reload();
	// 			   // alert('dd error: ' + JSON.stringify(err));
	// 		   });
	// 	   },
	// 	   error : function(xhr, errorType, error) {
	// 		   logger.e("未授权的公司:" + localStorage.corpId);
	// 		   alert(errorType + ', ' + error);
	// 	   }
	//    });
})
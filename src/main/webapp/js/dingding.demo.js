/**
 * Created by liqiao on 8/10/15.
 */

/**
 * _config comes from server-side template. see views/index.jade
 */
var baseUrl = $("script[baseUrl]").attr('baseUrl');

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
						  'device.geolocation.get',
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
//	 alert('dd.ready rocks!');

	dd.runtime.info({
		onSuccess : function(info) {
			logger.e('runtime info: ' + JSON.stringify(info));
		},
		onFail : function(err) {
			logger.e('fail: ' + JSON.stringify(err));
		}
	});
	dd.ui.pullToRefresh.enable({
	    onSuccess: function() {

	    },
	    onFail: function() {
	    }
	});



	// dd.biz.navigation.setMenu({
	// 	backgroundColor : "#ADD8E6",
	// 	items : [
	// 		{
	// 			id:"此处可以设置帮助",//字符串
	// 		// "iconId":"file",//字符串，图标命名
	// 		  text:"帮助"
	// 		}
	// 		,
	// 		{
	// 			"id":"2",
	// 		"iconId":"photo",
	// 		  "text":"我们"
	// 		}
	// 		,
	// 		{
	// 			"id":"3",
	// 		"iconId":"file",
	// 		  "text":"你们"
	// 		}
	// 		,
	// 		{
	// 			"id":"4",
	// 		"iconId":"time",
	// 		  "text":"他们"
	// 		}
	// 	],
	// 	onSuccess: function(data) {
	// 		// alert(JSON.stringify(data));
    //
	// 	},
	// 	onFail: function(err) {
	// 		// alert(JSON.stringify(err));
	// 	}
	// });


	dd.runtime.permission.requestAuthCode({
		corpId : _config.corpId,
		onSuccess : function(info) {
			$.ajax({
				url : '/dingding/authCode.shtml?code=' + info.code + '&corpid='
						+ _config.corpId,
				type : 'GET',
				success : function(data, status, xhr) {
					var info = JSON.parse(data);
					// alert(info.name);
					alert("当前用户UUID:"+info.userid);
					alert(baseUrl+"/dingding/my?uuid="+info.userid+"&cityCode="+current_city_code);
			        $('.person_center').attr("href",baseUrl+"/dingding/my?uuid="+info.userid+"&cityCode="+current_city_code);
					// alert($('.person_center').attr("href"))
					// document.getElementById("userName").innerHTML = info.name;
					// document.getElementById("userId").innerHTML = info.userid;

					// 图片
//					if(info.avatar.length != 0){
//			            var img = document.getElementById("userImg");
//			            img.src = info.avatar;
//			                      img.height = '100';
//			                      img.width = '100';
//			          }

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


	dd.device.geolocation.get({
		  targetAccuracy : 1000,
		  coordinate : 1,
		  withReGeocode : false,
		  onSuccess: function(result) {
			  var location = JSON.stringify(result);
			  alert(location);
			  if(location.city && location.city.length()>0){
				 $.data(cache_city, 'cache_city', location.city);
			  }else {
				  dd.device.notification.alert({
					   message: "无法获取当前城市，请手动选择城市",
					   title: "",//可传空
					   buttonName: "确定",
					   onSuccess : function() {


						   //onSuccess将在点击button之后回调
						   /*回调*/
					   },
					   onFail : function(err) {}
				   });
			  }

			  dd.biz.map.locate({
					latitude: location.latitude, // 纬度
					longitude: location.longitude, // 经度
					onSuccess: function (result) {
						var map = JSON.stringify(result);
						alert(map);
						/* result 结构 */
						// {
						// 	province: 'xxx', // POI所在省会
						// 		provinceCode: 'xxx', // POI所在省会编码
						// 	city: 'xxx', // POI所在城市
						// 	cityCode: 'xxx', // POI所在城市
						// 	adName: 'xxx', // POI所在区名称
						// 	adCode: 'xxx', // POI所在区编码
						// 	distance: 'xxx', // POI与设备位置的距离
						// 	postCode: 'xxx', // POI的邮编
						// 	snippet: 'xxx', // POI的街道地址
						// 	title: 'xxx', // POI的名称
						// 	latitude: 39.903578, // POI的纬度
						// 	longitude: 116.473565, // POI的经度
						// }
					},
					onFail: function (err) {
					}
				});

			  // alert("dd 获取地址1："+result)
			  // alert("dd 获取地址2："+JSON.stringify(result));
		  },
		  onFail: function() {

		  }
	  });
});

dd.error(function(err) {
	alert('dd error: ' + JSON.stringify(err));
});



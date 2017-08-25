/**
 * Created by liqiao on 8/10/15.
 */

/**
 * _config comes from server-side template. see views/index.jade
 */
var baseUrl = $("script[baseUrl]").attr('baseUrl');


var dingdingUserInfo;
var openCitys = [
	{
		"code": "bj",
		"name": "北京",
		"name2": "北京市"
	},
	{
		"code": "sh",
		"name": "上海",
		"name2": "上海市"
	},
	{
		"code": "sz",
		"name": "深圳",
		"name2": "深圳市"
	},
	{
		"code": "gz",
		"name": "广州",
		"name2": "广州市"
	},
	{
		"code": "hz",
		"name": "杭州",
		"name2": "杭州市"
	},
	{
		"code": "tj",
		"name": "天津",
		"name2": "天津市"
	},
	{
		"code": "suzhou",
		"name": "苏州",
		"name2": "苏州市"
	},
	{
		"code": "wuhan",
		"name": "武汉",
		"name2": "武汉市"
	},
	{
		"code": "xian",
		"name": "西安",
		"name2": "西安市"
	},
	{
		"code": "changsha",
		"name": "长沙",
		"name2": "长沙市"
	},
	{
		"code": "zhengzhou",
		"name": "郑州",
		"name2": "郑州市"
	},
	{
		"code": "nanjing",
		"name": "南京",
		"name2": "南京市"
	},
	{
		"code": "chongqing",
		"name": "重庆",
		"name2": "重庆市"
	},
	{
		"code": "chengdu",
		"name": "成都",
		"name2": "成都市"
	},
	{
		"code": "wuxi",
		"name": "无锡",
		"name2": "无锡市"
	},
	{
		"code": "foshan",
		"name": "佛山",
		"name2": "佛山市"
	},
	{
		"code": "nantong",
		"name": "南通",
		"name2": "南通市"
	},
	{
		"code": "sjz",
		"name": "石家庄",
		"name2": "石家庄市"
	},
	{
		"code": "zhongshan",
		"name": "中山",
		"name2": "中山市"
	},
	{
		"code": "jincheng",
		"name": "晋城",
		"name2": "晋城市"
	},
	{
		"code": "jiaxing",
		"name": "嘉兴",
		"name2": "嘉兴市"
	},
	{
		"code": "shenyang",
		"name": "沈阳",
		"name2": "沈阳市"
	},
	{
		"code": "wulumuqi",
		"name": "乌鲁木齐",
		"name2": "乌鲁木齐市"
	},
	{
		"code": "fuzhou",
		"name": "福州",
		"name2": "福州市"
	},
	{
		"code": "heze",
		"name": "菏泽",
		"name2": "菏泽市"
	},
	{
		"code": "taizhou",
		"name": "泰州",
		"name2": "泰州市"
	},
	{
		"code": "jinan",
		"name": "济南",
		"name2": "济南市"
	},
	{
		"code": "jingjiang",
		"name": "靖江",
		"name2": "靖江市"
	},
	{
		"code": "yuncheng",
		"name": "运城",
		"name2": "运城市"
	},
	{
		"code": "hengshui",
		"name": "衡水",
		"name2": "衡水市"
	},
	{
		"code": "shaoguan",
		"name": "韶关",
		"name2": "韶关市"
	},
	{
		"code": "xiangtan",
		"name": "湘潭",
		"name2": "湘潭市"
	},
	{
		"code": "puyang",
		"name": "濮阳",
		"name2": "濮阳市"
	},
	{
		"code": "qingdao",
		"name": "青岛",
		"name2": "青岛市"
	},
	{
		"code": "lianyungang",
		"name": "连云港",
		"name2": "连云港市"
	},
	{
		"code": "huhehaote",
		"name": "呼和浩特",
		"name2": "呼和浩特市"
	},
	{
		"code": "changzh",
		"name": "长治",
		"name2": "长治市"
	},
	{
		"code": "guiyang",
		"name": "贵阳",
		"name2": "贵阳市"
	},
	{
		"code": "chengde",
		"name": "承德",
		"name2": "承德市"
	},
	{
		"code": "changchun",
		"name": "长春",
		"name2": "长春市"
	},
	{
		"code": "hefei",
		"name": "合肥",
		"name2": "合肥市"
	},
	{
		"code": "lvliang",
		"name": "吕梁",
		"name2": "吕梁市"
	},
	{
		"code": "chenzhou",
		"name": "郴州",
		"name2": "郴州市"
	},
	{
		"code": "baoji",
		"name": "宝鸡",
		"name2": "宝鸡市"
	},
	{
		"code": "baotou",
		"name": "包头",
		"name2": "包头市"
	},
	{
		"code": "linyi",
		"name": "临沂",
		"name2": "临沂市"
	},
	{
		"code": "taiyuan",
		"name": "太原",
		"name2": "太原市"
	},
	{
		"code": "haerbin",
		"name": "哈尔滨",
		"name2": "哈尔滨市"
	},{
		"code": "leshan",
		"name": "乐山",
		"name2": "乐山市"
	},
	{
		"code": "huaibei",
		"name": "淮北",
		"name2": "淮北市"
	},
	{
		"code": "changzhou",
		"name": "常州",
		"name2": "常州市"
	},
	{
		"code": "qingyuan",
		"name": "清远",
		"name2": "清远市"
	},
	{
		"code": "anyang",
		"name": "安阳",
		"name2": "安阳市"
	},
	{
		"code": "baoding",
		"name": "保定",
		"name2": "保定市"
	},
	{
		"code": "luoyang",
		"name": "洛阳",
		"name2": "洛阳市"
	},
	{
		"code": "xinxiang",
		"name": "新乡",
		"name2": "新乡市"
	},
	{
		"code": "zhangzhou",
		"name": "漳州",
		"name2": "漳州市"
	},
	{
		"code": "yinchuan",
		"name": "银川",
		"name2": "银川市"
	},
	{
		"code": "tianshui",
		"name": "天水",
		"name2": "天水市"
	},
	{
		"code": "bayannaoer",
		"name": "巴彦淖尔",
		"name2": "巴彦淖尔市"
	},
	{
		"code": "anshan",
		"name": "鞍山",
		"name2": "鞍山市"
	},
	{
		"code": "yantai",
		"name": "烟台",
		"name2": "烟台市"
	},
	{
		"code": "changshu",
		"name": "常熟",
		"name2": "常熟市"
	},
	{
		"code": "nanyang",
		"name": "南阳",
		"name2": "南阳市"
	},
	{
		"code": "zhaoqing",
		"name": "肇庆",
		"name2": "肇庆市"
	},
	{
		"code": "zhoukou",
		"name": "周口",
		"name2": "周口市"
	},
	{
		"code": "jiyuan",
		"name": "济源",
		"name2": "济源市"
	},
	{
		"code": "ganzhou",
		"name": "赣州",
		"name2": "赣州市"
	}
]

function change_url(citycode) {
	$('.hot_project>ul>li .hot_btn>a').each(function(i,item) {
		var current_url = $(item).attr('href');
		var url_array = current_url.split('/');
		url_array[url_array.length-1] = citycode;
		current_url = url_array.join('/')
		$(item).attr('href',current_url);
		console.log(item);
	})
}

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
						  'device.geolocation.get',
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

	dd.runtime.permission.requestAuthCode({
		corpId : localStorage.corpId,
		onSuccess : function(info) {
			$.ajax({
				url : '/dingding/authCode.shtml?code=' + info.code + '&corpid='
						+ localStorage.corpId,
				type : 'GET',
				success : function(data, status, xhr) {
					dingdingUserInfo = JSON.parse(data);
					localStorage.dingdingUserId = dingdingUserInfo.userid;
					var myUrl;
					var qydUrl;
					if(dingdingUserInfo.isAdmin || dingdingUserInfo.isBoss){
						myUrl = baseUrl+"/dingding/my_admin.shtml?uuid="+localStorage.dingdingUserId+"&cityCode="+current_city_code+"&corpid="+localStorage.corpId;
						qydUrl = baseUrl+"/dingding/qyd.shtml?corpid="+localStorage.corpId+"&isAdmin=true&cityCode="+current_city_code;
					}else{
						myUrl = baseUrl+"/dingding/my.shtml?uuid="+localStorage.dingdingUserId+"&cityCode="+current_city_code+"&corpid="+localStorage.corpId;
						qydUrl = baseUrl+"/dingding/qyd.shtml?corpid="+localStorage.corpId+"&isAdmin=false&cityCode="+current_city_code;
					}
			        $('.person_center').attr("href",myUrl);
					$('.wnqyd').attr("href",qydUrl);

					// 图片
//					if(info.avatar.length != 0){
//			            var img = document.getElementById("userImg");
//			            img.src = info.avatar;
//			                      img.height = '100';
//			                      img.width = '100';
//			          }

				},
				error : function(xhr, errorType, error) {
					logger.e("未授权的公司:" + localStorage.corpId);
					alert(errorType + ', ' + error);
				}
			});

		},
		onFail : function(err) {
			alert('fail: ' + JSON.stringify(err));
		}
	});

	// dd.biz.map.locate({
	// 	  onSuccess: function (poi) {
	// 		  var poi = JSON.stringify(result);
	// 		  alert(poi);
	// 	  },
	// 	  onFail: function (err) {
	// 	  }
	//   });


	dd.device.geolocation.get({
		  targetAccuracy : 1000,
		  coordinate : 1,
		  withReGeocode : true,
		  onSuccess: function(location) {
			  // var location = JSON.stringify(location);
			  var locationCity;
			  var isOpen;
			  if($.trim(location.city).length > 0 || $.trim(location.province).length > 0){
				  //定位城市
				  if($.trim(location.city).length > 0){
					  locationCity = location.city
				  }else{
					  locationCity = location.province;
				  }

				  //判断定位城市是否与当前城市一致
				  if(locationCity.includes(current_city)){

				  }else{
					  //判断城市是否开城
					  openCitys.forEach(function(city){
						  if(locationCity == city.name2){
							  localStorage.current_city = city.name;
							  localStorage.current_city_code = city.code;
							  current_city = localStorage.current_city;
							  current_city_code = localStorage.current_city_code;
							  // alert(localStorage.current_city);
							  // alert(localStorage.current_city_code);
							  isOpen = true;
						  }
					  })


					  if(isOpen){
						  dd.device.notification.alert({
							   message: "检测到当前城市"+locationCity+"，自动切换选择城市",
							   title: "",//可传空
							   buttonName: "确定",
							   onSuccess : function() {
								   $('.choose_city .city_current').text(current_city);
								   var myUrl
								   if(dingdingUserInfo.isAdmin || dingdingUserInfo.isBoss){
									   myUrl = baseUrl+"/dingding/my_admin.shtml?uuid="+dingdingUserInfo.userid+"&cityCode="+current_city_code+"&corpid="+localStorage.corpId;
								   }else{
									   myUrl = baseUrl+"/dingding/my.shtml?uuid="+dingdingUserInfo.userid+"&cityCode="+current_city_code;
								   }
								   change_url(current_city_code+".shtml?corpid="+localStorage.corpId+"&appid=3919&dd_nav_bgcolor=FFFB870D");
								   $('.person_center').attr("href",myUrl);
							   },
							   onFail : function(err) {}
						   });
					  }else{
						  dd.device.notification.alert({
							   message: "城市暂未开通，敬请期待",
							   title: "",//可传空
							   buttonName: "确定",
							   onSuccess : function() {
								   //onSuccess将在点击button之后回调
								   /*回调*/
							   },
							   onFail : function(err) {}
						   });
					  }
				  }

			  }else{
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

		  },
		  onFail: function() {

		  }
	  });
});

dd.error(function(err) {
	location.reload();
	// alert('dd error: ' + JSON.stringify(err));
});



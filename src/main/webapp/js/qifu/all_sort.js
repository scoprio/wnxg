var baseUrl = $("script[baseUrl]").attr('baseUrl');
var cropId = $("script[cropId]").attr('cropId');
var sort_city_code;
$(function() {
	//获取地址栏中的地址  
	var url = window.location.search;
	//转换成字符串  
	url = url.toString();
	var array = new Array(); //用来存放分分割后的字符串  
	array = url.split("=");
	function find_index(string){
		return string.indexOf('&&')
	}
	if(array[1]){
		if(find_index(array[1])>0){
		   var type = array[1].substring(0,find_index(array[1]));
		}
		else{
			var type = array[1]
		}
	}
	if(array[2]){
		if(find_index(array[2])>0){
			sort_city_code = array[2].substring(0,find_index(array[2]));
		}
		else{
			sort_city_code = array[2]
		}
	}
	console.log(type)
	//这里的titles数组是tab选项卡的的标签数组，遍历数组  
	//找到与之相等的标签，然后改变其背景颜色  
	var titles = $('.sort_left li');
	var divs = $('.sort_right .sort_r_con');
	titles.eq(type).addClass('choosed').siblings('li').removeClass('choosed');
	divs.eq(type).stop(true).show()
	divs.eq(type).siblings('.sort_r_con').stop(true).hide();
	fill_data(type)

	
	$('.sort_left li').click(function() {
		var index = $(this).index();
		$(this).addClass('choosed').siblings('li').removeClass('choosed');
		$('.sort_right .sort_r_con').eq(index).show().siblings().hide();   
		fill_data(index);
	});

	function fill_data(page) {
		var result = '';
		var list = sort_data['sort' + page];
		console.log(list);
		if(list) {
			for(var i = 0; i < list.length; i++) {

				var orderUrl = baseUrl + "/ulb/sku/" +list[i].id+"/"+sort_city_code+".shtml?corpid="+cropId+"&appid="+localStorage.appId;
				result += '<li>' + '<a href="'+orderUrl+'">'+
					'<div class="all_pic">' + '<img src="' + list[i].pic + '" alt="">' + '</div>' +
					'<div class="all_price">' +
					'<p>' + list[i].title + ' </p>' +
					'<p>&yen;<span> ' + list[i].money + '</span></p>' +
					'</li>';

			}

			$('.sort_r_con').eq(page).find('li').remove();
			$('.sort_r_con').eq(page).find('ul').prepend(result);
		}
	}

})
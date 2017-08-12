$(function() {
	

	//获取地址栏中的地址  
	var url = window.location.search;
	//转换成字符串  
	url = url.toString();
	var array = new Array(); //用来存放分分割后的字符串  
	array = url.split("=");
	//这里的titles数组是tab选项卡的的标签数组，遍历数组  
	//找到与之相等的标签，然后改变其背景颜色  
	var titles = $('.sort_left li');
	var divs = $('.sort_right .sort_r_con');
	for(var m = 0; m < titles.length; m++) {

		titles[m].id = m;
		if(array[1] == titles[m].className) {
			titles[m].classList.add('choosed');
			//清除其他样式  
			for(var j = 0; j < titles.length; j++) {
				divs[j].style.display = "none";
			}
			/* divs数组是tab选项卡对应内容的数组 ,将其内容显示出来*/
			divs[titles[m].id].style.display = "block";

			fill_data(titles[m].id);
		}
	}
	
	fill_data(0);
	$('.sort_left li').click(function() {
		var index = $(this).index();
		$(this).addClass('choosed').siblings('li').removeClass('choosed');
		$('.sort_right .sort_r_con').eq(index).show().siblings().hide();   
		fill_data(index);
	});

	function fill_data(page) {
		var result = '';
		var list = sort_data['sort' + page];

		if(list) {
			for(var i = 0; i < list.length; i++) {
				result += '<li>' + '<div class="all_pic">' + '<img src="' + list[i].pic + '" alt="">' + '</div>' +
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
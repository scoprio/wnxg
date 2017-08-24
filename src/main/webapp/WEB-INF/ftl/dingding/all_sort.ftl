<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
		<title>全部分类</title>
		<link rel="stylesheet" type="text/css" href="${basePath}/css/qifu/reset_h5.css" />
		<link rel="stylesheet" type="text/css" href="${basePath}/css/qifu/all_sort.css" />
	</head>

	<body>
		<ul class="sort_left">
			<li id="work" class="work">
				<div><img src="${basePath}/images/5.png"/></div>
				<p>办公设备维护</p>
			</li>
			<li id="light" class="light">
				<div><img src="${basePath}/images/2.png"/></div>
				<p>办公电器保养</p>
			</li>
			<li id="door" class="door">
				<div><img src="${basePath}/images/3.png"/></div>
				<p>办公环境维修</p>
			</li>
			<#--<li id="electricity" class="electricity">-->
				<#--<div><img src="${basePath}/images/4.png"/></div>-->
				<#--<p>万能企业盾</p>-->
			<#--</li>-->
			
		</ul>
		<div class="sort_right">
			<div class="sort_r_con"><ul></ul></div>
			<div class="sort_r_con"><ul></ul></div>
			<div class="sort_r_con"><ul></ul></div>
			<div class="sort_r_con"><ul></ul></div>
			
		</div>

		<script src="${basePath}/js/qifu/jquery-1.11.3.js" type="text/javascript" charset="utf-8"></script>
		<#--<script src="${basePath}/js/qifu/all_sort.js" type="text/javascript" charset="utf-8" baseUrl="${basePath}"></script>-->
		<script src="${basePath}/js/qifu/all_sortdata.js" type="text/javascript" charset="utf-8" baseUrl="${basePath}"></script>

		<script>

            var sort_city_code;
			var corpId;
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

                if(array[3]){
                    if(find_index(array[3])>0){
                        corpId = array[3].substring(0,find_index(array[3]));
                    }
                    else{
                        corpId = array[3]
                    }
                }
                console.log(type)
                console.log(corpId)
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

                            var orderUrl = "${basePath}/ulb/sku/" +list[i].id+"/"+sort_city_code+".shtml?corpid="+corpId+"&appid=3928&dd_nav_bgcolor=FFFB870D";
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

		</script>
	</body>

</html>
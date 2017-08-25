<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
		<title>我的订单</title>
		<link rel="stylesheet" type="text/css" href="${basePath}/css/qifu/reset_h5.css"/>
		<link rel="stylesheet" type="text/css" href="${basePath}/css/qifu/my_order.css"/>
	</head>
	<body>
		<ul class="order_title">
			<li><a href="javascript:;">全部</a><span class="span_bg"></span></li>
			<li><a href="javascript:;">未完成</a><span></span></li>
			<li><a href="javascript:;">已完成</a><span></span></li>
			<#--<li><a href="javascript:;">待评价</a><span></span></li>-->
		</ul>
		<div class="order_content" >
			<div class="sidebox" style="display: block;">


				<#if orders?exists && orders?size gt 0 >
                <ul>
					<#list orders as order>

                        <li>
                            <p class="order_p1">订单编号：<span>${order.oid?default('未设置')}</span><i>${order.statusName?default('未完成')}</i></p>
                            <div class="order_box border_bottom border_top">
                                <#--<div class="imgdiv"><img src=""/></div>-->
                                <div class="pdiv">
                                    <p><i>维修项目</i><span>${order.repairName?default('未设置')}</span></p>
                                    <p><i>下单时间</i><span>${order.downTime?default('未设置')}</span></p>
                                    <p><i>上门时间</i><span>${order.yuyueTime?default('未设置')}</span></p>
                                    <p><i>下单地址</i><span>${order.address?default('未设置')}</span></p>

                                </div>
                            </div>
                            <p class="order_p2"><input type="button" name="" id="" value="联系客服" /></p>
                        </li>
					</#list>
                </ul>
				<#else>
                    <div class="order_nodata border_top">
                        <div><img src="${basePath}/images/bill4.png"/></div>
                        <p>您现在还没有此类订单</p>
                    </div>
				</#if>

			</div>
			<div class="sidebox">
				<ul>

				</ul>
                <div class="order_nodata border_top">
                    <div><img src="${basePath}/images/bill4.png"/></div>
                    <p>您现在还没有此类订单</p>
                </div>
			</div>
			<div class="sidebox">
				<ul>

				</ul>
                <div class="order_nodata border_top">
                    <div><img src="${basePath}/images/bill4.png"/></div>
                    <p>您现在还没有此类订单</p>
                </div>
			</div>
			<div class="sidebox">
				<ul>
				</ul>
                <div class="order_nodata border_top">
                    <div><img src="${basePath}/images/bill4.png"/></div>
                    <p>您现在还没有此类订单</p>
                </div>
			</div>
		</div>
		<script src="${basePath}/js/qifu/jquery-1.11.3.js" type="text/javascript" charset="utf-8"></script>
		<script type="text/javascript">

            var array1 = new Array();
            var array2 = new Array();
            var rArray3 = new Array();
			<#list orders as order>
			    var status = '${order.pid}';

				if(status == '1' ||status == '2'||status == '3'||status == '4'||status == '5'
                   ||status == '11'||status == '12'||status == '13'||status == '14'||status == '15'
                   ||status == '16'||status == '17'||status == '19'||status == '20'||status == '21'
                   ||status == '23'||status == '24'||status == '25'||status == '26'||status == '27'||status == '41'){
					var order = {};
					order.oid = ${order.oid};
					order.downTime = '${order.downTime?default('未设置')}';
					order.yuyueTime = '${order.yuyueTime?default('未设置')}';
					order.address = '${order.address?default('未设置')}';
					order.repairName = '${order.repairName?default('未设置')}';
                    order.statusName = '${order.statusName?default('未设置')}';
                	array1.push(order)
					console.log(array1);
				}
				if(status == '8' ||status == '18' ||status == '22'){
                    var order = {};
                    order.oid = ${order.oid};
                    order.downTime = '${order.downTime?default('未设置')}';
                    order.yuyueTime = '${order.yuyueTime?default('未设置')}';
                    order.address = '${order.address?default('未设置')}';
                    order.repairName = '${order.repairName?default('未设置')}';
                    order.statusName = '${order.statusName?default('未设置')}';
                	array2.push(order);
                	console.log(array2);
				}
				if(status == '7'){
                    var order = {};
                    order.oid = ${order.oid};
                    order.downTime = '${order.downTime?default('未设置')}';
                    order.yuyueTime = '${order.yuyueTime?default('未设置')}';
                    order.address = '${order.address?default('未设置')}';
                    order.repairName = '${order.repairName?default('未设置')}';
                    order.statusName = '${order.statusName?default('未设置')}';
                	rArray3.push(order)
                	console.log(rArray3);
				}

			</#list>

            function order_fill(){
                // 未完成
                var result_undo = '';

                if(array1.length>0){
                    array1.forEach(function(item,i){
                        result_undo += '<li><p class="order_p1">订单编号：<span>'+item.oid+'</span><i>未完成</i></p >'+
                                       '<div class="order_box border_bottom border_top">'+
                                       '<div class="imgdiv">< img src="" alt="" /></div>'+
                                       '<div class="pdiv">'+
                                       '<p><i>下单时间</i><span>'+item.downTime+'</span></p >'+
                                       '<p><i>上门时间</i><span>'+item.yuyueTime+'</span></p >'+
                                       '<p><i>上单时间</i><span>'+item.address+'</span></p >'+
                                       '<p><i>维修项目</i><span>'+item.repairName+'</span></p >'+
                                       '</div>'+
                                       '</div>'+
                                       '<p class="order_p2"><input type="button" value="取消订单" /><input type="button" value="联系客服" /></p >'+
                                       '</li>'

                    })
                    $('.sidebox').eq(1).find('ul').html('')
                    $('.sidebox').eq(1).find('ul').append(result_undo);
                    $('.sidebox').eq(1).find('.order_nodata').hide()
                }
                else{
                    $('.sidebox').eq(1).find('.order_nodata').show()
                }
                // 已完成
                var result_done = '';
                if(array2.length>0){
                    array2.forEach(function(item,i){
                        result_done += '<li><p class="order_p1">订单编号：<span>'+item.oid+'</span><i>已完成</i></p >'+
                                       '<div class="order_box border_bottom border_top">'+
                                       '<div class="imgdiv">< img src="" alt="" /></div>'+
                                       '<div class="pdiv">'+
                                       '<p><i>下单时间</i><span>'+item.downTime+'</span></p >'+
                                       '<p><i>上门时间</i><span>'+item.yuyueTime+'</span></p >'+
                                       '<p><i>上单时间</i><span>'+item.address+'</span></p >'+
                                       '<p><i>维修项目</i><span>'+item.repairName+'</span></p >'+
                                       '</div>'+
                                       '</div>'+
                                       '<p class="order_p2"><input type="button" value="取消订单" /></p >'+
                                       '</li>'

                    })
                    $('.sidebox').eq(2).find('ul').html('')
                    $('.sidebox').eq(2).find('ul').append(result_done);
                    $('.sidebox').eq(2).find('.order_nodata').show()
                }
                else{
                    $('.sidebox').eq(2).find('.order_nodata').show()
                }
                //待评价
//                var result_value = '';
//                rArray3.forEach(function(item,i){
//                    result_value += '<li><p class="order_p1">订单编号：<span>'+item.oid+'</span><i>待评价</i></p>'+
//                                    '<div class="order_box border_bottom border_top"><div class="imgdiv"><img src="" alt="" /></div>'+
//                                    '<div class="pdiv">'+
//                                    '<p><i>下单时间</i><span>'+item.downTime+'</span></p>'+
//                                    '<p><i>上门时间</i><span>'+item.yuyueTime+'</span></p>'+
//                                    '<p><i>上单时间</i><span>'+item.address+'</span></p>'+
//                                    '<p><i>维修项目</i><span>'+item.repairName+'</span></p>'+
//                                    '</div>'+
//                                    '</div>'+
//                                    '<p class="order_p2"><input type="button" value="联系客服" /></p>'+
//                                    '</li>'
//
//                })
//                $('.sidebox').eq(3).find('ul').html('')
//                $('.sidebox').eq(3).find('ul').append(result_value);
            }

			$(function(){
				$('.order_title li').click(function(){
					$(this).find('span').addClass('span_bg').parent().siblings().find('span').removeClass('span_bg');
					$('.order_content .sidebox').eq($(this).index()).show().siblings().hide();
				})

             	order_fill();
			})
		</script>
	</body>
</html>

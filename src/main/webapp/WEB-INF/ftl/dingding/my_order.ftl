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
			<li><a href="javascript:;">待评价</a><span></span></li>
		</ul>
		<div class="order_content" >
			<div class="sidebox" style="display: block;">
				<ul>

				<#if orders?exists && orders?size gt 0 >
					<#list orders as order>

                        <li>
                            <p class="order_p1">订单编号：<span>${order.oid?default('未设置')}</span><i>已完成</i></p>
                            <div class="order_box border_bottom border_top">
                                <div class="imgdiv"><img src=""/></div>
                                <div class="pdiv">
                                    <p><i>下单时间</i><span>${order.downTime?default('未设置')}</span></p>
                                    <p><i>上门时间</i><span>${order.yuyueTime?default('未设置')}</span></p>
                                    <p><i>上单地址</i><span>${order.address?default('未设置')}</span></p>
                                    <p><i>维修项目</i><span>${order.name?default('未设置')}</span></p>
                                </div>
                            </div>
                            <p class="order_p2"><input type="button" name="" id="" value="联系客服" /></p>
                        </li>
                        <#--<tr>-->
                            <#--<td>${it.sessionId?default('未设置')}</td>-->
                            <#--<td>${it.nickname?default('未设置')}</td>-->
                            <#--<td>${it.email?default('未设置')}</td>-->
                            <#--<td>${it.startTime?string('HH:mm:ss yy-MM-dd')}</td>-->
                            <#--<td>${it.lastAccess?string('HH:mm:ss yy-MM-dd')}</td>-->
                            <#--<td>${(it.sessionStatus)?string('有效','已踢出')}</td>-->
                            <#--<td>-->
                                <#--<a href="${basePath}/member/onlineDetails/${it.sessionId}.shtml">详情</a>-->
								<#--<@shiro.hasPermission name="/member/changeSessionStatus.shtml">-->
                                    <#--<a v="onlineDetails"href="javascript:void(0);" sessionId="${it.sessionId}" status="${(it.sessionStatus)?string(1,0)}">${(it.sessionStatus)?string('踢出','激活')}</a>-->
								<#--</@shiro.hasPermission>-->
                            <#--</td>-->
                        <#--</tr>-->
					</#list>
				<#else>
                    <#--<div class="order_nodata border_top" style="display: none;">-->
                        <#--<div><img src="image/bill4.png"/></div>-->
                        <p>您现在还没有此类订单</p>
                    <#--</div>-->
				</#if>
				</ul>
			</div>
			<div class="sidebox">
				<ul>
					<li>
						<p class="order_p1">订单编号：<span>SJDFHDS152</span><i>未完成</i></p>
						<div class="order_box border_bottom border_top">
							<div class="imgdiv"><img src=""/></div>
							<div class="pdiv">
								<p><i>下单时间</i><span>2017-05-06 15:20:00</span></p>
								<p><i>上门时间</i><span>2017-05-06 15:20:00</span></p>
								<p><i>上单地址</i><span>石家庄新华区中华北大街中储广场A座17楼</span></p>
								<p><i>维修项目</i><span>电脑操作系统重装</span></p>
							</div>
						</div>
						<p class="order_p2"><input type="button" name="" id="" value="取消订单" /><input type="button" name="" id="" value="联系客服" /></p>
					</li>
				</ul>
			</div>
			<div class="sidebox">
				<ul>
					<li>
						<p class="order_p1">订单编号：<span>SJDFHDS152</span><i>已完成</i></p>
						<div class="order_box border_bottom border_top">
							<div class="imgdiv"><img src=""/></div>
							<div class="pdiv">
								<p><i>下单时间</i><span>2017-05-06 15:20:00</span></p>
								<p><i>上门时间</i><span>2017-05-06 15:20:00</span></p>
								<p><i>上单地址</i><span>石家庄新华区中华北大街中储广场A座17楼</span></p>
								<p><i>维修项目</i><span>电脑操作系统重装</span></p>
							</div>
						</div>
						<p class="order_p2"><input type="button" name="" id="" value="取消订单" /></p>
					</li>
				</ul>
			</div>
			<div class="sidebox">
				<ul>
					<li>
						<p class="order_p1">订单编号：<span>SJDFHDS152</span><i>待评价</i></p>
						<div class="order_box border_bottom border_top">
							<div class="imgdiv"><img src=""/></div>
							<div class="pdiv">
								<p><i>下单时间</i><span>2017-05-06 15:20:00</span></p>
								<p><i>上门时间</i><span>2017-05-06 15:20:00</span></p>
								<p><i>上单地址</i><span>石家庄新华区中华北大街中储广场A座17楼</span></p>
								<p><i>维修项目</i><span>电脑操作系统重装</span></p>
							</div>
						</div>
						<p class="order_p2"><input type="button" name="" id="" value="联系客服" /></p>
					</li>
					
				</ul>
			</div>
		</div>
		<script src="${basePath}/js/qifu/jquery-1.11.3.js" type="text/javascript" charset="utf-8"></script>
		<script type="text/javascript">
			$(function(){
				$('.order_title li').click(function(){
					$(this).find('span').addClass('span_bg').parent().siblings().find('span').removeClass('span_bg');
					$('.order_content .sidebox').eq($(this).index()).show().siblings().hide();
				})
			})
		</script>
	</body>
</html>

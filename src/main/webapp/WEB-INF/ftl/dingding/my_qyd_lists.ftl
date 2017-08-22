<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
		<title>我的企业盾列表</title>
        <link rel="stylesheet" type="text/css" href="${basePath}/css/qifu/reset_h5.css"/>
        <link rel="stylesheet" type="text/css" href="${basePath}/css/qifu/my_qyd_lists.css"/>
	</head>

	<body>

		<ul class="lists_ul" >

		<#if qydOrders?exists && qydOrders?size gt 0 >
			<#list qydOrders as order>

                <li class="lists_li">
                    <p class="lists_img"><img src="${basePath}/images/weishengxiao.png" /></p>
                    <p class="lists_title"><span>${order.serviceName?default('未设置')}</span><i><img src="${basePath}/images/btn_shuoming.png"/></i><i>${order.state?default('未设置')}</i></p>
                    <ul class="lists_detl border_bottom border_top">
                        <li><i>服务地址</i><span>${order.address?default('未设置')}</span></li>
                        <li><i>联系人</i><span>${order.linkman?default('未设置')}</span></li>
                        <li><i>服务周期</i><span>${order.beginTime?default('未设置')}到${order.endTime?default('未设置')}</span></li>
                        <li><i>服务详情</i><span>${order.buyNums?default('未设置')} 设备</span></li>
                        <li><i>订单金额</i><span>${order.orderMoney?default('未设置')}</span></li>
                    </ul>
                    <p class="lists_btn"><input type="button" id="" value="联系客服" /></p>
                </li>


			</#list>
		<#else>
		<div class="order_nodata border_top" style="display: none;">
		<div><img src="${basePath}/images/bill4.png"/></div>
            <p>您现在还没有此类订单</p>
		</div>
		</#if>
		</ul>
		
		<script src="${basePath}/js/qifu/jquery-1.11.3.js" type="text/javascript" charset="utf-8"></script>
		<script type="text/javascript">
			$(function() {
				$('.more').click(function() {
					$('.past_li').stop().slideToggle();
					$(this).val($(this).val() == "点击查看更多" ? "收起" : "点击查看更多");
				})
			})
		</script>
	</body>

</html>
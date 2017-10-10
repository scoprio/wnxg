<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
        <meta http-equiv="Cache-Control" content="no-cache, no-store, must-revalidate" />
        <meta http-equiv="Pragma" content="no-cache" />
        <meta http-equiv="Expires" content="0" />
		<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
        <meta name="format-detection" content="telephone=no" />
        <meta name="format-detection" content="email=no" />
        <meta name="format-detection" content="address=no;">
        <meta name="apple-mobile-web-app-capable" content="yes" />
        <meta name="apple-mobile-web-app-status-bar-style" content="black" />
		<title>我的</title>
		<link rel="stylesheet" type="text/css" href="${basePath}/css/qifu/reset_h5.css"/>
		<link rel="stylesheet" type="text/css" href="${basePath}/css/qifu/my.css"/>
        <script type="text/javascript" src="http://g.alicdn.com/dingding/open-develop/1.6.9/dingtalk.js"></script>
        <script src="${basePath}/js/qifu/jquery-1.11.3.js" type="text/javascript" charset="utf-8"></script>
        <script src="${basePath}/js/qifu/dingding_comm.js" type="text/javascript" charset="utf-8"></script>
	</head>
	<body>
		<div class="my_box border_bottom">
			<div class="my_head">
				<div class="my_headimg"><img src="${basePath}/images/headimg.png"/></div>
			</div>
		</div>
		<!-- 正式环境-->
		<#--<ul class="my_ul1 border_bottom border_top">-->
			<#--<a href="${basePath}/dingding/my_order/${my.userId}/${my.cityCode}.shtml?corpId=${my.corpId}&appid=3919"><li><p>我的订单</p></li></a>-->
            <#--<a href="${basePath}/dingding/my_company_order/${my.corpId}/${my.cityCode}.shtml?corpId=${my.corpId}&appid=3919"><li><p>公司的订单</p></li></a>-->

		<#--</ul>-->
		<#--<ul class="my_ul2 border_bottom border_top">-->
            <#--<a href="${basePath}/dingding/my_qyd_lists.shtml?corpId=${my.corpId}&cityCode=${my.cityCode}&appid=3919"><li><p>公司的企业盾</p></li></a>-->
			<#--<a href="${basePath}/dingding/help.shtml"><li><p>帮助中心</p></li></a>-->
		<#--</ul>-->

        <ul class="my_ul1 border_bottom border_top">
            <a href="${basePath}/dingding/my_order/${my.userId}/${my.cityCode}.shtml?corpId=${my.corpId}&appid=3919"><li><p>我的订单</p></li></a>
            <a href="${basePath}/dingding/my_company_order/${my.corpId}/${my.cityCode}.shtml?corpId=${my.corpId}&appid=3919"><li><p>公司的订单</p></li></a>

        </ul>
        <ul class="my_ul2 border_bottom border_top">
            <a href="${basePath}/dingding/my_qyd_lists.shtml?corpId=${my.corpId}&cityCode=${my.cityCode}&appid=3919"><li><p>公司的企业盾</p></li></a>
            <a href="${basePath}/dingding/help.shtml"><li><p>帮助中心</p></li></a>
        </ul>
	</body>
</html>

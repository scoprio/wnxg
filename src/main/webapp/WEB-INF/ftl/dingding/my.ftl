<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
        <meta http-equiv="Cache-Control" content="no-cache, no-store, must-revalidate" />
        <meta http-equiv="Pragma" content="no-cache" />
        <meta http-equiv="Expires" content="0" />
		<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
		<title>我的</title>
		<link rel="stylesheet" type="text/css" href="${basePath}/css/qifu/reset_h5.css"/>
		<link rel="stylesheet" type="text/css" href="${basePath}/css/qifu/my.css"/>

	</head>
	<body>
		<div class="my_box border_bottom">
			<div class="my_head">
				<div class="my_headimg"><img src="${basePath}/images/headimg.png"/></div>
			</div>
		</div>
		<ul class="my_ul1 border_bottom border_top">
			<a href="${basePath}/dingding/my_order/${my.userID}/${my.cityCode}.shtml"><li><p>我的订单</p></li></a>
			<a href="${basePath}/dingding/my_qyd_lists.shtml?corpId=$CORPID"><li><p>我的企业盾</p></li></a>
		</ul>
		<ul class="my_ul2 border_bottom border_top">
			<a href="apply_for_bill.html"><li><p>发票管理</p></li></a>
			<a href="${basePath}/dingding/help.shtml"><li><p>帮助中心</p></li></a>
		</ul>
	</body>
</html>

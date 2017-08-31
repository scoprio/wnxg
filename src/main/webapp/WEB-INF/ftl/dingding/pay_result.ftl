<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>支付结果</title>
		<meta name="viewport" content="initial-scale=1.0,maximum-scale=1.0,minimum-scale=1.0,user-scalable=0,width=device-width" />
		<link rel="stylesheet" type="text/css" href="${basePath}/css/qifu/reset_h5.css"/>
		<link rel="stylesheet" type="text/css" href="${basePath}/css/qifu/pay_result.css"/>
        <script src="${basePath}/js/qifu/jquery-1.11.3.js" type="text/javascript" charset="utf-8"></script>
	</head>
	<body>
		<section>
			<div class="pay_box">
				<div class="pay_img"><img src="${basePath}/images/icon_gaimaichenggong.png"/></div>
				<p class="pay_results">${payState.message}</p>
				<p class="pay_tip">24小时内客服人员将会与您联系上门巡检细节</p>
			</div>
		</section>
		<div class="result_foot"><a href="" class="returnQF">返回企业盾</a></div>
	</body>
	<script>
        $(function() {
			var qydUrl = "${basePath}/dingding/my_qyd_lists.shtml?corpId="+localStorage.corpId+"&cityCode="+localStorage.current_city_code;
            $('.returnQF').attr("href",qydUrl);
        });


	</script>

</html>

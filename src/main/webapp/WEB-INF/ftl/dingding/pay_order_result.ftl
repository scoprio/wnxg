<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>支付结果</title>
		<meta name="viewport" content="initial-scale=1.0,maximum-scale=1.0,minimum-scale=1.0,user-scalable=0,width=device-width" />
        <meta name="format-detection" content="telephone=no" />
        <meta name="format-detection" content="email=no" />
        <meta name="format-detection" content="address=no;">
        <meta name="apple-mobile-web-app-capable" content="yes" />
        <meta name="apple-mobile-web-app-status-bar-style" content="black" />
        <link rel="stylesheet" type="text/css" href="${basePath}/css/qifu/reset_h5.css"/>
		<link rel="stylesheet" type="text/css" href="${basePath}/css/qifu/pay_result.css"/>
        <script src="${basePath}/js/qifu/jquery-1.11.3.js" type="text/javascript" charset="utf-8"></script>
        <script type="text/javascript" src="http://g.alicdn.com/dingding/open-develop/1.6.9/dingtalk.js"></script>
        <script src="${basePath}/js/qifu/dingding_comm.js" type="text/javascript" charset="utf-8"></script>
        <script src="${basePath}/js/dingding.order.js" baseUrl="${basePath}"></script>
	</head>
	<body>

    <section>

        <div class="pay_box">

            <div class="pay_img"><img src="${basePath}/images/icon_gaimaichenggong.png"/></div>

            <p class="pay_results">${payState.message}</p>

            <p class="pay_tip"></p>

        </div>
        <div class="tip">
            <p>温馨提示 </p>
            <ul>
                <li>1、服务时间：08：00 －18：00 </li>
                <li>2、服务热线：400－6633－750 </li>
                <li>3、建议提前24小时预约，以便得到更快捷的服务，因为每日申请维修的用户较多，如遇排队的情况，请予以谅解</li>
            </ul>
        </div>

    </section>

    <div class="result_foot"><a href="" class="returnQF">返回订单</a></div>
	</body>
	<script>
        $(function() {
			var orderUrl = "${basePath}/dingding/my_order/"+localStorage.dingdingUserId+"/"+localStorage.current_city_code+".shtml?corpId="+localStorage.corpId+"&appid=3919";
            $('.returnQF').attr("href",orderUrl);
        });


	</script>

</html>

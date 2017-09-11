<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="initial-scale=1.0,maximum-scale=1.0,minimum-scale=1.0,user-scalable=0,width=device-width" />
        <meta name="format-detection" content="telephone=no" />
        <meta name="format-detection" content="email=no" />
        <meta name="format-detection" content="address=no;">
        <meta name="apple-mobile-web-app-capable" content="yes" />
        <meta name="apple-mobile-web-app-status-bar-style" content="black" />
		<title>评价</title>

		<link rel="stylesheet" type="text/css" href="${basePath}/css/qifu/reset_h5.css" />
		<link rel="stylesheet" type="text/css" href="${basePath}/css/qifu/comment.css" />

		<script src="${basePath}/js/qifu/jquery-1.11.3.js" type="text/javascript" charset="utf-8"></script>
		<script src="${basePath}/js/qifu/comment.js" type="text/javascript" charset="utf-8"></script>
        <script src="${basePath}/js/qifu/common.js" type="text/javascript" charset="utf-8"></script>
	</head>

	<body>
		<section>
			<form method="post" id="form">
				<div id="box">
					<div class="evaluate">
						<div class="total_evaluate">总体评价</div>
						<div class="stars">
							<img id="star_1" src="${basePath}/images/content_icon_default_xing.png" alt="" />
							<img id="star_2" src="${basePath}/images/content_icon_default_xing.png" alt="" />
							<img id="star_3" src="${basePath}/images/content_icon_default_xing.png" alt="" />
							<img id="star_4" src="${basePath}/images/content_icon_default_xing.png" alt="" />
							<img id="star_5" src="${basePath}/images/content_icon_default_xing.png" alt="" />
						</div>
						<input id="grade" type="hidden" name="grade" value="" />
                        <input id="orderId" type="hidden" name="orderId" value="${comment.oid?default("")}" />
						<div id="eva"></div>
					</div>

					<div id="sharp"></div>
					<div class="textarea">
						<textarea name="msg"  id="msg" maxlength="200" placeholder="您对我们服务满意吗？您的评价会让我们对您提供更好的服务哦～"></textarea>
						<p class="gptu">
							<var style="color: #999 ;font-style: normal;">--</var>/200
						</p>
					</div>

				</div>

				<div id="last">
					<input type="button" value="提交评价"/></div>
		</form>
		</section>
	</body>

</html>
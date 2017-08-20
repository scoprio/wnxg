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
		<script src="${basePath}/js/qifu/all_sort.js" type="text/javascript" charset="utf-8"></script>
		<script src="${basePath}/js/qifu/all_sortdata.js" type="text/javascript" charset="utf-8" baseUrl="${basePath}"></script>
	</body>

</html>
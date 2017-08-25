<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
		<title>服务须知</title>
		<link rel="stylesheet" type="text/css" href="${basePath}/css/qifu/reset_h5.css" />
		<script src="${basePath}/js/qifu/jquery-1.11.3.js" type="text/javascript" charset="utf-8"></script>
		<script src="${basePath}/js/qifu/jquery.lazyload.js" type="text/javascript" charset="utf-8"></script>
	</head>

	<body>
		<div><img data-original="${basePath}/images/guide1.png" alt="" class="lazy" /></div>
		<div><img data-original="${basePath}/images/guide2.png" alt="" class="lazy" /></div>
		<div><img data-original="${basePath}/images/guide3.png" alt="" class="lazy" /></div>
		<div><img data-original="${basePath}/images/guide4.png" alt="" class="lazy" /></div>
		<div><img data-original="${basePath}/images/guide5.png" alt="" class="lazy" /></div>
		<div><img data-original="${basePath}/images/guide6.png" alt="" class="lazy" /></div>
	</body>
	
	<script type="text/javascript">
		$(function(){
			$("img.lazy").lazyload({
				effect: "fadeIn"
			});
		})
		
	</script>

</html>
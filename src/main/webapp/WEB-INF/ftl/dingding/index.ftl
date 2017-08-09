<!DOCTYPE html>
<html lang="zh-cn">
	<head>
		<meta charset="utf-8" />
		<title></title>
		<meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" name="viewport" />
		<link   rel="icon" href="${basePath}/favicon.ico" type="image/x-icon" />
		<link   rel="shortcut icon" href="${basePath}/favicon.ico" />
		<link href="${basePath}/js/common/bootstrap/3.3.5/css/bootstrap.min.css?${_v}" rel="stylesheet"/>
		<link href="${basePath}/css/common/base.css?${_v}" rel="stylesheet"/>

		<script  src="${basePath}/js/common/jquery/jquery1.8.3.min.js"></script>
		<script  src="${basePath}/js/common/layer/layer.js"></script>
		<script  src="${basePath}/js/common/bootstrap/3.3.5/js/bootstrap.min.js"></script>

        <script  src="${basePath}/js/dingding.demo.js"></script>

        <script>
            function openLink(url){
                dd.biz.util.openLink({
					 url:url,
					 onSuccess : function(result) {
					 },
					 onFail : function(err) {
						 alert(JSON.stringify(err));
					 }
				 });
            }

        </script>
	</head>
	<body data-target="#one" data-spy="scroll">

		<br>


        <table class="table table-bordered">
            <tr>
                <th>授权方Id</th>
                <td>${_config.agentId}</td>
            </tr>
            <tr>
                <th>授权方CropId</th>
                <td>${_config.corpId}</td>
            </tr>
        </table>
		<div style="padding-left:10px;">&nbsp;&nbsp;&nbsp;&nbsp;欢迎您：<div id="userName" style="display:inline-block;font-weight:bold"></div>&nbsp;成为钉钉开发者，您当前在钉钉的<code>userId</code>为：
			<div id="userId" style="display:inline-block;font-weight:bold"></div> 。</div>
		<br>
		<ul>
			<li>
				<div class="icon"><img src="list/num11.png" style="width: 25px; height: 25px"></div>
				<div class="text">企业接入指南</div>
			</li>
			<!-- <li>
				<div class="icon"><img src="list/heart2.png"></div>
				<div class="text">企业授权</div>
			</li>
			<li>
				<div class="icon"><img src="list/heart3.png"></div>
				<div class="text">企业解授权</div>
			</li> -->
			<li>
				<div class="icon"><img src="list/num2.png" style="width: 25px; height: 25px"></div>
				<div class="text">使用JSAPI</div>
			</li>
			<li>
				<div class="icon"><img src="list/num33.png" style="width: 25px; height: 25px"></div>
				<div class="text">导航框架</div>
			</li>
			<li>
				<div class="icon"><img src="list/num4.png" style="width: 25px; height: 25px"></div>
				<div class="text">List展示（当前仅支持Android）</div>
			</li>
			<li>
				<div class="icon"><img src="list/num5.png" style="width: 25px; height: 25px"></div>
				<div class="text">侧拉展现（当前仅支持Android）</div>
			</li>
			<li>
				<div class="icon"><img src="list/num6.png" style="width: 25px; height: 25px"></div>
				<div class="text">Tab页面（当前仅支持Android）</div>
			</li>
			<li>
				<div class="icon"><img src="list/num7.png" style="width: 25px; height: 25px"></div>
				<div class="text">企业通讯录</div>
			</li>
		</ul>
		<#--<script type="text/javascript">-->
			<#--window.addEventListener('load', function() {-->
				<#--setTimeout(function(){-->
				<#--}, 500);-->
			<#--});-->

			<#--var items = document.querySelectorAll('li');-->
			<#--var i = 0;-->
			<#--items[0].addEventListener('click',function(){-->
				<#--/* window.location='http://ddtalk.github.io/dingTalkDoc/#企业接入指南'; */-->
				<#--openLink('http://ddtalk.github.io/dingTalkDoc/#企业接入指南');-->
			<#--});-->
			<#--items[1].addEventListener('click',function(){-->
				<#--openLink('http://h5.m.laiwang.com/home/ding.html');-->
			<#--});-->
			<#--items[2].addEventListener('click',function(){-->
				<#--window.location='./nav/1.html';-->
			<#--});-->


			<#--items[3].addEventListener('click', function(){-->
				<#--window.location = './list/list.html';-->
			<#--});-->

			<#--items[4].addEventListener('click',function(){-->
				<#--window.location='./drawer/index.html';-->
			<#--});-->
			<#--items[5].addEventListener('click',function(){-->
				<#--window.location='./tab/index.html';-->
			<#--});-->
			<#--items[6].addEventListener('click',function(){-->
				<#--window.location='./contacts.jsp?corpid='+_config.corpId;-->
			<#--});-->

		<#--</script>-->
			
	</body>
</html>
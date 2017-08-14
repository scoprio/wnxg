<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
		<title>万能小哥</title>
        <#--<link href="${basePath}/js/common/bootstrap/3.3.5/css/bootstrap.min.css?${_v}" rel="stylesheet"/>-->
        <#--<link href="${basePath}/css/common/base.css?${_v}" rel="stylesheet"/>-->
		<link rel="stylesheet" type="text/css" href="${basePath}/css/qifu/reset_h5.css" />
		<link rel="stylesheet" type="text/css" href="${basePath}/css/qifu/index.css" />
		<link rel="stylesheet" type="text/css" href="${basePath}/css/qifu/dropload.css"/>

        <script>
            var _config = {"agentId":'${_config.agentId}',
                "corpId":'${_config.corpId}',
                "timeStamp":'${_config.timeStamp}',
                "nonceStr":'${_config.nonceStr}',
                "signature":'${_config.signature}'
            }
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

        <script type="text/javascript" src="http://g.alicdn.com/dingding/open-develop/1.6.9/dingtalk.js"></script>
        <script src="${basePath}/js/qifu/jquery-1.11.3.js" type="text/javascript" charset="utf-8"></script>
        <script src="${basePath}/js/qifu/dropload.js" type="text/javascript" charset="utf-8"></script>
        <script baseUrl="${basePath}" src="${basePath}/js/qifu/index_data.js" type="text/javascript" charset="utf-8"></script>
       	<script src="${basePath}/js/qifu/index.js" type="text/javascript" charset="utf-8"></script>
		<script src="${basePath}/js/dingding.demo.js"></script>
	</head>

	<body>


    <div class="choose_city">
        <a href="my.html" class="person_center"></a>
        <a href="${basePath}/dingding/city.shtml" class="city" id="citychoose" >北京</a>
    </div>
    <div class="banner"><img src="/images/banner.png"/></div>
    <div class="tab">
        <table border="0" cellspacing="0" cellpadding="0">

            <tr>
                <td>
                    <a href="all_sort.html?type=work">
                        <div><img src="/images/5.png" /></div>
                        <p>办公设备维护</p>
                    </a>
                </td>
                <td>
                    <a href="all_sort.html?type=light">
                        <div><img src="/images/2.png" /></div>
                        <p>办公电器保养</p>
                    </a>
                </td>
                <td>
                    <a href="all_sort.html?type=door">
                        <div><img src="/images/3.png" /></div>
                        <p>办公环境维修</p>
                    </a>
                </td>
                <td class="monthly">
                    <a href="all_sort.html?type=electricity">
                        <div><img src="/images/4.png" /></div>
                        <p>万能企业盾</p>
                    </a>
                </td>
            </tr>
        </table>
    </div>
    <div class="hot_project">
        <p class="hot_title">热门维修项目</p>
        <ul></ul>
    </div>

    <#--<div style="padding-left:10px;">&nbsp;&nbsp;&nbsp;&nbsp;欢迎您：<div id="userName" style="display:inline-block;font-weight:bold"></div>&nbsp;成为钉钉开发者，您当前在钉钉的<code>userId</code>为：-->
        <#--<div id="userId" style="display:inline-block;font-weight:bold"></div> 。</div>-->

		<#--<div class="choose_city">-->
			<#--<input type="" name="" id="" value="" class="person_center" />-->
			<#--<input class="city" type="button" name="" id="" value="北京" />-->
		<#--</div>-->
		<#--<div class="tab">-->
			<#--<table border="0" cellspacing="0" cellpadding="0">-->

				<#--<tr>-->
					<#--<td>-->
						<#--<a href="">-->
							<#--<div><img src="${basePath}/images/2.png" /></div>-->
							<#--<p>办公设备</p>-->
						<#--</a>-->
					<#--</td>-->
					<#--<td>-->
						<#--<a href="">-->
							<#--<div><img src="${basePath}/images/3.png" /></div>-->
							<#--<p>灯具电路</p>-->
						<#--</a>-->
					<#--</td>-->
					<#--<td>-->
						<#--<a href="">-->
							<#--<div><img src="${basePath}/images/4.png" /></div>-->
							<#--<p>门窗家具</p>-->
						<#--</a>-->
					<#--</td>-->
					<#--<td>-->
						<#--<a href="">-->
							<#--<div><img src="${basePath}/images/5.png" /></div>-->
							<#--<p>疏通管道</p>-->
						<#--</a>-->
					<#--</td>-->
				<#--</tr>-->
				<#--<tr>-->
					<#--<td>-->
						<#--<a href="">-->
							<#--<div><img src="${basePath}/images/6.png" /></div>-->
							<#--<p>空调养护</p>-->
						<#--</a>-->
					<#--</td>-->
					<#--<td>-->
						<#--<a href="">-->
							<#--<div><img src="${basePath}/images/7.png" /></div>-->
							<#--<p>墙面地面</p>-->
						<#--</a>-->
					<#--</td>-->
					<#--<td class="monthly">-->
						<#--<a href="">-->
							<#--<div><img src="${basePath}/images/8.png" /></div>-->
							<#--<p>IT运维</p>-->
						<#--</a>-->
					<#--</td>-->
					<#--<td>-->
					<#--</td>-->
				<#--</tr>-->
			<#--</table>-->
		<#--</div>-->
		<#--<div class="hot_project">-->
			<#--<p class="hot_title">热门维修项目</p>-->
			<#--<ul>-->
			<#--</ul>-->
		<#--</div>-->

		
	</body>

</html>
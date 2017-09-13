<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
        <meta name="format-detection" content="telephone=no" />
        <meta name="format-detection" content="email=no" />
        <meta name="format-detection" content="address=no;">
        <meta name="apple-mobile-web-app-capable" content="yes" />
        <meta name="apple-mobile-web-app-status-bar-style" content="black" />
		<title>我的企业盾详情</title>
		<link rel="stylesheet" type="text/css" href="${basePath}/css/qifu/reset_h5.css"/>
		<link rel="stylesheet" type="text/css" href="${basePath}/css/qifu/my_QF.css"/>
		
		<script src="${basePath}/js/qifu/jquery-1.11.3.js" type="text/javascript" charset="utf-8"></script>
		<script src="${basePath}/js/qifu/my_QF.js" type="text/javascript" charset="utf-8"></script>
        <script src="${basePath}/js/qifu/common.js" type="text/javascript" charset="utf-8"></script>
        <script type="text/javascript" src="http://g.alicdn.com/dingding/open-develop/1.6.9/dingtalk.js"></script>
        <script src="${basePath}/js/qifu/dingding_comm.js" type="text/javascript" charset="utf-8"></script>
	</head>
	<body>
		<section style="display: -webkit-flex;-webkit-flex-direction: column;">
			<div class="my_box">
				<div class="my_left"><img src="${basePath}/images/1tu.png"/></div>
				<div class="my_right">
					<p>${qifuInfo.info.service_name?default('未设置')}</p>
					<p><span>服务周期：</span><span>${qifuInfo.info.period?default('未设置')}</span></p>
					<p><span>服务详情：</span><span>${qifuInfo.info.service_name?default('未设置')} ${qifuInfo.info.buy_time?default('未设置')} 天</span></p>
					<p><span>订单金额：</span><span>${qifuInfo.info.money?default('未设置')}元</span></p>
				</div>
			</div>
			<div class="message">
				<p class="msg_img">

                    <img src="${basePath}/images/${qifuInfo.info.stateImage?default('weishengxiao.png')}"/>
				</p>
				<#--<p class="msg_edit">修改</p>-->
				<p>企业信息</p>
				<p><span>公司名称：</span><span>${qifuInfo.info.company_name?default('未设置')}</span></p>
				<p><span>联&nbsp;系&nbsp;人   ：</span><span>${qifuInfo.info.linkman?default('未设置')}</span></p>
				<p><span>联系电话：</span><span>${qifuInfo.info.tel?default('未设置')}</span></p>
				<p><span>维修地址：</span><span class="msg_addr">${qifuInfo.info.address?default('未设置')}</span></p>
			</div>
			<div class="record" style="-webkit-flex-grow: 1;">
				<p class="record_title">维修记录</p>

				<ul class="record_ul">

				<#if qifuInfo.repairList?exists && qifuInfo.repairList?size gt 0 >
					<#list qifuInfo.repairList as repair>
						<li>
							<p class="record_order"><span>订单编号：</span><span>${repair.order_num?default('未设置')}</span><span>${repair.stateName?default('未设置')}</span></p>
							<div class="recordbox">
								<div class="record_left"><img src="${basePath}/images/${repair.repairId?default('1tu')}.png"/></div>
								<div class="record_right">
									<p><span>维修类目：</span><span>${repair.repair_name?default('未设置')}</span></p>
									<p><span>下单时间：</span><span>${repair.createTime?default('未设置')}</span></p>
									<p><span>预约时间：</span><span>${repair.order_time?default('未设置')}</span></p>
								</div>
							</div>
							<div class="record_btn"><a  href="tel:400-6633-750" class="notescontact_kf" type="button" name="" id="" >联系客服</a></div>
						</li>
					</#list>
				<#else>
                    <div class="no_datebox">
                        <div ><img src="${basePath}/images/no_data2.png"/></div>
                        <p style="">暂无维修记录</p>
                    </div>
				</#if>
				</ul>
			</div>
		</section>
		<footer class="border_top">
			<#--<input type="button" name="" id="" value="续购服务" class="btn_go_on"/>-->
			<input type="button" name="" id="" value="预约维修" class="btn_subscribe"/>
		</footer>
		
	</body>
	<script type="text/javascript">
		$(".record").ready(function(){
			var windowHeight = $(window).height();
  			if($(this).height() < windowHeight){
      			$(this).height(windowHeight);
  			}
		})

        $(function() {
			$(".btn_subscribe").click(function() {
                if('${qifuInfo.info.state}' == '0') {
                    layer_tip("您的企业盾待支付!");
                }else if('${qifuInfo.info.state}' == '1'){
                    layer_tip("您的企业盾支付成功,未生效，待巡检后生效")
                }else if('${qifuInfo.info.state}' == '4'){
                    location.href = "${basePath}/ulb/reservation.shtml?recordId=${qifuInfo.info.serivce_id}";
                }else{
                    layer_tip("您的企业盾已失效")
				}
            })
			if(${qifuInfo.repairList?size} == '10'){
                layer_tip("亲，你本月的万能企业盾维修次数已用完。如有维修需求，请单独下单!",function () {
                    $("footer input").css("background","#ccc");
                    $("footer input").attr("disabled",true)
                })
			}
        })
	</script>
</html>

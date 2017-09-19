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
        <title>订单详情</title>
		<link rel="stylesheet" type="text/css" href="${basePath}/css/qifu/reset_h5.css" />
		<link rel="stylesheet" type="text/css" href="${basePath}/css/qifu/order_details.css" />
        <script type="text/javascript" src="http://g.alicdn.com/dingding/open-develop/1.6.9/dingtalk.js"></script>
        <script src="${basePath}/js/qifu/jquery-1.11.3.js" type="text/javascript" charset="utf-8"></script>
        <script src="${basePath}/js/qifu/dingding_comm.js" type="text/javascript" charset="utf-8"></script>
	</head>

	<body>
		<!--小哥信息-->


		<div class="xg_details border_bottom" style="display: ${order.xgDisplay?default('block')}">
			<div class="xg_head"><img src="${basePath}/images/xg1.png" /></div>
			<div class="xg_doc">
				<p class="xg_name">${order.xgName?default("无")}</p>
				<p class="xg_num"><span>工号：</span><i>${order.employeeid?default("无")}</i></p>
			</div>
			<a href="tel:${order.xgPhone?default("400-6633-750")}" name="" id="" value="" class="xg_tel"></a>
		</div>
		<!--订单跟踪-->
		<div class="order_after border_top border_bottom">
			<p>订单跟踪</p>
			<ul>
				<#if order.orderDatas?exists && order.orderDatas?size gt 0 >
					<#list order.orderDatas as orderDate>
                        <li><i>${orderDate.pName}</i><span>${orderDate.updateDateTime}</span></li>
					</#list>
				<#else>
				</#if>

			</ul>
		</div>
		<!--订单详情-->
		<div class="order_detail">
			<p class="border_top border_bottom">订单详情</p>
			<ul>
                <li><i>订单编号</i><span>${order.onum?default("无")}</span></li>
				<li><i>预约时间</i><span>${order.yuyueTime}</span></li>
				<li><i>服务类别</i><span>${order.repairName}</span></li>
				<li><i>问题描述</i><span>${order.remark}</span></li>
				<li><i>联系人</i><span>${order.userName}  ${order.userPhone}</span></li>
				<li><i>地址</i><span>${order.address}</span></li>
				<li><i>平台报价</i><span>${order.platformPrice?default('面议')}</span></li>
				<li><i>人工费</i><span>${order.costString?default('面议')}</span></li>
				<li><i>材料费</i><span>${order.costMaterialString?default('面议')}</span></li>
				<li><i>附加费</i><span>${order.surchargeString?default('面议')}</span></li>
				<li><i>下单时间</i><span>${order.downTime}</span></li>

                <div class="order_code" style="display: ${order.display?default('none')}">
                    <input type="button" value="取消订单" onclick="cancelOrder(${order.oid?default('0')})" />
                </div>
				
				<!--三联协议-->
                <div class="sanlian">
                    <div class="logo">
                        <div class="top">
                            <img src="${basePath}/images/help_2.png" alt="" />
                            <!--<span class="title">万能小哥</span>-->
                        </div>
                        <!--<span class="text">万能小哥 您身边的维修专家</span>-->
                    </div>
                    <p>万能小哥服务确认单</p>
                    <div class="confirm_order">
                        <div class="first_row">
                            <span>小&nbsp;&nbsp;哥：</span>
                            <span class="name msg">${order.xgName?default('无')}</span>
                            <span>订单号：</span>
                            <span class="order_num msg">${order.onum?default('无')}</span>
                        </div>
                        <div class="second_row">
                            <span>日&nbsp;&nbsp;期：</span>
                            <span class="data msg">${order.downTime?default('无')}</span>
                        </div>
                        <div class="third_row">
                            <span>客官地址：</span>
                            <span>${order.address?default('无')}</span></div>
                        <div class="fifth_row">
                            <span>客官电话：</span>
                            <span class="tel msg">${order.userPhone?default('无')}</span>
                        </div>
                        <div class="sixth_row">
                            <span>维修项目：</span>
                            <span class="project msg">${order.repairName?default('无')}</span>
                        </div>
                        <div class="seventh_row">
                            <span>人工费金额：</span>
                            <span class="fix_cost msg">${order.costString?default('面议')}</span>
                        </div>
                        <div class="last_row">
                            <span>材料费金额：</span>
                            <span class="take_cost msg">${order.costMaterialString?default('面议')}</span>
                        </div>
                    </div>
                    <div class="detail">
                        <div class="detail_title">维修明细</div>
                        <div class="detail_text msg"></div>
                        <div class="confirm"><span>客官确认：</span><span>${order.userName?default('无')}</span></div>
                    </div>
                    <div class="deal">
                        <h3>万能小哥服务协议</h3>
                        <p> 1. 本协议适用于北京万能小哥信息技术有限公司（以下简称万能小哥）利用自身研发的维修管理系统完成为客户推荐维修人员的服务项目。</p>
                        <p> 2. 客官通过微信平台或者400-6633-750电话向万能小哥预约维修服务。</p>
                        <p> 3. 客官签字即确认了解本次服务收费标准及万能小哥的最新政策，并依据收费标准和政策向万能小哥支付费用。</p>
                        <p> 4. 客官须根据万能小哥提供的小哥信息核实小哥工牌身份，如果未经身份核实使用小哥，所带来的纠纷或损害，万能小哥不承担责任及赔偿义务。</p>
                        <p> 5. 维修人员有权向委托方如实告知此次维修的问题和维修过程中的突发情况，如：零配件老化，零配件损坏等一系列问题，委托方可根据情况选择性进行维修。如因在维修过程中出现上述情况带来的纠纷或破坏，维修小哥不承担任何责任及赔偿，由委托方自行承担。</p>
                        <p> 6. 委托方在维修前检查室内的贵重财物并妥善保管，万能小哥严格要求维修人员不得接触维修以外的任何财物，如发生财物丢失情况请及时提出，维修人员会及时汇报万能小哥公司并报警，维修人员需配合警察进行调查。服务结束后委托方同意维修人员离开即确认本次服务过程中没有发生财物丢失情况。警方依法处理前，委托方不得以怀疑为理由进行语言攻击，人格侮辱及暴力手段的人身伤害行为。否则由此造成万能小哥及维修人员的损失，委托方需承担一切责任。</p>
                        <p> 7. 委托方没有通过万能小哥正规预约渠道进行预约，私下预约万能小哥的维修人员提供的服务，签订的协议无效。</p>
                        <p> 8. 委托方在维修完成72小时之内，如因维修服务后所产生的质量问题，可向万能小哥及维修人员提出售后维修申请，万能小哥及维修人员有义务为委托方提供免费的售后服务（最终解释权归万能小哥所有）。</p>
                        <div class="client">
                            <p class="trustee">委托方：${order.userName?default('无')}</p>
                            <div class="client_text msg" /><img src="${basePath}/images/seal.png" alt="" /></div>
                        <p class="trustee the_client">被委托方：北京万能小哥信息技术有限公司</p>
                    </div>
                </div>
        </div>
				<li class="border_top" style="clear: both"><input type="button" name="" id="" value="点击查看三联协议"  class="third_client" style="display: ${order.slDisplay?default('none')}"/></li>
			</ul>
			
		</div>
		<script src="${basePath}/js/qifu/jquery-1.11.3.js" type="text/javascript" charset="utf-8"></script>
        <script src="${basePath}/js/qifu/common.js" type="text/javascript" charset="utf-8"></script>
		<script type="text/javascript">
            function cancelOrder(orderId){

                var skuOrder = {
                    "id":orderId,
					"cityCode":localStorage.current_city_code,
                    "operater": 1
                }
                layer_confirm("确定取消订单",function(){
                    $.ajax({
                               url:"${basePath}/ulb/sku/order.shtml",
                               type:"PUT",
                               data:JSON.stringify(skuOrder),
                               contentType:"application/json; charset=utf-8",
                               dataType:"json",
                               success: function(result){
                                   if(result && result.status== 200){
                                       layer_tip(result.message,function () {
                                           location.href = "${basePath}/dingding/my_order/"+localStorage.dingdingUserId+"/"+localStorage.current_city_code+".shtml?corpId="+localStorage.corpId+"&appid="+localStorage.appId;
                                       })
                                   }else{
                                       layer_tip(result.message);
                                   }
                               },
                               error: function(result){
                                   console.log(result.message);
                               }
                           })
                },function(){});

            }

			$(function(){

				$('.third_client').click(function(){
					$('.sanlian').stop().slideToggle();
					$(this).val($(this).val() == "点击查看三联协议" ? "收起" : "点击查看三联协议");
				})


			})
		</script>
	</body>

</html>
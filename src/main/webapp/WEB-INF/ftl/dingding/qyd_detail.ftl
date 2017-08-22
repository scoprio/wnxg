<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="widtd=device-widtd,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
		<title>企业盾1号</title>
		<link rel="stylesheet" type="text/css" href="${basePath}/css/qifu/reset_h5.css" />
		<link rel="stylesheet" type="text/css" href="${basePath}/css/qifu/qyd_detail.css" />
        <script type="text/javascript" src="http://g.alicdn.com/dingding/open-develop/1.6.9/dingtalk.js"></script>
        <script src="${basePath}/js/qifu/jquery-1.11.3.js" type="text/javascript" charset="utf-8"></script>

        <script type="text/javascript">
            $(function() {
            	$('.submit_btn').click(function() {

					if('${qydInfo.isAdmin}' == 'true'){
                        location.href = "${basePath}/ubl/qf.shtml?cityCode=${qydInfo.cityCode}";
					}else{
                        alert("联系管理员开通");
					}

				});
            });
		</script>
	</head>

	<body>
		<div>
			<div class="qyd_banner img_box"><img src="${basePath}/images/qyd_banner.png" /></div>
			<ul class="qyd_title border_bottom">
				<li>
					<a href="javascript:;" class="change_color">服务详情</a>
				</li>
				<li>
					<a href="javascript:;">评论（<span>2</span>）</a>
				</li>
			</ul>
			<ul class="qyd_content">
				<li  class="content_right" style="display: block;">
					<div class="products_presentation">
						<h2 class="h2">产品介绍</h2>
						<p>万能企业盾是万能小哥针对企业办公基本设施设备提供的托管包月服务，并提供一站式解决方案。</p>
						<img src="${basePath}/images/qyd2.png">
					</div>
					<div class="content_of_product">
						<h2 class="h2">产品内容</h2>
						<p class="qyd_price">[498元/30天]</p>
						<table>
							<tr>
								<th>一级类目</th>
								<th>二级类目</th>
							</tr>
							<tr>
								<td rowspan="5">房屋电路维修</td>
								<td>开关更换维修</td>
							</tr>
							<tr>

								<td>空气开关拆换维修</td>
							</tr>
							<tr>

								<td>墙体插座更换维修</td>
							</tr>
							<tr>

								<td>墙体插座增加安装（非嵌入墙体）</td>
							</tr>
							<tr>

								<td>地插更换维修</td>
							</tr>
							<tr>
								<td>灯具维修</td>
								<td>灯具检测维修</td>
							</tr>
							<tr>
								<td rowspan="5">家具维修</td>
								<td>家具轨道更换维修（单轨）</td>
							</tr>
							<tr>

								<td>家具轨道更换维修（双轨）</td>
							</tr>
							<tr>

								<td>家具合页更换维修</td>
							</tr>
							<tr>

								<td>家具护角安装维修</td>
							</tr>
							<tr>

								<td>家具滑轮更换维修</td>
							</tr>
							<tr>
								<td rowspan="10">门窗五金维修</td>
								<td>玻璃门五金件更换维修</td>
							</tr>
							<tr>

								<td>木门合页更换维修</td>
							</tr>
							<tr>

								<td>门吸维修更换</td>
							</tr>
							<tr>

								<td>塑钢窗滑轮更换维修</td>
							</tr>
							<tr>

								<td>塑钢窗合页更换维修</td>
							</tr>
							<tr>

								<td>塑钢窗锁更换维修</td>
							</tr>
							<tr>

								<td>塑钢门锁更换维修</td>
							</tr>
							<tr>

								<td>纱窗更换维修（隐形）</td>
							</tr>
							<tr>

								<td>窗帘更换维修</td>
							</tr>
							<tr>

								<td>门窗封胶维修</td>
							</tr>
							<tr>
								<td rowspan="2">洗手盆面盆维修</td>
								<td>洗手盆上水管或下水管维修</td>
							</tr>
							<tr>

								<td>洗手盆上水管和下水管全套更换</td>
							</tr>
							<tr>
								<td rowspan="2">管道疏通</td>
								<td>管道疏通（疏通机作业疏通）</td>
							</tr>
							<tr>
								<td>小便池疏通（手动）</td>
							</tr>
						</table>
						<div class="qyd_remark">
							<div>备注：</div>
							<div>
								<p>1、购买后3日内会对企业提供一次上门巡检服务，确认符合标准之后服务正式开始；</p>
								<p>2、如不符合标准需先行维护之后再行开始服务；</p>
								<p>3、若办公场所发生维修，企业最多有10次免费维修服务；</p>
								<p>4、服务不包含材料配件等费用，如需材料配件企业可自备，也可选择由小哥按市场价自行协商进行代购；</p>
								<p>5、万能小哥客户专属服务热线：4006633750。</p>
							</div>
						</div>
					</div>
					<div class="img_box margin_b"><img src="${basePath}/images/qyd_1.jpg" /></div>
					<div class="img_box"><img src="${basePath}/images/qyd_2.jpg" /></div>
					<div class="img_box"><img src="${basePath}/images/qyd_3.jpg" /></div>
					<div class="img_box margin_b"><img src="${basePath}/images/qyd_4.jpg" /></div>
					<div class="img_box margin_b"><img src="${basePath}/images/qyd_5.jpg" /></div>
					<div class="service_note">
						<h2 class="h2">服务说明</h2>
						<ul>
							<li><span>1</span>
								<p>预约维修后技能小哥会联系客户，与客户就需要维修的物品情况进行电话沟通，以确定是否需要携带零配件，上门服务时间等相关信息。</p>
							</li>
							<li><span>2</span>
								<p>技能小哥上门携带专业的工具，按照指定地点进行检测、维修。</p>
							</li>
							<li><span>3</span>
								<p>技能小哥在维修安装完毕后打扫清洁现场卫生。</p>
							</li>
							<li><span>4</span>
								<p>维修完毕后72小时之内，如因维修服务后产生的质量问题，万能小哥有义务为用户提供免费售后服务（不含材料配件）。</p>
							</li>
						</ul>
					</div>
				</li>
				<li class="content_right">
					<!-- 没有评论的时候显示内容-->
					<!--<div class="ag_Comment" >
						<div><img src="img/no_comment.png"/></div>
						<p >此商品还没有评价！</p>
					</div>-->
					<!-- 有评论的时候显示的内容-->
					<ul class="pl_box">
						<li class="pl_list">
							<div class="pl_left"><img src="${basePath}/images/logo1.png" /></div>
							<div class="pl_right">
								<p><span>河北万杰超修信息科技有限公司</span><span>2017-05-06</span></p>
								<ul class="star">
									<li></li>
									<li></li>
									<li></li>
									<li></li>
									<li></li>
									<span>非常好</span>
								</ul>
								<p>维修师傅速度很快，很负责，很完美！维修师傅速度很快，很负责，很完美！维修师傅速度很快，很负责，很完美！</p>
							</div>
						</li>
						<li class="pl_list">
							<div class="pl_left"><img src="${basePath}/images/logo2.png" /></div>
							<div class="pl_right">
								<p><span>河北万杰超修信息科技有限公司</span><span>2017-05-06</span></p>
								<ul class="star">
									<li></li>
									<li></li>
									<li></li>
									<li></li>
									<span>非常好</span>
								</ul>
								<p>维修师傅速度很快，很负责，很完美！</p>
							</div>
						</li>
					</ul>
				</li>
			</ul>
		</div>
		<div class="qyd_foot border_top"><input type="button" class="submit_btn" value="立即购买" /></div>
		<script src="${basePath}/js/qifu/jquery-1.11.3.js" type="text/javascript" charset="utf-8"></script>
		<script src="${basePath}/js/qifu/qyd_detail.js" type="text/javascript" charset="utf-8"></script>
	</body>

</html>
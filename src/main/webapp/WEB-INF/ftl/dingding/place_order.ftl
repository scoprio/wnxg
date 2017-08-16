<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
		<title>下单</title>
		<link rel="stylesheet" type="text/css" href="${basePath}/css/qifu/reset_h5.css" />
		<link rel="stylesheet" type="text/css" href="${basePath}/css/qifu/place_order.css" />
		<link rel="stylesheet" type="text/css" href="${basePath}/css/qifu/webuploader.css" />

        <script src="${basePath}/js/qifu/jquery-1.11.3.js" type="text/javascript" charset="utf-8"></script>
        <script src="${basePath}/js/qifu/text_self_adaption.js" type="text/javascript" charset="utf-8"></script>
        <script src="${basePath}/js/qifu/webuploader.js" type="text/javascript" charset="utf-8"></script>
        <script src="${basePath}/js/qifu/wnxg_qf.js" type="text/javascript" charset="utf-8"></script>
        <script type="text/javascript">
            $(function() {
                $(".enter_in").click(function() {
                    $('.datebox').fadeIn()
                    $(".choosedate").animate({
						 "bottom": "0"
					 }, 500);
                })
                $(".cancelbtn").click(function() {
                    $(".choosedate").animate({
						 "bottom": "-3.36rem"
					 }, 500, function() {
                        $('.datebox').fadeOut();
                    })
                })
                $('.fleft li').click(function() {
                    $(this).addClass('add_bgcolor').find('span').css('color', '#fff').parent().siblings().removeClass('add_bgcolor').find('span').css('color', '#222');
                    $('.fright li').eq($(this).index()).show().siblings().hide().find('span').removeClass('add_bgcolor');
                })
                $('.fright li span').click(function() {
                    $(this).addClass('add_bgcolor').siblings().removeClass('add_bgcolor');
                })

                $(".checked_btn").click(function() {
                    if($(this).prop('checked')) {
                        $(this).css({
                                        "background": "url(${basePath}/images/btn_press_tongyi.png) no-repeat center",
                                        "background-size": "100%"
                                    })
                        $(".submit_btn").css("background", "#ff943e");

                    } else {
                        $(this).css({
                                        "background": "url(${basePath}/images/btn_defult_tongyi.png) no-repeat center",
                                        "background-size": "100%"
                                    })
                        $(".submit_btn").css("background", "#ccc");
                        console.log(888)
                    }
                })

                $(".add").click(function(){
                    var carValue = $('.txt').text();
                    carValue++
                    $('.txt').text(carValue)
                })
                $(".jian").click(function(){
                    var carValue =$('.txt').text();
                    carValue--
                    if(carValue<=1){
                        carValue = 1
                    }
                    $('.txt').text(carValue)
                })

            })
        </script>
	</head>

	<body>
		<div class="flow border_bottom">
			<div><img src="${basePath}/images/liucheng_1.png" /></div>
		</div>
		<form action="${basePath}/" method="post">
			<div class="order_head border_bottom border_top">
				<div class="head_img"><img src="${sku.imgUrl}" /></div>
				<div class="choose_num">
					<p class="order_name">维修类目：<span>${sku.name}</span></p>
					<p class="remark">${sku.content}</p>
					<div>
						<p class="priceshow"><i>&yen;</i><span>${sku.price}</span> <input type="button" name="" id="" value="服务说明" /></p>
					</div>
				</div>
			</div>
			<ul class="contact_way border_bottom">
				<li class="contact_wayli enter enter_in"><span>请选择服务时间</span><input type="hidden" name="" id="" value="" /></li>
				<li class="contact_wayli enter"><span>位置</span><input type="hidden" name="" id="" value="" /></li>
				<li class="contact_wayli"><span>详细地址</span><textarea data-adaptheight onpropertychange="this.style.posHeight=this.scrollHeight " name="" rows="1" cols="40" placeholder="请输入具体门牌号"></textarea></li>
				<li class="contact_wayli"><span>称呼</span><input type="text" id="" value="" /></li>
				<li class="contact_wayli"><span>联系电话</span><input type="tel" name="" id="" value="" /></li>
				<li class="problem_desc contact_wayli"><span>请输入问题描述</span>
					<textarea data-adaptheight onpropertychange="this.style.posHeight=this.scrollHeight " name="" rows="3" cols="" placeholder="请输入问题描述"></textarea>
				</li>
				<!--dom结构部分    图片上传-->
				<div id="uploader" class="wu-example" style="display: none">
					<!--用来存放item-->
					<div class="queueList">
						<div id="filePicker" class="webuploader-container">
						</div>
						<div class="statusBar element-invisible">
							<div id="filePicker2">

							</div>
						</div>
					</div>
				</div>
				<p class="agree"><label for=""><input type="checkbox" checked="checked" class="checked_btn" name="" id="" value="" />我同意</label>
					<a href="javascript:;">《万能小哥维修协议》</a>
				</p>
			</ul>
			<div class="foot border_top"><input  class="submit_btn" type="submit" value="立即报修" /></div>
		</form>
		<div class="datebox">
			<div class="choosedate">
				<p class="border_bottom"><span class="cancelbtn fl">取消</span><i>请选择时间</i><span class="affirmbtn fr">确认</span></p>
				<div>
					<ul class="fl fleft">
						<li class="add_bgcolor">今天（<span>星期二</span>）</li>
						<li>明天（<span>星期三</span>）</li>
						<li>后天（<span>星期四</span>）</li>
					</ul>
					<ul class="fr fright">
						<li style="display: block;">
							<span>8:30</span>
							<span>9:00</span>
							<span>9:30</span>
							<span>10:00</span>
							<span>10:30</span>
							<span>11:00</span>
							<span>11:30</span>
							<span>12:00</span>
							<span>12:30</span>
							<span>13:00</span>
							<span>13:30</span>
							<span>14:00</span>
							<span>14:30</span>
							<span>15:00</span>
							<span>15:30</span>
							<span>16:00</span>
							<span>16:30</span>
							<span>17:00</span>
							<span>17:30</span>
							<span>18:00</span>
						</li>
						<li>
							<span>8:30</span>
							<span>9:00</span>
							<span>9:30</span>
							<span>10:00</span>
							<span>10:30</span>
							<span>11:00</span>
							<span>11:30</span>
							<span>12:00</span>
							<span>12:30</span>
							<span>13:00</span>
							<span>13:30</span>
							<span>14:00</span>
							<span>14:30</span>
							<span>15:00</span>
							<span>15:30</span>
							<span>16:00</span>
							<span>16:30</span>
							<span>17:00</span>
							<span>17:30</span>
							<span>18:00</span>
						</li>
						<li>
							<span>8:30</span>
							<span>9:00</span>
							<span>9:30</span>
							<span>10:00</span>
							<span>10:30</span>
							<span>11:00</span>
							<span>11:30</span>
							<span>12:00</span>
							<span>12:30</span>
							<span>13:00</span>
							<span>13:30</span>
							<span>14:00</span>
							<span>14:30</span>
							<span>15:00</span>
							<span>15:30</span>
							<span>16:00</span>
							<span>16:30</span>
							<span>17:00</span>
							<span>17:30</span>
							<span>18:00</span>
						</li>
					</ul>
				</div>
			</div>
		</div>

	</body>

</html>
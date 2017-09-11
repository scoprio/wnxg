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
        <title>下单</title>
		<link rel="stylesheet" type="text/css" href="${basePath}/css/qifu/reset_h5.css" />
		<link rel="stylesheet" type="text/css" href="${basePath}/css/qifu/place_order.css" />
		<link rel="stylesheet" type="text/css" href="${basePath}/css/qifu/webuploader.css" />

        <script type="text/javascript" src="http://g.alicdn.com/dingding/open-develop/1.6.9/dingtalk.js"></script>
        <script src="${basePath}/js/qifu/jquery-1.11.3.js" type="text/javascript" charset="utf-8"></script>
        <script src="${basePath}/js/qifu/text_self_adaption.js" type="text/javascript" charset="utf-8"></script>
        <script src="${basePath}/js/qifu/webuploader.js" type="text/javascript" charset="utf-8"></script>
        <script src="${basePath}/js/qifu/wnxg_qf.js" type="text/javascript" charset="utf-8"></script>
        <script src="${basePath}/js/qifu/common.js" type="text/javascript" charset="utf-8"></script>
        <script type="text/javascript">

            <#--alert(localStorage.agentId);-->
            <#--alert(localStorage.corpId);-->
            <#--alert(localStorage.timeStamp);-->
            <#--alert(localStorage.nonceStr);-->
            <#--alert(localStorage.signature);-->
            <#--alert(localStorage.dingdingUserId);-->
            <#--var _config = {-->
                <#--"agentId":'${sku.config.agentId}',-->
                <#--"corpId":'${sku.config.corpId}',-->
                <#--"timeStamp":'${sku.config.timeStamp}',-->
                <#--"nonceStr":'${sku.config.nonceStr}',-->
                <#--"signature":'${sku.config.signature}'-->
            <#--}-->
//            alert(localStorage.agentId);
            localStorage.agentId ='${sku.config.agentId?default("")}';
            localStorage.corpId ='${sku.config.corpId?default("")}';
            localStorage.timeStamp ='${sku.config.timeStamp?default("")}';
            localStorage.nonceStr = '${sku.config.nonceStr?default("")}';
            localStorage.signature = '${sku.config.signature?default("")}';

            dd.ready(function() {

                dd.ui.webViewBounce.disable({
                    onSuccess: function() {
                    },
                    onFail: function() {
                    }
                });
                dd.biz.navigation.setTitle({
                       title: '万能小哥',
                       onSuccess: function(data) {
                       },
                       onFail: function(err) {
                           log.e(JSON.stringify(err));
                       }
                   });
            });

			$(function() {

                var input_time = $("#date");
                var input_site = $("#site");
                var input_addr = $("#addr");
                var input_telephone = $("#telephone");
                var input_username = $("#username");
                var input_desc = $("#desc");
                var input_checkbox = $("input:checkbox");
                var checked_btn = $('.checked_btn');
                var submit_btn = $('.submit_btn');
                var date_order = '';//预约日期+时间
                var flag = false;
                Iscomplete = function(){
                    var form_time = input_time.val().trim();
                    var form_site = $("#site").val()
                    var form_addr = input_addr.val().trim();
                    var form_telephone = input_telephone.val();
                    var form_username = input_username.val().trim();
                    var form_desc = input_desc.val().trim();
                    var checkbox = input_checkbox.prop('checked');

                    if(form_addr && form_desc && form_telephone && form_username && checkbox && form_time &&form_site){
                        submit_btn.css("background", "#ff943e");
                        flag = true;
                    }
                    else{
                        submit_btn.css("background", "#ccc");
                        flag = false;
                    }
                }
                Iscomplete();
            console.log(JSON.parse('${sku.usefulTime}'));

			// 选择时间数据填充
            function fill_date(){
                var result_date = '';
                var result_time = '';
                var result_time_all = '';

				var date_data = JSON.parse('${sku.usefulTime}');


                if(date_data){
                    date_data.forEach(function(item,i){
                        result_time = '';
                        item.time.forEach(function(time,i){
                            result_time += '<span>'+time+'</span>'
                        })
                        if(i==0){
                            result_date += '<li class="add_bgcolor"><span>'+item.date+'</span></li>';
                        }
                        else if(i==1){
                            result_date += '<li><span>'+item.date+'</span></li>';
                        }
                        else if(i==2){
                            result_date += '<li><span>'+item.date+'</span></li>';
                        }
                        else{
                            result_date += '<li><span>'+item.date+'</span></li>';
                        }
                        result_time_all += '<li>'+result_time+'</li>'
                    })
                    $('.choosedate>div .fleft').html('');
                    $('.choosedate>div .fright').html('');
                    $('.choosedate>div .fleft').prepend(result_date);
                    $('.choosedate>div .fright').prepend(result_time_all);
                }

            }

            input_telephone.blur(function(){
                var tel_yz = input_telephone.val();
                reg = /^1[3|4|5|7|8]\d{9}$/;
                if(!reg.test(tel_yz)){
                    layer_tip("请输入正确的手机号")
                    input_telephone.val('')
                }else{
                    console.log(1111)
                }
                Iscomplete()

            })
            $('.affirmbtn').click(function(event){
                event.stopPropagation();
                var index = 0;
                var index_time = 0;
                var val_data = '';
                date_order ='';
                var flag = 0
                $('.choosedate>div .fleft>li').each(function(i,item){
                    if($(item).hasClass('add_bgcolor')){
                        index = i;
                        val_data += $(item).text();
                        date_order +=$(item).find('span').text();
                        return false;
                    }
                })
                $(".choosedate>div .fright>li").eq(index).find('span').each(function(i,item){
                    if($(item).hasClass('add_bgcolor')){
                        val_data += ' '+$(item).text();
                        date_order += ' '+$(item).text();
                        index_time = i;
                        flag = 1;
                        return false;
                    }
                    else{
                        console.log('f')
                    }
                })
                if(flag == 1){
                    $('.enter_in input').val(val_data);
                    $(".choosedate").animate({
                                                 "bottom": "-7rem"
                                             }, 400, function() {
                        $('.datebox').fadeOut();
                    })

                    $(".enter_in").attr('data-day-code',index);
                    $(".enter_in").attr('data-time-code',index_time);
                    Iscomplete();
                }

            })



            $(".enter_in").click(function() {
                fill_date();
                var dataset = event.currentTarget.dataset;
                var data_day_code = dataset.dayCode;
                var data_time_code = dataset.timeCode;
                $('.fright>li').eq(data_day_code).show();
                $('.fright>li').eq(data_day_code).siblings('li').hide();
                $('.fleft>li').eq(data_day_code).addClass('add_bgcolor');
                $('.fleft>li').eq(data_day_code).siblings('li').removeClass('add_bgcolor');
                $('.fright>li').eq(data_day_code).find('span').removeClass('add_bgcolor');
                $('.fright>li').eq(data_day_code).find('span').eq(data_time_code).addClass('add_bgcolor');
                $('.datebox').fadeIn()
                $(".choosedate").animate({
                     "bottom": "0"
                 }, 400);
            })

            var province = "";
            var city ="";
            var snippet ="";
            var latitude = 10;
            var longitude = 10;


            $(".enter_position").click(function() {
                dd.biz.map.locate({
                      onSuccess: function (map) {
                          province = map.province;
                          city = map.city;
                          snippet = map.snippet;
                          latitude = map.latitude;
                          longitude = map.longitude;
                          input_site.val(province + city + snippet)
                          Iscomplete();
                      },
                      onFail: function (err) {
                          Iscomplete();
                      }
                  });
            })

            $(".cancelbtn").click(function(event) {
                event.stopPropagation();
                $(".choosedate").animate({
                                             "bottom": "-7rem"
                                         }, 400, function() {
                    $('.datebox').fadeOut();
                })
            })

            $(".datebox").click(function() {
                $(".choosedate").animate({
                         "bottom": "-7rem"
                     }, 400, function() {
                    $('.datebox').fadeOut();
                })
            })
            $('.fleft').delegate("li", "click", function(event){
                event.stopPropagation();
                $(this).addClass('add_bgcolor').find('span').css('color', '#fff').parent().siblings().removeClass('add_bgcolor').find('span').css('color', '#222');
                $('.fright li').eq($(this).index()).show().siblings().hide().find('span').removeClass('add_bgcolor');
            })
            $('.fright').delegate("li span", "click", function(event){
                event.stopPropagation();
                $(this).addClass('add_bgcolor').siblings().removeClass('add_bgcolor');
            })

            $(".checked_btn").click(function() {
                if($(this).prop('checked')) {
                    $(this).css({
                                    "background": "url(/images/btn_press_tongyi.png) no-repeat center",
                                    "background-size": "100%"
                                })

                } else {
                    $(this).css({
                                    "background": "url(/images/btn_defult_tongyi.png) no-repeat center",
                                    "background-size": "100%"
                                })
                }
                Iscomplete();
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

            $('.xieyi_btn').click(function(){
                $(".xieyi").show();
            })
            $(".close_agree").click(function(){
                $(".xieyi").hide();
            })

            $('.submit_btn').click(function() {
                if(flag){
                    // 正常提交信息
                    var order = {
                        "yuyueTime":date_order,
                        "address":input_site.val().trim() + input_addr.val().trim(),
                        "remark":input_desc.val().trim(),
                        "tel":input_telephone.val(),
                        "rid":'${sku.rid}',
                        "name":$("#username").val().trim(),
                        "latitude":latitude,
                        "longitude":longitude,
                        "ori":6
                    };

                    var skuOrder = {
                        "cityCode":'${sku.cityCode}',
                        "openId": localStorage.dingdingUserId,
                        "companyCode" : '${sku.config.corpId}',
                        "order":order
                    }
                    console.log(skuOrder);

                    $.ajax({
                               url:"${basePath}/ulb/sku/order.shtml",
                               type:"POST",
                               data:JSON.stringify(skuOrder),
                               contentType:"application/json; charset=utf-8",
                               dataType:"json",
                               success: function(result){
                                   if(result && result.status== 200){
                                       dd.device.notification.alert({
                                            message: "亲，您的维修单已提交，小哥接单后会主动与您联系，请保持手机畅通",
                                            title: "",//可传空
                                            buttonName: "好的",
                                            onSuccess : function() {
                                                location.href = "${basePath}/dingding/my_order/"+localStorage.dingdingUserId+"/${sku.cityCode}.shtml?corpId="+localStorage.corpId+"&appid=3919";
                                            },
                                            onFail : function(err) {}
                                        });
                                   }else{
                                       layer_tip(result.message);
                                   }
                               },
                               error: function(result){
                                   console.log(result.message);
                               }
                           })

                }else{
                    layer_tip('请完善信息!');
                }
            })
        })

        </script>

        <script src="${basePath}/js/dingding.order.js" baseUrl="${basePath}"></script>
	</head>

	<body>
		<div class="flow border_bottom">
			<div><img src="${basePath}/images/liucheng_1.png" /></div>
		</div>
		<form>
			<div class="order_head border_bottom border_top">
				<div class="head_img"><img src="${basePath}/images/${sku.rid}.png" /></div>
				<div class="choose_num">
					<p class="order_name">维修类目：<span>${sku.name}</span></p>
					<p class="remark">${sku.content?default('无')}</p>
					<div>
						<p class="priceshow"><i>&yen;</i><span>${sku.priceFormat?default('价格面议')}</span> <input type="button" name="" id="" value="服务说明" /></p>
					</div>
				</div>
			</div>
			<ul class="contact_way border_bottom">
				<li class="contact_wayli enter enter_in" data-day-code="0" data-time-code="0"><span>请选择服务时间</span><input type="text" name="" id="date" value="" readonly="readonly" onchange="Iscomplete()"/></li>
				<li class="contact_wayli enter enter_position"><span>位置</span><input type="text" name="" id="site" value="" readonly="readonly" autocomplete="off" oninput="Iscomplete()"/></li>
				<li class="contact_wayli"><span>详细地址</span><textarea data-adaptheight onpropertychange="this.style.posHeight=this.scrollHeight " name="" rows="1" cols="40" placeholder="请输入具体门牌号" id="addr" autocomplete="off" oninput="Iscomplete()"></textarea></li>
				<li class="contact_wayli"><span>称呼</span><input type="text" id="username" value="" autocomplete="off" oninput="Iscomplete()" /></li>
				<li class="contact_wayli"><span>联系电话</span><input type="tel" name="" id="telephone" value="" autocomplete="off" oninput="Iscomplete()"/></li>
				<li class="contact_wayli"><span>描述</span><textarea data-adaptheight onpropertychange="this.style.posHeight=this.scrollHeight " name="" rows="1" cols="40" placeholder="您有什么要求，请告知我们" id="desc" autocomplete="off" oninput="Iscomplete()"></textarea>
					<#--<textarea data-adaptheight onpropertychange="this.style.posHeight=this.scrollHeight " name="" rows="3" cols="" placeholder="您可以将您需要维修的具体情况描述在此处。可以让小哥更好的为您提供服务。"-->
                              <#--id = "desc" autocomplete="off" oninput="Iscomplete()"></textarea>-->
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
					<a href="javascript:;" class="xieyi_btn">《万能小哥企业服务协议书》</a>
				</p>
			</ul>
			<div class="foot border_top"><input  class="submit_btn" type="button" value="立即报修" /></div>
		</form>
		<div class="datebox">
			<div class="choosedate">
				<p class="border_bottom"><span class="cancelbtn fl">取消</span><i>请选择时间</i><span class="affirmbtn fr">确认</span></p>
				<div>
					<ul class="fl fleft">

					</ul>
					<ul class="fr fright">

					</ul>
				</div>
			</div>
		</div>
        <div class="xieyi">
            <div class="agreement_sec">
                <header class="agreement_head">
                    <p>万能小哥企业服务协议书 <span class="close_agree">关闭</span></p>
                </header>
                <div class="agreement_content">
                    <p class="last_p">本协议是用户与万能小哥B2B维修平台（简称"本站"，官网地址：www.wannengxiaoge.com）所有者北京万能小哥信息技术有限公司之间就本站服务等相关事宜所订立的契约，请用户仔细阅读本协议，用户签署或点击"同意并继续"按钮后，本协议即构成对双方有约束力的法律文件。</p>
                    <p class="title">一、用户注册 </p>
                    <p>1.1用户与万能小哥各子公司（以下简称“销售方”）签署经销协议（双方另行签署），提供完整资料，由公司在本站维护用户账户，并由用户使用初始密码登陆其账户，点击同意按钮，修改初始密码，完成注册程序，才能成为本站的正式用户。客户根据经营需求可自行设定分账号。主账号和分账号用户可随时更改密码。用户确认：本协议条款是处理双方权利义务的契约，始终有效，法律另有强制性规定或双方另有特别约定的，依其规定。</p>
                    <p class="last_p">1.2用户签署或在本站点击同意本协议的，即视为用户确认自己具有享受本站服务、下单购物等相应的权利能力和行为能力，能够独立承担法律责任，并且用户将对其在订单中提供的所有信息的真实性负责。
                    </p>
                    <p class="title">二、服务简介</p>
                    <p>2.1本站通过互联网依法为用户提供互联网信息等服务，用户在完全同意本协议及本站规定的情况下，方有权使用本站的相关服务。</p>
                    <p>2.2本站运用自己的操作系统通过国际互联网络为用户提供网络服务。同时，用户必须：</p>
                    <p>a.自行配备上网的所需设备，包括个人电脑、调制解调器或其他必备上网装置。</p>
                    <p>b.自行负担个人上网所支付的与此服务有关的电话费用、网络费用。</p>
                    <p>c.基于本站所提供的网络服务的重要性，用户应同意：提供详尽、准确的客户资料；客户资料变更时，及时、准确提供给万能小哥各子公司更新。</p>
                    <p class="last_p">d.所有发给用户的通告都通过重要页面的公告或电子邮件或常规的信件传送。用户协议条款的修改、服务变更、或其它重要事件的通告都会以此形式进行。</p>

                    <p class="title">三、用户信息</p>
                    <p>3.1用户应自行诚信向北京万能小哥信息技术有限公司提供注册资料，用户同意其提供的注册资料真实、准确、完整、合法有效，用户注册资料如有变动的，应及时更新其注册资料。如果用户提供的注册资料不合法、不真实、不准确、不详尽的，用户需承担因此引起的相应责任及后果，并且本站经北京万能小哥信息技术有限公司通知保留终止用户使用万能小哥各项服务的权利。</p>
                    <p>3.2用户在本站进行浏览、下单购物等活动时，涉及用户真实姓名、通信地址、联系电话、电子邮箱等隐私信息的，本站将予以严格保密，除非得到用户的授权或法律另有规定，本站不会向外界披露用户隐私信息。</p>
                    <p>3.3用户注册成功后，可以根据本站规定改变密码。用户应谨慎合理的保存、使用其用户名和密码，不得提供给其他任何人。用户若发现任何非法使用用户账号或存在安全漏洞的情况，请立即通知本站并向公安机关报案。</p>
                    <p>3.4用户同意，本站拥有通过邮件、短信电话等形式，向在本站用户、收货人发送订单信息、促销活动等告知信息的权利。</p>
                    <p>3.5用户不得将在本站注册获得的账户借给他人使用，否则用户应承担由此产生的全部责任，并与实际使用人承担连带责任。 </p>
                    <p>3.6本站尊重并保护用户的个人隐私权。本站将以高度的勤勉、审慎义务对待用户的资料信息，除在如下情况下，不会将这些信息对外泄露或向第三方提供：</p>
                    <p>a.根据法律的有关规定，或者行政司法机构的要求，向第三方或者行政、司法机构透露；</p>
                    <p>b.为提供用户所要求的产品和服务，而必须向第三方分享用户的个人信息；</p>
                    <p class="last_p">3.7用户需对本站所显示的信息保密，不得向第三方透露。</p>

                    <p class="title">四、商品信息</p>
                    <p class="last_p">本站上的商品价格、数量、是否有货等商品信息随时都有可能发生变动，本站不作特别通知。由于网站上商品信息的数量极其庞大，虽然本站会尽最大努力保证用户所浏览商品信息的准确性，但由于众所周知的互联网技术因素等客观原因存在，本站网页显示的信息可能会有一定的滞后性或差错，对此情形用户知悉并理解。为表述便利，商品和服务简称为"商品"或"货物"。</p>

                    <p class="title">五、订单</p>
                    <p>1.在用户下订单时，请用户仔细确认所购商品的名称、价格、数量、型号、联系地址、电话等信息。</p>
                    <p class="last_p">2.除法律另有强制性规定外，双方约定如下：本站上销售方展示的商品和价格等信息仅仅是要约邀请，用户下单时须填写用户希望购买的商品数量、价款及支付方式、收货人、联系方式、收货地址等内容；系统生成的订单信息是计算机信息系统根据用户填写的内容自动生成的数据，仅是用户向销售方发出的合同要约；销售方收到用户的订单信息后，只有在销售方将用户在订单中订购的商品从仓库实际向用户发出时（以商品出库为标志），方视为用户与销售方之间就实际向用户发出的商品交易成立；如果用户在一份订单里订购了多种商品并且销售方只给用户发出了部分商品时，用户与销售方之间仅就实际向用户发出的商品交易成立；只有在销售方实际向用户发出了订单中订购的其他商品时，用户和销售方之间就订单中该其他已实际向用户发出的商品交易才成立。用户可以随时登录用户在本站注册的账户，查询用户的订单状态。</p>

                    <p class="title">六、配送</p>
                    <p>1.经销协议签订时，用户应书面确认收货人、收货地址及收货印鉴，收货印鉴以供预留。</p>
                    <p>2.销售方将会把商品（货物）送到用户所指定的收货地址。</p>
                    <p>3.因如下情况造成订单延迟或无法配送等，销售方不承担延迟配送的责任：</p>
                    <p>（1）用户提供的信息错误、地址不详细等原因导致的；</p>
                    <p>（2）货物送达后无人签收，导致无法配送或延迟配送的；</p>
                    <p>（3）不可抗力因素导致的，例如：自然灾害、交通戒严、突发战争等。</p>
                    <p class="last_p">4.用户办理自提业务的应完善自提手续。</p>

                    <p class="title">七、货款数据显示</p>
                    <p class="last_p">本站提供用户在销售方的货款余额、欠款、费用、费用转货款等财务数据，数据由销售方账务系统接口发布。用户可在本站进行相关查询，最终货款金额以用户与销售方根据具体签署的对账协议为准。</p>

                    <p class="title">八、费用使用</p>
                    <p>费用为你与厂家共同确认后，且厂家同意支付给用户的与价格有关的相关费用，包括但不限于年度返利和月度返利。</p>
                    <p class="last_p">用户在本站操作时，可选择待兑现费用冲抵订单价格使用。用户使用费用的数据记录将保存于系统，该记录作为对账有效依据。若用户发现系统提供数据有误，请及时联系厂家。</p>

                    <p class="title">九、所有权及知识产权条款</p>
                    <p>1.北京万能小哥科技有限公司是本站的所有者，拥有此网站内容及资源的版权等合法权利，受法律保护，有权不时地对本协议及本站的内容进行修改和公示，无须另行通知用户。在法律允许的最大限度范围内，北京万能小哥科技有限公司对本协议及本站内容拥有解释权。</p>
                    <p>2.除法律另有强制性规定外，未经万能小哥的特别书面许可，任何单位或个人不得以任何方式非法地全部或部分复制、转载、引用、链接、抓取或以其他方式使用本站的信息内容，否则，万能小哥有权追究其法律责任。</p>
                    <p class="last_p">3.本站所刊登的资料信息（诸如文字、图表、标识、按钮图标、图像、声音文件片段、数字下载、数据编辑和软件），均是万能小哥或其内容提供者的财产，受中国和国际版权法的保护。本站上所有内容的汇编是万能小哥的排他财产，受中国和国际版权法的保护。本站上所有软件都是万能小哥或其关联公司或其软件供应商的财产，受中国和国际版权法的保护。</p>

                    <p class="title">十、责任限制及不承诺担保</p>
                    <p>除非另有明确的书面说明，本站及其所包含的或以其它方式通过本站提供给用户的全部信息、内容、材料、产品（包括软件）和服务，均是在"按现状"和"按现有"的基础上提供的。</p>
                    <p>除非另有明确的书面说明，万能小哥不对本站的运营及其包含在本网站上的信息、内容、材料、产品（包括软件）或服务作任何形式的、明示或默示的声明或担保（根据中华人民共和国法律另有规定的以外）。 万能小哥不担保本站所包含的或以其它方式通过本站提供给用户的全部信息、内容、材料、产品（包括软件）和服务、其服务器或从本站发出的电子信件、信息没有病毒或其他有害成分。
                    </p>
                    <p class="last_p">如因不可抗力或其它本站无法控制的原因使本站销售系统崩溃或无法正常使用导致网上交易无法完成或丢失有关的信息、记录等，万能小哥会合理地尽力协助处理善后事宜。</p>

                    <p class="title">十一、协议更新及用户关注义务</p>
                    <p class="last_p">根据国家法律法规变化及网站运营需要，万能小哥有权对本协议条款不时地进行修改，修改后的协议一旦被签署或张贴在本站上即生效，并代替原来的协议。<i>用户可随时登录查阅最新协议；用户有义务不时关注并阅读最新版的协议及网站公告。如用户不同意更新后的协议，应立即停止接受依据本协议提供的本站服务。万能小哥提示用户在使用本站之前阅读本协议及本站的公告。</i> 如果本协议中任何一条被视为废止、无效或因任何理由不可执行，该条应视为可分的且并不影响任何其余条款的有效性和可执行性。 本协议内容中以黑体、加粗、下划线、斜体等方式显著标识的条款，请用户着重阅读。
                    </p>

                    <p class="title">十二、终止服务</p>
                    <p>在下列情况下，本站可以终止服务，同时保留对用户的违法或违约行为追究法律责任的权利：</p>
                    <p>1.用户违反法律法规及本协议相关条款规定；</p>
                    <p>2.本协议条款更新时，用户明示不愿接受新的条款；</p>
                    <p>3.用户对本站实施欺诈、胁迫、恶意攻击等行为；</p>
                    <p class="last_p">4.本站认为需要终止服务的其他情况。</p>

                    <p class="title">十三、法律管辖和适用</p>
                    <p class="last_p">本协议的订立、履行和解释及争议的解决均应适用在中华人民共和国（不包括港澳台地区）适用之有效法律（但不包括其冲突法规则）。 如发生本协议与适用之法律相抵触时，则这些条款将完全按法律规定重新解释，而其它有效条款继续有效。 如各方就本协议内容或其履行发生任何争议，双方应尽力友好协商解决；协商不成时，任何一方均可向万能小哥住所地法院提起诉讼。</p>

                    <p class="title">十四、其他</p>
                    <p class="last_p">用户签署或点击"同意并继续"按钮即视为用户完全接受本协议，在点击之前请用户再次确认已知悉并完全理解本协议的全部内容。</p>
                        <div class="close_agree_wrap"><input type="button" value="返回" class="close_agree"></div>
                </div>
            </div>
        </div>

	</body>

</html>
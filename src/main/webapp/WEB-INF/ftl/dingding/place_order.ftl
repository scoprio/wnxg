<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
		<title>下单</title>
		<link rel="stylesheet" type="text/css" href="${basePath}/css/qifu/reset_h5.css" />
		<link rel="stylesheet" type="text/css" href="${basePath}/css/qifu/place_order.css" />
		<link rel="stylesheet" type="text/css" href="${basePath}/css/qifu/webuploader.css" />

        <script type="text/javascript" src="http://g.alicdn.com/dingding/open-develop/1.6.9/dingtalk.js"></script>
        <script src="${basePath}/js/qifu/jquery-1.11.3.js" type="text/javascript" charset="utf-8"></script>
        <script src="${basePath}/js/qifu/text_self_adaption.js" type="text/javascript" charset="utf-8"></script>
        <script src="${basePath}/js/qifu/webuploader.js" type="text/javascript" charset="utf-8"></script>
        <script src="${basePath}/js/qifu/wnxg_qf.js" type="text/javascript" charset="utf-8"></script>


        <script type="text/javascript">
            alert('${sku.config.agentId}');
            var _config = {"agentId":'${sku.config.agentId}',
                "corpId":'${sku.config.corpId}',
                "timeStamp":'${sku.config.timeStamp}',
                "nonceStr":'${sku.config.nonceStr}',
                "signature":'${sku.config.signature}'
            }

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
                Iscomplete = function(){
                    var form_time = input_time.val().trim();
                    var form_site = $("#site").val()
                    var form_addr = input_addr.val().trim();
                    var form_telephone = input_telephone.val();
                    var form_username = input_username.val().trim();
                    var form_desc = input_desc.val().trim();
                    var checkbox = input_checkbox.prop('checked');

                    if(form_addr && form_desc && form_telephone && form_username && checkbox && form_time){
                        submit_btn.attr("disabled",false)
                        submit_btn.css("background", "#ff943e");
                    }
                    else{
                        submit_btn.attr("disabled",true)
                        submit_btn.css("background", "#ccc");
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
                            result_date += '<li class="add_bgcolor">今天（<span>'+item.date+'</span>)</li>';
                        }
                        else if(i==1){
                            result_date += '<li>明天（<span>'+item.date+'</span>)</li>';
                        }
                        else{
                            result_date += '<li>后天（<span>'+item.date+'</span>)</li>';
                        }
                        result_time_all += '<li>'+result_time+'</li>'
                    })
                    $('.choosedate>div .fleft').html('');
                    $('.choosedate>div .fright').html('');
                    $('.choosedate>div .fleft').prepend(result_date);
                    $('.choosedate>div .fright').prepend(result_time_all);
                }
            }

            $('.affirmbtn').click(function(){
                var index = 0;
                var val_data = '';
                var flag = 0
                $('.choosedate>div .fleft>li').each(function(i,item){
                    if($(item).hasClass('add_bgcolor')){
                        index = i;
                        val_data += $(item).text();
                        return false;
                    }
                })
                $(".choosedate>div .fright>li").eq(index).find('span').each(function(i,item){
                    if($(item).hasClass('add_bgcolor')){
                        val_data += ' '+$(item).text();
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
                                                 "bottom": "-3.36rem"
                                             }, 400, function() {
                        $('.datebox').fadeOut();
                    })
                    Iscomplete();
                }

            })



            $(".enter_in").click(function() {
                $('.datebox').fadeIn()
                $(".choosedate").animate({
                     "bottom": "0"
                 }, 400);
                fill_date();
            })

            $(".enter_position").click(function() {
                alert(11111);
                dd.biz.map.locate({
                      onSuccess: function (result) {
                          var map = JSON.stringify(result);
                          alert(map);
                          /* result 结构 */
                          // {
                          // 	province: 'xxx', // POI所在省会
                          // 		provinceCode: 'xxx', // POI所在省会编码
                          // 	city: 'xxx', // POI所在城市
                          // 	cityCode: 'xxx', // POI所在城市
                          // 	adName: 'xxx', // POI所在区名称
                          // 	adCode: 'xxx', // POI所在区编码
                          // 	distance: 'xxx', // POI与设备位置的距离
                          // 	postCode: 'xxx', // POI的邮编
                          // 	snippet: 'xxx', // POI的街道地址
                          // 	title: 'xxx', // POI的名称
                          // 	latitude: 39.903578, // POI的纬度
                          // 	longitude: 116.473565, // POI的经度
                          // }
                      },
                      onFail: function (err) {
                      }
                  });
//                dd.device.geolocation.get({
//                  targetAccuracy : 1000,
//                  coordinate : 1,
//                  withReGeocode : true,
//                  onSuccess: function(result) {
//                      var location = JSON.stringify(result);
//
//                  },
//                  onFail: function() {
//
//                  }
//              });
            })

            $(".cancelbtn").click(function() {
                $(".choosedate").animate({
                                             "bottom": "-3.36rem"
                                         }, 400, function() {
                    $('.datebox').fadeOut();
                })
            })
            $('.fleft').delegate("li", "click", function(){
                $(this).addClass('add_bgcolor').find('span').css('color', '#fff').parent().siblings().removeClass('add_bgcolor').find('span').css('color', '#222');
                $('.fright li').eq($(this).index()).show().siblings().hide().find('span').removeClass('add_bgcolor');
            })
            $('.fright').delegate("li span", "click", function(){
                $(this).addClass('add_bgcolor').siblings().removeClass('add_bgcolor');
            })

            $(".checked_btn").click(function() {
                if($(this).prop('checked')) {
                    $(this).css({
                                    "background": "url(img/btn_press_tongyi.png) no-repeat center",
                                    "background-size": "100%"
                                })

                } else {
                    $(this).css({
                                    "background": "url(img/btn_defult_tongyi.png) no-repeat center",
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

                $('.submit_feedback input').click(function(argument) {
                    if(change_bg()){
                        // 正常提交信息
                        console.log(feedback_email,feedback_commit);
                        var order = {
                            "yuyueTime":input_time.val().trim(),
                            "address":feedback_email,
                            "remark":"1111",
                            "tel":"111",
                            "rid":222,
                            "name":"111",
                            "latitude":"111",
                            "longitude":"1111",
                            "ori":6
                        };

                        var skuOrder = {
                            "cityCode":"${sku.cityCode}",
                            "openId":dingdingUserInfo.userid,
                            "order":order
                        }


                        $.ajax({
                                   url:"${basePath}/ulb/sku/order.shtml",
                                   type:"POST",
                                   data:JSON.stringify(skuOrder),
                                   contentType:"application/json; charset=utf-8",
                                   dataType:"json",
                                   success: function(result){
                                       if(result && result.status!= 200){

                                       }else{
                                           layer.msg('提交成功！' );

                                       }
                                   }
                               })
                    <#--$.post("${basePath}/dingding/my/feedback.shtml",feedback,function(result){-->
                    <#--alert(result);-->
                    <#--//                                if(result && result.status!= 200){-->
                    <#--//                                }else{-->
                    <#--//                                    layer.msg('提交成功！' );-->
                    <#--//                                }-->
                    <#--},"json");-->

                    }
                    else{
                        alert('请完善信息')
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
				<div class="head_img"><img src="" /></div>
				<div class="choose_num">
					<p class="order_name">维修类目：<span>${sku.name}</span></p>
					<p class="remark">${sku.content?default('无')}</p>
					<div>
						<p class="priceshow"><i>&yen;</i><span>${sku.price?default('0')}</span> <input type="button" name="" id="" value="服务说明" /></p>
					</div>
				</div>
			</div>
			<ul class="contact_way border_bottom">
				<li class="contact_wayli enter enter_in"><span>请选择服务时间</span><input type="text" name="" id="date" value="" disabled="disabled" onchange="Iscomplete()"/></li>
				<li class="contact_wayli enter enter_position"><span>位置</span><input type="hidden" name="" id="site" value="" autocomplete="off" oninput="Iscomplete()"/></li>
				<li class="contact_wayli"><span>详细地址</span><textarea data-adaptheight onpropertychange="this.style.posHeight=this.scrollHeight " name="" rows="1" cols="40" placeholder="请输入具体门牌号" id="addr" autocomplete="off" oninput="Iscomplete()"></textarea></li>
				<li class="contact_wayli"><span>称呼</span><input type="text" id="username" value="" autocomplete="off" oninput="Iscomplete()" /></li>
				<li class="contact_wayli"><span>联系电话</span><input type="tel" name="" id="telephone" value="" autocomplete="off" oninput="Iscomplete()"/></li>
				<li class="problem_desc contact_wayli"><span>请输入问题描述</span>
					<textarea data-adaptheight onpropertychange="this.style.posHeight=this.scrollHeight " name="" rows="3" cols="" placeholder="请输入问题描述"
                              id = "desc" autocomplete="off" oninput="Iscomplete()"></textarea>
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
			<div class="foot border_top"><input  class="submit_btn" type="button" value="立即报修" disabled="disabled"/></div>
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

	</body>

</html>
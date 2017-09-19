<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="initial-scale=1.0,maximum-scale=1.0,minimum-scale=1.0,user-scalable=0,width=device-width" />
        <meta name="format-detection" content="telephone=no" />
        <meta name="format-detection" content="email=no" />
        <meta name="format-detection" content="address=no;">
        <meta name="apple-mobile-web-app-capable" content="yes" />
        <meta name="apple-mobile-web-app-status-bar-style" content="black" />
        <title>预约维修 </title>
		

		<link rel="stylesheet" href="${basePath}/css/qifu/iosSelect.css" />
		<link rel="stylesheet" type="text/css" href="${basePath}/css/qifu/reset_h5.css"/>
		<link rel="stylesheet" type="text/css" href="${basePath}/css/qifu/reservation.css" />
		<link rel="stylesheet" type="text/css" href="${basePath}/css/qifu/place_order.css" />
        <script type="text/javascript" src="http://g.alicdn.com/dingding/open-develop/1.6.9/dingtalk.js"></script>
        <script src="${basePath}/js/qifu/jquery-1.11.3.js" type="text/javascript" charset="utf-8"></script>
        <script src="${basePath}/js/qifu/dingding_comm.js" type="text/javascript" charset="utf-8"></script>
		<!-- <link rel="stylesheet" type="text/css" href="css/webuploader.css" /> -->

	</head>

	<body>
		<section>
			<form action="" method="post">
				<div class="num_msg">
					<p>维修信息</p>
					<p>
						<span>维修内容</span>
						<input type="hidden" name="bank_id" id="bankId4" value="">
						<input id="showBank4" class="please_select" placeholder="请选择" readonly="readonly">
					</p>
						
					<!-- <p>
						<span>维修数量</span>
						<input type="hidden" name="bank_id" id="bankId5" value="">
						<input id="showBank5" class="please_select" placeholder="请选择" readonly="readonly">
					</p> -->
					<p class="load_time" data-day-code="0" data-time-code="0">
						<span>预约时间</span>
						<input type="text" name="" id="" value="" readonly="readonly" class="make_time"/>
					</p>
				</div>
				<div class="ms_msg">
					<textarea name="" rows="" cols="" placeholder="您可以将您需要维修的具体情况描述在此处。可以让小哥更好的为您提供服务。" maxlength="200"></textarea>
					<p class="gptu" style="position: absolute; bottom: 0;right: .28rem; color: #929292;">
						<var style="color: #929292;font-style: normal;">--</var>/200
					</p>
				</div>

				<!--dom结构部分    图片上传-->
				<!-- <div id="uploader" class="wu-example">
					<p class="camera">上传照片（非必传）</p> -->
					<!--用来存放item-->
					<!-- <div class="queueList">
						<div id="filePicker" class="webuploader-container">
						</div>
						<div class="statusBar element-invisible">
							<div id="filePicker2">

							</div>
						</div>
					</div>

					
				</div>
 -->
				<footer class="border_top">
					<input type="button" name="" id="" value="立即预约" class="btn_at_once" />
				</footer>
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
		</section>

	</body>
	<script src="${basePath}/js/qifu/jquery-1.11.3.js" type="text/javascript" charset="utf-8"></script>
	<!-- <script src="js/webuploader.js" type="text/javascript" charset="utf-8"></script> -->
	<!-- <script src="js/wnxg_qf.js" type="text/javascript" charset="utf-8"></script> -->
	<script src="${basePath}/js/qifu/iscroll.js"></script>
	<script src="${basePath}/js/qifu/iosSelect.js"></script>
	<script src="${basePath}/js/qifu/content_data.js" type="text/javascript" charset="utf-8"></script>
	<script src="${basePath}/js/qifu/common.js" type="text/javascript" charset="utf-8"></script>
	<script>

        $(function() {
			<#--alert('${reservation.usefulTime}');-->
			// 判断信息是否填写完整
            var dom_content = $('#showBank4');//服务内容的元素
            var dom_time2 = $('.load_time input');//预约时间的元素
            var dom_textarea = $('.ms_msg textarea');//具体描述的元素
            var time_val = '';//预约时间
            var content_val = '';//服务内容
            var content_id = '';//服务内容的 id
            var textarea_val = '';//具体描述
            var date_order = '';//预约日期+时间
            function Isfill2(){
                time_val = dom_time2.val();
                content_val = dom_content.val();
                textarea_val = dom_textarea.val();
                if(time_val && content_val && textarea_val){
                    $('.btn_at_once').css('background','#ff943e');
                    return true;
                }
                else{
                    $('.btn_at_once').css('background','#ccc');
                    return false;
                }

            }

            var counter = $(".ms_msg textarea").val().length; //获取文本域的字符串长度
            $(".gptu var").text(counter);

            $(document).keyup(function() {
                var text = $(".ms_msg textarea").val();
                var counter = text.length;
                $(".gptu var").text(counter); //每次减去字符长度
                if(counter >= 190) {
                    $(".gptu var").css("color", "red")
                } else {
                    $(".gptu var").css("color", "#999")
                }
                Isfill2()
            });

            $(".camera_btn").click(function() {
                $(this).hide();
                $(".uploadimg").show();
            })

            $(".change").click(function() {
                $(this).addClass("change_bg").siblings().removeClass("change_bg");
                $(this).css("border-color", "#FB870D").siblings().css("border-color", "#D8D8D8");
            })

//预约服务时间
            function fill_date(){
                var result_date = '';
                var result_time = '';
                var result_time_all = '';
                var date_data = JSON.parse('${reservation.usefulTime}');

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
                    $('.load_time input').val(val_data);
                    $(".choosedate").animate({
                                                 "bottom": "-7rem"
                                             }, 400, function() {
                        $('.datebox').fadeOut();
                    })
                    $('.load_time').attr('data-day-code',index);
                    $('.load_time').attr('data-time-code',index_time);
                    Isfill2()
                }
                else{
                    layer_tip('请选择时间点')
                }

            })
            $(".load_time").click(function(event) {
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




            // 提交按钮
            $('.btn_at_once').click(function(event) {
                if(Isfill2()){
                    console.log(date_order,content_val,textarea_val,content_id)

                    var order = {
                        "record_id": '${reservation.recordId}',
                        "repair_id": content_id,
                        "repair_name": content_val,
                        "service_id": 2,
                        "yuyue": date_order,
                        "package_id": 1,
                        "remark": textarea_val
                    }

                    $.ajax({
                               url:"${basePath}/ulb/qf/repair.shtml",
                               type:"POST",
                               data:JSON.stringify(order),
                               contentType:"application/json; charset=utf-8",
                               dataType:"json",
                               success: function(result){
                                   if(result && result.status== 200){
                                       layer_tip(result.message,function () {
                                           location.href = "${basePath}/ulb/my_qifu/${reservation.recordId}.shtml?corpId="+localStorage.corpId+"&appid="+localStorage.appId;
                                       });
                                   }else{

                                   }
                               },
                               error: function(result){

                               }
                           })

                }
                else{
                    layer_tip('请填写完整信息');
                }
            });



            var showBankDom4 = document.querySelector('#showBank4');
            var bankIdDom4 = document.querySelector('#bankId4');

            showBankDom4.addEventListener('click', function() {
                var bankId4 = showBankDom4.dataset['id'];
                var bankName4 = showBankDom4.dataset['value'];

                var bankSelect4 = new IosSelect(1, [data4], {
                    title: '预约时间选择',
                    oneLevelId: bankId4,
                    itemHeight: 0.7,
                    headerHeight: 0.88,
                    cssUnit: 'rem',
                    callback: function(selectOneObj) {
                        bankIdDom4.value = selectOneObj.id;
                        showBankDom4.value = selectOneObj.value;
                        showBankDom4.dataset['id'] = selectOneObj.id;
                        content_id = selectOneObj.id;
                        showBankDom4.dataset['value'] = selectOneObj.value;
                        Isfill2()
                    }
                });
            });

        })
	</script>
</html>


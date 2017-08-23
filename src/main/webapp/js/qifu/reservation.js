
$(function() {
// 判断信息是否填写完整
    var dom_content = $('#showBank4');//服务内容的元素
    var dom_time2 = $('.load_time input');//预约时间的元素
    var dom_textarea = $('.ms_msg textarea');//具体描述的元素
    var time_val = '';//预约时间
    var content_val = '';//服务内容
    var content_id = '';//服务内容的 id
    var textarea_val = '';//具体描述
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
            $('.load_time input').val(val_data);
            $(".choosedate").animate({
                "bottom": "-3.36rem"
            }, 400, function() {
                $('.datebox').fadeOut();
            })
            Isfill2()
        }
        else{
            layer_tip('请选择时间点')
        }
        
    })
    $(".load_time").click(function() {
        $('.datebox').fadeIn()
        $(".choosedate").animate({
            "bottom": "0"
        }, 400);
        fill_date();
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




    // 提交按钮
    $('.btn_at_once').click(function(event) {
    	if(Isfill2()){
    		console.log(time_val,content_val,textarea_val,content_id)

            var order = {
                "record_id": '${reservation.recordId}',
                "repair_id": content_id,
                "repair_name": content_val,
                "service_id": 2,
                "yuyue": time_val,
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
                               alert(result.message);
                               location.href = "${basePath}/dingding/my_order/"+dingdingUserInfo.userid+"/${sku.cityCode}.shtml";
                           }else{

                           }
                       },
                       error: function(result){

                       }
                   })

                // "yuyueTime":input_time.val().trim(),
                // "address":input_site.val().trim() + input_addr.val().trim(),
                // "remark":input_desc.val().trim(),
                // "tel":input_telephone.val(),
                // "rid":'${sku.rid}',
                // "name":'${sku.name}',
                // "latitude":latitude,
                // "longitude":longitude,
                // "ori":6
    	}
    	else{
    		alert('请填写完整信息')
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
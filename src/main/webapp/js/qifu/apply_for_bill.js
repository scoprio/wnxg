$(function() {
	$(".pitch").click(function() {		
		$(this).toggleClass('pitch_on');		
		if($(this).is($('.pitch_on'))){
			$(this).attr("checked","checked");
			
		}else{
			$(this).attr("checked",false)
		}
		bill()
	});
	var dom_title =$('.bill_title');
	var dom_number =$('.bill_num');
	var dom_man =$('.bill_man');
	var dom_tel =$('.bill_tel');
	var dom_place =$('.bill_place');
	var applyTitle ='' ;//发票抬头
	var applyNum = '';//企业税号
	var applyMan = '' ;//联系人
	var applyTel = '';//联系电话
	var applyPlace = '';//地址
	var applyBill = []
	bill=function() {
		var pitch = false;
		applyTitle = dom_title.val();//发票抬头
		applyNum = dom_number.val();//企业税号
		applyMan =  dom_man.val();//联系人
		applyTel = dom_tel.val();//联系电话
		applyPlace = dom_place.val();//地址
		applyBill = []
		$('.pitch').each(function(i,item){
			if($(item).is(':checked')){
				pitch = true;
				return false;
			}

		})
		if(applyTitle && applyNum && applyMan && applyTel && applyPlace && pitch){
			$('.submit_box input').css('background','#ff943e');
			return true;
		}
		else{
			$('.submit_box input').css('background','#ccc');
			return false
		}
		console.log(applyTitle,applyNum,applyMan,applyTel,applyPlace,pitch)
	
		
	};

	$('.submit_box input').click(function() {
		if(bill()){
			$('.pitch').each(function(i,item){
				if($(item).is(':checked')){
					applyBill.push($(item).parent().siblings().text())
				}

			})
			console.log(applyBill)
		}
		else{
			alert('请完善信息后再提交')
		}
	});
	$(".bill_tel").blur(function() {
		var tel_yz = $(".bill_tel").val();
		reg = /^1[3|4|5|7|8]\d{9}$/;
		if(!reg.test(tel_yz)) {
			$(this).val('')
			alert("请输入正确的手机号")
		} else {
			console.log(1111)
		}
		bill()
	})

})
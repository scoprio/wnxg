	
	var service_time = $('#showBank2');
	var com_name = $('#company_name');
	var dom_people = $('.tel_man');
	var phone_num = $('.tel_num');
    var dom_place = $('#show_contact');
	var now_place = $('.place_now');
	// var changeBack = null
	var checked_now = $('.checked_btn');
	var unit_price = $('.unit_price').text();
	var all_price = 0;
	var valueBer2 = 0;
	function IsPull(){
		var sertime = service_time.val();
		var coname = com_name.val();
		console.log(coname);
		var dompeo = dom_people.val();
		var telnum = phone_num.val();
		var domace = dom_place.val();
		var placexx = now_place.val();
		// var back_active = changeBack?changeBack.val():'';
		var selckecked = checked_now.prop('checked');
		console.log(sertime,coname,dompeo,telnum,placexx,selckecked)
		if(coname && dompeo && telnum && placexx && selckecked  && sertime  && domace){
			$('.pay_now').css('background','#ff943e');
			return true;
		}
		else{
			$('.pay_now').css('background','#ccc');
			return false;
		}
	}

$(function() {

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
		IsPull()
	})



	var showBankDom2 = document.querySelector('#showBank2');
	var bankIdDom2 = document.querySelector('#bankId2');

	showBankDom2.addEventListener('click', function() {
		var bankId2 = showBankDom2.dataset['id'];
		var bankName2 = showBankDom2.dataset['value'];

		var bankSelect2 = new IosSelect(1, [data2], {
			title: '服务时间选择',
			oneLevelId: bankId2,
			itemHeight: 0.7,
			headerHeight: 0.88,
			cssUnit: 'rem',
			callback: function(selectOneObj) {
				bankIdDom2.value = selectOneObj.value;
				showBankDom2.value = selectOneObj.value;
				showBankDom2.dataset['id'] = selectOneObj.id;
				showBankDom2.dataset['value'] = selectOneObj.value;
				valueBer2 = bankIdDom2.value.replace(/[^0-9]/ig, "")
				document.getElementsByClassName('hide_input2')[0].value = valueBer2;
				all_price = 498 * valueBer2;
				$('.all_price').text(all_price+'元')
				IsPull()
			}
		});
	});
	$(".tel_num").blur(function() {
		var tel_yz = $(".tel_num").val();
		reg = /^1[3|4|5|7|8]\d{9}$/;
		if(!reg.test(tel_yz)) {
			$(".tel_num").val('')
			layer_tip("请输入正确的手机号");
			IsPull()
		} else {
			console.log(1111)
		}
	})


	$('.agreement').click(function(){
		$(".xieyi").show();
	})
	
	$(".close_agree").click(function() {
		$(".xieyi").hide();
	})

	$('#showBank2').click(function() {
		if($("#showBank2").val() == '请选择') {
			$("#showBank2").css('background', 'none')
		}
	})
	$('#showBank').click(function() {
		if($("#showBank").val() == '请选择') {
			$("#showBank").css('background', 'none')
		}
	});
	
	

})
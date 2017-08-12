$(function(){
	$(".change").click(function(){
		$(this).addClass("change_bg").siblings().removeClass("change_bg");
	})
	$(".checked_btn").click(function(){
		if($(this).prop('checked')) {
					$(this).css({"background":"url(img/btn_press_tongyi.png) no-repeat center","background-size":"100%"})
					$(".pay_now").css("background","#FB870D");
					
				} else {
					$(this).css({"background":"url(img/btn_defult_tongyi.png) no-repeat center","background-size":"100%"})
					$(".pay_now").css("background","#ccc");
					console.log(888)
				}
	})
	
	
	
	var showBankDom2 = document.querySelector('#showBank2');
		var bankIdDom2 = document.querySelector('#bankId2');

		showBankDom2.addEventListener('click', function() {
			var bankId2 = showBankDom2.dataset['id'];
			var bankName2 = showBankDom2.dataset['value'];

			var bankSelect2 = new IosSelect(1, [data2], {
				title: '服务台数选择',
				oneLevelId: bankId2,
				itemHeight: 0.7,
				headerHeight: 0.88,
				cssUnit: 'rem',
				callback: function(selectOneObj) {
					bankIdDom2.value = selectOneObj.value;
					showBankDom2.value = selectOneObj.value;
					showBankDom2.dataset['id'] = selectOneObj.id;
					showBankDom2.dataset['value'] = selectOneObj.value;
					var valueBer2 = bankIdDom2.value.replace(/[^0-9]/ig,"")
			        document.getElementsByClassName('hide_input')[0].value = valueBer2;
				}
			});
		});
		
		var showBankDom = document.querySelector('#showBank');
		var bankIdDom = document.querySelector('#bankId');

		showBankDom.addEventListener('click', function() {
			var bankId = showBankDom.dataset['id'];
			var bankName = showBankDom.dataset['value'];

			var bankSelect = new IosSelect(1, [data], {
				title: '服务时间选择',
				oneLevelId: bankId,
				itemHeight: 0.7,
				headerHeight: 0.88,
				cssUnit: 'rem',
				callback: function(selectOneObj) {
					bankIdDom.value = selectOneObj.value;
					showBankDom.value = selectOneObj.value;
					showBankDom.dataset['id'] = selectOneObj.id;
					showBankDom.dataset['value'] = selectOneObj.value;
					var valueBer1 = bankIdDom.value.replace(/[^0-9]/ig,"")
			        document.getElementsByClassName('hide_input2')[0].value = valueBer1;
				}
			});
		});
		$(".tel_yz").blur(function(){
			var tel_yz = $(".tel_yz").val();
			reg = /^1[3|4|5|7|8]\d{9}$/;
			if(!reg.test(tel_yz)){
				alert("请输入正确的手机号")
			}else{
				console.log(1111)
			}
		})
		function agreement(){
			$(".xieyi").show();
		}
		$(".close_agree").click(function(){
			$(".xieyi").hide();
		})

	

	$('#showBank2').click(function(){
		if($("#showBank2").val() == '请选择'){
		$("#showBank2").css('background','none')
	}
	})
	$('#showBank').click(function(){
		if($("#showBank").val() == '请选择'){
		$("#showBank").css('background','none')
	}
	})
	
})

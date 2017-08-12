$(function() {
	$(".checked_btn").click(function() {
		if($(this).prop('checked')) {
			$(this).css({
				"background": "url(img/btn_press_tongyi.png) no-repeat center",
				"background-size": "100%"
			})
			$(".pay_now").css("background", "#FB870D");

		} else {
			$(this).css({
				"background": "url(img/btn_defult_tongyi.png) no-repeat center",
				"background-size": "100%"
			})
			$(".pay_now").css("background", "#ccc");
			console.log(888)
		}
	})
})
$(function() {
	$('#showBank3').click(function() {
		if($("#showBank3").val() == '请选择') {
			$("#showBank3").css('background', 'none')
		}
	})
	$('#showBank4').click(function() {
		if($("#showBank4").val() == '请选择') {
			$("#showBank4").css('background', 'none')
		}
	})

})
window.onload = function() {
	var showBankDom3 = document.querySelector('#showBank3');
	var bankIdDom3 = document.querySelector('#bankId3');

	showBankDom3.addEventListener('click', function() {
		var bankId3 = showBankDom3.dataset['id'];
		var bankName3 = showBankDom3.dataset['value'];

		var bankSelect3 = new IosSelect(1, [data], {
			title: '服务时间选择',
			oneLevelId: bankId3,
			itemHeight: 0.7,
			headerHeight: 0.88,
			cssUnit: 'rem',
			callback: function(selectOneObj) {
				bankIdDom3.value = selectOneObj.id;
				showBankDom3.value = selectOneObj.value;
				showBankDom3.dataset['id'] = selectOneObj.id;
				showBankDom3.dataset['value'] = selectOneObj.value;
			}
		});
	});
	var showBankDom4 = document.querySelector('#showBank4');
	var bankIdDom4 = document.querySelector('#bankId4');

	showBankDom4.addEventListener('click', function() {
		var bankId4 = showBankDom4.dataset['id'];
		var bankName4 = showBankDom4.dataset['value'];

		var bankSelect4 = new IosSelect(1, [num], {
			title: '服务台数选择',
			oneLevelId: bankId4,
			itemHeight: 0.7,
			headerHeight: 0.88,
			cssUnit: 'rem',
			callback: function(selectOneObj) {
				bankIdDom4.value = selectOneObj.id;
				showBankDom4.value = selectOneObj.value;
				showBankDom4.dataset['id'] = selectOneObj.id;
				showBankDom4.dataset['value'] = selectOneObj.value;
			}
		});
	});
}
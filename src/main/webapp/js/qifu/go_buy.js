
var dom_num = $('#showBank3');
var dom_time = $('#showBank4');
var dom_check = $('#checked_btn');
function Isfill(){
	var num_val = dom_num.val();
	var time_val = dom_time.val();
	var check_val = dom_check.prop('checked');
	console.log(num_val,time_val,check_val)
	if(num_val && time_val && check_val){
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
				"background": "url(img/btn_press_tongyi.png) no-repeat center",
				"background-size": "100%"
			})
			
		} else {
			$(this).css({
				"background": "url(img/btn_defult_tongyi.png) no-repeat center",
				"background-size": "100%"
			})
			
		}
		Isfill()
	})

	
	
	$('.agreement').click(function(){
		$(".xieyi").show();
	})
	
	$(".close_agree").click(function() {
		$(".xieyi").hide();
	})

	// 支付按钮
	$('.pay_now').click(function() {
		if(Isfill()){
			// 正常提交数据、
		}
		else{
			alert('请完善信息')
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
				Isfill()
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
				Isfill()
			}
		});
	});
}
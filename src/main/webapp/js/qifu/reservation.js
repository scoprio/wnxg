$(function() {
	var counter = $(".ms_msg textarea").val().length; //获取文本域的字符串长度

	$(".gptu var").text(counter);

	$(document).keyup(function() {
		var text = $(".ms_msg textarea").val();
		var counter = text.length;
		$(".gptu var").text(counter); //每次减去字符长度
		if(counter >= 190) {
			$(".gptu var").css("color", "red")
		}else{
			$(".gptu var").css("color", "#999")
		}
	});
	
	$(".camera_btn").click(function(){
		$(this).hide();
		$(".uploadimg").show();
	})
	
	$(".change").click(function(){
		$(this).addClass("change_bg").siblings().removeClass("change_bg");
		$(this).css("border-color","#FB870D").siblings().css("border-color","#D8D8D8");
	})

})
$(function(){
	$('#showBank5').click(function(){
		if($("#showBank5").val() == '请选择'){
		$("#showBank5").css('background','none')
	}
	})
	$('#showBank6').click(function(){
		if($("#showBank6").val() == '请选择'){
		$("#showBank6").css('background','none')
	}
	})
	
	var showBankDom5 = document.querySelector('#showBank5');
    var bankIdDom5 = document.querySelector('#bankId5');

    showBankDom5.addEventListener('click', function () {
        var bankId5 = showBankDom5.dataset['id'];
        var bankName5 = showBankDom5.dataset['value'];

        var bankSelect5 = new IosSelect(1, 
            [data5],
            {
                title: '维修数量选择',
                oneLevelId: bankId5,
                itemHeight: 0.7,
                headerHeight: 0.88,
                cssUnit: 'rem',
                callback: function (selectOneObj) {
                    bankIdDom5.value = selectOneObj.id;
                    showBankDom5.value = selectOneObj.value;
                    showBankDom5.dataset['id'] = selectOneObj.id;
                    showBankDom5.dataset['value'] = selectOneObj.value;
                }
        });
    });
     var showBankDom6 = document.querySelector('#showBank6');
    var bankIdDom6 = document.querySelector('#bankId6');

    showBankDom6.addEventListener('click', function () {
        var bankId6 = showBankDom6.dataset['id'];
        var bankName6 = showBankDom6.dataset['value'];

        var bankSelect6 = new IosSelect(1, 
            [data6],
            {
                title: '预约时间选择',
                oneLevelId: bankId6,
                itemHeight: 0.7,
                headerHeight: 0.88,
                cssUnit: 'rem',
                callback: function (selectOneObj) {
                    bankIdDom6.value = selectOneObj.id;
                    showBankDom6.value = selectOneObj.value;
                    showBankDom6.dataset['id'] = selectOneObj.id;
                    showBankDom6.dataset['value'] = selectOneObj.value;
                }
        });
    });
})


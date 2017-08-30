$(function() {
	$(".stars img").click(function() {
		$(".stars img").attr("src", "/images/content_icon_default_xing.png");
		var n = $(this).index();
		for(var i = 0; i <= n; i++) {
			$(".stars img").eq(i).attr("src", "/images/content_icon_xing.png");
		}
		var m = n + 1;
		$("#eva").html(m + "星");
		$("#grade").val(m);
		// if(m == 1) {
		// 	document.getElementById("grade").value = 1;
		// } else if(m == 2 || m == 3 || m == 4) {
		// 	document.getElementById("grade").value = 2;
		// } else if(m == 5) {
		// 	document.getElementById("grade").value = 3;
		// }
		// $("#service_eva").addClass("show");
		// $("#sharp").css("display", "block");
		
//		$("textarea").removeAttr("readonly");
	})
	var eva = ["差", "一般", "好", "很好", "非常好"];
	//服务质量
	$(".service img").click(function() {
		$(".service img").attr("src", "/images/content_icon_default_xiaolian.png");
		var n = $(this).index();
		for(var i = 0; i <= n; i++) {
			$(".service img").eq(i).attr("src", "/images/content_icon_pressed_xiaolian.png");
		}
		$(this).parent().next().html(eva[n]);
		document.getElementById("fwzl").value = eva[n];
		$("#last").css("color", "#fb870d");
	})
	//服务速度
	$(".speed img").click(function() {
		$(".speed img").attr("src", "/images/content_icon_default_xiaolian.png");
		var n = $(this).index();
		for(var i = 0; i <= n; i++) {
			$(".speed img").eq(i).attr("src", "/images/content_icon_pressed_xiaolian.png");
		}
		$(this).parent().next().html(eva[n]);
		document.getElementById("fwsd").value = eva[n];
		$("#last").css("color", "#fb870d");
	})
	//服务态度
	$(".manner img").click(function() {
		$(".manner img").attr("src", "/images/content_icon_default_xiaolian.png");
		var n = $(this).index();
		for(var i = 0; i <= n; i++) {
			$(".manner img").eq(i).attr("src", "/images/content_icon_pressed_xiaolian.png");
		}
		$(this).parent().next().html(eva[n]);
		document.getElementById("fwtd").value = eva[n];
		$("#last").css("color", "#fb870d");
	})
	
	
	//监测到190个字时候变色
	var counter = $("textarea").val().length; //获取文本域的字符串长度

	$(".gptu var").text(counter);

	$(document).keyup(function() {
		var text = $("textarea").val();
		var counter = text.length;
		$(".gptu var").text(counter); //每次减去字符长度
		if(counter >= 190) {
			$(".gptu var").css("color", "red")
		} else {
			$(".gptu var").css("color", "#999")
		}
	});
	
	    function check(){
	        var grade = document.getElementById("grade").value;
	        // var fwzl = document.getElementById("fwzl").value;
	        // var fwsd = document.getElementById("fwsd").value;
	        // var fwtd = document.getElementById("fwtd").value;
	        var msg = $('#msg').val().trim(); 
	        if(grade == ''){
	            alert('请选择总体评价的星级');
	            return false;
	        }else if(msg == ''){
	            alert('请输入评价信息');
	            return false;        
	        }
	        else{
	        	return true;
	        }


			
	    };
	$('#last input').click(function(){
		if(check()){

			if($('#orderId').val()){
				var comment = {
					"oid": $('#orderId').val(),
					"grade" : $("#grade").val(),
					"remark":$("#msg").val(),
					"cityCode":localStorage.current_city_code
				}


				$.ajax({
				   url:"/ulb/sku/comment.shtml",
				   type:"POST",
				   data:JSON.stringify(comment),
				   contentType:"application/json; charset=utf-8",
				   dataType:"json",
				   success: function(result){
					   if(result && result.status== 200){
						   layer_tip(result.message,function () {
							   location.href = "/ulb/sku/order/"+$('#orderId').val() +"/"+localStorage.current_city_code+".shtml";
						   });
					   }else{

					   }
				   },
				   error: function(result){

				   }
			   })
			}else{
				var comment = {
					"companyCode": localStorage.corpId,
					"grade" : $("#grade").val(),
					"content":$("#msg").val(),
					"serviceId":2
				}


				$.ajax({
						   url:"/ulb/qf/comment.shtml",
						   type:"POST",
						   data:JSON.stringify(comment),
						   contentType:"application/json; charset=utf-8",
						   dataType:"json",
						   success: function(result){
							   if(result && result.status== 200){
								   layer_tip(result.message,function () {
									   location.href = "/dingding/qyd.shtml?corpid="+localStorage.corpId +"&isAdmin=true&cityCode="+localStorage.current_city_code;
								   });
							   }else{

							   }
						   },
						   error: function(result){

						   }
					   })
			}

		}

	})
})
$(function() {
	$(".stars img").click(function() {
		$(".stars img").attr("src", "img/content_icon_default_xing.png");
		var n = $(this).index();
		for(var i = 0; i <= n; i++) {
			$(".stars img").eq(i).attr("src", "img/content_icon_xing.png");
		}
		var m = n + 1;
		$("#eva").html(m + "星");
		if(m == 1) {
			document.getElementById("grade").value = 1;
		} else if(m == 2 || m == 3 || m == 4) {
			document.getElementById("grade").value = 2;
		} else if(m == 5) {
			document.getElementById("grade").value = 3;
		}
		$("#service_eva").addClass("show");
		$("#sharp").css("display", "block");
		
//		$("textarea").removeAttr("readonly");
	})
	var eva = ["差", "一般", "好", "很好", "非常好"];
	//服务质量
	$(".service img").click(function() {
		$(".service img").attr("src", "img/content_icon_default_xiaolian.png");
		var n = $(this).index();
		for(var i = 0; i <= n; i++) {
			$(".service img").eq(i).attr("src", "img/content_icon_pressed_xiaolian.png");
		}
		$(this).parent().next().html(eva[n]);
		document.getElementById("fwzl").value = eva[n];
		$("#last").css("color", "#fb870d");
	})
	//服务速度
	$(".speed img").click(function() {
		$(".speed img").attr("src", "img/content_icon_default_xiaolian.png");
		var n = $(this).index();
		for(var i = 0; i <= n; i++) {
			$(".speed img").eq(i).attr("src", "img/content_icon_pressed_xiaolian.png");
		}
		$(this).parent().next().html(eva[n]);
		document.getElementById("fwsd").value = eva[n];
		$("#last").css("color", "#fb870d");
	})
	//服务态度
	$(".manner img").click(function() {
		$(".manner img").attr("src", "img/content_icon_default_xiaolian.png");
		var n = $(this).index();
		for(var i = 0; i <= n; i++) {
			$(".manner img").eq(i).attr("src", "img/content_icon_pressed_xiaolian.png");
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
	        var fwzl = document.getElementById("fwzl").value;
	        var fwsd = document.getElementById("fwsd").value;
	        var fwtd = document.getElementById("fwtd").value;
	        var msg = $('#msg').val().trim(); 
	        if(grade == ''){
	            alert('请选择总体评价的星级');
	            return false;
	        }else if(fwzl == ''){
	            alert('请选择服务质量星级');
	            return false;
	        }else if(fwsd == ''){
	            alert('请选择服务速度星级');
	            return false;     
	        }else if(fwtd == ''){
	            alert('请选择服务态度星级');
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
		var s = check()
		console.log(s)
	})
})
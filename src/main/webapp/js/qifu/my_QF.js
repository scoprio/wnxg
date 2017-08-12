$(function() {
	$(".btn_go_on").click(function() {
		window.location.href = "go_buy.html";
	})
	$(".btn_subscribe").click(function() {
		window.location.href = "reservation.html";
	})
	$(".recordbox").click(function() {
		window.location.href = "service_detail.html";
	})
	//联系客服
	$(".kf").click(function() {
		$(".mark2").show();
	})
	$(".mark2_p span").click(function(){
		$(".mark2").hide();
	})
	//维修完成
	$(".wc").click(function() {
		$(".mark1").show();
	})
	//取消按钮
	$(".mark1_p span:first-child").click(function(){
		$(".mark1").hide();
	})
//	确认按钮
	$(".mark1_p span:last-child").click(function(){
		$(".mark1").hide();
	})
	
	$(".ywc").click(function(){
		location.href = "comment.html";
	})
})
$(function(){
	$('.qyd_title li').click(function(){
		$(this).find('a').addClass('change_color').parents().siblings().find('a').removeClass('change_color');
		$('.qyd_content .content_right').eq($(this).index()).show().siblings().hide();
	})

})
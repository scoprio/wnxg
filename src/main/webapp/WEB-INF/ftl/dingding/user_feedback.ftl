<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
        <meta name="format-detection" content="telephone=no" />
        <meta name="format-detection" content="email=no" />
        <meta name="format-detection" content="address=no;">
        <meta name="apple-mobile-web-app-capable" content="yes" />
        <meta name="apple-mobile-web-app-status-bar-style" content="black" />
		<title>用户反馈</title>
		<link rel="stylesheet" type="text/css" href="${basePath}/css/qifu/reset_h5.css" />
		<link rel="stylesheet" type="text/css" href="${basePath}/css/qifu/user_feedback.css" />
        <script type="text/javascript" src="http://g.alicdn.com/dingding/open-develop/1.6.9/dingtalk.js"></script>
        <script src="${basePath}/js/qifu/jquery-1.11.3.js" type="text/javascript" charset="utf-8"></script>
        <script src="${basePath}/js/qifu/dingding_comm.js" type="text/javascript" charset="utf-8"></script>
        <script src="${basePath}/js/dingding.order.js" baseUrl="${basePath}"></script>
	</head>

	<body>
		<div>
			<form action="" method="post">
				<p class="headline">信息反馈及宝贵建议</p>
				<div class="textarea"><textarea name="" rows="" cols="" placeholder="如对我们有任何建议或疑问，都可以畅所欲言。" oninput = "change_bg()"></textarea></div>
				<p class="headline">邮箱</p>
				<div class="email"><input type="email" name="" id="" value="" placeholder="请输入您的邮箱，方便我们与您联系" oninput = "change_bg()"/></div>
				<div class="submit_feedback"><input type="button" id="" value="提交" /></div>
			</form>

			<p class="guidance_p">我们将在一个工作日内回复您的消息</p>
			<p class="guidance_p">也可以查看
				<a href="${basePath}/dingding/help/newbie_guide.shtml">新手引导</a>
			</p>
		</div>

		<script src="${basePath}/js/qifu/jquery-1.11.3.js" type="text/javascript" charset="utf-8"></script>
        <script  src="${basePath}/js/qifu/common.js" type="text/javascript" charset="utf-8"></script>
		<script type="text/javascript">

					// $('.submit_feedback input').click(function(){
					// 	var tel_yz = $(".email input").val();
					// 	reg = /^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/;
					// 	if($('.textarea textarea').val() == '' && $('.email input').val() == ''){
					// 		console.log($('.textarea textarea').val())
					// 		alert("请填写您要反馈的内容和正确的邮箱");
					// 	}else if(!reg.test(tel_yz)){
					// 		alert("请输入正确的邮箱")
					// 	}else if($('.textarea textarea').val() != '' && reg.test(tel_yz)){
					// 		$(this).css("background","#ff943e")
					// 		alert("感谢您的反馈！")
					// 	}

					// })
					var dom_commit = $('.textarea textarea')
					var dom_feedback_email = $(".email input");
					var feedback_commit = '';
					var feedback_email = '';
					function change_bg() {
						feedback_commit = dom_commit.val();
						feedback_email = dom_feedback_email.val();
						if(feedback_commit && feedback_email){
							$('.submit_feedback input').css('background','#ff943e')
							return true;
						}
						else{
							$('.submit_feedback input').css('background','#ccc')
							return false;
						}
						// if($('.textarea textarea').val() == ''){
						// 	alert("请填写您要反馈的内容")
						// }else if(!reg.test(tel_yz)){
							
						// }else if($('.textarea textarea').val() == '' && $('.email input').val() == ''){
						// 	console.log($('.textarea textarea').val())
						// 	alert("请填写您要反馈的内容和正确的邮箱");
						// }else if($('.textarea textarea').val() != '' && reg.test(tel_yz)){
						// 	$('.submit_feedback input').css("background","#ff943e")
						// }
					}
					$(".email input").blur(function() {
						var email_yz = $(".email input").val();
						var reg = /^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/;
						if(!reg.test(email_yz)) {
							$(this).val('')
                            layer_tip("请输入正确的邮箱")
						} else {
							console.log(1111)
						}
						change_bg()
					})
					$('.submit_feedback input').click(function(argument) {
						if(change_bg()){
							// 正常提交信息
							console.log(feedback_email,feedback_commit);
							var feedback = {
								"commit":feedback_commit,
								"email":feedback_email
							}


                            $.ajax({
							   url:"${basePath}/dingding/my/feedback.shtml",
							   type:"POST",
							   data:JSON.stringify(feedback),
							   contentType:"application/json; charset=utf-8",
							   dataType:"json",
							   success: function (data, status, xhr) {

                                   if(data.status && data.status ==200){
                                       layer_tip("感谢您的反馈，对于您的意见和建议，我们将认真对待，并视情况予以回复！",function () {
                                           location.href = "${basePath}/dingding/help.shtml";
                                       })
								   }
							   },
							   error: function () {
                                   layer_tip("An error has occured!!!");
							   }

							 })

						}
						else{
                            layer_tip('请完善信息')
						}
					})

				</script>

	</body>

</html>
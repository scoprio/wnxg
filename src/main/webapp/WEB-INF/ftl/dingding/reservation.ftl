<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="initial-scale=1.0,maximum-scale=1.0,minimum-scale=1.0,user-scalable=0,width=device-width" />
		<title>预约维修 </title>
		<link rel="stylesheet" href="${basePath}/css/qifu/iosSelect.css" />
		<link rel="stylesheet" type="text/css" href="${basePath}/css/qifu/reset_h5.css"/>
		<link rel="stylesheet" type="text/css" href="${basePath}/css/qifu/reservation.css" />
		<link rel="stylesheet" type="text/css" href="${basePath}/css/qifu/webuploader.css" />

	</head>

	<body>
		<section>
			<form action="" method="post">
				<div class="num_msg">
					<p>维修信息</p>
					<p>
						<span>维修内容</span>
						<input type="hidden" name="bank_id" id="bankId4" value=""  >
						<input id="showBank4" class="please_select" placeholder="请选择" readonly="readonly" onBlur="this.style.color='#222'" onFocus="this.style.color='#222'">
					</p>
					<p>
						<span>预约时间</span>
						<input type="hidden" name="bank_id" id="bankId6" value="" class="hide_input_centent">
						<input id="showBank6" class="please_select" placeholder="请选择" readonly="readonly" onBlur="this.style.color='#222'" onFocus="this.style.color='#222'">
					</p>
				</div>
				<div class="ms_msg">
					<textarea name="" rows="" cols="" placeholder="请将您需要维修的具体情况描述在此" maxlength="200"></textarea>
					<p class="gptu" style="position: absolute; bottom: 0;right: .28rem; color: #929292;">
						<var style="color: #929292;font-style: normal;">--</var>/200
					</p>
				</div>

				<!--dom结构部分    图片上传-->
				<div id="uploader" class="wu-example" style="display: none">
					<p class="camera">上传照片（非必传）</p>
					<!--用来存放item-->
					<div class="queueList">
						<div id="filePicker" class="webuploader-container">
						</div>
						<div class="statusBar element-invisible">
							<div id="filePicker2">

							</div>
						</div>
					</div>

					<!--<button id="ctlBtn" class="btn btn-default">开始上传</button>
					<div id="fileList" class="uploader-list"></div>-->
				</div>

				<footer class="border_top">
					<input type="button" name="" id="" value="立即预约" class="btn_at_once" />
				</footer>
			</form>
		</section>

	</body>
	<script src="${basePath}/js/qifu/jquery-1.11.3.js" type="text/javascript" charset="utf-8"></script>
	<script src="${basePath}/js/qifu/reservation.js" type="text/javascript" charset="utf-8"></script>
	<script src="${basePath}/js/qifu/webuploader.js" type="text/javascript" charset="utf-8"></script>
	<script src="${basePath}/js/qifu/wnxg_qf.js" type="text/javascript" charset="utf-8"></script>
	<script src="${basePath}/js/qifu/iscroll.js"></script>
	<script src="${basePath}/js/qifu/iosSelect.js"></script>
	<script src="${basePath}/js/qifu/date.js"></script>
	<script src="${basePath}/js/qifu/content_data.js" type="text/javascript" charset="utf-8"></script>

</html>


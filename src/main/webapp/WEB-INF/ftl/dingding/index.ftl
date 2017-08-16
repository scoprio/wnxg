<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
		<title>万能小哥</title>
        <#--<link href="${basePath}/js/common/bootstrap/3.3.5/css/bootstrap.min.css?${_v}" rel="stylesheet"/>-->
        <#--<link href="${basePath}/css/common/base.css?${_v}" rel="stylesheet"/>-->
		<link rel="stylesheet" type="text/css" href="${basePath}/css/qifu/reset_h5.css" />
		<link rel="stylesheet" type="text/css" href="${basePath}/css/qifu/index.css" />
		<link rel="stylesheet" type="text/css" href="${basePath}/css/qifu/dropload.css"/>
        <link rel="stylesheet" type="text/css" href="${basePath}/css/qifu/choose_city.css" />

        <script>
            var _config = {"agentId":'${_config.agentId}',
                "corpId":'${_config.corpId}',
                "timeStamp":'${_config.timeStamp}',
                "nonceStr":'${_config.nonceStr}',
                "signature":'${_config.signature}'
            }
            function openLink(url){
                dd.biz.util.openLink({
					 url:url,
					 onSuccess : function(result) {

					 },
					 onFail : function(err) {
						 alert(JSON.stringify(err));
					 }
				 });
            }
        </script>

        <script type="text/javascript" src="http://g.alicdn.com/dingding/open-develop/1.6.9/dingtalk.js"></script>
        <script src="${basePath}/js/qifu/jquery-1.11.3.js" type="text/javascript" charset="utf-8"></script>
        <script src="${basePath}/js/qifu/dropload.js" type="text/javascript" charset="utf-8"></script>
        <script src="${basePath}/js/qifu/index_data.js" type="text/javascript" charset="utf-8" baseUrl="${basePath}"></script>
        <script src="${basePath}/js/qifu/choose_citydata.js" type="text/javascript" charset="utf-8"></script>
        <script src="${basePath}/js/qifu/city.js" type="text/javascript" charset="utf-8"></script>
        <script src="${basePath}/js/qifu/index.js" type="text/javascript" charset="utf-8" baseUrl="${basePath}"></script>

        <script src="${basePath}/js/dingding.demo.js"></script>
	</head>

	<body>


    <div class="choose_city">
        <a href="my.html" class="person_center"></a>
        <a href="javascript:void(0);" class="city_current" id="citychoose" >北京</a>
    </div>
    <div class="banner"><img src="/images/banner.png"/></div>
    <div class="tab">
        <table border="0" cellspacing="0" cellpadding="0">

            <tr>
                <td>
                    <a href="all_sort.html?type=work">
                        <div><img src="/images/5.png" /></div>
                        <p>办公设备维护</p>
                    </a>
                </td>
                <td>
                    <a href="all_sort.html?type=light">
                        <div><img src="/images/2.png" /></div>
                        <p>办公电器保养</p>
                    </a>
                </td>
                <td>
                    <a href="all_sort.html?type=door">
                        <div><img src="/images/3.png" /></div>
                        <p>办公环境维修</p>
                    </a>
                </td>
                <td class="monthly">
                    <a href="all_sort.html?type=electricity">
                        <div><img src="/images/4.png" /></div>
                        <p>万能企业盾</p>
                    </a>
                </td>
            </tr>
        </table>
    </div>
    <div class="hot_project">
        <p class="hot_title">热门维修项目</p>
        <ul></ul>
    </div>
    <div class="city-wrap">
        <div class="city-wrap-tit border_bottom">
            <p class="back"></p>
            城市列表
        </div>
        <!--显示点击的是哪一个字母-->
        <div id="showLetter" class="showLetter"><span>A</span></div>
        <!--城市索引查询-->
        <div class="letter">
            <ul>
                <li>
                    <a href="javascript:;">A</a>
                </li>
                <li>
                    <a href="javascript:;">B</a>
                </li>
                <li>
                    <a href="javascript:;">C</a>
                </li>
                <li>
                    <a href="javascript:;">D</a>
                </li>
                <li>
                    <a href="javascript:;">E</a>
                </li>
                <li>
                    <a href="javascript:;">F</a>
                </li>
                <li>
                    <a href="javascript:;">G</a>
                </li>
                <li>
                    <a href="javascript:;">H</a>
                </li>
                <li>
                    <a href="javascript:;">J</a>
                </li>
                <li>
                    <a href="javascript:;">K</a>
                </li>
                <li>
                    <a href="javascript:;">L</a>
                </li>
                <li>
                    <a href="javascript:;">M</a>
                </li>
                <li>
                    <a href="javascript:;">N</a>
                </li>
                <li>
                    <a href="javascript:;">P</a>
                </li>
                <li>
                    <a href="javascript:;">Q</a>
                </li>
                <li>
                    <a href="javascript:;">R</a>
                </li>
                <li>
                    <a href="javascript:;">S</a>
                </li>
                <li>
                    <a href="javascript:;">T</a>
                </li>
                <li>
                    <a href="javascript:;">W</a>
                </li>
                <li>
                    <a href="javascript:;">X</a>
                </li>
                <li>
                    <a href="javascript:;">Y</a>
                </li>
                <li>
                    <a href="javascript:;">Z</a>
                </li>
            </ul>
        </div>
        <!--城市列表-->
        <div class="box">

            <div class="container tab1">
                <div class="city">
                </div>
            </div>
        </div>
    </div>


		
	</body>

</html>
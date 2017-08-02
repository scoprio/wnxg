package com.ulb.web.demo;


import com.ulb.web.config.Global;

public class Env {
	
	public static final String OAPI_HOST = "https://oapi.dingtalk.com";
	public static final String OA_BACKGROUND_URL = ""; 
	public static final String CORP_ID = Global.getConfig("QF_CORP_ID");   //"ding83eec6969bab9bce35c2f4657eb6378f";
	 
	public static final String CORP_SECRET = Global.getConfig("QF_CORP_SECRET");   //"hWdnDeArrSHcEuYdbUK6Ua1XzyIz1LzlH8HGHegjQBAmbTK9hPBo2sco6M9q9bbj";
	public static final String SSO_Secret = Global.getConfig("QF_SSO_Secret");   //"iMnW0U3hlzIrPDCl3lSg2cvrt9dxmgbmIYVAF9XYhnuhOAVXrXsiGqD4Uduvw0uw";

	
	public static String suiteTicket = "";
	public static String authCode = ""; 
	public static String suiteToken = ""; 
	public static String access_token = ""; 
	public static String jsapi_ticket = "";
	public static long timeStamp = 0;
	public static String nonceStr = "WNXGdingdingQF";
	public static String signature = "";
	public static String agentid = Global.getConfig("QF_AGENTID");

	public static final String CREATE_SUITE_KEY = "suite4xxxxxxxxxxxxxxx";
	public static final String SUITE_KEY = Global.getConfig("QF_SUITE_KEY");   //"suitem7fcieglwwbzkdoj";
	public static final String SUITE_SECRET = Global.getConfig("QF_SUITE_SECRET");   //"TzitXxO_W-bHIb1ukLHSaO5S1aZmS0w-WiLEVHf7xZID9aVI93P8nl_MehIqnUYc";
	public static final String TOKEN = Global.getConfig("QF_TOKEN");   //"qingwawangzi";
	public static final String ENCODING_AES_KEY = Global.getConfig("QF_ENCODING_AES_KEY");   //"70876zr9h6j9d4j70ec8fm04rervuhrebo4bbgao8jh";
	
}

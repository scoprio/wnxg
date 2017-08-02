package com.ulb.web.utils.aes;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;
import com.ulb.web.demo.Env;
import com.ulb.web.demo.OApiException;
import com.ulb.web.utils.HttpHelper;

public class GetAccessToken {
	private static Logger log = LoggerFactory.getLogger(GetAccessToken.class);
	public static final String getTokenUrl = "https://oapi.dingtalk.com/gettoken"+ "?corpid="+ Env.CORP_ID + "&corpsecret="+Env.CORP_SECRET;
	
	public static final String getJsapiTicketUrl = "https://oapi.dingtalk.com/get_jsapi_ticket?access_token=";
	
	/**
	 * 获取钉钉token
	 * @return
	 */
	public static boolean getToken(){
		
		JSONObject json = null;
		try {
			json = HttpHelper.httpGet(getTokenUrl);
			if (json != null){
				//设置token
				Env.access_token = json.getString("access_token");
				Env.timeStamp = System.currentTimeMillis();
				log.info("获取钉钉token成功：" + Env.access_token);
				return true;
			}
		} catch (OApiException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	
	
	/**
	 * 获取钉钉jsapi_ticket
	 * @return
	 */
	public static boolean getJsapiTicket(){
		
		JSONObject json = null;
		try {
			json = HttpHelper.httpGet(getJsapiTicketUrl+Env.access_token);
			if (json != null){
				//设置jsapi_ticket
				Env.jsapi_ticket = json.getString("ticket");
				log.info("获取钉钉jsapi_ticket成功：" + Env.jsapi_ticket);
				return true;
			}
		} catch (OApiException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	
	public static String getTokenStr(){
		long now = System.currentTimeMillis();
		if(Env.timeStamp == 0 || Env.access_token == null || Env.access_token.equals("") || (now-Env.timeStamp) > 3600000){
			getToken();
			getJsapiTicket();
		}
		return Env.access_token;
	}
	
	public static String getJsapiTicketStr(){
		long now = System.currentTimeMillis();
//		if(Env.timeStamp == 0 || Env.access_token == null || Env.access_token.equals("") ||
//			Env.jsapi_ticket == null || Env.jsapi_ticket.equals("")	|| (now-Env.timeStamp) > 3600000){
			getToken();
			getJsapiTicket();
//		}
		return Env.jsapi_ticket;
	}
	
	
	public static void main(String args[]){
		System.out.println(getTokenUrl);
		getToken();
		System.out.println(getJsapiTicketUrl);
		getJsapiTicket();
	}

}

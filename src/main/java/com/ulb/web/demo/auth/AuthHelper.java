package com.ulb.web.demo.auth;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLDecoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Formatter;
import java.util.List;
import java.util.Timer;

import javax.servlet.http.HttpServletRequest;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dingtalk.open.client.ServiceFactory;
import com.dingtalk.open.client.api.model.corp.JsapiTicket;
import com.dingtalk.open.client.api.model.isv.CorpAuthToken;
import com.dingtalk.open.client.api.service.corp.JsapiService;
import com.dingtalk.open.client.api.service.isv.IsvService;
import com.ulb.service.generator.APIServiceGenrator;
import com.ulb.service.remote.RemoteDDService;
import com.ulb.web.demo.Env;
import com.ulb.web.demo.OApiException;
import com.ulb.web.demo.OApiResultException;
import com.ulb.web.demo.utils.FileUtils;
import com.ulb.web.demo.utils.HttpHelper;
import com.ulb.web.dto.ConversationDTO;
import com.ulb.web.dto.DDMessageDTO;
import com.ulb.web.dto.DingResultDTO;
import com.ulb.web.dto.KeyValueDTO;
import com.ulb.web.dto.OAMessageBodyDTO;
import com.ulb.web.dto.OAMessageDTO;
import com.ulb.web.dto.OAMessageHeadDTO;
import com.ulb.web.dto.OrderDetailDTO;

import org.apache.commons.lang.StringUtils;
import org.springframework.util.ObjectUtils;

import retrofit2.Call;
import retrofit2.Response;

public class AuthHelper {

	// public static String jsapiTicket = null;
	// public static String accessToken = null;
	public static Timer timer = null;
	// 调整到1小时50分钟
	public static final long cacheTime = 1000 * 60 * 55 * 2;
	public static long currentTime = 0 + cacheTime + 1;
	public static long lastTime = 0;
	public static SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	/*
	 * 在此方法中，为了避免频繁获取access_token，
	 * 在距离上一次获取access_token时间在两个小时之内的情况，
	 * 将直接从持久化存储中读取access_token
	 * 
	 * 因为access_token和jsapi_ticket的过期时间都是7200秒
	 * 所以在获取access_token的同时也去获取了jsapi_ticket
	 * 注：jsapi_ticket是在前端页面JSAPI做权限验证配置的时候需要使用的
	 * 具体信息请查看开发者文档--权限验证配置
	 */
	public static String getAccessToken(String corpId) throws Exception {
		long curTime = System.currentTimeMillis();
		JSONObject accessTokenValue = (JSONObject) FileUtils.getValue("accesstoken", corpId);
		String accToken = "";
		String jsTicket = "";
		JSONObject jsontemp = new JSONObject();
		if (accessTokenValue == null || curTime - accessTokenValue.getLong("begin_time") >= cacheTime) {
			ServiceFactory serviceFactory = ServiceFactory.getInstance();

			IsvService isvService = serviceFactory.getOpenService(IsvService.class);
			CorpAuthToken corpAuthToken = isvService.getCorpToken((String)FileUtils.getValue("ticket", "suiteToken"), 
					corpId,(String)FileUtils.getValue("permanentcode", corpId));
			
			if (corpAuthToken.getAccess_token() != null) {
				// save accessToken
				accToken = corpAuthToken.getAccess_token();
				JSONObject jsonAccess = new JSONObject();
				jsontemp.clear();
				jsontemp.put("access_token", accToken);
				jsontemp.put("begin_time", curTime);
				jsonAccess.put(corpId, jsontemp);

				FileUtils.write2File(jsonAccess, "accesstoken");
			} else {
				throw new OApiResultException("access_token");
			}
			
			if(accToken.length() > 0){
				
				JsapiService jsapiService = serviceFactory.getOpenService(JsapiService.class);

				JsapiTicket JsapiTicket = jsapiService.getJsapiTicket(accToken, "jsapi");
				jsTicket = JsapiTicket.getTicket();
				
				JSONObject jsonTicket = new JSONObject();
				jsontemp.clear();
				jsontemp.put("ticket", jsTicket);
				jsontemp.put("begin_time", curTime);
				jsonTicket.put(corpId, jsontemp);
				FileUtils.write2File(jsonTicket, "jsticket");
			}

		} else {
			return accessTokenValue.getString("access_token");
		}

		return accToken;
	}

	// 正常的情况下，jsapi_ticket的有效期为7200秒，所以开发者需要在某个地方设计一个定时器，定期去更新jsapi_ticket
	public static String getJsapiTicket(String accessToken, String corpId) throws Exception {
		JSONObject jsTicketValue = (JSONObject) FileUtils.getValue("jsticket", corpId);
		long curTime = System.currentTimeMillis();
		String jsTicket = "";

		 if (jsTicketValue == null || curTime -
		 jsTicketValue.getLong("begin_time") >= cacheTime) {
				ServiceFactory serviceFactory;
				
			serviceFactory = ServiceFactory.getInstance();
			JsapiService jsapiService = serviceFactory.getOpenService(JsapiService.class);

			JsapiTicket JsapiTicket = jsapiService.getJsapiTicket(accessToken, "jsapi");
			jsTicket = JsapiTicket.getTicket();
			
			JSONObject jsonTicket = new JSONObject();
			JSONObject jsontemp = new JSONObject();
			jsontemp.clear();
			jsontemp.put("ticket", jsTicket);
			jsontemp.put("begin_time", curTime);
			jsonTicket.put(corpId, jsontemp);
			FileUtils.write2File(jsonTicket, "jsticket");

			return jsTicket;
		 } else {
			 return jsTicketValue.getString("ticket");
		 }
	}

	public static String sign(String ticket, String nonceStr, long timeStamp, String url) throws OApiException {
		String plain = "jsapi_ticket=" + ticket + "&noncestr=" + nonceStr + "&timestamp=" + String.valueOf(timeStamp)
				+ "&url=" + url;
		try {
			MessageDigest sha1 = MessageDigest.getInstance("SHA-1");
			sha1.reset();
			sha1.update(plain.getBytes("UTF-8"));
			return bytesToHex(sha1.digest());
		} catch (NoSuchAlgorithmException e) {
			throw new OApiResultException(e.getMessage());
		} catch (UnsupportedEncodingException e) {
			throw new OApiResultException(e.getMessage());
		}
	}

	private static String bytesToHex(byte[] hash) {
		Formatter formatter = new Formatter();
		for (byte b : hash) {
			formatter.format("%02x", b);
		}
		String result = formatter.toString();
		System.out.print(result);
		formatter.close();
		return result;
	}


	public static String getAgentId(String corpId, String appId) throws OApiException {
		String agentId = null;
		String endTime = FileUtils.getValue("ticket", "endTime").toString();
		long curTime = System.currentTimeMillis();
		if (endTime == null || Long.valueOf(endTime) - curTime < 0){
			agentId = FileUtils.getValue("permanentcode", corpId).toString();
		}

		String accessToken = FileUtils.getValue("ticket", "suiteToken").toString();
		String url = "https://oapi.dingtalk.com/service/get_auth_info?suite_access_token=" + accessToken;

		JSONObject args = new JSONObject();
		args.put("suite_key", Env.SUITE_KEY);
		args.put("auth_corpid", corpId);
		args.put("permanent_code", FileUtils.getValue("permanentcode", corpId));
		JSONObject response = HttpHelper.httpPost(url, args);
		if (response.containsKey("auth_info")) {
			JSONArray agents = (JSONArray) ((JSONObject) response.get("auth_info")).get("agent");

			for (int i = 0; i < agents.size(); i++) {
				if (((JSONObject) agents.get(i)).get("appid").toString().equals(appId)) {
					agentId = ((JSONObject) agents.get(i)).get("agentid").toString();
					break;
				}
			}
		} else {
			throw new OApiResultException("agentid");
		}
		return agentId;
	}

	public static int sendToConversation(ConversationDTO conversationDTO,OrderDetailDTO  orderDetailDTO) throws OApiException {
		NumberFormat currency = NumberFormat.getCurrencyInstance();

		String uid = conversationDTO.getUid();
		String cid = conversationDTO.getCid();
		String cropId = conversationDTO.getCropId();
		DDMessageDTO ddMessageDTO = new DDMessageDTO();



		List<KeyValueDTO> list = new ArrayList<>();

		KeyValueDTO keyValueDTO0 = new KeyValueDTO("预约时间",orderDetailDTO.getYuyueTime());

		KeyValueDTO keyValueDTO1 = new KeyValueDTO("服务类型",orderDetailDTO.getRepairName());
		KeyValueDTO keyValueDTO2 = new KeyValueDTO("问题描述",orderDetailDTO.getRemark());
		KeyValueDTO keyValueDTO3 = new KeyValueDTO("联系人",orderDetailDTO.getUserName()+" "+orderDetailDTO.getUserPhone());
		KeyValueDTO keyValueDTO4 = new KeyValueDTO("地址",orderDetailDTO.getAddress());
		KeyValueDTO keyValueDTO5 = new KeyValueDTO("平台报价", StringUtils.isEmpty(orderDetailDTO.getPlatformPrice())?"CNY0.00":"CNY"+String.format("%.2f",orderDetailDTO.getPlatformPrice()));
		KeyValueDTO keyValueDTO6 = new KeyValueDTO("人工费", ObjectUtils.isEmpty(orderDetailDTO.getCost())?currency.format(BigDecimal.ZERO):orderDetailDTO.getCost().toString());
		KeyValueDTO keyValueDTO7 = new KeyValueDTO("材料费", ObjectUtils.isEmpty(orderDetailDTO.getCostMaterial())?currency.format(BigDecimal.ZERO):currency.format(orderDetailDTO.getCostMaterial()));
		KeyValueDTO keyValueDTO8 = new KeyValueDTO("附加费", ObjectUtils.isEmpty(orderDetailDTO.getPlatformPrice())?currency.format(BigDecimal.ZERO):currency.format(orderDetailDTO.getPlatformPrice()));
		KeyValueDTO keyValueDTO9 = new KeyValueDTO("下单时间", StringUtils.isEmpty(orderDetailDTO.getPlatformPrice())?currency.format(BigDecimal.ZERO):currency.format(orderDetailDTO.getPlatformPrice()));
		list.add(keyValueDTO0);
		list.add(keyValueDTO1);
		list.add(keyValueDTO2);
		list.add(keyValueDTO3);
		list.add(keyValueDTO4);
		list.add(keyValueDTO5);
		list.add(keyValueDTO6);
		list.add(keyValueDTO7);
		list.add(keyValueDTO8);
		list.add(keyValueDTO9);
		OAMessageHeadDTO oaMessageHeadDTO = new OAMessageHeadDTO("FFBBBBBB","万能小哥维修订单");
		OAMessageBodyDTO oaMessageBodyDTO = new OAMessageBodyDTO();
		oaMessageBodyDTO.setTitle("万能小哥维修订单");
		oaMessageBodyDTO.setForm(list);


		OAMessageDTO oaMessageDTO = new OAMessageDTO();
		oaMessageDTO.setMessage_url("https://www.dingtalk.com");
		oaMessageDTO.setHead(oaMessageHeadDTO);
		oaMessageDTO.setBody(oaMessageBodyDTO);

		ddMessageDTO.setSender(uid);
		ddMessageDTO.setCid(cid);
		ddMessageDTO.setMsgtype("oa");
		ddMessageDTO.setOa(oaMessageDTO);

		String accessToken = null;
		try {
			accessToken = getAccessToken(cropId);
		} catch (Exception e) {
			e.printStackTrace();
		}

		RemoteDDService service = APIServiceGenrator.createRequsetService(RemoteDDService.class,"https://oapi.dingtalk.com");
		Call<DingResultDTO> call = service.sendToConversation(accessToken, ddMessageDTO);
		Response<DingResultDTO> response = null;
		try {
			response = call.execute();
		} catch (IOException e) {
			e.printStackTrace();
		}
		DingResultDTO resultDTO = response.body();

//		String url = "https://oapi.dingtalk.com/message/send_to_conversation?access_token=" + accessToken;


//		AuthHelper.getAccessToken(corpId)
//		JSONObject args = new JSONObject();
//		args.put("sender", "");
//		args.put("cid", cid);
//		args.put("msgtype", "oa");
//		args.put("permanent_code", FileUtils.getValue("permanentcode", corpId));
//		JSONObject response = HttpHelper.httpPost(url, args);
//		if (response.containsKey("auth_info")) {
//			JSONArray agents = (JSONArray) ((JSONObject) response.get("auth_info")).get("agent");
//
//			for (int i = 0; i < agents.size(); i++) {
//				if (((JSONObject) agents.get(i)).get("appid").toString().equals(appId)) {
//					agentId = ((JSONObject) agents.get(i)).get("agentid").toString();
//					break;
//				}
//			}
//		} else {
//			throw new OApiResultException("agentid");
//		}
		return resultDTO.getErrcode();
	}

//	public static String getSsoToken() throws OApiException {
//		String url = "https://oapi.dingtalk.com/sso/gettoken?corpid=" + Env.CORP_ID + "&corpsecret=" + Env.SSO_Secret;
//		JSONObject response = HttpHelper.httpGet(url);
//		String ssoToken;
//		if (response.containsKey("access_token")) {
//			ssoToken = response.getString("access_token");
//		} else {
//			throw new OApiResultException("Sso_token");
//		}
//		return ssoToken;
//
//	}


	public static void main(String args[]){
		NumberFormat currency = NumberFormat.getCurrencyInstance(); //建立货币格式化引用
		NumberFormat percent = NumberFormat.getPercentInstance();  //建立百分比格式化引用
		percent.setMaximumFractionDigits(3); //百分比小数点最多3位

		BigDecimal loanAmount = new BigDecimal("0"); //贷款金额
//		BigDecimal interestRate = new BigDecimal("0.008"); //利率
//		BigDecimal interest = loanAmount.multiply(interestRate); //相乘

		System.out.println("贷款金额:\t" + currency.format(loanAmount)); //贷款
	}

}

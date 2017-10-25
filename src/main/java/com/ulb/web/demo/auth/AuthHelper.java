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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;

import javax.servlet.http.HttpServletRequest;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dingtalk.open.client.ServiceFactory;
import com.dingtalk.open.client.api.model.corp.CorpUserDetail;
import com.dingtalk.open.client.api.model.corp.JsapiTicket;
import com.dingtalk.open.client.api.model.isv.CorpAuthToken;
import com.dingtalk.open.client.api.service.corp.JsapiService;
import com.dingtalk.open.client.api.service.isv.IsvService;
import com.ulb.service.generator.APIServiceGenrator;
import com.ulb.service.remote.RemoteDDService;
import com.ulb.web.demo.Env;
import com.ulb.web.demo.OApiException;
import com.ulb.web.demo.OApiResultException;
import com.ulb.web.demo.user.UserHelper;
import com.ulb.web.demo.utils.FileUtils;
import com.ulb.web.demo.utils.HttpHelper;
import com.ulb.web.dto.ConversationDTO;
import com.ulb.web.dto.DDMessageDTO;
import com.ulb.web.dto.DingAdminDTO;
import com.ulb.web.dto.DingResultDTO;
import com.ulb.web.dto.DingReturnAdminDTO;
import com.ulb.web.dto.KeyValueDTO;
import com.ulb.web.dto.OAMessageBodyDTO;
import com.ulb.web.dto.OAMessageDTO;
import com.ulb.web.dto.OAMessageHeadDTO;
import com.ulb.web.dto.OrderDetailDTO;

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


//		DingTalkClient client = new DefaultDingTalkClient("https://eco.taobao.com/router/rest");
//		SmartworkBpmsProcessSyncRequest req = new SmartworkBpmsProcessSyncRequest();
//		req.setAgentId(41605932L);
//		req.setSrcProcessCode("PROC-EF6YJL35P2-SCKICSB7P750S0YISYKV3-17IBLGZI-1");
//		req.setTargetProcessCode("PROC-EF6YJL35P2-SCKICSB7P750S0YISYKV3-17IBLGZI-1");
//		req.setBizCategoryId("fab.purchase");
//		req.setProcessName("请假审批");
//		SmartworkBpmsProcessSyncResponse rsp = client.execute(req, access_token);
//		System.out.println(rsp.getBody());

		String uid = conversationDTO.getUid();
		String cid = conversationDTO.getCid();
		String cropId = conversationDTO.getCropId();
		String appId = conversationDTO.getAppId();

		String accessToken ="";
		try {
			accessToken = getAccessToken(cropId);
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("conversation1----"+"accessToken:"+accessToken+",uid:"+uid+",cid:"+cid);
		DDMessageDTO ddMessageDTO = new DDMessageDTO();


		switch (conversationDTO.getType()){
			case 0:

				/**
				 * 获取管理员
				 */
				StringBuffer sbAdmin = new StringBuffer();

				RemoteDDService service = APIServiceGenrator.createRequsetService(RemoteDDService.class,"https://oapi.dingtalk.com");
				Map<String, String> maps = new HashMap<>();
				maps.put("access_token",accessToken);
				Call<DingReturnAdminDTO> call0 = service.getAdmin("/user/get_admin",maps);

				DingReturnAdminDTO dingReturnAdminDTO = null;
				try {
					dingReturnAdminDTO = call0.execute().body();
				} catch (IOException e) {
					e.printStackTrace();
				}

				if(dingReturnAdminDTO.getErrcode() == 0){
					for(DingAdminDTO dingAdminDTO:dingReturnAdminDTO.getAdminList()){
						if(sbAdmin.length() > 0){
							sbAdmin.append("|");
						}
						sbAdmin.append(dingAdminDTO.getUserid());
					}
				}

				CorpUserDetail corpUserDetail = null;
				try {
					corpUserDetail = UserHelper.getUser(accessToken, uid);
				} catch (Exception e) {
					e.printStackTrace();
				}


				List<KeyValueDTO> list = new ArrayList<>();

				KeyValueDTO keyValueDTO0 = new KeyValueDTO("预约时间：",orderDetailDTO.getYuyueTime());
				KeyValueDTO keyValueDTO1 = new KeyValueDTO("服务类型：",orderDetailDTO.getRepairName());
				KeyValueDTO keyValueDTO2 = new KeyValueDTO("问题描述：",orderDetailDTO.getRemark());
				KeyValueDTO keyValueDTO3 = new KeyValueDTO("发起人：",orderDetailDTO.getUserName());
				KeyValueDTO keyValueDTO4 = new KeyValueDTO("地址：",orderDetailDTO.getAddress());
				KeyValueDTO keyValueDTO5 = new KeyValueDTO("预计报价：", ObjectUtils.isEmpty(orderDetailDTO.getRepairPrice())?"CNY0.00":"CNY"+String.format("%.2f",orderDetailDTO.getRepairPrice()));
//		        KeyValueDTO keyValueDTO6 = new KeyValueDTO("人工费：", ObjectUtils.isEmpty(orderDetailDTO.getCost())?"CNY0.00":"CNY"+String.format("%.2f",orderDetailDTO.getCost()));
//		        KeyValueDTO keyValueDTO7 = new KeyValueDTO("材料费：", ObjectUtils.isEmpty(orderDetailDTO.getCostMaterial())?"CNY0.00":"CNY"+String.format("%.2f",orderDetailDTO.getCostMaterial()));
//		        KeyValueDTO keyValueDTO8 = new KeyValueDTO("附加费：", ObjectUtils.isEmpty(orderDetailDTO.getSurcharge())?"CNY0.00":"CNY"+String.format("%.2f",orderDetailDTO.getSurcharge()));
//		        KeyValueDTO keyValueDTO9 = new KeyValueDTO("下单时间：", orderDetailDTO.getDownTime());
				list.add(keyValueDTO0);
				list.add(keyValueDTO1);
				list.add(keyValueDTO2);
				list.add(keyValueDTO3);
				list.add(keyValueDTO4);
				list.add(keyValueDTO5);
//		        list.add(keyValueDTO6);
//		        list.add(keyValueDTO7);
//		        list.add(keyValueDTO8);
//		        list.add(keyValueDTO9);

				OAMessageHeadDTO oaMessageHeadDTO = new OAMessageHeadDTO("FFBBBBBB","管理员您好，您的公司"+corpUserDetail.getName()+"发起了维修申请，需要您去万能小哥应用中去审核.");
				OAMessageBodyDTO oaMessageBodyDTO = new OAMessageBodyDTO();
				oaMessageBodyDTO.setTitle("管理员您好，您的公司"+corpUserDetail.getName()+"发起了维修申请，需要您去万能小哥应用中去审核.");
				oaMessageBodyDTO.setForm(list);


				OAMessageDTO oaMessageDTO = new OAMessageDTO();
				oaMessageDTO.setHead(oaMessageHeadDTO);
				oaMessageDTO.setBody(oaMessageBodyDTO);

				String messageUrl = "dingtalk://dingtalkclient/page/link?url=http%3a%2f%2fwnxgtest.hz.taeapp.com%2fdingding%2findex.shtml%3fcorpid%3d%24CORPID%24%26appid%3d4198&pc_slide=true";
				oaMessageDTO.setMessage_url(messageUrl);

				ddMessageDTO.setTouser(sbAdmin.toString());
				ddMessageDTO.setToparty("");
				ddMessageDTO.setAgentid(getAgentId(cropId, appId));
				ddMessageDTO.setMsgtype("oa");
				ddMessageDTO.setOa(oaMessageDTO);
				break;
			case 1:
				List<KeyValueDTO> list1 = new ArrayList<>();

				KeyValueDTO keyValueDTO1_1 = new KeyValueDTO("审核结果：","");
				KeyValueDTO keyValueDTO1_2 = new KeyValueDTO("不通过理由：",orderDetailDTO.getRemark());



				if(orderDetailDTO.getPid() == 1){
					keyValueDTO1_1.setValue("通过");
					list1.add(keyValueDTO1_1);
				}else if(orderDetailDTO.getPid() == 22){
					keyValueDTO1_1.setValue("不通过");
					list1.add(keyValueDTO1_1);
					list1.add(keyValueDTO1_2);
				}

				OAMessageHeadDTO oaMessageHeadDTO1 = new OAMessageHeadDTO("FFBBBBBB","万能小哥维修单审核");
				OAMessageBodyDTO oaMessageBodyDTO1 = new OAMessageBodyDTO();
				oaMessageBodyDTO1.setTitle("万能小哥维修单审核");
				oaMessageBodyDTO1.setForm(list1);
				OAMessageDTO oaMessageDTO1 = new OAMessageDTO();
				oaMessageDTO1.setHead(oaMessageHeadDTO1);
				oaMessageDTO1.setBody(oaMessageBodyDTO1);

				String messageUrl1 = "dingtalk://dingtalkclient/page/link?url=http%3a%2f%2fwnxgtest.hz.taeapp.com%2fdingding%2findex.shtml%3fcorpid%3d%24CORPID%24%26appid%3d4198&pc_slide=true";
				oaMessageDTO1.setMessage_url(messageUrl1);
				ddMessageDTO.setTouser(orderDetailDTO.getEmployeeid());
				ddMessageDTO.setToparty("");
				ddMessageDTO.setAgentid(getAgentId(cropId, appId));
				ddMessageDTO.setMsgtype("oa");
				ddMessageDTO.setOa(oaMessageDTO1);

				break;

			default:
		}



		RemoteDDService service = APIServiceGenrator.createRequsetService(RemoteDDService.class,"https://oapi.dingtalk.com");
		Map<String, String> maps = new HashMap<>();
		maps.put("access_token",accessToken);
		Call<DingResultDTO> call = service.sendToConversation("/message/send",maps, ddMessageDTO);


		Response<DingResultDTO> response = null;
		try {
			response = call.execute();
		} catch (IOException e) {
			e.printStackTrace();
		}
		DingResultDTO resultDTO = response.body();

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
		System.out.println(String.format("%.2f",loanAmount));
		System.out.println("贷款金额:\t" + currency.format(loanAmount)); //贷款
	}

}

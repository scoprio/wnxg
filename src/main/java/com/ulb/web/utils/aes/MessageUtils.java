package com.ulb.web.utils.aes;

import java.util.HashMap;
import java.util.Map;

import com.xwtec.iocp.common.utils.HttpUtils;
import com.xwtec.iocp.modules.qifu.demo.Env;

public class MessageUtils {
	
	public static void sendToDD(String msg, String ddid){
		/*LightAppMessageDelivery delivery = new LightAppMessageDelivery(ddid, "", Env.agentid);
    	MessageBody.TextBody textBody = new MessageBody.TextBody();
		textBody.setContent(msg);
		delivery.withMessage(MessageType.TEXT, textBody);
    	try {
			Receipt r = MessageHelper.send(GetAccessToken.getTokenStr(), delivery);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		String url = "https://oapi.dingtalk.com/message/send?access_token="+GetAccessToken.getTokenStr();
    	Map<String, Object> params = new HashMap<String, Object>();
        // String url = "http://112.124.127.52:8080/WNXG/access.action";
        
        params.put("touser", ddid);
        params.put("agentid", Env.agentid);
        params.put("msgtype", "text");
        Map<String, String> content = new HashMap<String, String>();
        
        content.put("content", msg);
        params.put("text", content);
        // String result=HttpUtils.doPost(url, params);
        String result = HttpUtils.PostUrl(url, params, true);
        System.out.println(result);
	}
	
	
	public static void main(String args[]){
		sendToDD("测试信息", "manager8843");
	}

}

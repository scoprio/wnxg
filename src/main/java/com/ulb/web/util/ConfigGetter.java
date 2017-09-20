package com.ulb.web.util;

import java.net.URLDecoder;

import javax.servlet.http.HttpServletRequest;

import com.ulb.web.demo.auth.AuthHelper;
import com.ulb.web.dto.DingDingConfigDTO;

/**
 * Created by wangpeng on 19/08/2017.
 */
public class ConfigGetter {

    public static DingDingConfigDTO getConfig(HttpServletRequest request){

        String urlString = request.getRequestURL().toString();
        String queryString = request.getQueryString();

        String corpId = request.getParameter("corpid");
        if(corpId == null){
            corpId = request.getParameter("corpId");
        }
        String appId = request.getParameter("appid");
//        String corpId = "ding7b7ae2d7653b9f7e35c2f4657eb6378f";
//        String appId = "117461615";

        String queryStringEncode = null;
        String url;
        if (queryString != null) {
            queryStringEncode = URLDecoder.decode(queryString);
            url = urlString + "?" + queryStringEncode;
        } else {
            url = urlString;
        }
        System.out.println(url);
        String nonceStr = "abcdefg";
        long timeStamp = System.currentTimeMillis() / 1000;
        String signedUrl = url;
        String accessToken = null;
        String ticket = null;
        String signature = null;
        String agentid = null;

        try {
            accessToken = AuthHelper.getAccessToken(corpId);
            ticket = AuthHelper.getJsapiTicket(accessToken, corpId);
            signature = AuthHelper.sign(ticket, nonceStr, timeStamp, signedUrl);
            agentid = AuthHelper.getAgentId(corpId, appId);
//            accessToken = "1111";
//            ticket = "111";
//            signature = "111";
//            agentid = "1111";

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        DingDingConfigDTO dto = new DingDingConfigDTO();

        dto.setAgentId(agentid);
        dto.setCorpId(corpId);
        dto.setTimeStamp(String.valueOf(timeStamp));
        dto.setNonceStr(nonceStr);
        dto.setSignature(signature);
        dto.setJsticket(ticket);
        dto.setAppid(appId);
        return dto;

    }
}

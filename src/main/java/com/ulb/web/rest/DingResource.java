package com.ulb.web.rest;

import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import com.alibaba.fastjson.JSON;
import com.dingtalk.open.client.api.model.corp.CorpUserDetail;
import com.ulb.web.demo.auth.AuthHelper;
import com.ulb.web.demo.user.UserHelper;
import com.ulb.web.dto.DingDingConfigDTO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by wangpeng on 03/08/2017.
 */

@RestController
@Scope(value="prototype")
@RequestMapping("dingding")
public class DingResource {

    public static final Logger LOGGER = LoggerFactory.getLogger(DingResource.class);

    public static SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


    @RequestMapping(value="index",method=RequestMethod.GET)
    public ModelAndView userIndex(HttpServletRequest request){

        String urlString = request.getRequestURL().toString();
        String queryString = request.getQueryString();

        String corpId = request.getParameter("corpid");
        String appId = request.getParameter("appid");
//        String corpId = "ding7b7ae2d7653b9f7e35c2f4657eb6378f";
//        String appId = "117461615";

        System.out.println(df.format(new Date())+
                " getconfig,url:" + urlString + " query:" + queryString + " corpid:" + corpId + " appid:" + appId);

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
//            accessToken = AuthHelper.getAccessToken(corpId);
//            ticket = AuthHelper.getJsapiTicket(accessToken, corpId);
//            signature = AuthHelper.sign(ticket, nonceStr, timeStamp, signedUrl);
//            agentid = AuthHelper.getAgentId(corpId, appId);

            accessToken = "";
            ticket = "";
            signature = "";
            agentid = "";

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


//        "{jsticket:'" + ticket + "',signature:'" + signature + "',nonceStr:'" + nonceStr + "',timeStamp:'"
//                + timeStamp + "',corpId:'" + corpId + "',agentid:'" + agentid+ "',appid:'" + appId + "'}";
        DingDingConfigDTO dto = new DingDingConfigDTO();

        dto.setAgentId(agentid);
        dto.setCorpId(corpId);
        dto.setTimeStamp(String.valueOf(timeStamp));
        dto.setNonceStr(nonceStr);
        dto.setSignature(signature);
        dto.setJsticket(ticket);

        return new ModelAndView("dingding/index","_config",dto);
    }


    @RequestMapping(value="authCode.shtml",method=RequestMethod.GET)
    public ResponseEntity<String> getAuthCode(HttpServletRequest request){

        String code = request.getParameter("code");
        String corpId = request.getParameter("corpid");
        LOGGER.info("code:"+code+" corpid:"+corpId);

        String accessToken = "";
        CorpUserDetail user = null;

        try {
            accessToken = AuthHelper.getAccessToken(corpId);
            LOGGER.info("access token:"+accessToken);
            user = UserHelper.getUser(accessToken, UserHelper.getUserInfo(accessToken, code).getUserid());
        } catch (Exception e) {
            e.printStackTrace();
        }
        String userJson = JSON.toJSONString(user);
        LOGGER.info("access user:"+userJson);
        return new ResponseEntity<>(userJson, HttpStatus.OK);
    }


    @RequestMapping(value="city",method=RequestMethod.GET)
    public ModelAndView city(){
        return new ModelAndView("dingding/choose_city");
    }

}

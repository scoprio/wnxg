package com.ulb.web.rest;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;


/**
 * Created by wangpeng on 19/08/2017.
 */
public class AlipayInfoGetter {

    public static String getAlipayInfo(HttpServletRequest request){

        String subject = "scoprio测试";
        String out_trade_no = "1111111";
        String money = "0.01";
        String notifyUrl = request.getContextPath()+"/help/FAQ.shtml";
        Map<String, String> sParaTemp = new HashMap<String, String>();
        sParaTemp.put("service", AlipayConfig.service);
        sParaTemp.put("partner", AlipayConfig.partner);
        sParaTemp.put("seller_id", AlipayConfig.seller_id);
        sParaTemp.put("_input_charset", AlipayConfig.input_charset);
        sParaTemp.put("payment_type", AlipayConfig.payment_type);
        sParaTemp.put("notify_url", notifyUrl);
        sParaTemp.put("out_trade_no", out_trade_no);
        sParaTemp.put("subject", subject);
        sParaTemp.put("total_fee", money);
        sParaTemp.put("body", subject);
        // 待请求参数数组
        String mysign = AlipaySubmit.buildRequestMysign(sParaTemp, "RSA");

        String info = "partner=" + AlipayConfig.partner + "&seller_id="
                + AlipayConfig.seller_id + "&out_trade_no="
                + out_trade_no + "&subject=" + subject + "&body="
                + subject + "&total_fee="
                + money + "&notify_url="
                + notifyUrl
                + "&service=mobile.securitypay.pay" + "&payment_type=1"
                + "&_input_charset=" + AlipayConfig.input_charset + "&sign="
                + mysign + "&sign_type=RSA";

        return info;

    }
}

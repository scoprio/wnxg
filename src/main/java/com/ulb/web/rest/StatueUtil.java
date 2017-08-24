package com.ulb.web.rest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wangpeng on 24/08/2017.
 */
public class StatueUtil {

    private static Map<String,String> statueMap = new HashMap<>();

    private StatueUtil(){
        statueMap.put("1","下单");
        statueMap.put("2","接单");
        statueMap.put("3","沟通顺利");
        statueMap.put("4","出发");
        statueMap.put("5","开始维修");
        statueMap.put("7","开始维修");
        statueMap.put("8","用户已评论，订单完成");
        statueMap.put("11","申请退单（小哥原因)");
        statueMap.put("12","申请退单（客户原因）");
        statueMap.put("13","小哥驳回退单（小哥原因）");
        statueMap.put("14","小哥驳回退单（ 客户原因）");
        statueMap.put("15","小哥同意退单（小哥原因）");
        statueMap.put("16","小哥同意退单（客户原因）");
        statueMap.put("17","小哥申请取消订单");
        statueMap.put("18","小哥转出订单");
        statueMap.put("19","客户申请更换小哥");
        statueMap.put("20","小哥同意更换");
        statueMap.put("21","小哥驳回更换");
        statueMap.put("22","管理员终止订单");
        statueMap.put("23","管理员终止订单");
        statueMap.put("24","等待客户确认支付");
        statueMap.put("25","客户确认付款");
        statueMap.put("26","等待选择支付方式");
        statueMap.put("27","等待客户支付");

    }

    public static String getStatueName(String statue){
        new StatueUtil();
        return statueMap.get(statue);

    }
}

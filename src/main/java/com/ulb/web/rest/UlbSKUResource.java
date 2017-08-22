package com.ulb.web.rest;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import com.alibaba.fastjson.JSON;
import com.dingtalk.open.client.api.model.corp.CorpUserDetail;
import com.ulb.service.SKUService;
import com.ulb.service.TimeService;
import com.ulb.user.bo.UserOnlineBo;
import com.ulb.web.demo.auth.AuthHelper;
import com.ulb.web.demo.user.UserHelper;
import com.ulb.web.dto.DingDingConfigDTO;
import com.ulb.web.dto.FeedbackDTO;
import com.ulb.web.dto.SKUOrderRecordDTO;
import com.ulb.web.dto.SKURecordDTO;
import com.ulb.web.dto.UsefulTimeDTO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * Created by wangpeng on 03/08/2017.
 */

@Controller
@Scope(value="prototype")
@RequestMapping("ulb")
public class UlbSKUResource {

    public static final Logger LOGGER = LoggerFactory.getLogger(UlbSKUResource.class);

    @Resource
    private SKUService skuService;

    @Resource
    private TimeService timeService;

    @RequestMapping(value="sku/{skuId}/{cityCode}",method=RequestMethod.GET)
    public ModelAndView getSKU(@PathVariable String skuId,@PathVariable String cityCode,HttpServletRequest request){
        SKURecordDTO dto  = null;
        try {
            dto = skuService.getSKU(skuId,cityCode);
            dto.setUsefulTime(JSONArray.fromObject(timeService.getUsefulTime()).toString());
            dto.setConfig(ConfigGetter.getConfig(request));
            dto.setCityCode(cityCode);
        } catch (IOException e) {
            LOGGER.error("从服务请求SKU详情失败");
            e.printStackTrace();
        }
        return new ModelAndView("dingding/place_order","sku",dto);
    }


    @RequestMapping(value = "/sku/order.shtml",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Object>> order(@RequestBody SKUOrderRecordDTO skuOrderRecordDTO){
        Map<String, Object> resultMap = new LinkedHashMap<>();
        try {
            skuService.order(skuOrderRecordDTO);
            resultMap.put("message", "下单成功！");
            resultMap.put("status", 200);
        } catch (IOException e) {
            resultMap.put("status", 500);
            e.printStackTrace();
        }
        return new ResponseEntity(resultMap,HttpStatus.OK);
    }

}

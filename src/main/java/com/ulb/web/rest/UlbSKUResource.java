package com.ulb.web.rest;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import com.alibaba.fastjson.JSON;
import com.dingtalk.open.client.api.model.corp.CorpUserDetail;
import com.ulb.service.SKUService;
import com.ulb.user.bo.UserOnlineBo;
import com.ulb.web.demo.auth.AuthHelper;
import com.ulb.web.demo.user.UserHelper;
import com.ulb.web.dto.DingDingConfigDTO;
import com.ulb.web.dto.SKURecordDTO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

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

    @RequestMapping(value="sku/{skuId}/{cityCode}",method=RequestMethod.GET)
    public ModelAndView getSKU(@PathVariable String skuId,@PathVariable String cityCode){
        SKURecordDTO dto  = new SKURecordDTO();
//        dto.setRid("11");
//        dto.setName("222");
//        dto.setContent("2222");
//        dto.setImgUrl("sss");
//        dto.setPrice(new BigDecimal(50.0));
//        dto.setUnit("台");
        try {
            dto = skuService.getSKU(skuId,cityCode);
        } catch (IOException e) {
            LOGGER.error("从服务请求SKU详情失败");
            e.printStackTrace();
        }
        return new ModelAndView("dingding/place_order","sku",dto);
    }

}

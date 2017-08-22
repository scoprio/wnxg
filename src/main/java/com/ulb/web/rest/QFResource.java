package com.ulb.web.rest;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.ulb.service.QFService;
import com.ulb.service.SKUService;
import com.ulb.service.TimeService;
import com.ulb.web.dto.QFOrderRecordDTO;
import com.ulb.web.dto.QFRecordDTO;
import com.ulb.web.dto.SKUOrderRecordDTO;
import com.ulb.web.dto.SKURecordDTO;

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
import org.springframework.web.servlet.ModelAndView;

import net.sf.json.JSONArray;

/**
 * Created by wangpeng on 03/08/2017.
 */

@Controller
@Scope(value="prototype")
@RequestMapping("ulb")
public class QFResource {

    public static final Logger LOGGER = LoggerFactory.getLogger(QFResource.class);

    @Resource
    private QFService qfService;

    @Resource
    private TimeService timeService;

    @RequestMapping(value="qf",method=RequestMethod.GET)
    public ModelAndView getQF(HttpServletRequest request){

        QFRecordDTO dto  = new QFRecordDTO();
        dto.setConfig(ConfigGetter.getConfig(request));
        dto.setCityCode(request.getParameter("cityCode"));
        return new ModelAndView("dingding/confirm_buy","qf",dto);
    }


    @RequestMapping(value = "/qf/order.shtml",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Object>> order(@RequestBody QFOrderRecordDTO qfOrderRecordDTO){
        Map<String, Object> resultMap = new LinkedHashMap<>();
        try {
            qfService.order(qfOrderRecordDTO);
            resultMap.put("status", 200);
            resultMap.put("message", "下单成功！");
        } catch (IOException e) {
            resultMap.put("status", 500);
            e.printStackTrace();
        }
        return new ResponseEntity(resultMap,HttpStatus.OK);
    }

//    @RequestMapping(value = "my/feedback.shtml",
//            method = RequestMethod.POST,
//            produces = MediaType.APPLICATION_JSON_VALUE)
//    public Map<String,Object> save(@RequestBody FeedbackDTO feedbackDTO){
//        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
//        resultMap.put("message", "提交成功！");
//        resultMap.put("status", 200);
//        return resultMap;
//    }


//    @RequestMapping(value="skuOrderRecord/{userID}",method=RequestMethod.GET)
//    public ModelAndView getSKUOrder(@PathVariable String userID){
//        List<SKURecordDTO> list  = null;
//        try {
//            list = skuService.getSKUOrderRecord(userID);
//        } catch (IOException e) {
//            LOGGER.error("从服务请求SKU详情失败");
//            e.printStackTrace();
//        }
//        return new ModelAndView("dingding/place_order","sku",list);
//    }
}

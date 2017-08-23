package com.ulb.web.rest;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.ulb.service.QFService;
import com.ulb.service.SKUService;
import com.ulb.service.TimeService;
import com.ulb.web.dto.OrderRecordDTO;
import com.ulb.web.dto.QFOrderRecordDTO;
import com.ulb.web.dto.QFRecordDTO;
import com.ulb.web.dto.QFRecordDetailDTO;
import com.ulb.web.dto.ResultDTO;
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
        dto.setAlipayInfo(AlipayInfoGetter.getAlipayInfo(request));
        return new ModelAndView("dingding/confirm_buy","qf",dto);
    }


    @RequestMapping(value = "/qf/order.shtml",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Object>> order(@RequestBody QFOrderRecordDTO qfOrderRecordDTO){
        Map<String, Object> resultMap = new LinkedHashMap<>();
        try {
            ResultDTO resultDTO = qfService.order(qfOrderRecordDTO);
            if(resultDTO.getCode().equals("200")){
                resultMap.put("status", 200);
                resultMap.put("message", "下单成功！");
            }else{
                resultMap.put("status", 500);
                resultMap.put("message", "服务端下单失败！");
            }

        } catch (IOException e) {
            resultMap.put("status", 500);
            resultMap.put("message", "应用端下单失败！");
            e.printStackTrace();
        }
        return new ResponseEntity(resultMap,HttpStatus.OK);
    }

    @RequestMapping(value="my_qifu/{qifuId}",method=RequestMethod.GET)
    public ModelAndView getOrders(@PathVariable String qifuId,HttpServletRequest request){

        String cityCode = request.getParameter("cityCode");
        QFRecordDetailDTO qfRecordDetailDTO = new QFRecordDetailDTO();
        try {
            qfRecordDetailDTO = qfService.getQFRecordDetail(qifuId);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ModelAndView("dingding/my_QF","qifuInfo",qfRecordDetailDTO);
    }

    @RequestMapping(value="reservation",method=RequestMethod.GET)
    public ModelAndView getReservation(HttpServletRequest request){
        return new ModelAndView("dingding/reservation");
    }

}

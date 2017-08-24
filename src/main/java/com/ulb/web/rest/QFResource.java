package com.ulb.web.rest;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.ulb.service.QFService;
import com.ulb.service.TimeService;
import com.ulb.web.dto.QFOrderRecordDTO;
import com.ulb.web.dto.QFRecordDTO;
import com.ulb.web.dto.QFRecordDetailDTO;
import com.ulb.web.dto.QFRepairDTO;
import com.ulb.web.dto.QFRepairPostDTO;
import com.ulb.web.dto.ReservationTimeDTO;
import com.ulb.web.dto.ResultDTO;
import com.ulb.web.util.ConfigGetter;
import com.ulb.web.util.StatueUtil;

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
//        dto.setAlipayInfo(AlipayInfoGetter.getAlipayInfo());
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
    public ModelAndView getOrders(@PathVariable String qifuId){

        QFRecordDetailDTO qfRecordDetailDTO = new QFRecordDetailDTO();
        try {
            qfRecordDetailDTO = qfService.getQFRecordDetail(qifuId);
            if(qfRecordDetailDTO.getInfo().getBegin_time().trim().length() == 0|| qfRecordDetailDTO.getInfo().getEnd_time().trim().length()== 0){
                qfRecordDetailDTO.getInfo().setPeriod("未开通");
            }else{
                qfRecordDetailDTO.getInfo().setPeriod(qfRecordDetailDTO.getInfo().getBegin_time() +" 到 "+ qfRecordDetailDTO.getInfo().getEnd_time());
            }
            List<QFRepairDTO> list =  qfRecordDetailDTO.getRepairList();
            for(QFRepairDTO qfRepairDTO :list){
                qfRepairDTO.setStateName(StatueUtil.getStatueName(qfRepairDTO.getOrder_state()));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ModelAndView("dingding/my_QF","qifuInfo",qfRecordDetailDTO);
    }

    @RequestMapping(value="reservation",method=RequestMethod.GET)
    public ModelAndView getReservation(HttpServletRequest request){
        ReservationTimeDTO reservationTimeDTO = new ReservationTimeDTO();
        String recordId = request.getParameter("recordId");
        try {
            reservationTimeDTO.setUsefulTime(JSONArray.fromObject(timeService.getUsefulTime()).toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        reservationTimeDTO.setRecordId(recordId);
        return new ModelAndView("dingding/reservation","reservation",reservationTimeDTO);
    }


    @RequestMapping(value = "/qf/repair.shtml",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Object>> repair(@RequestBody QFRepairPostDTO qfRepairPostDTO){
        Map<String, Object> resultMap = new LinkedHashMap<>();
        try {
            ResultDTO resultDTO = qfService.repair(qfRepairPostDTO);
            if(resultDTO.getCode().equals("200")){
                resultMap.put("status", 200);
                resultMap.put("message", "预约成功！");
            }else{
                resultMap.put("status", 500);
                resultMap.put("message", "服务端预约失败！");
            }

        } catch (IOException e) {
            resultMap.put("status", 500);
            resultMap.put("message", "应用端预约失败！");
            e.printStackTrace();
        }
        return new ResponseEntity(resultMap,HttpStatus.OK);
    }
}

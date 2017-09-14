package com.ulb.web.rest;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.ulb.service.QFService;
import com.ulb.service.TimeService;
import com.ulb.web.dto.Comment2DTO;
import com.ulb.web.dto.CommentDTO;
import com.ulb.web.dto.PayState2DTO;
import com.ulb.web.dto.PayStateDTO;
import com.ulb.web.dto.QFCompanyInfoDTO;
import com.ulb.web.dto.QFOrderRecordDTO;
import com.ulb.web.dto.QFRecordDTO;
import com.ulb.web.dto.QFRecordDetailDTO;
import com.ulb.web.dto.QFRepairDTO;
import com.ulb.web.dto.QFRepairPostDTO;
import com.ulb.web.dto.ReservationTimeDTO;
import com.ulb.web.dto.ResultDTO;
import com.ulb.web.dto.ResultWithQFDTO;
import com.ulb.web.util.AlipayInfoGetter;
import com.ulb.web.util.ConfigGetter;
import com.ulb.web.util.StatueUtil;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
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

    @RequestMapping(value="/qf/comment",method=RequestMethod.GET)
    public ModelAndView getComment(HttpServletRequest request){
        CommentDTO commentDTO = new CommentDTO();
        commentDTO.setOid("");
        return new ModelAndView("dingding/comment","comment",commentDTO);
    }

    @RequestMapping(value="/qf/comment.shtml",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Object>> comment(@RequestBody Comment2DTO comment2DTO){

        Map<String, Object> resultMap = new LinkedHashMap<>();
        comment2DTO.setContent(StatueUtil.filterEmoji(comment2DTO.getContent().trim(),""));
        try {
            ResultDTO resultDTO = qfService.comment(comment2DTO);
            if(resultDTO.getCode().equals("200")){
                resultMap.put("message", "评论成功！");
                resultMap.put("status", 200);
            }else{
                resultMap.put("message", "服务端失败！");
                resultMap.put("status", 500);
            }

        } catch (IOException e) {
            resultMap.put("status", 500);
            resultMap.put("message", "应用端失败！");
            e.printStackTrace();
        }
        return new ResponseEntity(resultMap,HttpStatus.OK);
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


    @RequestMapping(value = "/qf/order.shtml",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Object>> order(@RequestBody QFOrderRecordDTO qfOrderRecordDTO){
        Map<String, Object> resultMap = new LinkedHashMap<>();
        try {
            ResultWithQFDTO resultWithQFDTO = qfService.order(qfOrderRecordDTO);
            if(resultWithQFDTO.getCode().equals("200")){
                resultMap.put("status", 200);
                resultMap.put("message", "下单成功！");
                String notifyUrl = "/ulb/qf/pay/"+resultWithQFDTO.getRecordId() +".shtml";
                String alipayInfo = AlipayInfoGetter.getAlipayInfo("企业盾购买:"+resultWithQFDTO.getRecordId(),resultWithQFDTO.getRecordId().toString(),resultWithQFDTO.getMoney().toString(),notifyUrl);
                resultMap.put("alipayInfo",alipayInfo);

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
            QFCompanyInfoDTO dto = qfRecordDetailDTO.getInfo();

            switch (qfRecordDetailDTO.getInfo().getState()){
                case "0":
                    dto.setStateImage("weishengxiao.png");
                    break;
                case "1":
                    dto.setStateImage("weishengxiao.png");
                    break;
                case "2":
                    dto.setStateImage("weishengxiao.png");
                    break;
                case "4":
                    dto.setStateImage("yishengxiao.png");
                    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
                    try {
                        if(sdf.parse(dto.getEnd_time()).before(new Date())){
                            dto.setState("100");
                            dto.setStateImage("yiguoqi.png");
                        }
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }

                    break;
                case "5":
                    dto.setStateImage("yituikuan.png");
                    break;
                default:
                    dto.setStateImage("yiguoqi.png");
            }
            List<QFRepairDTO> list =  qfRecordDetailDTO.getRepairList();
            for(QFRepairDTO qfRepairDTO :list){
                qfRepairDTO.setStateName(StatueUtil.getStatueName(qfRepairDTO.getOrder_state()));
                qfRepairDTO.setCreateTime( StringUtils.substringBeforeLast(qfRepairDTO.getCreateTime(),"."));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ModelAndView("dingding/my_QF","qifuInfo",qfRecordDetailDTO);
    }

    @RequestMapping(value="/qf/pay/{qifuId}",method=RequestMethod.GET)
    public ModelAndView pay(@PathVariable String qifuId){
        PayStateDTO payStateDTO = new PayStateDTO();
        payStateDTO.setPayState(1);

        ResultDTO resultDTO = null;
        try {
            resultDTO = qfService.pay(qifuId,payStateDTO);
        } catch (IOException e) {
            e.printStackTrace();
        }
        PayState2DTO payState2DTO = new PayState2DTO();
        if(resultDTO.getCode().equals("200")){
            payState2DTO.setPayState(1);
            payState2DTO.setMessage("恭喜您购买成功");
        }else{
            payState2DTO.setPayState(0);
            payState2DTO.setMessage("购买失败");
        }
        return new ModelAndView("dingding/pay_result","payState",payState2DTO);
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


    @RequestMapping(value = "/qf/orderPayInfo.shtml",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Object>> getPayInfo(HttpServletRequest request){
        String orderId = request.getParameter("orderId");
        Map<String, Object> resultMap = new LinkedHashMap<>();
        QFRecordDetailDTO qfRecordDetailDTO = null;
        try {
            qfRecordDetailDTO = qfService.getQFRecordDetail(orderId);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String notifyUrl = "/ulb/qf/pay/"+orderId +".shtml";
        String alipayInfo = AlipayInfoGetter.getAlipayInfo("万能小哥：企业盾购买",orderId,qfRecordDetailDTO.getInfo().getMoney(),notifyUrl);
        if(ObjectUtils.isEmpty(qfRecordDetailDTO)){
            resultMap.put("status", 500);
            resultMap.put("alipayInfo", "");

        }else{
            resultMap.put("status", 200);
            resultMap.put("alipayInfo", alipayInfo);
        }
        return new ResponseEntity(resultMap,HttpStatus.OK);
    }
}

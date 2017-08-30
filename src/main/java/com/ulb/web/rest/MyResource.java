package com.ulb.web.rest;


import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.ulb.service.MyService;
import com.ulb.service.TimeService;
import com.ulb.web.dto.FeedbackDTO;
import com.ulb.web.dto.OrderRecordDTO;
import com.ulb.web.dto.QydOrderRecordDTO;
import com.ulb.web.dto.UserDTO;
import com.ulb.web.util.StatueUtil;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


/**
 * Created by wangpeng on 03/08/2017.
 */

@Controller
@Scope(value="prototype")
@RequestMapping("dingding")
public class MyResource {

    public static final Logger LOGGER = LoggerFactory.getLogger(MyResource.class);

    @Resource
    private MyService myService;

    @Resource
    private TimeService timeService;

    @RequestMapping(value="my",method=RequestMethod.GET)
    public ModelAndView getMy(HttpServletRequest request){
        String userId = request.getParameter("uuid");
        String cityCode = request.getParameter("cityCode");
        String corpId = request.getParameter("corpid");

        UserDTO userDTO = new UserDTO();
        userDTO.setUserId(userId);
        userDTO.setCityCode(cityCode);
        userDTO.setCorpId(corpId);
        return new ModelAndView("dingding/my","my",userDTO);

    }


    @RequestMapping(value="my_admin",method=RequestMethod.GET)
    public ModelAndView getMyAdmin(HttpServletRequest request){
        String userId = request.getParameter("uuid");
        String cityCode = request.getParameter("cityCode");
        String corpId = request.getParameter("corpid");

        UserDTO userDTO = new UserDTO();
        userDTO.setUserId(userId);
        userDTO.setCityCode(cityCode);
        userDTO.setCorpId(corpId);
        return new ModelAndView("dingding/my_admin","my",userDTO);

    }

    @RequestMapping(value="my_order/{dingdingUId}/{cityCode}",method=RequestMethod.GET)
    public ModelAndView getOrders(@PathVariable String dingdingUId,@PathVariable String cityCode){

        List<OrderRecordDTO> list = null;
        try {
            list = myService.getSKUOrderRecord(dingdingUId,cityCode);
            for(OrderRecordDTO dto:list){
                dto.setCityCode(cityCode);
                dto.setStatusName(StatueUtil.getStatueName(dto.getPid().toString()));
                dto.setOnum("wnxg"+dto.getOnum());
                if(dto.getPid() == 1 ||dto.getPid() ==2 ||dto.getPid()==3){
                    dto.setDisplay("inline-block");
                }else{
                    dto.setDisplay("none");
                }

                if(dto.getPid() == 7){
                    dto.setCommentDisplay("inline-block");
                }else{
                    dto.setCommentDisplay("none");
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ModelAndView("dingding/my_order","orders",list);

    }

    @RequestMapping(value="my_company_order/{corpId}/{cityCode}",method=RequestMethod.GET)
    public ModelAndView getCropOrders(@PathVariable String corpId,@PathVariable String cityCode){

        List<OrderRecordDTO> list = null;
        try {
            list = myService.getCropSKUOrderRecord(corpId,cityCode);
            for(OrderRecordDTO dto:list){
                dto.setCityCode(cityCode);
                dto.setStatusName(StatueUtil.getStatueName(dto.getPid().toString()));
                if(dto.getPid() == 1||dto.getPid() ==2 ||dto.getPid()==3){
                    dto.setDisplay("inline-block");
                }else{
                    dto.setDisplay("none");
                }

                if(dto.getPid() == 7){
                    dto.setCommentDisplay("inline-block");
                }else{
                    dto.setCommentDisplay("none");
                }
                dto.setOnum("wnxg"+dto.getOnum());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ModelAndView("dingding/my_order","orders",list);

    }

    @RequestMapping(value="my_qyd_lists",method=RequestMethod.GET)
    public ModelAndView getQydLists(HttpServletRequest request){
        String corpId = request.getParameter("corpId");
        String cityCode = request.getParameter("cityCode");
        List<QydOrderRecordDTO> list = null;
        try {
            list = myService.getQydOrderRecord(corpId);
            for(QydOrderRecordDTO dto:list){
                dto.setCityCode(cityCode);
                String orderNum = StringUtils.leftPad(dto.getId().toString(),10,'0');
                dto.setOrderNum("WNXG"+orderNum);
                if(dto.getBeginTime() == null || dto.getEndTime() == null){
                    dto.setPeriod("未开通");
                }else{

                    SimpleDateFormat sdf=new SimpleDateFormat("yyyy.MM.dd");
                    Date beginDate = new Date(Long.valueOf(dto.getBeginTime()));
                    Date endDate = new Date(Long.valueOf(dto.getEndTime()));
                    dto.setPeriod(sdf.format(beginDate) +" 到 "+ sdf.format(endDate));
                }
                switch (dto.getState()){
                    case 0:
                        dto.setStateName("待支付");
                        break;
                    case 1:
                        dto.setStateName("支付成功,未生效");
                        break;
                    case 2:
                        dto.setStateName("取消订单");
                        break;
                    case 4:
                        dto.setStateName("支付成功，已生效");
                        break;
                    default:
                        dto.setStateName("已失效");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ModelAndView("dingding/my_qyd_lists","qydOrders",list);

    }

    @RequestMapping(value="help",method=RequestMethod.GET)
    public ModelAndView getHelp(){
        return new ModelAndView("dingding/help");
    }

    @RequestMapping(value="help/FAQ",method=RequestMethod.GET)
    public ModelAndView getHelpFAQ(){
        return new ModelAndView("dingding/FAQ");
    }

    @RequestMapping(value="help/newbie_guide",method=RequestMethod.GET)
    public ModelAndView getHelpNoviceBoot(){
        return new ModelAndView("dingding/newbie_guide");
    }

    @RequestMapping(value="help/user_feedback",method=RequestMethod.GET)
    public ModelAndView getHelpUserFeedback(){
        return new ModelAndView("dingding/user_feedback");
    }

    @RequestMapping(value="help/about_wnxg",method=RequestMethod.GET)
    public ModelAndView getHelpAbout(){
        return new ModelAndView("dingding/about_wnxg");
    }


    @RequestMapping(value="help/pay",method=RequestMethod.GET)
    public ModelAndView pay(HttpServletRequest request){

        return new ModelAndView("dingding/FAQ");
    }

    @RequestMapping(value = "my/feedback.shtml",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Object>>  save(@RequestBody FeedbackDTO feedbackDTO){
        Map<String, Object> resultMap = new LinkedHashMap<>();
        myService.insert(feedbackDTO);
        resultMap.put("message", "提交成功！");
        resultMap.put("status", 200);
        return new ResponseEntity(resultMap,HttpStatus.OK);
    }


}

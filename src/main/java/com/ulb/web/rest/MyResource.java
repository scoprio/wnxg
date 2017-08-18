package com.ulb.web.rest;


import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.ulb.service.MyService;
import com.ulb.service.SKUService;
import com.ulb.service.TimeService;
import com.ulb.web.dto.OrderRecordDTO;
import com.ulb.web.dto.QydOrderRecordDTO;
import com.ulb.web.dto.UserDTO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
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

    @RequestMapping(value="my/{dingdingUId}/{cityCode}",method=RequestMethod.GET)
    public ModelAndView getMy(@PathVariable String dingdingUId,@PathVariable String cityCode){

        UserDTO userDTO = new UserDTO();
        userDTO.setUserID(dingdingUId);
        userDTO.setCityCode(cityCode);
        return new ModelAndView("dingding/my","my",userDTO);

    }

    @RequestMapping(value="my_order/{dingdingUId}/{cityCode}",method=RequestMethod.GET)
    public ModelAndView getOrders(@PathVariable String dingdingUId,@PathVariable String cityCode){

        List<OrderRecordDTO> list = null;
        try {
            list = myService.getSKUOrderRecord(dingdingUId,cityCode);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ModelAndView("dingding/my_order","orders",list);

    }

    @RequestMapping(value="my_qyd_lists",method=RequestMethod.GET)
    public ModelAndView getQydLists(HttpServletRequest request){
        String corpId = request.getParameter("corpId");
        List<QydOrderRecordDTO> list = null;
        try {
            list = myService.getQydOrderRecord(corpId);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ModelAndView("dingding/my_qyd_lists","qydOrders",list);

    }



}

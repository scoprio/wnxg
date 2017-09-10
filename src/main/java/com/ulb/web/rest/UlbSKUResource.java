package com.ulb.web.rest;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.alibaba.druid.support.spring.stat.annotation.Stat;
import com.ulb.service.SKUService;
import com.ulb.service.TimeService;
import com.ulb.web.dto.Comment2DTO;
import com.ulb.web.dto.CommentDTO;
import com.ulb.web.dto.OperaterOrderDTO;
import com.ulb.web.dto.OperaterOrderWithIdDTO;
import com.ulb.web.dto.OrderDataDetailDTO;
import com.ulb.web.dto.OrderDetailDTO;
import com.ulb.web.dto.PayState2DTO;
import com.ulb.web.dto.PayStateDTO;
import com.ulb.web.dto.QFRecordDetailDTO;
import com.ulb.web.dto.QFRepairDTO;
import com.ulb.web.dto.ResultDTO;
import com.ulb.web.dto.SKUOrderRecordDTO;
import com.ulb.web.dto.SKUOrderStateDTO;
import com.ulb.web.dto.SKURecordDTO;
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
            if(dto.getPrice().compareTo(new BigDecimal(0)) == 0){
                dto.setPriceFormat("价格面议");
            }else{
                dto.setPriceFormat(dto.getPrice().toString());
            }
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
            ResultDTO resultDTO = skuService.order(skuOrderRecordDTO);
            if(resultDTO.getCode().equals("200")){
                resultMap.put("status", 200);
                resultMap.put("message", "下单成功！");
            }else{
                resultMap.put("message", "服务端下单失败！");
                resultMap.put("status", 500);
            }
        } catch (IOException e) {
            resultMap.put("status", 500);
            resultMap.put("message", "应用端下单失败！");
            e.printStackTrace();
        }
        return new ResponseEntity(resultMap,HttpStatus.OK);
    }

    @RequestMapping(value = "/sku/order.shtml",
            method = RequestMethod.PUT,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Object>> updateOrder(@RequestBody OperaterOrderWithIdDTO operaterOrderWithIdDTO){
        Map<String, Object> resultMap = new LinkedHashMap<>();
        OperaterOrderDTO operaterOrderDTO = new OperaterOrderDTO();
        operaterOrderDTO.setCityCode(operaterOrderWithIdDTO.getCityCode());
        operaterOrderDTO.setOperater(operaterOrderWithIdDTO.getOperater());
        try {
            ResultDTO resultDTO = skuService.updateOrder(operaterOrderWithIdDTO.getId(),operaterOrderDTO);
            if(resultDTO.getCode().equals("200")){
                resultMap.put("message", "取消成功！");
                resultMap.put("status", 200);
            }else{
                resultMap.put("message", "服务端下单失败！");
                resultMap.put("status", 500);
            }
        } catch (IOException e) {
            resultMap.put("status", 500);
            resultMap.put("message", "应用端下单失败！");
            e.printStackTrace();
        }
        return new ResponseEntity(resultMap,HttpStatus.OK);
    }


    @RequestMapping(value="sku/order/{orderId}/{cityCode}",method=RequestMethod.GET)
    public ModelAndView getOrders(@PathVariable String orderId,@PathVariable String cityCode){

        OrderDetailDTO  orderDetailDTO = null;
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            orderDetailDTO = skuService.getSKUOrderService(orderId,cityCode);
            if(orderDetailDTO.getPid() == 1 ||orderDetailDTO.getPid() ==2 ||orderDetailDTO.getPid() ==3){
                orderDetailDTO.setDisplay("inline-block");
            }else{
                orderDetailDTO.setDisplay("none");
            }

            if(orderDetailDTO.getPid() == 7|| orderDetailDTO.getPid() ==8){
                orderDetailDTO.setSlDisplay("block");
            }else{
                orderDetailDTO.setSlDisplay("none");
            }

            if(StringUtils.isEmpty(orderDetailDTO.getXgName()) || StringUtils.isEmpty(orderDetailDTO.getXgPhone())){
                orderDetailDTO.setXgDisplay("none");

            }else{
                orderDetailDTO.setXgDisplay("block");
            }

            orderDetailDTO.setOnum("wnxg"+orderDetailDTO.getOnum());
            for(OrderDataDetailDTO dto:orderDetailDTO.getOrderDatas()){
                dto.setpName(StatueUtil.getStatueName(dto.getPid().toString()));
                Date updateDateTime = new Date(dto.getUpdatetime());
                dto.setUpdateDateTime(sdf.format(updateDateTime));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ModelAndView("dingding/order_details","order",orderDetailDTO);
    }

    @RequestMapping(value="/sku/comment",method=RequestMethod.GET)
    public ModelAndView getComment(HttpServletRequest request){
        CommentDTO commentDTO = new CommentDTO();
        commentDTO.setOid(request.getParameter("orderId"));
        return new ModelAndView("dingding/comment","comment",commentDTO);
    }

    @RequestMapping(value="/sku/comment.shtml",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Object>> comment(@RequestBody CommentDTO commentDTO){
        commentDTO.setRemark(StatueUtil.filterEmoji(commentDTO.getRemark().trim(),""));
        Map<String, Object> resultMap = new LinkedHashMap<>();
        try {
            ResultDTO resultDTO = skuService.comment(commentDTO);
            if(resultDTO.getCode().equals("200")){
                resultMap.put("status", 200);
                resultMap.put("message", "评论成功！");
            }else{
                resultMap.put("message", "服务端失败！");
                resultMap.put("status", 500);
            }

        } catch (IOException e) {
            resultMap.put("message", "应用端失败！");
            resultMap.put("status", 500);
            e.printStackTrace();
        }
        return new ResponseEntity(resultMap,HttpStatus.OK);
    }

    @RequestMapping(value = "/sku/orderPayInfo.shtml",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Object>> getPayInfo(HttpServletRequest request){
        String orderId = request.getParameter("orderId");
        String cityCode = request.getParameter("cityCode");
        Map<String, Object> resultMap = new LinkedHashMap<>();
        OrderDetailDTO  orderDetailDTO = null;
        try {
            orderDetailDTO = skuService.getSKUOrderService(orderId,cityCode);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String notifyUrl = "/ulb/sku/pay/"+orderId +"/"+ cityCode+".shtml";
        String alipayInfo = AlipayInfoGetter.getAlipayInfo("万能小哥支付:"+orderId,orderId,"0.01",notifyUrl);
        if(ObjectUtils.isEmpty(orderDetailDTO)){
            resultMap.put("alipayInfo", "");
            resultMap.put("status", 500);
        }else{
            resultMap.put("status", 200);
            resultMap.put("alipayInfo", alipayInfo);
        }
        return new ResponseEntity(resultMap,HttpStatus.OK);
    }

    @RequestMapping(value="/sku/pay/{orderId}/{cityCode}",method=RequestMethod.GET)
    public ModelAndView pay(@PathVariable String orderId,@PathVariable String cityCode){
        SKUOrderStateDTO payStateDTO = new SKUOrderStateDTO();
        payStateDTO.setPid(7);

        ResultDTO resultDTO = null;
        try {
            resultDTO = skuService.pay(orderId,cityCode,payStateDTO);
        } catch (IOException e) {
            e.printStackTrace();
        }
        PayState2DTO payState2DTO = new PayState2DTO();
        if(resultDTO.getCode().equals("200")){
            payState2DTO.setPayState(1);
            payState2DTO.setMessage("支付成功");
        }else{
            payState2DTO.setPayState(0);
            payState2DTO.setMessage("支付失败");
        }
        return new ModelAndView("dingding/pay_order_result","payState",payState2DTO);
    }

}

package com.ulb.service.remote;


import java.util.List;

import com.ulb.web.dto.Comment2DTO;
import com.ulb.web.dto.CommentDTO;
import com.ulb.web.dto.OperaterOrderDTO;
import com.ulb.web.dto.OrderDetailDTO;
import com.ulb.web.dto.PayStateDTO;
import com.ulb.web.dto.ResultDTO;
import com.ulb.web.dto.SKUOrderRecordDTO;
import com.ulb.web.dto.SKUOrderStateDTO;
import com.ulb.web.dto.SKURecordDTO;
import com.ulb.web.dto.UsefulTimeDTO;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Headers;
import retrofit2.http.PUT;
import retrofit2.http.Path;

/**
 * 调用服务端SKU订单
 *
 * Created by wangpeng on 25/07/2017.
 */
public interface RemoteSKUService {

    /**
     * SKU详情展示
     * @param skuId
     * @param cityCode
     * @return
     */
    @GET("/WNXG/ulb/api/new_enter_prise_my_order/repairDetails/{skuId}/{cityCode}")
    Call<SKURecordDTO> getSKU(@Path("skuId") String skuId, @Path("cityCode") String cityCode);

    /**
     * SKU下单
     * @param skuOrderRecordDTO
     * @return
     */
    @Headers({"Content-type:application/json;charset=UTF-8"})
    @POST("/WNXG/ulb/api/new_enter_prise/order")
    Call<ResultDTO> postOrder(@Body SKUOrderRecordDTO skuOrderRecordDTO);

    /**
     * 获取下单时间
     * @return
     */
    @GET("/WNXG/ulb/api/new_enter_prise/usefulTime")
    Call<List<UsefulTimeDTO>> getUsefulTime();

    /**
     * 获取订单详情
     * @param orderId
     * @param cityCode
     * @return
     */
    @GET("/WNXG/ulb/api/new_enter_prise_my_order/myOrderDetails/{orderId}/{cityCode}")
    Call<OrderDetailDTO> getOrderDetail(@Path("orderId")String orderId,@Path("cityCode")String cityCode);

    /**
     * 修改订单状态
     * @param orderId
     * @param operaterOrderDTO
     * @return
     */
    @Headers({"Content-type:application/json;charset=UTF-8"})
    @PUT("/WNXG/ulb/api/new_enter_prise_my_company/order/{orderId}")
    Call<ResultDTO> updateOrder(@Path("orderId")String orderId,@Body OperaterOrderDTO operaterOrderDTO);

    /**
     * 提交sku订单评论
     * @param commentDTO
     * @return
     */
    @Headers({"Content-type:application/json;charset=UTF-8"})
    @POST("/WNXG/ulb/api/new_enter_prise/skuComment")
    Call<ResultDTO> comment(@Body CommentDTO commentDTO);

    /**
     * 支付订单
     * @param orderId
     * @param cityCode
     * @param payStateDTO
     * @return
     */
    @Headers({"Content-type:application/json;charset=UTF-8"})
    @PUT("/WNXG/ulb/api/new_enter_prise_my_order/afterOnline/{orderId}/{cityCode}")
    Call<ResultDTO> payOrder(@Path("orderId")String orderId,@Path("cityCode")String cityCode,@Body SKUOrderStateDTO payStateDTO);
}

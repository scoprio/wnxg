package com.ulb.service.remote;


import java.util.List;

import com.ulb.web.dto.OperaterOrderDTO;
import com.ulb.web.dto.OrderDetailDTO;
import com.ulb.web.dto.ResultDTO;
import com.ulb.web.dto.SKUOrderRecordDTO;
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
 * 调用服务端
 *
 * Created by wangpeng on 25/07/2017.
 */
public interface RemoteSKUService {

    @GET("/WNXG/ulb/api/new_enter_prise_my_order/repairDetails/{skuId}/{cityCode}")
    Call<SKURecordDTO> getSKU(@Path("skuId") String skuId, @Path("cityCode") String cityCode);

    @Headers({"Content-type:application/json;charset=UTF-8"})
    @POST("/WNXG/ulb/api/new_enter_prise/order")
    Call<ResultDTO> postOrder(@Body SKUOrderRecordDTO skuOrderRecordDTO);

//    @GET("/WNXG/ulb/api/new_enter_prise_my_order/repairDetails/{userID}")
//    Call<List<SKURecordDTO>> getSKUOrderRecord(@Path("userId") String userId);

    @GET("/WNXG/ulb/api/new_enter_prise/usefulTime")
    Call<List<UsefulTimeDTO>> getUsefulTime();

    @GET("/WNXG/ulb/api/new_enter_prise_my_order/myOrderDetails/{orderId}/{cityCode}")
    Call<OrderDetailDTO> getOrderDetail(@Path("orderId")String orderId,@Path("cityCode")String cityCode);

    @Headers({"Content-type:application/json;charset=UTF-8"})
    @PUT("/WNXG/ulb/api/new_enter_prise/order")
    Call<ResultDTO> updateOrder(@Body OperaterOrderDTO operaterOrderDTO);
}

package com.ulb.service.remote;



import com.ulb.web.dto.QFOrderRecordDTO;
import com.ulb.web.dto.ResultDTO;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * 调用服务端
 *
 * Created by wangpeng on 25/07/2017.
 */
public interface RemoteQFService {

//    @GET("/WNXG/ulb/api/new_enter_prise_my_order/repairDetails/{skuId}/{cityCode}")
//    Call<SKURecordDTO> getSKU(@Path("skuId") String skuId, @Path("cityCode") String cityCode);

    @Headers({"Content-type:application/json;charset=UTF-8"})
    @POST("/WNXG/ulb/api/new_enter_prise_my_company/enterprise")
    Call<ResultDTO> postOrder(@Body QFOrderRecordDTO qfOrderRecordDTO);

//    @GET("/WNXG/ulb/api/new_enter_prise_my_order/repairDetails/{userID}")
//    Call<List<SKURecordDTO>> getSKUOrderRecord(@Path("userId") String userId);
//
//    @GET("/WNXG/ulb/api/new_enter_prise/usefulTime")
//    Call<List<UsefulTimeDTO>> getUsefulTime();
}

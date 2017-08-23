package com.ulb.service.remote;



import com.ulb.web.dto.QFOrderRecordDTO;
import com.ulb.web.dto.QFRecordDetailDTO;
import com.ulb.web.dto.QFRepairPostDTO;
import com.ulb.web.dto.ResultDTO;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * 调用服务端
 *
 * Created by wangpeng on 25/07/2017.
 */
public interface RemoteQFService {

    @GET("/WNXG/ulb/api/new_enter_prise_my_company/myDetails/{qifuId}")
    Call<QFRecordDetailDTO> getQFRecordDetail(@Path("qifuId") String qifuId);

    @Headers({"Content-type:application/json;charset=UTF-8"})
    @POST("/WNXG/ulb/api/new_enter_prise_my_company/enterprise")
    Call<ResultDTO> postOrder(@Body QFOrderRecordDTO qfOrderRecordDTO);


    @Headers({"Content-type:application/json;charset=UTF-8"})
    @POST("/WNXG/ulb/api/new_enter_prise_my_company/addedOrder")
    Call<ResultDTO> postRepair(@Body QFRepairPostDTO qfRepairPostDTO);

//    @GET("/WNXG/ulb/api/new_enter_prise_my_order/repairDetails/{userID}")
//    Call<List<SKURecordDTO>> getSKUOrderRecord(@Path("userId") String userId);
//
//    @GET("/WNXG/ulb/api/new_enter_prise/usefulTime")
//    Call<List<UsefulTimeDTO>> getUsefulTime();
}

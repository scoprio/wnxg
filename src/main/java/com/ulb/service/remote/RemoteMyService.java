package com.ulb.service.remote;


import java.util.List;

import com.ulb.web.dto.OrderRecordDTO;
import com.ulb.web.dto.QydOrderRecordDTO;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * 调用服务端
 *
 * Created by wangpeng on 25/07/2017.
 */
public interface RemoteMyService {

    @GET("WNXG/ulb/api/new_enter_prise_my_order/myOrder/{userID}/{cityCode}")
    Call<List<OrderRecordDTO>> getSKUOrderRecord(@Path("userID") String userId,@Path("cityCode") String cityCode);

    @GET("WNXG/ulb/api/new_enter_prise_my_order/staffOrder/{cropId}/{cityCode}")
    Call<List<OrderRecordDTO>> getCropSKUOrderRecord(@Path("cropId") String cropId,@Path("cityCode") String cityCode);

    @GET("WNXG/ulb/api/new_enter_prise_my_company/myBuyList/{cropID}")
    Call<List<QydOrderRecordDTO>> getQydOrderRecord(@Path("cropID") String cropID);

}

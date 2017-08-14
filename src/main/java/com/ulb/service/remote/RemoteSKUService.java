package com.ulb.service.remote;


import com.ulb.web.dto.SKURecordDTO;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * 调用服务端
 *
 * Created by wangpeng on 25/07/2017.
 */
public interface RemoteSKUService {

    @GET("/ulb/api/new_enter_prise_my_order/repairDetails/{skuId}/{cityCode}")
    Call<SKURecordDTO> getSKU(@Path("skuId") String skuId, @Path("cityCode") String cityCode);

}

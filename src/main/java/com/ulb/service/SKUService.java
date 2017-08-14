package com.ulb.service;

import java.io.IOException;

import com.ulb.service.generator.APIServiceGenrator;
import com.ulb.service.remote.RemoteSKUService;
import com.ulb.web.dto.SKURecordDTO;

import org.springframework.stereotype.Service;

import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by wangpeng on 25/07/2017.
 *
 * Service For SKU
 */

@Service
public class SKUService {

    public SKURecordDTO getSKU(String skuId,String cityCode) throws IOException {
        RemoteSKUService service = APIServiceGenrator.createRequsetService(RemoteSKUService.class);
        Call<SKURecordDTO> call = service.getSKU(skuId,cityCode);
        Response<SKURecordDTO> response = call.execute();
        SKURecordDTO dto = response.body();
        return dto;
    }

}

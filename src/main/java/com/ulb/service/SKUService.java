package com.ulb.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.ulb.service.generator.APIServiceGenrator;
import com.ulb.service.remote.RemoteSKUService;
import com.ulb.web.dto.ResultDTO;
import com.ulb.web.dto.SKUOrderRecordDTO;
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


    public ResultDTO order(SKUOrderRecordDTO skuOrderRecordDTO) throws IOException {
        RemoteSKUService service = APIServiceGenrator.createRequsetService(RemoteSKUService.class);
        Call<ResultDTO> call = service.postOrder(skuOrderRecordDTO);
        Response<ResultDTO> response = call.execute();
        return response.body();
    }

//    public List<SKURecordDTO> getSKUOrderRecord(String uid) throws IOException{
//        RemoteSKUService service = APIServiceGenrator.createRequsetService(RemoteSKUService.class);
//        Call<List<SKURecordDTO>> call = service.getSKUOrderRecord(uid);
//        Response<List<SKURecordDTO>> response = call.execute();
//        List<SKURecordDTO> list = response.body();
//        return list;
//    }

}

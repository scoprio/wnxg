package com.ulb.service;

import java.io.IOException;
import java.util.List;

import com.ulb.service.generator.APIServiceGenrator;
import com.ulb.service.remote.RemoteSKUService;
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
public class UserService {

    //获取SKU订单
    public SKURecordDTO getSKU(String skuId,String cityCode) throws IOException {
        return null;
    }

    //获取盾服务订单
    public void order(SKUOrderRecordDTO skuOrderRecordDTO) throws IOException {
        RemoteSKUService service = APIServiceGenrator.createRequsetService(RemoteSKUService.class);
        Call<String> call = service.postOrder(skuOrderRecordDTO);
        call.execute();
    }
    //获取发票列表
    public List<SKURecordDTO> getSKUOrderRecord(String uid) throws IOException{
       return null;
    }

}

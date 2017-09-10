package com.ulb.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.ulb.service.generator.APIServiceGenrator;
import com.ulb.service.remote.RemoteQFService;
import com.ulb.service.remote.RemoteSKUService;
import com.ulb.web.dto.Comment2DTO;
import com.ulb.web.dto.CommentDTO;
import com.ulb.web.dto.OperaterOrderDTO;
import com.ulb.web.dto.OrderDetailDTO;
import com.ulb.web.dto.PayStateDTO;
import com.ulb.web.dto.ResultDTO;
import com.ulb.web.dto.SKUOrderRecordDTO;
import com.ulb.web.dto.SKUOrderStateDTO;
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

    public OrderDetailDTO getSKUOrderService(String orderId,String cityCode) throws IOException {
        RemoteSKUService service = APIServiceGenrator.createRequsetService(RemoteSKUService.class);
        Call<OrderDetailDTO> call = service.getOrderDetail(orderId,cityCode);
        Response<OrderDetailDTO> response = call.execute();
        return response.body();
    }

    public ResultDTO updateOrder(String orderId,OperaterOrderDTO operaterOrderDTO) throws IOException {
        RemoteSKUService service = APIServiceGenrator.createRequsetService(RemoteSKUService.class);
        Call<ResultDTO> call = service.updateOrder(orderId,operaterOrderDTO);
        Response<ResultDTO> response = call.execute();
        return response.body();
    }


    public ResultDTO comment(CommentDTO commentDTO) throws IOException {
        RemoteSKUService service = APIServiceGenrator.createRequsetService(RemoteSKUService.class);
        Call<ResultDTO> call = service.comment(commentDTO);
        Response<ResultDTO> response = call.execute();
        return response.body();
    }

    public ResultDTO pay(String orderId,String cityCode,SKUOrderStateDTO payStateDTO) throws IOException {
        RemoteSKUService service = APIServiceGenrator.createRequsetService(RemoteSKUService.class);
        Call<ResultDTO> call = service.payOrder(orderId,cityCode,payStateDTO);
        Response<ResultDTO> response = call.execute();
        return response.body();
    }
}

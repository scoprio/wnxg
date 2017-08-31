package com.ulb.service;

import java.io.IOException;
import java.util.List;

import com.ulb.service.generator.APIServiceGenrator;
import com.ulb.service.remote.RemoteQFService;
import com.ulb.service.remote.RemoteSKUService;
import com.ulb.web.dto.Comment2DTO;
import com.ulb.web.dto.Comment2InfoDTO;
import com.ulb.web.dto.PayStateDTO;
import com.ulb.web.dto.QFOrderRecordDTO;
import com.ulb.web.dto.QFRecordDetailDTO;
import com.ulb.web.dto.QFRepairPostDTO;
import com.ulb.web.dto.ResultDTO;
import com.ulb.web.dto.ResultWithQFDTO;
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
public class QFService {

//    public SKURecordDTO getSKU(String skuId,String cityCode) throws IOException {
//        RemoteSKUService service = APIServiceGenrator.createRequsetService(RemoteSKUService.class);
//        Call<SKURecordDTO> call = service.getSKU(skuId,cityCode);
//        Response<SKURecordDTO> response = call.execute();
//        SKURecordDTO dto = response.body();
//        return dto;
//    }





    public ResultWithQFDTO order(QFOrderRecordDTO qfOrderRecordDTO) throws IOException {
        RemoteQFService service = APIServiceGenrator.createRequsetService(RemoteQFService.class);
        Call<ResultWithQFDTO> call = service.postOrder(qfOrderRecordDTO);
        Response<ResultWithQFDTO> response = call.execute();
        return response.body();
    }


    public ResultDTO pay(String qufuId,PayStateDTO payStateDTO) throws IOException {
        RemoteQFService service = APIServiceGenrator.createRequsetService(RemoteQFService.class);
        Call<ResultDTO> call = service.payOrder(qufuId,payStateDTO);
        Response<ResultDTO> response = call.execute();
        return response.body();
    }

    public ResultDTO comment(Comment2DTO comment2DTO) throws IOException {
        RemoteQFService service = APIServiceGenrator.createRequsetService(RemoteQFService.class);
        Call<ResultDTO> call = service.comment(comment2DTO);
        Response<ResultDTO> response = call.execute();
        return response.body();
    }

    public ResultDTO repair(QFRepairPostDTO qfRepairPostDTO) throws IOException {
        RemoteQFService service = APIServiceGenrator.createRequsetService(RemoteQFService.class);
        Call<ResultDTO> call = service.postRepair(qfRepairPostDTO);
        Response<ResultDTO> response = call.execute();
        return response.body();
    }

    public QFRecordDetailDTO getQFRecordDetail(String qifuId) throws IOException {
        RemoteQFService service = APIServiceGenrator.createRequsetService(RemoteQFService.class);
        Call<QFRecordDetailDTO> call = service.getQFRecordDetail(qifuId);
        Response<QFRecordDetailDTO> response = call.execute();
        return response.body();
    }

    public List<Comment2InfoDTO> getComments(String serviceId) throws IOException{
        RemoteQFService service = APIServiceGenrator.createRequsetService(RemoteQFService.class);
        Call<List<Comment2InfoDTO>> call = service.getComments(serviceId);
        Response<List<Comment2InfoDTO>> response = call.execute();
        List<Comment2InfoDTO> list = response.body();
        return list;
    }

}

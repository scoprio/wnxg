package com.ulb.service;

import java.io.IOException;
import java.util.List;

import com.ulb.common.dao.FeedbackMapper;
import com.ulb.common.dao.UPermissionMapper;
import com.ulb.common.model.Feedback;
import com.ulb.common.model.UPermission;
import com.ulb.service.generator.APIServiceGenrator;
import com.ulb.service.remote.RemoteMyService;
import com.ulb.service.remote.RemoteSKUService;
import com.ulb.web.dto.FeedbackDTO;
import com.ulb.web.dto.OrderRecordDTO;
import com.ulb.web.dto.QydOrderRecordDTO;
import com.ulb.web.dto.SKUOrderRecordDTO;
import com.ulb.web.dto.SKURecordDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by wangpeng on 25/07/2017.
 *
 * Service For SKU
 */

@Service
public class MyService {

    @Autowired
    FeedbackMapper feedbackMapper;

    public List<OrderRecordDTO> getSKUOrderRecord(String uid,String cityCode) throws IOException{
        RemoteMyService service = APIServiceGenrator.createRequsetService(RemoteMyService.class);
        Call<List<OrderRecordDTO>> call = service.getSKUOrderRecord(uid,cityCode);
        Response<List<OrderRecordDTO>> response = call.execute();
        List<OrderRecordDTO> list = response.body();
        return list;
    }


    public List<OrderRecordDTO> getCropSKUOrderRecord(String cropId,String cityCode) throws IOException{
        RemoteMyService service = APIServiceGenrator.createRequsetService(RemoteMyService.class);
        Call<List<OrderRecordDTO>> call = service.getCropSKUOrderRecord(cropId,cityCode);
        Response<List<OrderRecordDTO>> response = call.execute();
        List<OrderRecordDTO> list = response.body();
        return list;
    }

    public List<QydOrderRecordDTO> getQydOrderRecord(String cropId) throws IOException{
        RemoteMyService service = APIServiceGenrator.createRequsetService(RemoteMyService.class);
        Call<List<QydOrderRecordDTO>> call = service.getQydOrderRecord(cropId);
        Response<List<QydOrderRecordDTO>> response = call.execute();
        List<QydOrderRecordDTO> list = response.body();
        return list;
    }


    public Feedback insert(FeedbackDTO feedbackDTO) {

        Feedback feedback = new Feedback();
        feedback.setEmail(feedbackDTO.getEmail());
        feedback.setCommits(feedbackDTO.getCommit());
        feedbackMapper.insert(feedback);
        return feedback;
    }

}

package com.ulb.service;

import java.io.IOException;
import java.util.List;

import com.ulb.service.generator.APIServiceGenrator;
import com.ulb.service.remote.RemoteSKUService;
import com.ulb.web.dto.SKUOrderRecordDTO;
import com.ulb.web.dto.SKURecordDTO;
import com.ulb.web.dto.UsefulTimeDTO;

import org.springframework.stereotype.Service;

import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by wangpeng on 25/07/2017.
 *
 * Service For SKU
 */

@Service
public class TimeService {

    public List<UsefulTimeDTO> getUsefulTime() throws IOException{
        RemoteSKUService service = APIServiceGenrator.createRequsetService(RemoteSKUService.class);
        Call<List<UsefulTimeDTO>> call = service.getUsefulTime();
        Response<List<UsefulTimeDTO>> response = call.execute();
        List<UsefulTimeDTO> list = response.body();
        return list;
    }

}

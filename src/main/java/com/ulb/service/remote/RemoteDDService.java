package com.ulb.service.remote;


import java.util.List;

import com.ulb.web.dto.CommentDTO;
import com.ulb.web.dto.DDMessageDTO;
import com.ulb.web.dto.DingResultDTO;
import com.ulb.web.dto.OperaterOrderDTO;
import com.ulb.web.dto.OrderDetailDTO;
import com.ulb.web.dto.ResultDTO;
import com.ulb.web.dto.SKUOrderRecordDTO;
import com.ulb.web.dto.SKUOrderStateDTO;
import com.ulb.web.dto.SKURecordDTO;
import com.ulb.web.dto.UsefulTimeDTO;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

/**
 * 调用DD服务端
 *
 * Created by wangpeng on 25/07/2017.
 */
public interface RemoteDDService {

    @Headers({"Content-type:application/json;charset=UTF-8"})
    @POST("/message/send_to_conversation?access_token={access_token}")
    Call<DingResultDTO> sendToConversation(@Path("access_token") String access_token,@Body DDMessageDTO ddMessageDTO);

}

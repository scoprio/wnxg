package com.ulb.service.remote;



import java.util.List;

import com.ulb.web.dto.Comment2DTO;
import com.ulb.web.dto.Comment2InfoDTO;
import com.ulb.web.dto.OperaterDTO;
import com.ulb.web.dto.OperaterOrderDTO;
import com.ulb.web.dto.OrderRecordDTO;
import com.ulb.web.dto.PayStateDTO;
import com.ulb.web.dto.QFOrderRecordDTO;
import com.ulb.web.dto.QFRecordDetailDTO;
import com.ulb.web.dto.QFRepairPostDTO;
import com.ulb.web.dto.ResultDTO;
import com.ulb.web.dto.ResultWithQFDTO;
import com.ulb.web.dto.SKUOrderStateDTO;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

/**
 * 调用服务端企业盾接口
 *
 * Created by wangpeng on 25/07/2017.
 */
public interface RemoteQFService {

    /**
     * 企业盾详情
     * @param qifuId
     * @return
     */
    @GET("/WNXG/ulb/api/new_enter_prise_my_company/myDetails/{qifuId}")
    Call<QFRecordDetailDTO> getQFRecordDetail(@Path("qifuId") String qifuId);

    /**
     * 提交企业盾购买记录
     * @param qfOrderRecordDTO
     * @return
     */
    @Headers({"Content-type:application/json;charset=UTF-8"})
    @POST("/WNXG/ulb/api/new_enter_prise_my_company/enterprise")
    Call<ResultWithQFDTO> postOrder(@Body QFOrderRecordDTO qfOrderRecordDTO);

    /**
     * 提交企业盾订单(维修记录)
     * @param qfRepairPostDTO
     * @return
     */
    @Headers({"Content-type:application/json;charset=UTF-8"})
    @POST("/WNXG/ulb/api/new_enter_prise_my_company/addedOrder")
    Call<ResultDTO> postRepair(@Body QFRepairPostDTO qfRepairPostDTO);

    /**
     * 提交企业盾评论
     * @param comment2DTO
     * @return
     */
    @Headers({"Content-type:application/json;charset=UTF-8"})
    @POST("/WNXG/ulb/api/new_enter_prise_my_company/companyComment")
    Call<ResultDTO> comment(@Body Comment2DTO comment2DTO);

    /**
     * 获取企业盾评论
     * @param serviceId
     * @return
     */
    @GET("/WNXG/ulb/api/new_enter_prise_my_company/orderList/{serviceId}")
    Call<List<Comment2InfoDTO>> getComments(@Path("serviceId") String serviceId);

    /**
     * 支付企业盾
     * @param qfId
     * @param payStateDTO
     * @return
     */
    @Headers({"Content-type:application/json;charset=UTF-8"})
    @PUT("/WNXG/ulb/api/new_enter_prise_my_company/afterOnline/{qfId}")
    Call<ResultDTO> payOrder(@Path("qfId")String qfId,@Body PayStateDTO payStateDTO);

    /**
     * 确认企业盾订单(维修记录)
     * @param orderId
     * @param operaterDTO
     * @return
     */
    @Headers({"Content-type:application/json;charset=UTF-8"})
    @PUT("/WNXG/ulb/api/new_enter_prise_my_company/companyOrder/{orderId}")
    Call<ResultDTO> confirmOrder(@Path("orderId")String orderId,@Body OperaterDTO operaterDTO);

}

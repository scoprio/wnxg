package com.ulb.web.dto;


/**
 * Created by wangpeng on 25/07/2017.
 */
public class SKUOrderRecordDTO {

    private String cityCode;

    private OrderRecordDTO orderRecordDTO;

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public OrderRecordDTO getOrderRecordDTO() {
        return orderRecordDTO;
    }

    public void setOrderRecordDTO(OrderRecordDTO orderRecordDTO) {
        this.orderRecordDTO = orderRecordDTO;
    }
}

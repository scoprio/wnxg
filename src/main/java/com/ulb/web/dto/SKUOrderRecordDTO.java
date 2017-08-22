package com.ulb.web.dto;


/**
 * Created by wangpeng on 25/07/2017.
 */
public class SKUOrderRecordDTO {

    private String cityCode;

    private String openId;

    private String companyCode;

    private OrderRecordDTO order;

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public OrderRecordDTO getOrder() {
        return order;
    }

    public void setOrder(OrderRecordDTO order) {
        this.order = order;
    }



}

package com.ulb.web.dto;


/**
 * Created by wangpeng on 25/07/2017.
 */
public class QFRecordDTO {

    private DingDingConfigDTO config;

    private String cityCode;

    private String alipayInfo;

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public DingDingConfigDTO getConfig() {
        return config;
    }

    public void setConfig(DingDingConfigDTO config) {
        this.config = config;
    }

    public String getAlipayInfo() {
        return alipayInfo;
    }

    public void setAlipayInfo(String alipayInfo) {
        this.alipayInfo = alipayInfo;
    }
}

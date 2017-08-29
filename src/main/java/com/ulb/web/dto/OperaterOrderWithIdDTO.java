package com.ulb.web.dto;


/**
 * Created by wangpeng on 25/07/2017.
 */
public class OperaterOrderWithIdDTO {

    private String id;
    
    private String cityCode;

    private Integer operater;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public Integer getOperater() {
        return operater;
    }

    public void setOperater(Integer operater) {
        this.operater = operater;
    }
}

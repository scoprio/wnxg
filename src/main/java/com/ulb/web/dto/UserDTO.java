package com.ulb.web.dto;

/**
 * Created by wangpeng on 25/07/2017.
 */
public class UserDTO {

    private String userId;

    private String cityCode;

    private String corpId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getCorpId() {
        return corpId;
    }

    public void setCorpId(String corpId) {
        this.corpId = corpId;
    }
}

package com.ulb.web.dto;


/**
 * Created by wangpeng on 25/07/2017.
 */
public class QydInfoDTO {

    private String isAdmin;

    private String corpId;

    private String cityCode;

    public String getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(String isAdmin) {
        this.isAdmin = isAdmin;
    }

    public String getCorpId() {
        return corpId;
    }

    public void setCorpId(String corpId) {
        this.corpId = corpId;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }
}

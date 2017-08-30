package com.ulb.web.dto;


import java.util.List;

/**
 * Created by wangpeng on 25/07/2017.
 */
public class QydInfoDTO {

    private String isAdmin;

    private String corpId;

    private String cityCode;

    private List<Comment2InfoDTO> list;

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

    public List<Comment2InfoDTO> getList() {
        return list;
    }

    public void setList(List<Comment2InfoDTO> list) {
        this.list = list;
    }
}

package com.ulb.web.dto;

import java.util.List;

/**
 * Created by wangpeng on 21/08/2017.
 */
public class DingReturnAdminDTO {

    private int errcode;

    private String errmsg;

    private List<DingAdminDTO> adminList;

    public int getErrcode() {
        return errcode;
    }

    public void setErrcode(int errcode) {
        this.errcode = errcode;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public List<DingAdminDTO> getAdminList() {
        return adminList;
    }

    public void setAdminList(List<DingAdminDTO> adminList) {
        this.adminList = adminList;
    }
}

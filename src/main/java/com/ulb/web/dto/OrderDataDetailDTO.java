package com.ulb.web.dto;

import java.math.BigDecimal;

/**
 * Created by wangpeng on 27/08/2017.
 */
public class OrderDataDetailDTO {

    private Integer pid;
    private Long updatetime;

    private String pName;
    private String updateDateTime;

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getUpdateDateTime() {
        return updateDateTime;
    }

    public void setUpdateDateTime(String updateDateTime) {
        this.updateDateTime = updateDateTime;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Long getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Long updatetime) {
        this.updatetime = updatetime;
    }
}

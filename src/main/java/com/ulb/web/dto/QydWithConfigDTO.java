package com.ulb.web.dto;

import java.util.List;

/**
 * Created by wangpeng on 31/08/2017.
 */
public class QydWithConfigDTO {

    private List<QydOrderRecordDTO> list;

    private DingDingConfigDTO config;

    public List<QydOrderRecordDTO> getList() {
        return list;
    }

    public void setList(List<QydOrderRecordDTO> list) {
        this.list = list;
    }

    public DingDingConfigDTO getConfig() {
        return config;
    }

    public void setConfig(DingDingConfigDTO config) {
        this.config = config;
    }
}

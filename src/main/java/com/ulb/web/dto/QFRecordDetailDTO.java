package com.ulb.web.dto;


import java.util.List;

/**
 * Created by wangpeng on 25/07/2017.
 */
public class QFRecordDetailDTO {


    private QFCompanyInfoDTO info;

    private List<QFRepairDTO> repairList;


    public QFCompanyInfoDTO getInfo() {
        return info;
    }

    public void setInfo(QFCompanyInfoDTO info) {
        this.info = info;
    }

    public List<QFRepairDTO> getRepairList() {
        return repairList;
    }

    public void setRepairList(List<QFRepairDTO> repairList) {
        this.repairList = repairList;
    }
}

package com.ulb.web.dto;


/**
 * Created by wangpeng on 25/07/2017.
 */
public class QFOrderRecordDTO {


    private ServiceBuyRecordDTO serviceBuyRecord;
    private CompanyInfoDTO companyInfo;

    public ServiceBuyRecordDTO getServiceBuyRecord() {
        return serviceBuyRecord;
    }

    public void setServiceBuyRecord(ServiceBuyRecordDTO serviceBuyRecord) {
        this.serviceBuyRecord = serviceBuyRecord;
    }

    public CompanyInfoDTO getCompanyInfo() {
        return companyInfo;
    }

    public void setCompanyInfo(CompanyInfoDTO companyInfo) {
        this.companyInfo = companyInfo;
    }
}

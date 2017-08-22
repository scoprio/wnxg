package com.ulb.web.dto;


/**
 * Created by wangpeng on 25/07/2017.
 */
public class QFOrderRecordDTO {


    private ServiceBuyRecordDTO serviceBuyRecordDTO;
    private CompanyInfoDTO companyInfoDTO;


    public ServiceBuyRecordDTO getServiceBuyRecordDTO() {
        return serviceBuyRecordDTO;
    }

    public void setServiceBuyRecordDTO(ServiceBuyRecordDTO serviceBuyRecordDTO) {
        this.serviceBuyRecordDTO = serviceBuyRecordDTO;
    }

    public CompanyInfoDTO getCompanyInfoDTO() {
        return companyInfoDTO;
    }

    public void setCompanyInfoDTO(CompanyInfoDTO companyInfoDTO) {
        this.companyInfoDTO = companyInfoDTO;
    }
}

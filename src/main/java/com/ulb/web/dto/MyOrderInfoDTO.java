package com.ulb.web.dto;

import java.util.List;

/**
 * Created by wangpeng on 25/07/2017.
 */
public class MyOrderInfoDTO {

    private String dingdingUserId;

    private List<OrderRecordDTO> skuOrders;

    private List<ServiceRecordDTO> serviceOrders;

    private List<InvoiceDTO> invoices;

    public String getDingdingUserId() {
        return dingdingUserId;
    }

    public void setDingdingUserId(String dingdingUserId) {
        this.dingdingUserId = dingdingUserId;
    }

    public List<OrderRecordDTO> getSkuOrders() {
        return skuOrders;
    }

    public void setSkuOrders(List<OrderRecordDTO> skuOrders) {
        this.skuOrders = skuOrders;
    }

    public List<ServiceRecordDTO> getServiceOrders() {
        return serviceOrders;
    }

    public void setServiceOrders(List<ServiceRecordDTO> serviceOrders) {
        this.serviceOrders = serviceOrders;
    }

    public List<InvoiceDTO> getInvoices() {
        return invoices;
    }

    public void setInvoices(List<InvoiceDTO> invoices) {
        this.invoices = invoices;
    }
}

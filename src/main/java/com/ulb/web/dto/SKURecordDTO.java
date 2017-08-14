package com.ulb.web.dto;

import java.math.BigDecimal;

/**
 * Created by wangpeng on 25/07/2017.
 */
public class SKURecordDTO {

    private String id;

    private String name;

    private BigDecimal price;

    private String desc;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}

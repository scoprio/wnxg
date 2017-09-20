package com.ulb.web.dto;

/**
 * Created by wangpeng on 20/09/2017.
 */
public class KeyValueDTO {

    private String key;

    private String value;

    public KeyValueDTO(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}

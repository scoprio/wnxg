package com.ulb.web.dto;

import java.util.List;

/**
 * Created by wangpeng on 20/09/2017.
 */
public class OAMessageBodyDTO {

    private String title;

    private List<KeyValueDTO> form;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<KeyValueDTO> getForm() {
        return form;
    }

    public void setForm(List<KeyValueDTO> form) {
        this.form = form;
    }
}

package com.ulb.web.dto;

/**
 * Created by wangpeng on 20/09/2017.
 */
public class OAMessageHeadDTO {

    private String bgcolor;

    private String text;

    public OAMessageHeadDTO(String bgcolor, String text) {
        this.bgcolor = bgcolor;
        this.text = text;
    }

    public String getBgcolor() {
        return bgcolor;
    }

    public void setBgcolor(String bgcolor) {
        this.bgcolor = bgcolor;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}

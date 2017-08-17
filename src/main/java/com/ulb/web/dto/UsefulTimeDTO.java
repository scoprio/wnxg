package com.ulb.web.dto;

import java.util.List;

/**
 * Created by wangpeng on 25/07/2017.
 */
public class UsefulTimeDTO {

    private String date;

    private List<String> time;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<String> getTime() {
        return time;
    }

    public void setTime(List<String> time) {
        this.time = time;
    }
}

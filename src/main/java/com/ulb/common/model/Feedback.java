package com.ulb.common.model;

import java.io.Serializable;
import java.util.Date;

import net.sf.json.JSONObject;

public class Feedback implements Serializable{

	private Long id;

    private String commits;

    private String email;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCommits() {
        return commits;
    }

    public void setCommits(String commits) {
        this.commits = commits;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
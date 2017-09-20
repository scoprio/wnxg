package com.ulb.web.dto;

/**
 * Created by wangpeng on 20/09/2017.
 */
public class OAMessageDTO {

    private String message_url;

    private OAMessageHeadDTO head;

    private OAMessageBodyDTO body;

    public String getMessage_url() {
        return message_url;
    }

    public void setMessage_url(String message_url) {
        this.message_url = message_url;
    }

    public OAMessageHeadDTO getHead() {
        return head;
    }

    public void setHead(OAMessageHeadDTO head) {
        this.head = head;
    }

    public OAMessageBodyDTO getBody() {
        return body;
    }

    public void setBody(OAMessageBodyDTO body) {
        this.body = body;
    }
}

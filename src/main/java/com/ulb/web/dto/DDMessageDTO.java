package com.ulb.web.dto;

/**
 * Created by wangpeng on 20/09/2017.
 */
public class DDMessageDTO {

    private String sender;

    private String cid;

    private String msgtype;

    private OAMessageDTO oa;

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getMsgtype() {
        return msgtype;
    }

    public void setMsgtype(String msgtype) {
        this.msgtype = msgtype;
    }

    public OAMessageDTO getOa() {
        return oa;
    }

    public void setOa(OAMessageDTO oa) {
        this.oa = oa;
    }
}

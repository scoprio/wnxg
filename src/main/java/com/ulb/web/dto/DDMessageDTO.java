package com.ulb.web.dto;

/**
 * Created by wangpeng on 20/09/2017.
 */
public class DDMessageDTO {

    private String touser;

    private String toparty;

    private String agentid;

    private String msgtype;

    private OAMessageDTO oa;

    public String getTouser() {
        return touser;
    }

    public void setTouser(String touser) {
        this.touser = touser;
    }

    public String getToparty() {
        return toparty;
    }

    public void setToparty(String toparty) {
        this.toparty = toparty;
    }

    public String getAgentid() {
        return agentid;
    }

    public void setAgentid(String agentid) {
        this.agentid = agentid;
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

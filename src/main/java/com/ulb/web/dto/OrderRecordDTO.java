package com.ulb.web.dto;

import java.math.BigDecimal;

/**
 * Created by wangpeng on 25/07/2017.
 */
public class OrderRecordDTO {

    private String yuyueTime;
    private String street;
    private String houseNumber;
    private String village;

    private String address;
    private String remark;
    private String tel;

    private String aid;
    private String rid;
    private String name;
    private String repairName;
    private BigDecimal latitude;
    private BigDecimal longitude;
    private Integer pid;

    private String statusName;
    private String cityCode;
    private String title;
    // 钉钉B端ID
    private int ori;

    /**订单列表**/
    private String oid;
    private String downTime;
    private String orderState;

    private String display;
    private String onum;


    private String commentDisplay;
    private String auditDisplay;
    private String payDisplay;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    /**订单详情**/



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }
    public String getYuyueTime() {
        return yuyueTime;
    }

    public void setYuyueTime(String yuyueTime) {
        this.yuyueTime = yuyueTime;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getVillage() {
        return village;
    }

    public void setVillage(String village) {
        this.village = village;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getRid() {
        return rid;
    }

    public void setRid(String rid) {
        this.rid = rid;
    }

    public String getAid() {
        return aid;
    }

    public void setAid(String aid) {
        this.aid = aid;
    }

    public String getRepairName() {
        return repairName;
    }

    public void setRepairName(String repairName) {
        this.repairName = repairName;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public int getOri() {
        return ori;
    }

    public void setOri(int ori) {
        this.ori = ori;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getDownTime() {
        return downTime;
    }

    public void setDownTime(String downTime) {
        this.downTime = downTime;
    }

    public String getOrderState() {
        return orderState;
    }

    public void setOrderState(String orderState) {
        this.orderState = orderState;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    public String getOnum() {
        return onum;
    }

    public void setOnum(String onum) {
        this.onum = onum;
    }

    public String getCommentDisplay() {
        return commentDisplay;
    }

    public void setCommentDisplay(String commentDisplay) {
        this.commentDisplay = commentDisplay;
    }

    public String getPayDisplay() {
        return payDisplay;
    }

    public void setPayDisplay(String payDisplay) {
        this.payDisplay = payDisplay;
    }

    public String getAuditDisplay() {
        return auditDisplay;
    }

    public void setAuditDisplay(String auditDisplay) {
        this.auditDisplay = auditDisplay;
    }
}

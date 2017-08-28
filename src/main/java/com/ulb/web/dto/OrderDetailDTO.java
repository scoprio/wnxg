package com.ulb.web.dto;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by wangpeng on 27/08/2017.
 */
public class OrderDetailDTO {

    private String address;
    private String userName;
    private Integer accId;
    private Integer oid;
    private String remark;
    private String employeeid;
    private String onum;
    private Integer pid;
    private String downTime;
    private String yuyueTime;
    private Integer cost;
    private Integer costMaterial;
    private Integer surcharge;
    private String uidKh;
    private String cityCode;
    private String orderState;
    private String repairName;
    private String xgName;
    private String image;
    private BigDecimal totalFee;
    private BigDecimal repairPrice;
    private String repaUnit;
    private String platformPrice;
    private String xgPhone;

    private String userPhone;

    private String display;

    private List<OrderDataDetailDTO> orderDatas;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getAccId() {
        return accId;
    }

    public void setAccId(Integer accId) {
        this.accId = accId;
    }

    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getEmployeeid() {
        return employeeid;
    }

    public void setEmployeeid(String employeeid) {
        this.employeeid = employeeid;
    }

    public String getOnum() {
        return onum;
    }

    public void setOnum(String onum) {
        this.onum = onum;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getDownTime() {
        return downTime;
    }

    public void setDownTime(String downTime) {
        this.downTime = downTime;
    }

    public String getYuyueTime() {
        return yuyueTime;
    }

    public void setYuyueTime(String yuyueTime) {
        this.yuyueTime = yuyueTime;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public Integer getCostMaterial() {
        return costMaterial;
    }

    public void setCostMaterial(Integer costMaterial) {
        this.costMaterial = costMaterial;
    }

    public Integer getSurcharge() {
        return surcharge;
    }

    public void setSurcharge(Integer surcharge) {
        this.surcharge = surcharge;
    }

    public String getUidKh() {
        return uidKh;
    }

    public void setUidKh(String uidKh) {
        this.uidKh = uidKh;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getOrderState() {
        return orderState;
    }

    public void setOrderState(String orderState) {
        this.orderState = orderState;
    }

    public String getRepairName() {
        return repairName;
    }

    public void setRepairName(String repairName) {
        this.repairName = repairName;
    }

    public String getXgName() {
        return xgName;
    }

    public void setXgName(String xgName) {
        this.xgName = xgName;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public BigDecimal getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(BigDecimal totalFee) {
        this.totalFee = totalFee;
    }

    public BigDecimal getRepairPrice() {
        return repairPrice;
    }

    public void setRepairPrice(BigDecimal repairPrice) {
        this.repairPrice = repairPrice;
    }

    public String getRepaUnit() {
        return repaUnit;
    }

    public void setRepaUnit(String repaUnit) {
        this.repaUnit = repaUnit;
    }

    public String getPlatformPrice() {
        return platformPrice;
    }

    public void setPlatformPrice(String platformPrice) {
        this.platformPrice = platformPrice;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public List<OrderDataDetailDTO> getOrderDatas() {
        return orderDatas;
    }

    public void setOrderDatas(List<OrderDataDetailDTO> orderDatas) {
        this.orderDatas = orderDatas;
    }

    public String getXgPhone() {
        return xgPhone;
    }

    public void setXgPhone(String xgPhone) {
        this.xgPhone = xgPhone;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }
}

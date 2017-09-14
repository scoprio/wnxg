package com.ulb.web.dto;


/**
 * Created by wangpeng on 25/07/2017.
 */
public class QFRepairDTO {

    private String repair_name;//对应维修类目名称
    private String repairId;
    private String order_num;//订单编号
    private String order_state;//订单状态
    private String commodity_name;//维修商品名称
    private String count;//维修数量
    private String order_time;//预约时间
    private String pic_url;//维修图片
    private String id;//订单维修记录id
    private String pidName;//订单状态中文信息

    private String createTime;

    private String stateName;

    private String confirmDisplay;

    public String getRepairId() {
        return repairId;
    }

    public void setRepairId(String repairId) {
        this.repairId = repairId;
    }

    public String getRepair_name() {
        return repair_name;
    }

    public void setRepair_name(String repair_name) {
        this.repair_name = repair_name;
    }

    public String getOrder_num() {
        return order_num;
    }

    public void setOrder_num(String order_num) {
        this.order_num = order_num;
    }

    public String getOrder_state() {
        return order_state;
    }

    public void setOrder_state(String order_state) {
        this.order_state = order_state;
    }

    public String getCommodity_name() {
        return commodity_name;
    }

    public void setCommodity_name(String commodity_name) {
        this.commodity_name = commodity_name;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getOrder_time() {
        return order_time;
    }

    public void setOrder_time(String order_time) {
        this.order_time = order_time;
    }

    public String getPic_url() {
        return pic_url;
    }

    public void setPic_url(String pic_url) {
        this.pic_url = pic_url;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPidName() {
        return pidName;
    }

    public void setPidName(String pidName) {
        this.pidName = pidName;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getConfirmDisplay() {s
        return confirmDisplay;
    }

    public void setConfirmDisplay(String confirmDisplay) {
        this.confirmDisplay = confirmDisplay;
    }
}

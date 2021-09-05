package com.galaxy.project.vo;

import com.galaxy.project.annotation.ExcelField;

import java.util.Date;

public class ExportVo {

    @ExcelField(name = "预约成功时间")
    private Date createdAt;

    @ExcelField(name = "预约客人名称")
    private String userName;

    @ExcelField(name = "停车场名称")
    private String parkName;

    @ExcelField(name = "停车场地址")
    private String parkAddress;

    @ExcelField(name = "车位名字")
    private String stallName;

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getParkName() {
        return parkName;
    }

    public void setParkName(String parkName) {
        this.parkName = parkName;
    }

    public String getParkAddress() {
        return parkAddress;
    }

    public void setParkAddress(String parkAddress) {
        this.parkAddress = parkAddress;
    }

    public String getStallName() {
        return stallName;
    }

    public void setStallName(String stallName) {
        this.stallName = stallName;
    }
}

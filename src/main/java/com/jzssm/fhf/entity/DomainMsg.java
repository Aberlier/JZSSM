package com.jzssm.fhf.entity;

import java.util.Date;

public class DomainMsg {
    private Integer msgId;

    private Integer userId;

    private String msgContent;

    private Date createTime;

    private String msgRespon;

    private Integer responId;

    private String responRole;

    public DomainMsg(Integer msgId, Integer userId, String msgContent, Date createTime, String msgRespon, Integer responId, String responRole) {
        this.msgId = msgId;
        this.userId = userId;
        this.msgContent = msgContent;
        this.createTime = createTime;
        this.msgRespon = msgRespon;
        this.responId = responId;
        this.responRole = responRole;
    }

    public DomainMsg() {
        super();
    }

    public Integer getMsgId() {
        return msgId;
    }

    public void setMsgId(Integer msgId) {
        this.msgId = msgId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getMsgContent() {
        return msgContent;
    }

    public void setMsgContent(String msgContent) {
        this.msgContent = msgContent == null ? null : msgContent.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getMsgRespon() {
        return msgRespon;
    }

    public void setMsgRespon(String msgRespon) {
        this.msgRespon = msgRespon == null ? null : msgRespon.trim();
    }

    public Integer getResponId() {
        return responId;
    }

    public void setResponId(Integer responId) {
        this.responId = responId;
    }

    public String getResponRole() {
        return responRole;
    }

    public void setResponRole(String responRole) {
        this.responRole = responRole == null ? null : responRole.trim();
    }
}
package com.jzssm.fhf.entity;

import java.util.Date;

public class DomainMsg {
    private Integer msgId;

    private String msgName;

    private String msgContent;

    private String createTime;

    private Integer userId;

    private Integer userRole;

    public DomainMsg(Integer msgId, String msgName, String msgContent, String createTime, Integer userId,Integer userRole) {
        this.msgId = msgId;
        this.msgName = msgName;
        this.msgContent = msgContent;
        this.createTime = createTime;
        this.userId = userId;
        this.userRole = userRole;
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

    public String getMsgName() {
        return msgName;
    }

    public void setMsgName(String msgName) {
        this.msgName = msgName == null ? null : msgName.trim();
    }

    public String getMsgContent() {
        return msgContent;
    }

    public void setMsgContent(String msgContent) {
        this.msgContent = msgContent == null ? null : msgContent.trim();
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getUserRole() {
        return userRole;
    }

    public void setUserRole(Integer userRole) {
        this.userRole = userRole;
    }
}
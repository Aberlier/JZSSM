package com.jzssm.fhf.entity;

import java.util.Date;

public class DomainMsg {
    private Integer msgId;

    private Integer msgName;

    private String msgContent;

    private Date createTime;

    public DomainMsg(Integer msgId, Integer msgName, String msgContent, Date createTime) {
        this.msgId = msgId;
        this.msgName = msgName;
        this.msgContent = msgContent;
        this.createTime = createTime;
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

    public Integer getMsgName() {
        return msgName;
    }

    public void setMsgName(Integer msgName) {
        this.msgName = msgName;
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
}
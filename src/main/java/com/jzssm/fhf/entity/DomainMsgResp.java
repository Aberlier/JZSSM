package com.jzssm.fhf.entity;

import java.util.Date;

public class DomainMsgResp {
    private Integer resId;

    private String resMsg;

    private String resRole;

    private Date resTime;

    private Integer msgId;

    private Integer resUserId;

    public DomainMsgResp(Integer resId, String resMsg, String resRole, Date resTime, Integer msgId, Integer resUserId) {
        this.resId = resId;
        this.resMsg = resMsg;
        this.resRole = resRole;
        this.resTime = resTime;
        this.msgId = msgId;
        this.resUserId = resUserId;
    }

    public DomainMsgResp() {
        super();
    }

    public Integer getResId() {
        return resId;
    }

    public void setResId(Integer resId) {
        this.resId = resId;
    }

    public String getResMsg() {
        return resMsg;
    }

    public void setResMsg(String resMsg) {
        this.resMsg = resMsg == null ? null : resMsg.trim();
    }

    public String getResRole() {
        return resRole;
    }

    public void setResRole(String resRole) {
        this.resRole = resRole == null ? null : resRole.trim();
    }

    public Date getResTime() {
        return resTime;
    }

    public void setResTime(Date resTime) {
        this.resTime = resTime;
    }

    public Integer getMsgId() {
        return msgId;
    }

    public void setMsgId(Integer msgId) {
        this.msgId = msgId;
    }

    public Integer getResUserId() {
        return resUserId;
    }

    public void setResUserId(Integer resUserId) {
        this.resUserId = resUserId;
    }
}
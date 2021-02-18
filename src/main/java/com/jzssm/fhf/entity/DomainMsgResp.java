package com.jzssm.fhf.entity;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

public class DomainMsgResp {
    private Integer resId;

    private String resMsg;

    private String resRole;

    private String resTime;

    private Integer msgId;

    private Integer resUserId;

    private String msgName;

    private String userName;

    public DomainMsgResp(Integer resId, String resMsg, String resRole, String resTime, Integer msgId, Integer resUserId,String msgName,String userName) {
        this.resId = resId;
        this.resMsg = resMsg;
        this.resRole = resRole;
        this.resTime = resTime;
        this.msgId = msgId;
        this.resUserId = resUserId;
        this.userName = userName;
        this.msgName = msgName;
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

    public String getResTime() {
        return resTime;
    }

    public void setResTime(String resTime) {
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

    public String getMsgName() {
        return msgName;
    }

    public void setMsgName(String msgName) {
        this.msgName = msgName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
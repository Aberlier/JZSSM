package com.jzssm.fhf.entity;

public class DomainRequireUser {
    private Integer reqId;

    private String reqType;

    private String reqDesc;

    private String reqTime;

    private String reqCheckName;

    private String reqCheckRole;

    private String reqCheckRoleId;

    private String reqDoEmpName;

    private String reqDoEmpId;

    private String reqDoEmpPostname;

    private Integer reqUserId;

    private String reqUserName;

    public DomainRequireUser(Integer reqId, String reqType, String reqDesc, String reqTime, String reqCheckName, String reqCheckRole, String reqCheckRoleId, String reqDoEmpName, String reqDoEmpId, String reqDoEmpPostname, Integer reqUserId, String reqUserName) {
        this.reqId = reqId;
        this.reqType = reqType;
        this.reqDesc = reqDesc;
        this.reqTime = reqTime;
        this.reqCheckName = reqCheckName;
        this.reqCheckRole = reqCheckRole;
        this.reqCheckRoleId = reqCheckRoleId;
        this.reqDoEmpName = reqDoEmpName;
        this.reqDoEmpId = reqDoEmpId;
        this.reqDoEmpPostname = reqDoEmpPostname;
        this.reqUserId = reqUserId;
        this.reqUserName = reqUserName;
    }

    public DomainRequireUser() {
        super();
    }

    public Integer getReqId() {
        return reqId;
    }

    public void setReqId(Integer reqId) {
        this.reqId = reqId;
    }

    public String getReqType() {
        return reqType;
    }

    public void setReqType(String reqType) {
        this.reqType = reqType == null ? null : reqType.trim();
    }

    public String getReqDesc() {
        return reqDesc;
    }

    public void setReqDesc(String reqDesc) {
        this.reqDesc = reqDesc == null ? null : reqDesc.trim();
    }

    public String getReqTime() {
        return reqTime;
    }

    public void setReqTime(String reqTime) {
        this.reqTime = reqTime == null ? null : reqTime.trim();
    }

    public String getReqCheckName() {
        return reqCheckName;
    }

    public void setReqCheckName(String reqCheckName) {
        this.reqCheckName = reqCheckName == null ? null : reqCheckName.trim();
    }

    public String getReqCheckRole() {
        return reqCheckRole;
    }

    public void setReqCheckRole(String reqCheckRole) {
        this.reqCheckRole = reqCheckRole == null ? null : reqCheckRole.trim();
    }

    public String getReqCheckRoleId() {
        return reqCheckRoleId;
    }

    public void setReqCheckRoleId(String reqCheckRoleId) {
        this.reqCheckRoleId = reqCheckRoleId == null ? null : reqCheckRoleId.trim();
    }

    public String getReqDoEmpName() {
        return reqDoEmpName;
    }

    public void setReqDoEmpName(String reqDoEmpName) {
        this.reqDoEmpName = reqDoEmpName == null ? null : reqDoEmpName.trim();
    }

    public String getReqDoEmpId() {
        return reqDoEmpId;
    }

    public void setReqDoEmpId(String reqDoEmpId) {
        this.reqDoEmpId = reqDoEmpId == null ? null : reqDoEmpId.trim();
    }

    public String getReqDoEmpPostname() {
        return reqDoEmpPostname;
    }

    public void setReqDoEmpPostname(String reqDoEmpPostname) {
        this.reqDoEmpPostname = reqDoEmpPostname == null ? null : reqDoEmpPostname.trim();
    }

    public Integer getReqUserId() {
        return reqUserId;
    }

    public void setReqUserId(Integer reqUserId) {
        this.reqUserId = reqUserId;
    }

    public String getReqUserName() {
        return reqUserName;
    }

    public void setReqUserName(String reqUserName) {
        this.reqUserName = reqUserName == null ? null : reqUserName.trim();
    }
}
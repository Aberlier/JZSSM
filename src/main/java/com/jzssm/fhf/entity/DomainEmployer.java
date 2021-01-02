package com.jzssm.fhf.entity;

public class DomainEmployer {
    private Integer employerId;

    private String employerName;

    private Integer employerPwd;

    private String employerAge;

    private String employerIdcard;

    private String employerAddress;

    private Integer employerTelnum;

    private String employerPostname;

    private String employerField;

    private String employerDesc;

    private Integer employerRole;

    public DomainEmployer(Integer employerId, String employerName, Integer employerPwd, String employerAge, String employerIdcard, String employerAddress, Integer employerTelnum, String employerPostname, String employerField, String employerDesc, Integer employerRole) {
        this.employerId = employerId;
        this.employerName = employerName;
        this.employerPwd = employerPwd;
        this.employerAge = employerAge;
        this.employerIdcard = employerIdcard;
        this.employerAddress = employerAddress;
        this.employerTelnum = employerTelnum;
        this.employerPostname = employerPostname;
        this.employerField = employerField;
        this.employerDesc = employerDesc;
        this.employerRole = employerRole;
    }

    public DomainEmployer() {
        super();
    }

    public Integer getEmployerId() {
        return employerId;
    }

    public void setEmployerId(Integer employerId) {
        this.employerId = employerId;
    }

    public String getEmployerName() {
        return employerName;
    }

    public void setEmployerName(String employerName) {
        this.employerName = employerName == null ? null : employerName.trim();
    }

    public Integer getEmployerPwd() {
        return employerPwd;
    }

    public void setEmployerPwd(Integer employerPwd) {
        this.employerPwd = employerPwd;
    }

    public String getEmployerAge() {
        return employerAge;
    }

    public void setEmployerAge(String employerAge) {
        this.employerAge = employerAge == null ? null : employerAge.trim();
    }

    public String getEmployerIdcard() {
        return employerIdcard;
    }

    public void setEmployerIdcard(String employerIdcard) {
        this.employerIdcard = employerIdcard == null ? null : employerIdcard.trim();
    }

    public String getEmployerAddress() {
        return employerAddress;
    }

    public void setEmployerAddress(String employerAddress) {
        this.employerAddress = employerAddress == null ? null : employerAddress.trim();
    }

    public Integer getEmployerTelnum() {
        return employerTelnum;
    }

    public void setEmployerTelnum(Integer employerTelnum) {
        this.employerTelnum = employerTelnum;
    }

    public String getEmployerPostname() {
        return employerPostname;
    }

    public void setEmployerPostname(String employerPostname) {
        this.employerPostname = employerPostname == null ? null : employerPostname.trim();
    }

    public String getEmployerField() {
        return employerField;
    }

    public void setEmployerField(String employerField) {
        this.employerField = employerField == null ? null : employerField.trim();
    }

    public String getEmployerDesc() {
        return employerDesc;
    }

    public void setEmployerDesc(String employerDesc) {
        this.employerDesc = employerDesc == null ? null : employerDesc.trim();
    }

    public Integer getEmployerRole() {
        return employerRole;
    }

    public void setEmployerRole(Integer employerRole) {
        this.employerRole = employerRole;
    }
}
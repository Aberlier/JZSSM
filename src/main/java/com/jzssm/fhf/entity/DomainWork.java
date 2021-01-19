package com.jzssm.fhf.entity;

public class DomainWork {
    private Integer workId;

    private String workName;

    private String workType;

    private String workDesc;

    public DomainWork(Integer workId, String workName, String workType, String workDesc) {
        this.workId = workId;
        this.workName = workName;
        this.workType = workType;
        this.workDesc = workDesc;
    }

    public DomainWork() {
        super();
    }

    public Integer getWorkId() {
        return workId;
    }

    public void setWorkId(Integer workId) {
        this.workId = workId;
    }

    public String getWorkName() {
        return workName;
    }

    public void setWorkName(String workName) {
        this.workName = workName == null ? null : workName.trim();
    }

    public String getWorkType() {
        return workType;
    }

    public void setWorkType(String workType) {
        this.workType = workType == null ? null : workType.trim();
    }

    public String getWorkDesc() {
        return workDesc;
    }

    public void setWorkDesc(String workDesc) {
        this.workDesc = workDesc == null ? null : workDesc.trim();
    }
}
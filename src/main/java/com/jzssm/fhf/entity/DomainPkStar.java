package com.jzssm.fhf.entity;

import java.util.Date;

public class DomainPkStar {
    private Integer pkId;

    private String pkStarNum;

    private String pkEmpNamer;

    private Integer pkEmpId;

    private String pkUpdateTime;

    private String pkGiveStarRole;

    private String pkGiveStarName;

    private Integer pkGiveStarId;

    public DomainPkStar(Integer pkId, String pkStarNum, String pkEmpNamer, Integer pkEmpId, String pkUpdateTime, String pkGiveStarRole, String pkGiveStarName, Integer pkGiveStarId) {
        this.pkId = pkId;
        this.pkStarNum = pkStarNum;
        this.pkEmpNamer = pkEmpNamer;
        this.pkEmpId = pkEmpId;
        this.pkUpdateTime = pkUpdateTime;
        this.pkGiveStarRole = pkGiveStarRole;
        this.pkGiveStarName = pkGiveStarName;
        this.pkGiveStarId = pkGiveStarId;
    }

    public DomainPkStar() {
        super();
    }

    public Integer getPkId() {
        return pkId;
    }

    public void setPkId(Integer pkId) {
        this.pkId = pkId;
    }

    public String getPkStarNum() {
        return pkStarNum;
    }

    public void setPkStarNum(String pkStarNum) {
        this.pkStarNum = pkStarNum == null ? null : pkStarNum.trim();
    }

    public String getPkEmpNamer() {
        return pkEmpNamer;
    }

    public void setPkEmpNamer(String pkEmpNamer) {
        this.pkEmpNamer = pkEmpNamer == null ? null : pkEmpNamer.trim();
    }

    public Integer getPkEmpId() {
        return pkEmpId;
    }

    public void setPkEmpId(Integer pkEmpId) {
        this.pkEmpId = pkEmpId;
    }

    public String getPkUpdateTime() {
        return pkUpdateTime;
    }

    public void setPkUpdateTime(String pkUpdateTime) {
        this.pkUpdateTime = pkUpdateTime;
    }

    public String getPkGiveStarRole() {
        return pkGiveStarRole;
    }

    public void setPkGiveStarRole(String pkGiveStarRole) {
        this.pkGiveStarRole = pkGiveStarRole == null ? null : pkGiveStarRole.trim();
    }

    public String getPkGiveStarName() {
        return pkGiveStarName;
    }

    public void setPkGiveStarName(String pkGiveStarName) {
        this.pkGiveStarName = pkGiveStarName == null ? null : pkGiveStarName.trim();
    }

    public Integer getPkGiveStarId() {
        return pkGiveStarId;
    }

    public void setPkGiveStarId(Integer pkGiveStarId) {
        this.pkGiveStarId = pkGiveStarId;
    }
}
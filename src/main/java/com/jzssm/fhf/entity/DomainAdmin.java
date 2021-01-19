package com.jzssm.fhf.entity;

import java.time.LocalDateTime;
import java.util.Date;

public class DomainAdmin {
    private Integer adminId;

    private String adminName;

    private String adminPwd;

    private String adminSex;

    private Date adminCreatetime;

    private Date adminUpdatetime;

    private Integer adminRole;

    private String adminTelnum;

    public DomainAdmin(Integer adminId, String adminName, String adminPwd, String adminSex, Date adminCreatetime, Date adminUpdatetime, Integer adminRole, String adminTelnum) {
        this.adminId = adminId;
        this.adminName = adminName;
        this.adminPwd = adminPwd;
        this.adminSex = adminSex;
        this.adminCreatetime = adminCreatetime;
        this.adminUpdatetime = adminUpdatetime;
        this.adminRole = adminRole;
        this.adminTelnum = adminTelnum;
    }

    public DomainAdmin() {
        super();
    }

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName == null ? null : adminName.trim();
    }

    public String getAdminPwd() {
        return adminPwd;
    }

    public void setAdminPwd(String adminPwd) {
        this.adminPwd = adminPwd == null ? null : adminPwd.trim();
    }

    public String getAdminSex() {
        return adminSex;
    }

    public void setAdminSex(String adminSex) {
        this.adminSex = adminSex == null ? null : adminSex.trim();
    }

    public Date getAdminCreatetime() {
        return adminCreatetime;
    }

    public void setAdminCreatetime(Date adminCreatetime) {
        this.adminCreatetime = adminCreatetime;
    }

    public Date getAdminUpdatetime() {
        return adminUpdatetime;
    }

    public void setAdminUpdatetime(Date adminUpdatetime) {
        this.adminUpdatetime = adminUpdatetime;
    }

    public Integer getAdminRole() {
        return adminRole;
    }

    public void setAdminRole(Integer adminRole) {
        this.adminRole = adminRole;
    }

    public String getAdminTelnum() {
        return adminTelnum;
    }

    public void setAdminTelnum(String adminTelnum) {
        this.adminTelnum = adminTelnum == null ? null : adminTelnum.trim();
    }
}
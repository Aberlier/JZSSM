package com.jzssm.fhf.entity;

public class DomainUser {
    private Integer userId;

    private String userName;

    private String userPwd;

    private Integer userTelnum;

    private String userDemand;

    private String userUrgent;

    private String userAddress;

    private String userDispatchAddress;

    private String userRole;

    private String userOtherDesc;

    public DomainUser(Integer userId, String userName, String userPwd, Integer userTelnum, String userDemand, String userUrgent, String userAddress, String userDispatchAddress, String userRole, String userOtherDesc) {
        this.userId = userId;
        this.userName = userName;
        this.userPwd = userPwd;
        this.userTelnum = userTelnum;
        this.userDemand = userDemand;
        this.userUrgent = userUrgent;
        this.userAddress = userAddress;
        this.userDispatchAddress = userDispatchAddress;
        this.userRole = userRole;
        this.userOtherDesc = userOtherDesc;
    }

    public DomainUser() {
        super();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd == null ? null : userPwd.trim();
    }

    public Integer getUserTelnum() {
        return userTelnum;
    }

    public void setUserTelnum(Integer userTelnum) {
        this.userTelnum = userTelnum;
    }

    public String getUserDemand() {
        return userDemand;
    }

    public void setUserDemand(String userDemand) {
        this.userDemand = userDemand == null ? null : userDemand.trim();
    }

    public String getUserUrgent() {
        return userUrgent;
    }

    public void setUserUrgent(String userUrgent) {
        this.userUrgent = userUrgent == null ? null : userUrgent.trim();
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress == null ? null : userAddress.trim();
    }

    public String getUserDispatchAddress() {
        return userDispatchAddress;
    }

    public void setUserDispatchAddress(String userDispatchAddress) {
        this.userDispatchAddress = userDispatchAddress == null ? null : userDispatchAddress.trim();
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole == null ? null : userRole.trim();
    }

    public String getUserOtherDesc() {
        return userOtherDesc;
    }

    public void setUserOtherDesc(String userOtherDesc) {
        this.userOtherDesc = userOtherDesc == null ? null : userOtherDesc.trim();
    }
}
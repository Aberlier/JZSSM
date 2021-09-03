package com.jzssm.fhf.entity;

import org.springframework.stereotype.Component;

@Component
public class DomainInfoCollect {
    private Integer Id;

    private String postcode;

    private String address;

    private String companyname;

    private String username;

    private String job;

    private String tel1;

    private String tel2;

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getTel1() {
        return tel1;
    }

    public void setTel1(String tel1) {
        this.tel1 = tel1;
    }

    public String getTel2() {
        return tel2;
    }

    public void setTel2(String tel2) {
        this.tel2 = tel2;
    }

    @Override
    public String toString() {
        return "DomainInfoCollect{" +
                "Id=" + Id +
                ", postcode='" + postcode + '\'' +
                ", address='" + address + '\'' +
                ", companyname='" + companyname + '\'' +
                ", username='" + username + '\'' +
                ", job='" + job + '\'' +
                ", tel1=" + tel1 +
                ", tel2='" + tel2 + '\'' +
                '}';
    }
}
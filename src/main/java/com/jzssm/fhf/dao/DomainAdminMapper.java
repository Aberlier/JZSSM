package com.jzssm.fhf.dao;

import com.jzssm.fhf.entity.DomainAdmin;

public interface DomainAdminMapper {
    int deleteByPrimaryKey(Integer adminId);

    int insert(DomainAdmin record);

    int insertSelective(DomainAdmin record);

    DomainAdmin selectByPrimaryKey(Integer adminId);

    int updateByPrimaryKeySelective(DomainAdmin record);

    int updateByPrimaryKey(DomainAdmin record);

    DomainAdmin selectByTelNum(String telnum);
}
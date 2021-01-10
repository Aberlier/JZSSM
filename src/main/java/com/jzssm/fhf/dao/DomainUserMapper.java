package com.jzssm.fhf.dao;

import com.jzssm.fhf.entity.DomainUser;

public interface DomainUserMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(DomainUser record);

    int insertSelective(DomainUser record);

    DomainUser selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(DomainUser record);

    int updateByPrimaryKey(DomainUser record);

    DomainUser selectByTelNum(String telnum);
}
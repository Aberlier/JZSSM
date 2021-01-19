package com.jzssm.fhf.dao;

import com.jzssm.fhf.entity.DomainRequireUser;

public interface DomainRequireUserMapper {
    int deleteByPrimaryKey(Integer reqId);

    int insert(DomainRequireUser record);

    int insertSelective(DomainRequireUser record);

    DomainRequireUser selectByPrimaryKey(Integer reqId);

    int updateByPrimaryKeySelective(DomainRequireUser record);

    int updateByPrimaryKey(DomainRequireUser record);
}
package com.jzssm.fhf.dao;

import com.jzssm.fhf.entity.DomainWork;

public interface DomainWorkMapper {
    int deleteByPrimaryKey(Integer workId);

    int insert(DomainWork record);

    int insertSelective(DomainWork record);

    DomainWork selectByPrimaryKey(Integer workId);

    int updateByPrimaryKeySelective(DomainWork record);

    int updateByPrimaryKey(DomainWork record);
}
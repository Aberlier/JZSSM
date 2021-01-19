package com.jzssm.fhf.dao;

import com.jzssm.fhf.entity.DomainMsg;

public interface DomainMsgMapper {
    int deleteByPrimaryKey(Integer msgId);

    int insert(DomainMsg record);

    int insertSelective(DomainMsg record);

    DomainMsg selectByPrimaryKey(Integer msgId);

    int updateByPrimaryKeySelective(DomainMsg record);

    int updateByPrimaryKey(DomainMsg record);
}
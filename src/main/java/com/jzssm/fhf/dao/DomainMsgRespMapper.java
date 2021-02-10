package com.jzssm.fhf.dao;

import com.jzssm.fhf.entity.DomainMsgResp;

import java.util.List;

public interface DomainMsgRespMapper {
    int deleteByPrimaryKey(Integer resId);

    int insert(DomainMsgResp record);

    int insertSelective(DomainMsgResp record);

    DomainMsgResp selectByPrimaryKey(Integer resId);

    int updateByPrimaryKeySelective(DomainMsgResp record);

    int updateByPrimaryKey(DomainMsgResp record);

    List<DomainMsgResp> selectAllMsgRespData();
}
package com.jzssm.fhf.dao;

import com.jzssm.fhf.entity.DomainMsgResp;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface DomainMsgRespMapper {
    int deleteByPrimaryKey(Integer resId);

    int insert(DomainMsgResp record);

    int insertSelective(DomainMsgResp record);

    DomainMsgResp selectByPrimaryKey(Integer resId);

    int updateByPrimaryKeySelective(DomainMsgResp record);

    int updateByPrimaryKey(DomainMsgResp record);

    List<Map<String,Object>> selectAllMsgRespData(@Param("loginId") Integer loginId);
}
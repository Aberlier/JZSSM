package com.jzssm.fhf.dao;

import com.jzssm.fhf.entity.DomainRequireUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface DomainRequireUserMapper {
    int deleteByPrimaryKey(Integer reqId);

    int insert(DomainRequireUser record);

    int insertSelective(DomainRequireUser record);

    DomainRequireUser selectByPrimaryKey(Integer reqId);

    int updateByPrimaryKeySelective(DomainRequireUser record);

    int updateByPrimaryKey(DomainRequireUser record);

    List<DomainRequireUser> selectAllReqData(Integer loginId);

    DomainRequireUser selectByTelNum(String telnum);

    Map<String, Object> selectByTelRoleLogin(String telnum, String role);

    List<DomainRequireUser> findAllReqByEmpIdData(@Param("loginId") Integer loginId);
}
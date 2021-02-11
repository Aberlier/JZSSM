package com.jzssm.fhf.dao;

import com.jzssm.fhf.entity.DomainUser;
import org.apache.ibatis.annotations.Param;
import org.apache.poi.ss.formula.functions.T;

import java.util.List;
import java.util.Map;

public interface DomainUserMapper {
    int deleteByPrimaryKey(String userId);

    int insert(DomainUser record);

    int insertSelective(DomainUser record);

    DomainUser selectByPrimaryKey(Integer userId);

   List<DomainUser> selectAllUserData();

    int updateByPrimaryKeySelective(DomainUser record);

    int updateByPrimaryKey(DomainUser record);

    Map<String,Object> selectByTelRoleLogin(@Param("telnum") String telnum, @Param("role") String role);

    DomainUser selectByTelNum(String telnum);
}
package com.jzssm.fhf.dao;

import com.jzssm.fhf.entity.DomainUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DomainUserMapper {
    int deleteByPrimaryKey(String userId);

    int insert(DomainUser record);

    int insertSelective(DomainUser record);

    DomainUser selectByPrimaryKey(Integer userId);

   List<DomainUser> selectAllUserData();

    int updateByPrimaryKeySelective(DomainUser record);

    int updateByPrimaryKey(DomainUser record);

    DomainUser selectByTelNum(String telnum);
}
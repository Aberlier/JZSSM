package com.jzssm.fhf.dao;

import com.jzssm.fhf.entity.DomainEmployer;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DomainEmployerMapper {
    int deleteByPrimaryKey(Integer employerId);

    int insert(DomainEmployer record);

    int insertSelective(DomainEmployer record);

    DomainEmployer selectByPrimaryKey(Integer employerId);

    int updateByPrimaryKeySelective(DomainEmployer record);

    int updateByPrimaryKey(DomainEmployer record);

    DomainEmployer selectByTelNum(String telnum);

    List<DomainEmployer> selectAllEmpData();

    int updateField(@Param("workId") Integer workId, @Param("workType") String workType);
}
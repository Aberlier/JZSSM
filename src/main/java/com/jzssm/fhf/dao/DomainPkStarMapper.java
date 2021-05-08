package com.jzssm.fhf.dao;

import com.jzssm.fhf.entity.DomainPkStar;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DomainPkStarMapper {
    int deleteByPrimaryKey(Integer pkId);

    int insert(DomainPkStar record);

    int insertSelective(DomainPkStar record);

    DomainPkStar selectByPrimaryKey(@Param("pkId") Integer pkId, @Param("pkEmpId") Integer pkEmpId);

    int updateByPrimaryKeySelective(DomainPkStar record);

    int updateByPrimaryKey(DomainPkStar record);

    List<DomainPkStar> selectAllPkstarData();

    int updateByStrPostName(@Param("pkEmpId") Integer pkEmpId, @Param("pkStarNum") String pkStarNum);
}
package com.jzssm.fhf.dao;

import com.jzssm.fhf.entity.DomainPkStar;

public interface DomainPkStarMapper {
    int deleteByPrimaryKey(Integer pkId);

    int insert(DomainPkStar record);

    int insertSelective(DomainPkStar record);

    DomainPkStar selectByPrimaryKey(Integer pkId);

    int updateByPrimaryKeySelective(DomainPkStar record);

    int updateByPrimaryKey(DomainPkStar record);
}
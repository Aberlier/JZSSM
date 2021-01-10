package com.jzssm.fhf.service;

import com.jzssm.fhf.entity.DomainUser;

/**
 * @author ：Angular
 * @date ：Created in 2021/1/3 20:34
 * @description：用户业务实现类接口
 * @modified By：
 * @version: v1.0.0$
 */
public interface UserService {
    int deleteByPrimaryKey(Integer userId);

    int insert(DomainUser record);

    int insertSelective(DomainUser record);

    DomainUser selectByPrimaryKey(Integer userId);

    DomainUser selectByTelNum(String telnum);

    int updateByPrimaryKeySelective(DomainUser record);

    int updateByPrimaryKey(DomainUser record);
}

package com.jzssm.fhf.service;

import com.jzssm.fhf.entity.DomainAdmin;

/**
 * @author ：Angular
 * @ProjectName: JZSSM
 * @Package: com.jzssm.fhf.service
 * @InterfaceName: AdminService
 * @date ：Created in 2021/1/16 18:57
 * @description：管理员业务逻辑类
 * @modified By：
 * @version: v1.0.0$
 */
public interface AdminService {
    int deleteByPrimaryKey(Integer userId);

    int insert(DomainAdmin record);

    int insertSelective(DomainAdmin record);

    DomainAdmin selectByPrimaryKey(Integer userId);

    DomainAdmin selectByTelNum(String telnum);

    int updateByPrimaryKeySelective(DomainAdmin record);

    int updateByPrimaryKey(DomainAdmin record);
}

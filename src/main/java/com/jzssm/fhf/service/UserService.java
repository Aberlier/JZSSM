package com.jzssm.fhf.service;

import com.github.pagehelper.PageInfo;
import com.jzssm.fhf.common.Params;
import com.jzssm.fhf.entity.DomainInfoCollect;
import com.jzssm.fhf.entity.DomainUser;
import org.apache.poi.ss.formula.functions.T;

import java.util.Map;

/**
 * @author ：Angular
 * @date ：Created in 2021/1/3 20:34
 * @description：用户业务实现类接口
 * @modified By：
 * @version: v1.0.0$
 */
public interface UserService {
    Boolean deleteByPrimaryKey(String userId);

    Boolean insert(DomainUser record);

    int insertSelective(DomainUser record);

    DomainUser selectByPrimaryKey(Integer userId);

    Map<String,Object> selectByTelRoleLogin(String telnum, String role);

    DomainUser selectByTelNum(String telnum);

    Boolean updateByPrimaryKeySelective(DomainUser record);

    Boolean updateByPrimaryKey(DomainUser record);

    /**
     2      * 分页查询
     3      * @param params 分页参数 pageNo（页码），pageSize（每页查询数目）
     4      * @return
     5      */
    public PageInfo<DomainUser> finds(Params params);

    long counts();

    boolean insertInfo(DomainInfoCollect domainInfoCollect);
}

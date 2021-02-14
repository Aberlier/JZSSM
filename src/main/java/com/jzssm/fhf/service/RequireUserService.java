package com.jzssm.fhf.service;

import com.github.pagehelper.PageInfo;
import com.jzssm.fhf.common.Params;
import com.jzssm.fhf.entity.DomainRequireUser;

/**
 * @author ：Angular
 * @ProjectName: JZSSM
 * @Package: com.jzssm.fhf.service
 * @InterfaceName: DomainRequireUserService
 * @date ：Created in 2021/2/14 10:13
 * @description：
 * @modified By：
 * @version: $
 */
public interface RequireUserService {
    Boolean deleteByPrimaryKey(String userId);

    Boolean insert(DomainRequireUser record);

    int insertSelective(DomainRequireUser record);

    DomainRequireUser selectByPrimaryKey(Integer userId);

    DomainRequireUser selectByTelNum(String telnum);

    int updateByPrimaryKeySelective(DomainRequireUser record);

    Boolean updateByPrimaryKey(DomainRequireUser record);

    /**
     2      * 分页查询
     3      * @param params 分页参数 pageNo（页码），pageSize（每页查询数目）
     4      * @return
     5      */
    public PageInfo<DomainRequireUser> finds(Params params,Integer loginId);

    long counts();
}

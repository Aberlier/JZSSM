package com.jzssm.fhf.service;

import com.github.pagehelper.PageInfo;
import com.jzssm.fhf.common.Params;
import com.jzssm.fhf.entity.DomainPkStar;
import com.jzssm.fhf.entity.DomainWork;

/**
 * @author ：Angular
 * @ProjectName: JZSSM
 * @Package: com.jzssm.fhf.service
 * @InterfaceName: WorkService
 * @date ：Created in 2021/2/9 16:19
 * @description：工作类型管理
 * @modified By：
 * @version: $
 */
public interface WorkService {
    Boolean deleteByPrimaryKey(String userId);

    Boolean insert(DomainWork record);

    int insertSelective(DomainWork record);

    DomainWork selectByPrimaryKey(Integer userId);

    DomainWork selectByTelNum(String telnum);

    int updateByPrimaryKeySelective(DomainWork record);

    Boolean updateByPrimaryKey(DomainWork record);

    /**
     2      * 分页查询
     3      * @param params 分页参数 pageNo（页码），pageSize（每页查询数目）
     4      * @return
     5      */
    public PageInfo<DomainWork> finds(Params params);

    long counts();
}
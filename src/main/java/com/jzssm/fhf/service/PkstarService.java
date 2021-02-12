package com.jzssm.fhf.service;

import com.github.pagehelper.PageInfo;
import com.jzssm.fhf.common.Params;
import com.jzssm.fhf.entity.DomainPkStar;

/**
 * @author ：Angular
 * @ProjectName: JZSSM
 * @Package: com.jzssm.fhf.service
 * @InterfaceName: PkstarService
 * @date ：Created in 2021/2/9 14:49
 * @description：评星管理
 * @modified By：
 * @version: v1.0.0$
 */
public interface PkstarService {
    Boolean deleteByPrimaryKey(String userId);

    Boolean insert(DomainPkStar record);

    int insertSelective(DomainPkStar record);

    DomainPkStar selectByPrimaryKey(Integer index,Integer userId);

    DomainPkStar selectByTelNum(String telnum);

    int updateByPrimaryKeySelective(DomainPkStar record);

    Boolean updateByPrimaryKey(DomainPkStar record);

    /**
     2      * 分页查询
     3      * @param params 分页参数 pageNo（页码），pageSize（每页查询数目）
     4      * @return
     5      */
    public PageInfo<DomainPkStar> finds(Params params);

    long counts();
}

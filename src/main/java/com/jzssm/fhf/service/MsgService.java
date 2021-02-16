package com.jzssm.fhf.service;

import com.github.pagehelper.PageInfo;
import com.jzssm.fhf.common.Params;
import com.jzssm.fhf.entity.DomainMsg;

/**
 * @author ：Angular
 * @ProjectName: JZSSM
 * @Package: com.jzssm.fhf.service
 * @InterfaceName: MsgService
 * @date ：Created in 2021/2/9 12:19
 * @description：留言接口
 * @modified By：
 * @version: v1.0.0$
 */
public interface MsgService  {
    Boolean deleteByPrimaryKey(String userId);

    Boolean insert(DomainMsg record);

    int insertSelective(DomainMsg record);

    DomainMsg selectByPrimaryKey(Integer userId);

    DomainMsg selectByTelNum(String telnum);

    int updateByPrimaryKeySelective(DomainMsg record);

    Boolean updateByPrimaryKey(DomainMsg record);

    /**
     2      * 分页查询
     3      * @param params 分页参数 pageNo（页码），pageSize（每页查询数目）
     4      * @return
     5      */
    public PageInfo<DomainMsg> finds(Params params,Integer loginId);

    long counts();
}

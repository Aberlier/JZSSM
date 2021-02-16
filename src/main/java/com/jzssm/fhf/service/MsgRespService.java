package com.jzssm.fhf.service;

import com.github.pagehelper.PageInfo;
import com.jzssm.fhf.common.Params;
import com.jzssm.fhf.entity.DomainMsg;
import com.jzssm.fhf.entity.DomainMsgResp;

/**
 * @author ：Angular
 * @ProjectName: JZSSM
 * @Package: com.jzssm.fhf.service
 * @InterfaceName: MsgRespService
 * @date ：Created in 2021/2/10 8:45
 * @description：留言回复接口
 * @modified By：
 * @version: v1.0.0$
 */
public interface MsgRespService {
    Boolean deleteByPrimaryKey(String userId);

    Boolean insert(DomainMsgResp record);

    int insertSelective(DomainMsgResp record);

    DomainMsgResp selectByPrimaryKey(Integer userId);

    DomainMsgResp selectByTelNum(String telnum);

    int updateByPrimaryKeySelective(DomainMsgResp record);

    Boolean updateByPrimaryKey(DomainMsgResp record);

    /**
     2      * 分页查询
     3      * @param params 分页参数 pageNo（页码），pageSize（每页查询数目）
     4      * @return
     5      */
    public PageInfo<DomainMsgResp> finds(Params params,Integer loginId);

    long counts();
}

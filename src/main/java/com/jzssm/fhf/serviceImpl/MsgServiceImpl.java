package com.jzssm.fhf.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jzssm.fhf.common.Params;
import com.jzssm.fhf.dao.DomainMsgMapper;
import com.jzssm.fhf.entity.DomainMsg;
import com.jzssm.fhf.service.MsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ：Angular
 * @ProjectName: JZSSM
 * @Package: com.jzssm.fhf.serviceImpl
 * @ClassName: AdminServiceImpl
 * @date ：Created in 2021/1/16 18:59
 * @description：管理员业务逻辑实现类
 * @modified By：
 * @version: v1.0.0$
 */
@Service
public class MsgServiceImpl implements MsgService {

    @Autowired
    DomainMsgMapper domainMsgMapper;

    @Override
    public Boolean deleteByPrimaryKey(String userId) {
        int index = domainMsgMapper.deleteByPrimaryKey(Integer.parseInt(userId));
        return index > 0 ? true : false;
    }

    @Override
    public Boolean insert(DomainMsg record) {
        int index = domainMsgMapper.insert(record);
        return index > 0 ? true : false;
    }

    @Override
    public int insertSelective(DomainMsg record) {
        return domainMsgMapper.insertSelective(record);
    }

    @Override
    public DomainMsg selectByPrimaryKey(Integer userId) {
        return domainMsgMapper.selectByPrimaryKey(userId);
    }

    @Override
    public int updateByPrimaryKeySelective(DomainMsg record) {
        return domainMsgMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public Boolean updateByPrimaryKey(DomainMsg record) {
        int index = domainMsgMapper.updateByPrimaryKey(record);
        return index > 0 ? true : false;
    }

    @Override
    public PageInfo<DomainMsg> finds(Params params,Integer loginId) {
        //查询
        int pageNo = params.getPageNo();
        int pageSize = params.getPageSize();

        PageHelper.startPage(pageNo, pageSize);
        List<DomainMsg> blogs = domainMsgMapper.selectAllMsgData(loginId);
        //用PageInfo对结果进行包装
        PageInfo<DomainMsg> pageInfo = new PageInfo<DomainMsg>(blogs);
        return pageInfo;
    }

    @Override
    public DomainMsg selectByTelNum(String telnum) {
        return null;
    }

    @Override
    public long counts() {
        return 0;
    }
}

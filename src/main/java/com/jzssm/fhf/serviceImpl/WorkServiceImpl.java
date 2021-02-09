package com.jzssm.fhf.serviceImpl;

import com.github.pagehelper.PageInfo;
import com.jzssm.fhf.common.Params;
import com.jzssm.fhf.dao.DomainPkStarMapper;
import com.jzssm.fhf.dao.DomainWorkMapper;
import com.jzssm.fhf.entity.DomainPkStar;
import com.jzssm.fhf.entity.DomainWork;
import com.jzssm.fhf.service.PkstarService;
import com.jzssm.fhf.service.WorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
public class WorkServiceImpl implements WorkService {

    @Autowired
    DomainWorkMapper domainWorkMapper;

    @Override
    public Boolean deleteByPrimaryKey(String userId) {
        int index = domainWorkMapper.deleteByPrimaryKey(Integer.parseInt(userId));
        return index > 0 ? true : false;
    }

    @Override
    public Boolean insert(DomainWork record) {
        int index = domainWorkMapper.insert(record);
        return index > 0 ? true : false;
    }

    @Override
    public int insertSelective(DomainWork record) {
        return domainWorkMapper.insertSelective(record);
    }

    @Override
    public DomainWork selectByPrimaryKey(Integer userId) {
        return domainWorkMapper.selectByPrimaryKey(userId);
    }

    @Override
    public int updateByPrimaryKeySelective(DomainWork record) {
        return domainWorkMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public Boolean updateByPrimaryKey(DomainWork record) {
        int index = domainWorkMapper.updateByPrimaryKey(record);
        return index > 0 ? true : false;
    }

    @Override
    public PageInfo<DomainWork> finds(Params params) {
        return null;
    }

    @Override
    public DomainWork selectByTelNum(String telnum) {
        return null;
    }

    @Override
    public long counts() {
        return 0;
    }
}

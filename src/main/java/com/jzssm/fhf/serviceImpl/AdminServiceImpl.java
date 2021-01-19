package com.jzssm.fhf.serviceImpl;

import com.jzssm.fhf.dao.DomainAdminMapper;
import com.jzssm.fhf.entity.DomainAdmin;
import com.jzssm.fhf.service.AdminService;
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
public class AdminServiceImpl implements AdminService {

    @Autowired
    DomainAdminMapper domainAdminMapper;

    @Override
    public int deleteByPrimaryKey(Integer userId) {
        return domainAdminMapper.deleteByPrimaryKey(userId);
    }

    @Override
    public int insert(DomainAdmin record) {
        return domainAdminMapper.insert(record);
    }

    @Override
    public int insertSelective(DomainAdmin record) {
        return domainAdminMapper.insertSelective(record);
    }

    @Override
    public DomainAdmin selectByPrimaryKey(Integer userId) {
        return domainAdminMapper.selectByPrimaryKey(userId);
    }

    @Override
    public DomainAdmin selectByTelNum(String telnum) {
        return domainAdminMapper.selectByTelNum(telnum);
    }

    @Override
    public int updateByPrimaryKeySelective(DomainAdmin record) {
        return domainAdminMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(DomainAdmin record) {
        return domainAdminMapper.updateByPrimaryKey(record);
    }
}

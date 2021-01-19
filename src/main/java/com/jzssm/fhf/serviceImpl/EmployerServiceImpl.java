package com.jzssm.fhf.serviceImpl;

import com.jzssm.fhf.dao.DomainEmployerMapper;
import com.jzssm.fhf.entity.DomainEmployer;
import com.jzssm.fhf.service.EmployerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ：Angular
 * @ProjectName: JZSSM
 * @Package: com.jzssm.fhf.serviceImpl
 * @ClassName: EmployerServiceImpl
 * @date ：Created in 2021/1/16 19:03
 * @description：从业人员业务逻辑类
 * @modified By：
 * @version: v1.0.0$
 */
@Service
public class EmployerServiceImpl implements EmployerService {

    @Autowired
    DomainEmployerMapper domainEmployerMapper;

    @Override
    public int deleteByPrimaryKey(Integer userId) {
        return domainEmployerMapper.deleteByPrimaryKey(userId);
    }

    @Override
    public int insert(DomainEmployer record) {
        return domainEmployerMapper.insert(record);
    }

    @Override
    public int insertSelective(DomainEmployer record) {
        return domainEmployerMapper.insertSelective(record);
    }

    @Override
    public DomainEmployer selectByPrimaryKey(Integer userId) {
        return domainEmployerMapper.selectByPrimaryKey(userId);
    }

    @Override
    public DomainEmployer selectByTelNum(String telnum) {
        return domainEmployerMapper.selectByTelNum(telnum);
    }

    @Override
    public int updateByPrimaryKeySelective(DomainEmployer record) {
        return domainEmployerMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(DomainEmployer record) {
        return domainEmployerMapper.updateByPrimaryKey(record);
    }
}

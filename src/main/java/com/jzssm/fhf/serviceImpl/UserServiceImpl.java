package com.jzssm.fhf.serviceImpl;

import com.jzssm.fhf.dao.DomainUserMapper;
import com.jzssm.fhf.entity.DomainUser;
import com.jzssm.fhf.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ：Angular
 * @date ：Created in 2021/1/3 20:38
 * @description：用户业务逻辑接口实现类
 * @modified By：
 * @version: v1.0.0$
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    DomainUserMapper domainUserMapper;

    @Override
    public int deleteByPrimaryKey(Integer userId) {

        return 0;
    }

    @Override
    public int insert(DomainUser record) {
        return domainUserMapper.insert(record);
    }

    @Override
    public int insertSelective(DomainUser record) {
        return domainUserMapper.insertSelective(record);
    }

    @Override
    public DomainUser selectByPrimaryKey(Integer userId) {
        return domainUserMapper.selectByPrimaryKey(userId);
    }

    @Override
    public DomainUser selectByTelNum(@Param("telnum") String telnum) {
        return domainUserMapper.selectByTelNum(telnum);
    }

    @Override
    public int updateByPrimaryKeySelective(DomainUser record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(DomainUser record) {
        return 0;
    }
}

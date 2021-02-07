package com.jzssm.fhf.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jzssm.fhf.common.Params;
import com.jzssm.fhf.dao.DomainUserMapper;
import com.jzssm.fhf.entity.DomainUser;
import com.jzssm.fhf.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public Boolean deleteByPrimaryKey(String userId) {
        int index = domainUserMapper.deleteByPrimaryKey(userId);
        return index > 0 ? true : false;
    }

    @Override
    public Boolean insert(DomainUser record) {
        int index = domainUserMapper.insert(record);
        return index > 0 ? true : false;
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
    public Boolean updateByPrimaryKey(DomainUser record) {
        int index = domainUserMapper.updateByPrimaryKey(record);
        return index > 0 ? true : false;
    }


    @Override
    public long counts() {
        return 0;
    }

    @Override
    public PageInfo<DomainUser> finds(Params params) {

        //查询
        int pageNo = params.getPageNo();
        int pageSize = params.getPageSize();

        PageHelper.startPage(pageNo, pageSize);
        List<DomainUser> blogs = domainUserMapper.selectAllUserData();
        //用PageInfo对结果进行包装
        PageInfo<DomainUser> pageInfo = new PageInfo<DomainUser>(blogs);

        return pageInfo;

    }


}

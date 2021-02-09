package com.jzssm.fhf.serviceImpl;

import com.github.pagehelper.PageInfo;
import com.jzssm.fhf.common.Params;
import com.jzssm.fhf.dao.DomainPkStarMapper;
import com.jzssm.fhf.entity.DomainPkStar;
import com.jzssm.fhf.service.PkstarService;
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
public class PkstarServiceImpl implements PkstarService {

    @Autowired
    DomainPkStarMapper domainPkStarMapper;

    @Override
    public Boolean deleteByPrimaryKey(String userId) {
        int index = domainPkStarMapper.deleteByPrimaryKey(Integer.parseInt(userId));
        return index > 0 ? true : false;
    }

    @Override
    public Boolean insert(DomainPkStar record) {
        int index = domainPkStarMapper.insert(record);
        return index > 0 ? true : false;
    }

    @Override
    public int insertSelective(DomainPkStar record) {
        return domainPkStarMapper.insertSelective(record);
    }

    @Override
    public DomainPkStar selectByPrimaryKey(Integer userId) {
        return domainPkStarMapper.selectByPrimaryKey(userId);
    }

    @Override
    public int updateByPrimaryKeySelective(DomainPkStar record) {
        return domainPkStarMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public Boolean updateByPrimaryKey(DomainPkStar record) {
        int index = domainPkStarMapper.updateByPrimaryKey(record);
        return index > 0 ? true : false;
    }

    @Override
    public PageInfo<DomainPkStar> finds(Params params) {
        return null;
    }

    @Override
    public DomainPkStar selectByTelNum(String telnum) {
        return null;
    }

    @Override
    public long counts() {
        return 0;
    }
}

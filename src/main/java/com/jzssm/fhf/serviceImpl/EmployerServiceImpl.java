package com.jzssm.fhf.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jzssm.fhf.common.Params;
import com.jzssm.fhf.dao.DomainEmployerMapper;
import com.jzssm.fhf.dao.DomainWorkMapper;
import com.jzssm.fhf.entity.DomainEmployer;
import com.jzssm.fhf.entity.DomainUser;
import com.jzssm.fhf.service.EmployerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    @Autowired
    DomainWorkMapper domainWorkMapper;

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

    @Override
    public PageInfo<DomainEmployer> finds(Params params) {
        //查询
        int pageNo = params.getPageNo();
        int pageSize = params.getPageSize();

        PageHelper.startPage(pageNo, pageSize);
        List<DomainEmployer> blogs = domainEmployerMapper.selectAllEmpData();
        //用PageInfo对结果进行包装
        PageInfo<DomainEmployer> pageInfo = new PageInfo<DomainEmployer>(blogs);

        return pageInfo;

    }
    @Override
    public Boolean updateField(String workId,String wordType) {
        int index = domainEmployerMapper.updateField(Integer.parseInt(workId),wordType);
        return index > 0 ? true : false;
    }
    @Override
    public long counts() {
        return 0;
    }
}

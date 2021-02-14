package com.jzssm.fhf.service;

import com.github.pagehelper.PageInfo;
import com.jzssm.fhf.common.Params;
import com.jzssm.fhf.entity.DomainAdmin;
import com.jzssm.fhf.entity.DomainEmployer;
import com.jzssm.fhf.entity.DomainUser;

/**
 * @author ：Angular
 * @ProjectName: JZSSM
 * @Package: com.jzssm.fhf.service
 * @ClassName: EmployerService
 * @date ：Created in 2021/1/16 19:01
 * @description：从业人员业务逻辑类
 * @modified By：
 * @version: v1.0.0$
 */
public interface EmployerService {
    int deleteByPrimaryKey(Integer userId);

    int insert(DomainEmployer record);

    int insertSelective(DomainEmployer record);

    DomainEmployer selectByPrimaryKey(Integer userId);

    DomainEmployer selectByTelNum(String telnum);

    int updateByPrimaryKeySelective(DomainEmployer record);

    int updateByPrimaryKey(DomainEmployer record);

    PageInfo<DomainEmployer> finds(Params params);

    long counts();
}

package com.jzssm.fhf.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jzssm.fhf.common.Params;
import com.jzssm.fhf.dao.DomainRequireUserMapper;
import com.jzssm.fhf.entity.DomainRequireUser;
import com.jzssm.fhf.service.RequireUserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author ：Angular
 * @ProjectName: JZSSM
 * @Package: com.jzssm.fhf.serviceImpl
 * @ClassName: RequireUserServiceImpl
 * @date ：Created in 2021/2/14 10:15
 * @description：需求接口实现类
 * @modified By：
 * @version: $
 */
@Service
public class RequireUserServiceImpl implements RequireUserService {
    @Autowired
    DomainRequireUserMapper domainRequireUserMapper;

    @Override
    public Boolean deleteByPrimaryKey(String userId) {
        int index = domainRequireUserMapper.deleteByPrimaryKey(Integer.parseInt(userId));
        return index > 0 ? true : false;
    }

    @Override
    public Boolean checkReq(DomainRequireUser record) {
        int index = domainRequireUserMapper.checkReq(record);
        return index > 0 ? true : false;
    }

    @Override
    public Boolean insert(DomainRequireUser record) {
        int index = domainRequireUserMapper.insert(record);
        return index > 0 ? true : false;
    }

    @Override
    public int insertSelective(DomainRequireUser record) {
        return domainRequireUserMapper.insertSelective(record);
    }

    @Override
    public DomainRequireUser selectByPrimaryKey(Integer userId) {
        return domainRequireUserMapper.selectByPrimaryKey(userId);
    }


    @Override
    public DomainRequireUser selectByTelNum(@Param("telnum") String telnum) {
        return domainRequireUserMapper.selectByTelNum(telnum);
    }

    @Override
    public int updateByPrimaryKeySelective(DomainRequireUser record) {
        return 0;
    }

    @Override
    public Boolean updateByPrimaryKey(DomainRequireUser record) {
        int index = domainRequireUserMapper.updateByPrimaryKey(record);
        return index > 0 ? true : false;
    }


    @Override
    public long counts() {
        return 0;
    }

    @Override
    public PageInfo<DomainRequireUser> finds(Params params,Integer loginId) {

        //查询
        int pageNo = params.getPageNo();
        int pageSize = params.getPageSize();

        PageHelper.startPage(pageNo, pageSize);
        List<DomainRequireUser> blogs = domainRequireUserMapper.selectAllReqData(loginId);
        //用PageInfo对结果进行包装
        PageInfo<DomainRequireUser> pageInfo = new PageInfo<DomainRequireUser>(blogs);

        return pageInfo;

    }


    @Override
    public PageInfo<DomainRequireUser> findAllReqByEmpIdData(Params params, int loginId) {
        //查询
        int pageNo = params.getPageNo();
        int pageSize = params.getPageSize();

        PageHelper.startPage(pageNo, pageSize);
        List<DomainRequireUser> blogs = domainRequireUserMapper.findAllReqByEmpIdData(loginId);
        //用PageInfo对结果进行包装
        PageInfo<DomainRequireUser> pageInfo = new PageInfo<DomainRequireUser>(blogs);

        return pageInfo;
    }

    @Override
    public PageInfo<DomainRequireUser> findAllReqByUserIdData(Params params, int loginId) {
        //查询
        int pageNo = params.getPageNo();
        int pageSize = params.getPageSize();

        PageHelper.startPage(pageNo, pageSize);
        List<DomainRequireUser> blogs = domainRequireUserMapper.findAllReqByUserIdData(loginId);
        //用PageInfo对结果进行包装
        PageInfo<DomainRequireUser> pageInfo = new PageInfo<DomainRequireUser>(blogs);

        return pageInfo;
    }

    @Override
    public List<Map<String,Object>> selectEmpMsg(){
       return domainRequireUserMapper.selectEmpMsg();
    }

    @Override
    public List<Map<String,Object>> queryEmpFields(String employerId){
       return domainRequireUserMapper.queryEmpFields(employerId);
    }
     @Override
    public PageInfo<DomainRequireUser> findAllReq(Params params){
         //查询
         int pageNo = params.getPageNo();
         int pageSize = params.getPageSize();
         PageHelper.startPage(pageNo, pageSize);
         List<DomainRequireUser> blogs = domainRequireUserMapper.findAllReq();
         //用PageInfo对结果进行包装
         PageInfo<DomainRequireUser> pageInfo = new PageInfo<DomainRequireUser>(blogs);
         return pageInfo;
    }

}

package com.jzssm.fhf.serviceImpl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jzssm.fhf.common.Params;
import com.jzssm.fhf.dao.DomainMsgMapper;
import com.jzssm.fhf.dao.DomainMsgRespMapper;
import com.jzssm.fhf.entity.DomainMsg;
import com.jzssm.fhf.entity.DomainMsgResp;
import com.jzssm.fhf.service.MsgRespService;
import com.jzssm.fhf.service.MsgService;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

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
public class MsgRespServiceImpl implements MsgRespService {

    @Autowired
    DomainMsgRespMapper domainMsgRespMapper;

    @Override
    public Boolean deleteByPrimaryKey(String userId) {
        int index = domainMsgRespMapper.deleteByPrimaryKey(Integer.parseInt(userId));
        return index > 0 ? true : false;
    }

    @Override
    public Boolean insert(DomainMsgResp record) {
        int index = domainMsgRespMapper.insert(record);
        return index > 0 ? true : false;
    }

    @Override
    public int insertSelective(DomainMsgResp record) {
        return domainMsgRespMapper.insertSelective(record);
    }

    @Override
    public DomainMsgResp selectByPrimaryKey(Integer userId) {
        return domainMsgRespMapper.selectByPrimaryKey(userId);
    }

    @Override
    public int updateByPrimaryKeySelective(DomainMsgResp record) {
        return domainMsgRespMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public Boolean updateByPrimaryKey(DomainMsgResp record) {
        int index = domainMsgRespMapper.updateByPrimaryKey(record);
        return index > 0 ? true : false;
    }

    @Override
    public PageInfo<DomainMsgResp> finds(Params params, Integer loginId) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //查询
        List<DomainMsgResp> msgRespList = new ArrayList<>();
        int pageNo = params.getPageNo();
        int pageSize = params.getPageSize();

        PageHelper.startPage(pageNo, pageSize);
        List<Map<String,Object>> blogs = domainMsgRespMapper.selectAllMsgRespData(loginId);
        for(int i= 0; i<blogs.size(); i++){
            String obj = JSON.toJSONString(blogs.get(i));
            JSONObject jsonObject = JSONObject.parseObject(obj);
            DomainMsgResp jsonObj = JSON.toJavaObject(jsonObject,DomainMsgResp.class);
            Date date = new Date();
            date.setTime(Long.parseLong(jsonObj.getResTime()));
            jsonObj.setResTime(sdf.format(date));
            msgRespList.add(jsonObj);
        }
        //用PageInfo对结果进行包装
        PageInfo<DomainMsgResp> pageInfo = new PageInfo<DomainMsgResp>(msgRespList);
        return pageInfo;
    }

    @Override
    public DomainMsgResp selectByTelNum(String telnum) {
        return null;
    }

    @Override
    public long counts() {
        return 0;
    }
}

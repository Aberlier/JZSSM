package com.jzssm.fhf.controller;

import com.jzssm.fhf.common.ResultUtil;
import com.jzssm.fhf.entity.DomainInfoCollect;
import com.jzssm.fhf.entity.DomainUser;
import com.jzssm.fhf.service.UserService;
import com.jzssm.fhf.utils.MD5Util;
import com.jzssm.fhf.utils.UuidTools;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * @author ：zjc
 * @ProjectName: JZSSM
 * @Package: com.jzssm.fhf.controller
 * @ClassName: InfoCollectController
 * @date ：Created in 2021/7/21 16:42
 * @description：
 * @modified By：
 * @version: $
 */

@Controller
public class InfoCollectController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/insertInfo", method = POST)
    @ResponseBody
    @ApiOperation(value = "添加信息", httpMethod = "POST", notes = "添加用户信息")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "query", dataType = "String", name = "token", value = "token标记", required = true), @ApiImplicitParam(paramType = "query", dataType = "int", name = "loginId", value = "loginId标记", required = true)})
    public Object insertUser(DomainInfoCollect domainInfoCollect) {
        domainInfoCollect.setId(Integer.parseInt(UuidTools.getUuidNum()));
        domainInfoCollect.setPostcode(this.checkStringIsEmpty(MD5Util.getMD5String(domainInfoCollect.getPostcode())));
        domainInfoCollect.setAddress(this.checkStringIsEmpty(domainInfoCollect.getAddress()));
        domainInfoCollect.setCompanyname(this.checkStringIsEmpty(domainInfoCollect.getCompanyname()));
        domainInfoCollect.setUsername(this.checkStringIsEmpty(domainInfoCollect.getUsername()));
        domainInfoCollect.setJob(this.checkStringIsEmpty(domainInfoCollect.getJob()));
        domainInfoCollect.setTel1(this.checkStringIsEmpty(domainInfoCollect.getTel1()));
        domainInfoCollect.setTel2(this.checkStringIsEmpty(domainInfoCollect.getTel2()));
        if (userService.insertInfo(domainInfoCollect)) {
            return ResultUtil.success("添加成功！");
        } else {
            return ResultUtil.success("添加失败！");
        }
    }
    private String checkStringIsEmpty(String param) {
        return param == null ? null : (param.equals("") ? null : param);
    }
}

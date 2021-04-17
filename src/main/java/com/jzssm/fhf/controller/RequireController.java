package com.jzssm.fhf.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.jzssm.fhf.common.Params;
import com.jzssm.fhf.common.ResultUtil;
import com.jzssm.fhf.entity.DomainPkStar;
import com.jzssm.fhf.entity.DomainRequireUser;
import com.jzssm.fhf.entity.DomainUser;
import com.jzssm.fhf.service.RequireUserService;
import com.jzssm.fhf.utils.MD5Util;
import com.jzssm.fhf.utils.ResponseData;
import com.jzssm.fhf.utils.UuidTools;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * @author ：Angular
 * @ProjectName: JZSSM
 * @Package: com.jzssm.fhf.controller
 * @ClassName: RequireController
 * @date ：Created in 2021/2/14 11:34
 * @description：用户需求管理
 * @modified By：
 * @version: v1.0.0$
 */
@Controller
@RequestMapping("requireController")
@Api(value = "requireController", tags = "从业人员操作接口", description = "从业人员操作接口")
public class RequireController {


    @Autowired
    RequireUserService requireUserService;
    /**
     * 首页，并且分页查询
     *
     * @return
     */
    @RequestMapping(value = "/findAllReqData")
    @ApiOperation(value = "分页查询对应用户得需求", httpMethod = "GET", notes = "分页查询对应用户得需求")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "query", dataType = "String", name = "token", value = "token标记", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "int", name = "loginId", value = "loginId标记", required = true)})
    public ModelAndView index(@ApiIgnore Params params, HttpSession session) {

        ModelAndView modelAndView = new ModelAndView();
        //一开始第一页，查询10条
        params.setPageNo(1);
        params.setPageSize(10);
        PageInfo<DomainRequireUser> pageInfo = requireUserService.findAllReqByEmpIdData(params,Integer.parseInt(session.getAttribute("loginId").toString()));
        List<DomainRequireUser> reqList = pageInfo.getList();
        //查询数量
        long couts = requireUserService.counts();

        modelAndView.addObject("reqList", reqList);
        //当前页
        modelAndView.addObject("currentPage", pageInfo.getPageNum());
        //每页的数量
        modelAndView.addObject("pageSize", pageInfo.getPageSize());
        //当前页的数量
        modelAndView.addObject("startPage", pageInfo.getSize());
        //总记录数
        modelAndView.addObject("countNumber", pageInfo.getTotal());
        //int sumPageNumber=countNumber%pageSize==0?(countNumber/pageSize):((countNumber/pageSize)+1);
        //总页数
        modelAndView.addObject("sumPageNumber", pageInfo.getPages());
        modelAndView.addObject("couts", couts);
        modelAndView.setViewName("views/pages/user/req_manager");
        return modelAndView;
    }

    /**
     * 首页，并且分页查询
     *
     * @return
     */
    @RequestMapping(value = "/findAllReq")
    @ApiOperation(value = "分页查询对应用户得需求", httpMethod = "GET", notes = "分页查询对应用户得需求")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "query", dataType = "String", name = "token", value = "token标记", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "int", name = "loginId", value = "loginId标记", required = true)})
    public ModelAndView findAllReq(@ApiIgnore Params params, HttpSession session) {

        ModelAndView modelAndView = new ModelAndView();
        //一开始第一页，查询10条
        params.setPageNo(1);
        params.setPageSize(10);
        PageInfo<DomainRequireUser> pageInfo = requireUserService.findAllReq(params);
        List<DomainRequireUser> reqList = pageInfo.getList();
        //查询数量
        long couts = requireUserService.counts();
        List<Map<String,Object>> list = requireUserService.selectEmpMsg();
        session.setAttribute("listEmp",list);
        modelAndView.addObject("listEmp", list);

        modelAndView.addObject("reqList", reqList);
        //当前页
        modelAndView.addObject("currentPage", pageInfo.getPageNum());
        //每页的数量
        modelAndView.addObject("pageSize", pageInfo.getPageSize());
        //当前页的数量
        modelAndView.addObject("startPage", pageInfo.getSize());
        //总记录数
        modelAndView.addObject("countNumber", pageInfo.getTotal());
        //int sumPageNumber=countNumber%pageSize==0?(countNumber/pageSize):((countNumber/pageSize)+1);
        //总页数
        modelAndView.addObject("sumPageNumber", pageInfo.getPages());
        modelAndView.addObject("couts", couts);
        modelAndView.setViewName("views/pages/admin/reqmanager");
        return modelAndView;
    }


    @RequestMapping(value = "/findAllReqByEmpIdData")
    @ApiOperation(value = "职工查询对应自己的需求信息", httpMethod = "GET", notes = "职工查询对应自己的需求信息")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "query", dataType = "String", name = "token", value = "token标记", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "int", name = "loginId", value = "loginId标记", required = true)})
    public ModelAndView findAllReqByEmpIdData(@ApiIgnore Params params, HttpSession session) {

        ModelAndView modelAndView = new ModelAndView();
        //一开始第一页，查询10条
        params.setPageNo(1);
        params.setPageSize(10);
        PageInfo<DomainRequireUser> pageInfo =null;
        if(Integer.parseInt(session.getAttribute("role").toString())==3 ){
           pageInfo = requireUserService.findAllReqByUserIdData(params,Integer.parseInt(session.getAttribute("loginId").toString()));
        }
        if(Integer.parseInt(session.getAttribute("role").toString())==2){
            pageInfo = requireUserService.findAllReqByEmpIdData(params,Integer.parseInt(session.getAttribute("loginId").toString()));
        }
        if(Integer.parseInt(session.getAttribute("role").toString())==1){
            pageInfo = requireUserService.findAllReq(params);
        }
        List<DomainRequireUser> reqList = pageInfo.getList();
        List<Map<String,Object>> list = requireUserService.selectEmpMsg();
        session.setAttribute("listEmp",list);

        //查询数量
        long couts = requireUserService.counts();

        modelAndView.addObject("reqList", reqList);
        modelAndView.addObject("listEmp", list);
        //当前页
        modelAndView.addObject("currentPage", pageInfo.getPageNum());
        //每页的数量
        modelAndView.addObject("pageSize", pageInfo.getPageSize());
        //当前页的数量
        modelAndView.addObject("startPage", pageInfo.getSize());
        //总记录数
        modelAndView.addObject("countNumber", pageInfo.getTotal());
        //int sumPageNumber=countNumber%pageSize==0?(countNumber/pageSize):((countNumber/pageSize)+1);
        //总页数
        modelAndView.addObject("sumPageNumber", pageInfo.getPages());
        modelAndView.addObject("couts", couts);
        modelAndView.setViewName("views/pages/user/req_manager");
        return modelAndView;
    }


    @RequestMapping(value = "/insertRequireBefore", method = GET)
    @ApiOperation(value = "添加用户需求前请求接口", httpMethod = "GET", notes = "添加用户信息请求接口")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "query", dataType = "String", name = "token", value = "token标记", required = true), @ApiImplicitParam(paramType = "query", dataType = "int", name = "loginId", value = "loginId标记", required = true)})
    public Object insertRequireBefore(@RequestParam Integer loginId, HttpSession session) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        List<Map<String,Object>> mapList = requireUserService.selectEmpMsg();
        ModelAndView modelAndView = new ModelAndView();
        if (mapList.size()>0){
            modelAndView.addObject("list", mapList);
            modelAndView.setViewName("views/pages/user/addRequire");
            return modelAndView;
        }else {
            modelAndView.addObject("msg", "数据查询出错！");
            modelAndView.setViewName("views/pages/user/addRequire");
            return modelAndView;
        }
    }

    @RequestMapping(value = "/queryEmpFields", method = GET)
    @ResponseBody
    @ApiOperation(value = "添加用户需求前请求接口", httpMethod = "GET", notes = "添加用户信息请求接口")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "query", dataType = "String", name = "token", value = "token标记", required = true), @ApiImplicitParam(paramType = "query", dataType = "int", name = "loginId", value = "loginId标记", required = true)})
    public Object queryEmpFields(@RequestParam String employerId, HttpSession session) {

        List<Map<String,Object>> mapList = requireUserService.queryEmpFields(employerId);
        ModelAndView modelAndView = new ModelAndView();
        if (mapList.size()>0){
            modelAndView.addObject("listmap", mapList);
            modelAndView.setViewName("views/pages/user/addRequire");
            return modelAndView;
        }else {
            modelAndView.addObject("msg", "数据查询出错！");
            modelAndView.setViewName("views/pages/user/addRequire");
            return modelAndView;
        }
    }

    @RequestMapping(value = "/insertRequire", method = POST)
    @ResponseBody
    @ApiOperation(value = "添加用户需求", httpMethod = "POST", notes = "添加用户信息")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "query", dataType = "String", name = "token", value = "token标记", required = true), @ApiImplicitParam(paramType = "query", dataType = "int", name = "loginId", value = "loginId标记", required = true)})
    public Object insertRequire(@RequestBody Map<String,Object> stringObjectMap, @RequestParam Integer loginId, HttpSession session) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        DomainRequireUser domainRequireUser =  JSON.parseObject(JSON.toJSONString(stringObjectMap), DomainRequireUser.class);
      /*  domainRequireUser.setReqType(reqType);
        domainRequireUser.setReqDesc(reqContent);
        domainRequireUser.setReqDoEmpId(id);
        domainRequireUser.setReqDoEmpName(empName);
        domainRequireUser.setReqDoEmpPostname(empstarnum.toString());*/
        List<Map<String, Object>> list =  requireUserService.queryEmpFields(domainRequireUser.getReqDoEmpId().toString());
        domainRequireUser.setReqDoEmpName(list.get(0).get("employerName").toString());
        domainRequireUser.setReqDoEmpPostname(list.get(0).get("pkStarNum").toString());
        //需求编号
        domainRequireUser.setReqId(Integer.parseInt(UuidTools.getUuidNum()));
        //需求创建时间
        domainRequireUser.setReqTime(sdf.format(new Date()));
        domainRequireUser.setReqUserId(loginId);

        domainRequireUser.setReqUserName(session.getAttribute("userName").toString());

        if (requireUserService.insert(domainRequireUser)) {
            return ResultUtil.success("添加成功！");
        } else {
            return ResultUtil.success("添加失败！");
        }
    }





    @RequestMapping(value = "/insertReq", method = POST)
    @ResponseBody
    @ApiOperation(value = "添加用户需求", httpMethod = "POST", notes = "添加用户信息")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "query", dataType = "String", name = "token", value = "token标记", required = true), @ApiImplicitParam(paramType = "query", dataType = "int", name = "loginId", value = "loginId标记", required = true)})
    public Object insertReq(@RequestParam String reqType,@RequestParam String reqContent, @RequestParam String id, @RequestParam String empName, @RequestParam Integer empstarnum, @RequestParam Integer loginId, HttpSession session) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        DomainRequireUser domainRequireUser = new DomainRequireUser();
        domainRequireUser.setReqType(reqType);
        domainRequireUser.setReqDesc(reqContent);
        domainRequireUser.setReqDoEmpId(id);
        domainRequireUser.setReqDoEmpName(empName);
        domainRequireUser.setReqDoEmpPostname(empstarnum.toString());
        domainRequireUser.setReqId(Integer.parseInt(UuidTools.getUuidNum()));
        domainRequireUser.setReqTime(sdf.format(new Date()));
        domainRequireUser.setReqUserId(loginId);

        domainRequireUser.setReqUserName(session.getAttribute("userName").toString());

        if (requireUserService.insert(domainRequireUser)) {
            return ResultUtil.success("添加成功！");
        } else {
            return ResultUtil.success("添加失败！");
        }
    }

    @RequestMapping(value = "/updateReq", method = POST)
    @ResponseBody
    @ApiOperation(value = "修改用户信息", httpMethod = "POST", notes = "修改用户信息")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "query", dataType = "String", name = "token", value = "token标记", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "int", name = "loginId", value = "loginId标记", required = true)})
    public Object updateReq( DomainRequireUser domainRequireUser) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        domainRequireUser.setReqType(domainRequireUser.getReqType());
        domainRequireUser.setReqTime(sdf.format(new Date()));
        domainRequireUser.setReqId(domainRequireUser.getReqId());
        domainRequireUser.setReqDesc(domainRequireUser.getReqDesc());
        if (requireUserService.updateByPrimaryKey(domainRequireUser)) {
            return ResultUtil.success("修改成功！");
        } else {
            return ResultUtil.success("修改失败！");
        }

    }

    @RequestMapping(value = "/updateReqBefore", method = GET)
    @ResponseBody
    @ApiOperation(value = "修改用户信息跳转修改页", httpMethod = "GET", notes = "修改用户信息跳转修改页")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "query", dataType = "String", name = "token", value = "token标记", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "int", name = "loginId", value = "loginId标记", required = true)})
    public Object updateReqBefore(@RequestParam String id, HttpSession session) {
        DomainRequireUser domainRequireUser = requireUserService.selectByPrimaryKey(Integer.parseInt(id));
        session.setAttribute("domainRequireUser", domainRequireUser);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("domainRequireUser", domainRequireUser);
        modelAndView.setViewName("views/pages/user/updateReq.jsp");
        return ResultUtil.success(modelAndView);
    }


    @RequestMapping(value = "/deleteReq", method = POST)
    @ResponseBody
    @ApiOperation(value = "删除需求信息", httpMethod = "POST", notes = "删除需求信息")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "query", dataType = "String", name = "token", value = "token标记", required = true), @ApiImplicitParam(paramType = "query", dataType = "int", name = "loginId", value = "loginId标记", required = true)})
    public Object deleteReq(String id, String[] arrays) {
        Boolean index = null;
        if (id != null && !"".equals(id)) {
            index = requireUserService.deleteByPrimaryKey(id);
            if (index) {
                return ResultUtil.success("删除成功！");
            }
        } else {
            for (String str : arrays) {
                index = requireUserService.deleteByPrimaryKey(str);
                if (index) {
                    return ResultUtil.success("删除成功！");
                }
            }
        }
        return null;
    }

}

package com.jzssm.fhf.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.jzssm.fhf.common.Params;
import com.jzssm.fhf.common.ResultUtil;
import com.jzssm.fhf.entity.DomainPkStar;
import com.jzssm.fhf.entity.DomainRequireUser;
import com.jzssm.fhf.entity.DomainWork;
import com.jzssm.fhf.service.PkstarService;
import com.jzssm.fhf.service.WorkService;
import com.jzssm.fhf.utils.UuidTools;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
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
 * @ClassName: MsgController
 * @date ：Created in 2021/2/9 12:18
 * @description：工作管理
 * @modified By：
 * @version: v1.0.0$
 */
@Controller
@RequestMapping("workController")
@Api(value = "workController", tags = "工作管理操作接口", description = "工作管理操作接口")
public class WorkController {

    @Autowired
    WorkService workService;
    /**
     * 首页，并且分页查询
     *
     * @return
     */
    @RequestMapping(value = "/findAllWorkData")
    @ApiOperation(value = "工作类型查询列表", httpMethod = "GET", notes = "工作类型查询列表")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "query", dataType = "String", name = "token", value = "token标记", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "int", name = "loginId", value = "loginId标记", required = true)})
    public ModelAndView index(@ApiIgnore Params params, HttpServletRequest request) {

        ModelAndView modelAndView = new ModelAndView();
        //一开始第一页，查询10条
        params.setPageNo(1);
        params.setPageSize(10);
        PageInfo<DomainWork> pageInfo = workService.finds(params);
        List<DomainWork> worklist = pageInfo.getList();
        //查询数量
        //long couts = msgService.counts();

        modelAndView.addObject("worklist", worklist);
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
        //modelAndView.addObject("couts", couts);
        modelAndView.setViewName("views/pages/admin/work_manager");
        return modelAndView;
    }

    @RequestMapping(value = "/insertWork", method = POST)
    @ResponseBody
    @ApiOperation(value = "添加工作类型", httpMethod = "POST", notes = "添加工作类型")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "query", dataType = "String", name = "token", value = "token标记", required = true), @ApiImplicitParam(paramType = "query", dataType = "int", name = "loginId", value = "loginId标记", required = true)})
    public Object insertWork(@RequestBody Map<String,Object> map) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        DomainWork domainWork =  JSON.parseObject(JSON.toJSONString(map), DomainWork.class);
        if("1".equals(map.get("workId"))){
            domainWork.setWorkName("保安");
        }else if("2".equals(map.get("workId"))){
            domainWork.setWorkName("保洁");
        }else if("3".equals(map.get("workId"))){
            domainWork.setWorkName("保镖");
        }else if("4".equals(map.get("workId"))){
            domainWork.setWorkName("护工");
        }else if("5".equals(map.get("workId"))){
            domainWork.setWorkName("月嫂");
        }
        domainWork.setWorkId(Integer.parseInt(UuidTools.getUuidNum()));
        domainWork.setWorkType(map.get("workType").toString());
        domainWork.setWorkDesc(map.get("workContent").toString());
      /*  domainWork.setWorkName(this.checkStringIsEmpty(domainWork.getWorkName()));
        domainWork.setWorkType(this.checkStringIsEmpty(domainWork.getWorkType()));
        domainWork.setWorkDesc(this.checkStringIsEmpty(domainWork.getWorkDesc()));*/
        if (workService.insert(domainWork)) {
            return ResultUtil.success("添加成功！");
        } else {
            return ResultUtil.success("添加失败！");
        }
    }


    @RequestMapping(value = "/updateWork", method = POST)
    @ResponseBody
    @ApiOperation(value = "修改工作种类信息", httpMethod = "POST", notes = "修改工作种类信息")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "query", dataType = "String", name = "token", value = "token标记", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "int", name = "loginId", value = "loginId标记", required = true)})
    public Object updateWork(DomainWork domainWork) {
        domainWork.setWorkId(Integer.parseInt(UuidTools.getUuidNum()));
        domainWork.setWorkName(this.checkStringIsEmpty(domainWork.getWorkName()));
        domainWork.setWorkType(this.checkStringIsEmpty(domainWork.getWorkType()));
        domainWork.setWorkDesc(this.checkStringIsEmpty(domainWork.getWorkDesc()));
        if (workService.updateByPrimaryKey(domainWork)) {
            return ResultUtil.success("修改成功！");
        } else {
            return ResultUtil.success("修改失败！");
        }

    }


    @RequestMapping(value = "/updateWorkBefore", method = GET)
    @ResponseBody
    @ApiOperation(value = "修改留言信息跳转修改页", httpMethod = "GET", notes = "修改留言信息跳转修改页")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "query", dataType = "String", name = "token", value = "token标记", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "int", name = "loginId", value = "loginId标记", required = true)})
    public Object updateMsgBefore(@RequestParam String id, HttpSession session) {
        DomainWork domainWork = workService.selectByPrimaryKey(Integer.parseInt(id));
        session.setAttribute("domainWork", domainWork);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("domainWork", domainWork);
        modelAndView.setViewName("views/pages/admin/updateWork.jsp");
        return ResultUtil.success(modelAndView);
    }


    @RequestMapping(value = "/deleteWork", method = POST)
    @ResponseBody
    @ApiOperation(value = "删除工作种类信息", httpMethod = "POST", notes = "删除工作种类信息")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "query", dataType = "String", name = "token", value = "token标记", required = true), @ApiImplicitParam(paramType = "query", dataType = "int", name = "loginId", value = "loginId标记", required = true)})
    public Object deleteMsg(String id, String[] arrays) {
        Boolean index = null;
        if (id != null && !"".equals(id)) {
            index = workService.deleteByPrimaryKey(id);
            if (index) {
                return ResultUtil.success("删除成功！");
            }
        } else {
            for (String str : arrays) {
                index = workService.deleteByPrimaryKey(str);
                if (index) {
                    return ResultUtil.success("删除成功！");
                }
            }
        }
        return null;
    }


    private String checkStringIsEmpty(String param) {
        return param == null ? null : (param.equals("") ? null : param);
    }
}

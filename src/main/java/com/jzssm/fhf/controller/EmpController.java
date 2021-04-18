package com.jzssm.fhf.controller;

import com.github.pagehelper.PageInfo;
import com.jzssm.fhf.common.Params;
import com.jzssm.fhf.common.ResultUtil;
import com.jzssm.fhf.entity.DomainEmployer;
import com.jzssm.fhf.entity.DomainPkStar;
import com.jzssm.fhf.entity.DomainUser;
import com.jzssm.fhf.service.EmployerService;
import com.jzssm.fhf.service.PkstarService;
import com.jzssm.fhf.service.RequireUserService;
import com.jzssm.fhf.utils.MD5Util;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * @author ：Angular
 * @ProjectName: JZSSM
 * @Package: com.jzssm.fhf.controller
 * @ClassName: EmpController
 * @date ：Created in 2021/2/13 15:08
 * @description：
 * @modified By：
 * @version: $
 */
@Controller
@RequestMapping("empController")
@Api(value = "empController", tags = "从业人员操作接口", description = "从业人员操作接口")
public class EmpController {

    @Autowired
    EmployerService employerService;

    @Autowired
    PkstarService pkstarService;

    /**
     * 首页，并且分页查询
     *
     * @return
     */
    @RequestMapping(value = "/findAllEmpData")
    @ApiOperation(value = "分页查询用户列表", httpMethod = "GET", notes = "分页查询用户列表")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "query", dataType = "String", name = "token", value = "token标记", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "int", name = "loginId", value = "loginId标记", required = true)})
    public ModelAndView index(@ApiIgnore Params params, HttpServletRequest request) {

        ModelAndView modelAndView = new ModelAndView();
        //一开始第一页，查询10条
        params.setPageNo(1);
        params.setPageSize(10);
        PageInfo<DomainEmployer> pageInfo = employerService.finds(params);
        List<DomainEmployer> empList = pageInfo.getList();
        //查询数量
        long couts = employerService.counts();

        modelAndView.addObject("empList", empList);
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
        modelAndView.setViewName("views/pages/user/emp_manager");
        return modelAndView;
    }


    /**
     * 根据登录ID查询用户信息
     *
     * @return
     */
    @RequestMapping(value = "/findEmpByLoginId")
    @ApiOperation(value = "根据登录ID查询用户信息", httpMethod = "GET", notes = "根据登录ID查询用户信息")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "query", dataType = "String", name = "token", value = "token标记", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "int", name = "loginId", value = "loginId标记", required = true)})
    public ModelAndView findEmpByLoginId(@RequestParam String loginId, @ApiIgnore Params params, HttpServletRequest request) {

        ModelAndView modelAndView = new ModelAndView();
        DomainEmployer pageInfo = employerService.selectByPrimaryKey(Integer.parseInt(loginId));
        DomainPkStar pkInfo = pkstarService.selectByPrimaryKey(null, Integer.parseInt(loginId));

        modelAndView.addObject("pkstar", pkInfo);
        modelAndView.addObject("emp", pageInfo);
        modelAndView.setViewName("views/pages/emp/empDetail");
        return modelAndView;
    }


    @RequestMapping(value = "/updateEmp", method = POST)
    @ResponseBody
    @ApiOperation(value = "修改职工信息", httpMethod = "POST", notes = "修改职工信息")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "query", dataType = "String", name = "token", value = "token标记", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "int", name = "loginId", value = "loginId标记", required = true)})
    public Object updateEmp(DomainEmployer domainEmployer) {
        domainEmployer.setEmployerId(domainEmployer.getEmployerId());
        domainEmployer.setEmployerName(domainEmployer.getEmployerName());
        if(domainEmployer.getEmployerPwd()!=null && !"".equals(domainEmployer.getEmployerPwd())){
            domainEmployer.setEmployerPwd(MD5Util.getMD5String(domainEmployer.getEmployerPwd()));
        }
//        domainEmployer.setEmployerPwd(domainEmployer.getEmployerPwd());
        domainEmployer.setEmployerTelnum(domainEmployer.getEmployerTelnum());
        domainEmployer.setEmployerAddress(domainEmployer.getEmployerAddress());
        domainEmployer.setEmployerAge(domainEmployer.getEmployerAge());
        domainEmployer.setEmployerDesc(domainEmployer.getEmployerDesc());
        if (employerService.updateByPrimaryKeySelective(domainEmployer) > 0) {
            return ResultUtil.success("修改成功！");
        } else {
            return ResultUtil.success("修改失败！");
        }

    }

    @RequestMapping(value = "/updateEmpBefore", method = GET)
    @ResponseBody
    @ApiOperation(value = "修改职工信息跳转修改页", httpMethod = "GET", notes = "修改职工信息跳转修改页")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "query", dataType = "String", name = "token", value = "token标记", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "int", name = "loginId", value = "loginId标记", required = true)})
    public Object updateEmpBefore(@RequestParam String id, HttpSession session) {
        DomainEmployer domainEmployer = employerService.selectByPrimaryKey(Integer.parseInt(id));
        session.setAttribute("domainEmployer", domainEmployer);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("domainEmployer", domainEmployer);
        modelAndView.setViewName("views/pages/emp/updateEmp.jsp");
        return ResultUtil.success(modelAndView);
    }

    @RequestMapping(value = "/updateField", method = GET)
    @ResponseBody
    @ApiOperation(value = "修改工作种类信息", httpMethod = "GET", notes = "修改工作种类信息")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "query", dataType = "String", name = "token", value = "token标记", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "int", name = "loginId", value = "loginId标记", required = true)})
    public Object updateField(@RequestParam String workType, HttpSession session) {
        Boolean index = null;
        DomainEmployer domainEmployer = employerService.selectByPrimaryKey(Integer.parseInt(session.getAttribute("loginId").toString()));
        if (domainEmployer.getEmployerField() == null && "".equals(domainEmployer.getEmployerField())) {
            if (workType != null && !"".equals(workType)) {
                index = employerService.updateField(session.getAttribute("loginId").toString(), workType);
            }
        }
        if (index != null && index == true) {
            return ResultUtil.success("修改成功！");
        } else {
            return ResultUtil.error("已经存在对应的职位角色，请勿重复申请！");
        }

    }


    @RequestMapping(value = "/deleteEmp", method = POST)
    @ResponseBody
    @ApiOperation(value = "删除需求信息", httpMethod = "POST", notes = "删除需求信息")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "query", dataType = "String", name = "token", value = "token标记", required = true), @ApiImplicitParam(paramType = "query", dataType = "int", name = "loginId", value = "loginId标记", required = true)})
    public Object deleteEmp(String id, String[] arrays) {
        int index = 0;
        if (id != null && !"".equals(id)) {
            index = employerService.deleteByPrimaryKey(Integer.parseInt(id));
            if (index > 0) {
                return ResultUtil.success("删除成功！");
            }
        } else {
            for (String str : arrays) {
                index = employerService.deleteByPrimaryKey(Integer.parseInt(str));
                if (index>0) {
                    return ResultUtil.success("删除成功！");
                }
            }
        }
        return null;
    }


}

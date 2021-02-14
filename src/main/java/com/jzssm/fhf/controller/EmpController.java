package com.jzssm.fhf.controller;

import com.github.pagehelper.PageInfo;
import com.jzssm.fhf.common.Params;
import com.jzssm.fhf.entity.DomainEmployer;
import com.jzssm.fhf.service.EmployerService;
import com.jzssm.fhf.service.RequireUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

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
    RequireUserService requireUserService;
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



}

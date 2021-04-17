package com.jzssm.fhf.controller;

import com.github.pagehelper.PageInfo;
import com.jzssm.fhf.common.Params;
import com.jzssm.fhf.common.ResultUtil;
import com.jzssm.fhf.entity.DomainPkStar;
import com.jzssm.fhf.service.PkstarService;
import com.jzssm.fhf.service.RequireUserService;
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
import java.text.ParseException;
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
 * @description：评星管理
 * @modified By：
 * @version: v1.0.0$
 */
@Controller
@RequestMapping("pkstarController")
@Api(value = "pkstarController", tags = "评星管理操作接口", description = "评星管理操作接口")
public class PkstarController {

    @Autowired
    PkstarService pkstarService;

    @Autowired
    RequireUserService requireUserService;

    /**
     * 首页，并且分页查询
     *
     * @return
     */
    @RequestMapping(value = "/findAllPkstarData")
    @ApiOperation(value = "分页查询评星列表", httpMethod = "GET", notes = "分页查询评星列表")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "query", dataType = "String", name = "token", value = "token标记", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "int", name = "loginId", value = "loginId标记", required = true)})
    public ModelAndView index(@ApiIgnore Params params, HttpServletRequest request,HttpSession session) {

        ModelAndView modelAndView = new ModelAndView();
        //一开始第一页，查询10条
        params.setPageNo(1);
        params.setPageSize(10);
        PageInfo<DomainPkStar> pageInfo = pkstarService.finds(params);
        List<Map<String,Object>> list = requireUserService.selectEmpMsg();
        session.setAttribute("listEmp",list);
        List<DomainPkStar> pkstarlist = pageInfo.getList();
        //查询数量
        //long couts = msgService.counts();

        modelAndView.addObject("pkstarlist", pkstarlist);
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
        //modelAndView.addObject("couts", couts);
        modelAndView.setViewName("views/pages/admin/pkstar_manager");
        return modelAndView;
    }

    @RequestMapping(value = "/insertPkstar", method = POST)
    @ResponseBody
    @ApiOperation(value = "添加星标员工", httpMethod = "POST", notes = "添加星标员工")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "query", dataType = "String", name = "token", value = "token标记", required = true), @ApiImplicitParam(paramType = "query", dataType = "int", name = "loginId", value = "loginId标记", required = true)})
    public Object insertPkstar(DomainPkStar domainPkStar) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        domainPkStar.setPkId(Integer.parseInt(UuidTools.getUuidNum()));
        domainPkStar.setPkEmpId(Integer.parseInt(this.checkStringIsEmpty(domainPkStar.getPkEmpId().toString())));
        domainPkStar.setPkEmpNamer(this.checkStringIsEmpty(domainPkStar.getPkEmpNamer().toString()));
        domainPkStar.setPkGiveStarId(Integer.parseInt(this.checkStringIsEmpty(domainPkStar.getPkGiveStarId().toString())));
        domainPkStar.setPkGiveStarName(this.checkStringIsEmpty(domainPkStar.getPkGiveStarName()));
        domainPkStar.setPkGiveStarRole(this.checkStringIsEmpty(domainPkStar.getPkGiveStarRole()));
        domainPkStar.setPkStarNum(this.checkStringIsEmpty(domainPkStar.getPkStarNum()));
        domainPkStar.setPkUpdateTime(sdf.format(new Date()));
        if (pkstarService.insert(domainPkStar)) {
            return ResultUtil.success("添加成功！");
        } else {
            return ResultUtil.success("添加失败！");
        }
    }


    @RequestMapping(value = "/insertPkstarByEmpID", method = POST)
    @ResponseBody
    @ApiOperation(value = "添加星标员工", httpMethod = "POST", notes = "添加星标员工")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "query", dataType = "String", name = "token", value = "token标记", required = true), @ApiImplicitParam(paramType = "query", dataType = "int", name = "loginId", value = "loginId标记", required = true)})
    public Object insertPkstarByEmpID(@RequestBody Map<String,Object> map,HttpSession session) throws ParseException {
        List<Map<String, Object>> mapList = requireUserService.queryEmpFields(map.get("reqDoEmpId").toString());
        if(mapList.get(0).get("pkStarNum")!=null && !"".equals(mapList.get(0).get("pkStarNum"))){
            return ResultUtil.error("不可重复评星！");
        }else{
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            DomainPkStar domainPkStar = new DomainPkStar();
            domainPkStar.setPkId(Integer.parseInt(UuidTools.getUuidNum()));
            domainPkStar.setPkEmpId(Integer.parseInt(this.checkStringIsEmpty(map.get("reqDoEmpId").toString())));

            domainPkStar.setPkEmpNamer(this.checkStringIsEmpty(mapList.get(0).get("employerName").toString()));
            domainPkStar.setPkGiveStarId(Integer.parseInt(this.checkStringIsEmpty(session.getAttribute("loginId").toString())));
            domainPkStar.setPkGiveStarName(this.checkStringIsEmpty(session.getAttribute("userName").toString()));
            domainPkStar.setPkGiveStarRole(this.checkStringIsEmpty(session.getAttribute("role").toString()));
            domainPkStar.setPkStarNum(this.checkStringIsEmpty(map.get("userDemand").toString()));
            domainPkStar.setPkUpdateTime(sdf.format(new Date()));
            if (pkstarService.insert(domainPkStar)) {
                return ResultUtil.success("添加成功！");
            } else {
                return ResultUtil.success("添加失败！");
            }
        }

    }




    @RequestMapping(value = "/updatePkstar", method = POST)
    @ResponseBody
    @ApiOperation(value = "修改星级员工信息", httpMethod = "POST", notes = "修改星级员工信息")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "query", dataType = "String", name = "token", value = "token标记", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "int", name = "loginId", value = "loginId标记", required = true)})
    public Object updatePkstar(DomainPkStar domainPkStar) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        domainPkStar.setPkId(Integer.parseInt(UuidTools.getUuidNum()));
        domainPkStar.setPkEmpId(Integer.parseInt(this.checkStringIsEmpty(domainPkStar.getPkEmpId().toString())));
        domainPkStar.setPkEmpNamer(this.checkStringIsEmpty(domainPkStar.getPkEmpNamer().toString()));
        domainPkStar.setPkGiveStarId(Integer.parseInt(this.checkStringIsEmpty(domainPkStar.getPkGiveStarId().toString())));
        domainPkStar.setPkGiveStarName(this.checkStringIsEmpty(domainPkStar.getPkGiveStarName()));
        domainPkStar.setPkGiveStarRole(this.checkStringIsEmpty(domainPkStar.getPkGiveStarRole()));
        domainPkStar.setPkStarNum(this.checkStringIsEmpty(domainPkStar.getPkStarNum()));
        domainPkStar.setPkUpdateTime(sdf.format(new Date()));
        if (pkstarService.updateByPrimaryKey(domainPkStar)) {
            return ResultUtil.success("修改成功！");
        } else {
            return ResultUtil.success("修改失败！");
        }

    }

    @RequestMapping(value = "/updatePkstarBefore", method = GET)
    @ApiOperation(value = "修改留言信息跳转修改页", httpMethod = "GET", notes = "修改留言信息跳转修改页")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "query", dataType = "String", name = "token", value = "token标记", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "int", name = "loginId", value = "loginId标记", required = true)})
    public Object updatePkstarBefore(@RequestParam String id, HttpSession session) {
        DomainPkStar domainPkStar = pkstarService.selectByPrimaryKey(Integer.parseInt(id),null);
        session.setAttribute("domainPkStar", domainPkStar);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("domainPkStar", domainPkStar);
        modelAndView.setViewName("views/pages/admin/updatePkstar");
        return ResultUtil.success(modelAndView);
    }


    @RequestMapping(value = "/deletePkstar", method = GET)
    @ResponseBody
    @ApiOperation(value = "删除星级职工信息", httpMethod = "GET", notes = "删除星级职工信息")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "query", dataType = "String", name = "token", value = "token标记", required = true), @ApiImplicitParam(paramType = "query", dataType = "int", name = "loginId", value = "loginId标记", required = true)})
    public Object deleteMsg(String id, String[] arrays) {
        Boolean index = null;
        if (id != null && !"".equals(id)) {
            index = pkstarService.deleteByPrimaryKey(id);
            if (index) {
                return ResultUtil.success("删除成功！");
            }
        } else {
            for (String str : arrays) {
                index = pkstarService.deleteByPrimaryKey(str);
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

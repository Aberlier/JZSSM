package com.jzssm.fhf.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jzssm.fhf.common.ResultUtil;
import com.jzssm.fhf.entity.DomainAdmin;
import com.jzssm.fhf.entity.DomainEmployer;
import com.jzssm.fhf.entity.DomainUser;
import com.jzssm.fhf.service.AdminService;
import com.jzssm.fhf.service.EmployerService;
import com.jzssm.fhf.service.UserService;
import com.jzssm.fhf.utils.JWT;
import com.jzssm.fhf.utils.MD5Util;
import com.jzssm.fhf.utils.ResponseData;
import com.jzssm.fhf.utils.UuidTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * @author ：Angular
 * @date ：Created in 2021/1/3 20:08
 * @description：登录操作
 * @modified By：
 * @version: v1.0.0$
 */
@Controller
public class LoginController {
    @Autowired
    UserService userService;

    @Autowired
    AdminService adminService;

    @Autowired
    EmployerService employerService;

    @RequestMapping("/login_page")
    public String loginPage() {
        return "views/login";
    }

    @RequestMapping("/regist_page")
    public String registPage() {
        return "views/regist";
    }

    @RequestMapping("/info_page")
    public String infoPage() {
        return "views/info";
    }

    //处理登录
    @RequestMapping(value = "/login")
    @ResponseBody
    public ResponseData login(@RequestParam("telnum") String telnum,
                              @RequestParam("rolename") String role,
                              @RequestParam("password") String password, HttpSession session, Model model) {
        ResponseData responseData = ResponseData.ok();
        Map<String, Object> userMap = new HashMap<>();
        Map<String, Object> employerMap = new HashMap<>();
        Map<String, Object> adminMap = new HashMap<>();
        DomainEmployer loginEmployer = null;
        DomainAdmin loginAdmin = null;
        DomainUser loginUser = null;
        if (role == null || "".equals(role)) {
            responseData.putDataValue("errorMsg", "<script> alert('请选择对应的角色！')</script>");
        }
        if (telnum == null || "".equals(telnum)) {
            responseData.putDataValue("errorMsg", "<script> alert('请输入手机号！')</script>");
        }
        if (password == null || "".equals(password)) {
            responseData.putDataValue("errorMsg", "<script> alert('请输入密码！')</script>");
        }


        //先到数据库验证
        switch (role) {
            case "3":
                userMap = userService.selectByTelRoleLogin(telnum, role);
                loginUser = JSON.parseObject(JSON.toJSONString(userMap), DomainUser.class);
                break;
            case "2":
                employerMap = userService.selectByTelRoleLogin(telnum, role);
                loginEmployer = JSON.parseObject(JSON.toJSONString(employerMap), DomainEmployer.class);
                break;
            case "1":
                adminMap = userService.selectByTelRoleLogin(telnum, role);
                loginAdmin = JSON.parseObject(JSON.toJSONString(adminMap), DomainAdmin.class);
                break;
            default:
                return null;
        }
        if (null != loginUser && MD5Util.checkPassword(password, loginUser.getUserPwd())) {
            //给用户jwt加密生成token
            String token = JWT.sign(loginUser, 60L * 1000L * 30L);
            //封装成对象返回给客户端
            session.setAttribute("user", loginUser);
            session.setAttribute("userName", loginUser.getUserName());
            session.setAttribute("loginId", loginUser.getUserId());
            session.setAttribute("role", loginUser.getUserRole());
            session.setAttribute("token", token);

            responseData.putDataValue("loginId", loginUser.getUserId());
            responseData.putDataValue("role", loginUser.getUserRole());
            responseData.putDataValue("token", token);
            responseData.putDataValue("user", loginUser);
            responseData.putDataValue("code", 200);
            responseData.putDataValue("msg", "登陆成功");
        } else if (null != loginEmployer && MD5Util.checkPassword(password, loginEmployer.getEmployerPwd())) {
            //给用户jwt加密生成token
            String token = JWT.sign(loginEmployer, 60L * 1000L * 30L);
            //封装成对象返回给客户端
            session.setAttribute("user", loginEmployer);
            session.setAttribute("userName", loginEmployer.getEmployerName());
            session.setAttribute("role", loginEmployer.getEmployerRole());
            session.setAttribute("loginId", loginEmployer.getEmployerId());
            session.setAttribute("token", token);

            responseData.putDataValue("loginId", loginEmployer.getEmployerId());
            responseData.putDataValue("role", loginEmployer.getEmployerRole());
            responseData.putDataValue("token", token);
            responseData.putDataValue("user", loginEmployer);
            responseData.putDataValue("code", 200);
            responseData.putDataValue("msg", "登陆成功");
        } else if (null != loginAdmin && MD5Util.checkPassword(password, loginAdmin.getAdminPwd())) {
            //给用户jwt加密生成token
            String token = JWT.sign(loginAdmin, 60L * 1000L * 30L);
            //封装成对象返回给客户端
            session.setAttribute("user", loginAdmin);
            session.setAttribute("userName", loginAdmin.getAdminName());
            session.setAttribute("role", loginAdmin.getAdminRole());
            session.setAttribute("loginId", loginAdmin.getAdminId());
            session.setAttribute("token", token);

            responseData.putDataValue("loginId", loginAdmin.getAdminId());
            responseData.putDataValue("role", loginAdmin.getAdminRole());
            responseData.putDataValue("token", token);
            responseData.putDataValue("user", loginAdmin);
            responseData.putDataValue("code", 200);
            responseData.putDataValue("msg", "登陆成功");
        } else {
            responseData = ResponseData.customerError();
        }

        return responseData;
    }

    //处理登录
    @RequestMapping(value = "/regist", produces = "application/json; charset=utf-8")
    @ResponseBody
    public Object regist(@RequestParam("telnum") String telnum,
                         @RequestParam("password") String password,
                         @RequestParam("rolename") Integer roleName,
                         @RequestParam("username") String username,
                         @RequestParam("age") String age
    ) throws ParseException {
        SimpleDateFormat dtf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        ResponseData responseData = ResponseData.ok();
        //管理员
        if (roleName.equals(1)) {
//            DomainAdmin adminDomain = adminService.selectByTelNum(telnum);
            Map<String, Object> adminMap = userService.selectByTelRoleLogin(telnum, String.valueOf(roleName));
            DomainAdmin adminDomain = JSON.parseObject(JSON.toJSONString(adminMap), DomainAdmin.class);
            if (adminDomain != null && !"".equals(adminDomain)) {
                if (telnum.equals(adminDomain.getAdminTelnum())) {
                    responseData.putDataValue("code", 400);
                    responseData.putDataValue("msg", "该手机号已经注册，请重新注册！");
                }
            } else {
                DomainAdmin admin = new DomainAdmin();
                /* DomainAdmin admin = JSON.toJavaObject(jsonObject, DomainAdmin.class);*/
                admin.setAdminId(Integer.parseInt(UuidTools.getUuidNum()));
                admin.setAdminName(username);
                admin.setAdminPwd(MD5Util.getMD5String(password));
                admin.setAdminRole(roleName);
                admin.setAdminTelnum(telnum);
                admin.setAdminUpdatetime(dtf.format(new Date()));
                admin.setAdminCreatetime(dtf.format(new Date()));
                int index = adminService.insert(admin);
                if (index > 0) {
                    return ResultUtil.success("注册成功！");
                } else {
                    return ResultUtil.success("注册失败！");
                }
            }

        }
        //从业者
        else if (roleName.equals(2)) {
//            DomainEmployer eDomain = employerService.selectByTelNum(telnum);
            Map<String, Object> eMap = userService.selectByTelRoleLogin(telnum, String.valueOf(roleName));
            DomainEmployer eDomain = JSON.parseObject(JSON.toJSONString(eMap), DomainEmployer.class);
            if (eDomain != null && !"".equals(eDomain)) {
                if (telnum.equals(eDomain.getEmployerTelnum())) {
                    responseData.putDataValue("code", 400);
                    responseData.putDataValue("msg", "该手机号已经注册，请重新注册！");
                }
            } else {
                // DomainEmployer employer = JSON.toJavaObject(jsonObject, DomainEmployer.class);
                DomainEmployer employer = new DomainEmployer();
                employer.setEmployerId(Integer.parseInt(UuidTools.getUuidNum()));
                employer.setEmployerName(username);
                employer.setEmployerPwd(MD5Util.getMD5String(password));
                employer.setEmployerAge(age);
                employer.setEmployerRole(roleName);
                employer.setEmployerTelnum(telnum);
                int index = employerService.insert(employer);
                if (index > 0) {
                    return ResultUtil.success("注册成功！");
                } else {
                    return ResultUtil.success("注册失败！");
                }
            }
        }
        //用户
        else if (roleName.equals(3)) {
//            DomainUser eDomain = userService.selectByTelNum(telnum);
            Map<String, Object> uMap = userService.selectByTelRoleLogin(telnum, String.valueOf(roleName));
            DomainUser userDomain = JSON.parseObject(JSON.toJSONString(uMap), DomainUser.class);
            if (userDomain != null && !"".equals(userDomain)) {
                if (telnum.equals(userDomain.getUserTelnum())) {
                    responseData.putDataValue("code", 400);
                    responseData.putDataValue("msg", "该手机号已经注册，请重新注册！");
                }
            } else {
                DomainUser user = new DomainUser();
                user.setUserId(Integer.parseInt(UuidTools.getUuidNum()));
                user.setUserName(username);
                user.setUserPwd(MD5Util.getMD5String(password));
                user.setUserRole(roleName + "");
                user.setUserTelnum(telnum);
                Boolean index = userService.insert(user);
                if (index) {
                    return ResultUtil.success("注册成功！");
                } else {
                    return ResultUtil.success("注册失败！");
                }
            }
        }
        return responseData;
    }
}

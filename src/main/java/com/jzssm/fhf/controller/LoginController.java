package com.jzssm.fhf.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

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

    //处理登录
    @RequestMapping(value = "/login", produces = "application/json; charset=utf-8")
    @ResponseBody
    public ResponseData login(@RequestParam("telnum") String telnum,
                              @RequestParam("rolename") String role,
                              @RequestParam("password") String password, HttpSession session, Model model) {
        ResponseData responseData = ResponseData.ok();
        Map<String,Object> userMap = new HashMap<>();
        Map<String,Object> employerMap = new HashMap<>();
        Map<String,Object> adminMap = new HashMap<>();
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
                loginUser = JSON.parseObject(JSON.toJSONString(userMap),DomainUser.class);
                break;
            case "2":
                employerMap = userService.selectByTelRoleLogin(telnum, role);
                loginEmployer = JSON.parseObject(JSON.toJSONString(userMap),DomainEmployer.class);
                break;
            case "1":
                adminMap = userService.selectByTelRoleLogin(telnum, role);
                loginAdmin = JSON.parseObject(JSON.toJSONString(userMap),DomainAdmin.class);
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
            responseData.putDataValue("token", token);
            responseData.putDataValue("user", loginUser);
            responseData.putDataValue("code", 200);
            responseData.putDataValue("msg", "登陆成功");
        } else if(null != loginEmployer && MD5Util.checkPassword(password, loginEmployer.getEmployerPwd())) {
            //给用户jwt加密生成token
            String token = JWT.sign(loginUser, 60L * 1000L * 30L);
            //封装成对象返回给客户端
            session.setAttribute("user", loginEmployer);
            session.setAttribute("userName", loginEmployer.getEmployerName());
            session.setAttribute("role", loginEmployer.getEmployerRole());
            session.setAttribute("loginId", loginEmployer.getEmployerId());
            session.setAttribute("token", token);

            responseData.putDataValue("loginId", loginEmployer.getEmployerId());
            responseData.putDataValue("token", token);
            responseData.putDataValue("user", loginEmployer);
            responseData.putDataValue("code", 200);
            responseData.putDataValue("msg", "登陆成功");
        }else if(null != loginAdmin && MD5Util.checkPassword(password, loginAdmin.getAdminPwd())) {
            //给用户jwt加密生成token
            String token = JWT.sign(loginUser, 60L * 1000L * 30L);
            //封装成对象返回给客户端
            session.setAttribute("user", loginUser);
            session.setAttribute("userName", loginAdmin.getAdminName());
            session.setAttribute("role", loginAdmin.getAdminRole());
            session.setAttribute("loginId", loginAdmin.getAdminId());
            session.setAttribute("token", token);

            responseData.putDataValue("loginId", loginAdmin.getAdminId());
            responseData.putDataValue("token", token);
            responseData.putDataValue("user", loginAdmin);
            responseData.putDataValue("code", 200);
            responseData.putDataValue("msg", "登陆成功");
        }else {
            responseData = ResponseData.customerError();
        }

        return responseData;
    }

    //处理登录
    @RequestMapping(value = "/regist", produces = "application/json; charset=utf-8")
    @ResponseBody
    public ResponseData regist(@RequestParam("telnum") String telnum,
                               @RequestParam("password") String password,
                               @RequestParam("role") String role,
                               @RequestParam("rolename") Integer roleName,
                               @RequestParam("username") String username,
                               @RequestParam("age") String age
    ) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        ResponseData responseData = ResponseData.ok();
        //管理员
        if (roleName.equals(1)) {
//            DomainAdmin adminDomain = adminService.selectByTelNum(telnum);
            Map<String,Object> adminMap =  userService.selectByTelRoleLogin(telnum, role);
            DomainAdmin adminDomain = JSON.parseObject(JSON.toJSONString(adminMap),DomainAdmin.class);
            if (telnum.equals(adminDomain.getAdminTelnum())) {
                responseData.putDataValue("code", 400);
                responseData.putDataValue("msg", "该手机号已经注册，请重新注册！");
            } else {
                DomainAdmin admin = new DomainAdmin();
                /* DomainAdmin admin = JSON.toJavaObject(jsonObject, DomainAdmin.class);*/
                admin.setAdminId(Integer.parseInt(UuidTools.getUuidNum()));
                admin.setAdminName(username);
                admin.setAdminPwd(MD5Util.getMD5String(password));
                admin.setAdminRole(roleName);
                admin.setAdminTelnum(telnum);
                admin.setAdminUpdatetime(new Date());
                admin.setAdminCreatetime(new Date());
                int index = adminService.insert(admin);
                if (index > 0) {
                    responseData.putDataValue("code", 200);
                    responseData.putDataValue("msg", "注册成功");
                } else {
                    responseData.putDataValue("code", 401);
                    responseData.putDataValue("msg", "注册失败");
                }
            }

        }
        //从业者
        else if (roleName.equals(2)) {
//            DomainEmployer eDomain = employerService.selectByTelNum(telnum);
            Map<String,Object> eMap =  userService.selectByTelRoleLogin(telnum, role);
            DomainEmployer eDomain = JSON.parseObject(JSON.toJSONString(eMap),DomainEmployer.class);
            if (telnum.equals(eDomain.getEmployerTelnum())) {
                responseData.putDataValue("code", 400);
                responseData.putDataValue("msg", "该手机号已经注册，请重新注册！");
            } else {
                // DomainEmployer employer = JSON.toJavaObject(jsonObject, DomainEmployer.class);
                DomainEmployer employer = new DomainEmployer();
                employer.setEmployerId(Integer.parseInt(UuidTools.getUuidNum()));
                employer.setEmployerName(username);
                employer.setEmployerPwd(MD5Util.getMD5String(password));
                employer.setEmployerRole(roleName);
                employer.setEmployerTelnum(telnum);
                int index = employerService.insert(employer);
                if (index > 0) {
                    responseData.putDataValue("code", 200);
                    responseData.putDataValue("msg", "注册成功");
                } else {
                    responseData.putDataValue("code", 401);
                    responseData.putDataValue("msg", "注册失败");
                }
            }
        }
        //用户
        else if (roleName.equals(3)) {
//            DomainUser eDomain = userService.selectByTelNum(telnum);
            Map<String,Object> uMap =  userService.selectByTelRoleLogin(telnum, role);
            DomainUser eDomain = JSON.parseObject(JSON.toJSONString(uMap),DomainUser.class);
            if (telnum.equals(eDomain.getUserTelnum())) {
                responseData.putDataValue("code", 400);
                responseData.putDataValue("msg", "该手机号已经注册，请重新注册！");
            } else {
                DomainUser user = new DomainUser();
                user.setUserId(Integer.parseInt(UuidTools.getUuidNum()));
                user.setUserName(username);
                user.setUserPwd(MD5Util.getMD5String(password));
                user.setUserRole(roleName + "");
                user.setUserTelnum(telnum);
                Boolean index = userService.insert(user);
                if (index) {
                    responseData.putDataValue("code", 200);
                    responseData.putDataValue("msg", "注册成功");
                } else {
                    responseData.putDataValue("code", 401);
                    responseData.putDataValue("msg", "注册失败");
                }
            }
        }
        return responseData;
    }
}

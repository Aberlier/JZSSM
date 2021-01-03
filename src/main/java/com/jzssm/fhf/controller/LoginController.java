package com.jzssm.fhf.controller;

import com.jzssm.fhf.entity.DomainUser;
import com.jzssm.fhf.service.UserService;
import com.jzssm.fhf.utils.JWT;
import com.jzssm.fhf.utils.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：Angular
 * @date ：Created in 2021/1/3 20:08
 * @description：登录操作
 * @modified By：
 * @version: v1.0.0$
 */
@RestController
public class LoginController {
    @Autowired
    UserService userService;

    //处理登录
    @RequestMapping(value = "login", produces = "application/json; charset=utf-8")
    @ResponseBody
    public ResponseData login(@RequestParam("telnum") String telnum,
                              @RequestParam("password") String password) {
        DomainUser user = new DomainUser();
        user.setUserTelnum(Integer.parseInt(telnum));
        user.setUserPwd(password);
        ResponseData responseData = ResponseData.ok();
        //先到数据库验证
        DomainUser loginUser = userService.selectByPrimaryKey(Integer.parseInt(telnum));
        if (null != loginUser) {
            //给用户jwt加密生成token
            String token = JWT.sign(loginUser, 60L * 1000L * 30L);
            //封装成对象返回给客户端
            responseData.putDataValue("loginId", loginUser.getUserId());
            responseData.putDataValue("token", token);
            responseData.putDataValue("user", user);
        } else {
            responseData = ResponseData.customerError();
        }
        return responseData;
    }
}

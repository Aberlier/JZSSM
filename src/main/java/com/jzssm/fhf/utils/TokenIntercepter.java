package com.jzssm.fhf.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.jzssm.fhf.entity.DomainAdmin;
import com.jzssm.fhf.entity.DomainEmployer;
import com.jzssm.fhf.entity.DomainUser;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.io.PrintWriter;

/**
 * @author ：Angular
 * @date ：Created in 2021/1/3 21:17
 * @description：token拦截器
 * @modified By：
 * @version: v1.0.0$
 */
public class TokenIntercepter implements HandlerInterceptor {
    //第一个函数是预处理函数，比如而欧美让你用于拦截登陆时亚视第一个工作的
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        response.setCharacterEncoding("utf-8");
        //从原来的headers里改到普通
//        String token = request.getHeader("token");
        String token = request.getParameter("token");
        String loginId = request.getParameter("loginId");
        String role = request.getParameter("role");
        ResponseData responseData = ResponseData.ok();
        //token存在
        if(null != token && "3".equals(role)) {
            DomainUser domainUser = JWT.unsign(token, DomainUser.class);
            //解密token后的loginId与用户传来的loginId不一致，一般都是token过期
            if(null != loginId && null != domainUser) {
                if(Integer.parseInt(loginId) == domainUser.getUserId()) {
                    return true;
                } else {
                    responseData = ResponseData.forbidden();
                    responseMessage(response, response.getWriter(), responseData);
                    return false;
                }
            }
        } else if(null != token && "2".equals(role)){
            DomainEmployer domainEmployer = JWT.unsign(token, DomainEmployer.class);
            //解密token后的loginId与用户传来的loginId不一致，一般都是token过期
            if(null != loginId && null != domainEmployer) {
                if(Integer.parseInt(loginId) == domainEmployer.getEmployerId()) {
                    return true;
                } else {
                    responseData = ResponseData.forbidden();
                    responseMessage(response, response.getWriter(), responseData);
                    return false;
                }
            }
        } else if(null != token && "1".equals(role)){
                DomainAdmin domainAdmin = JWT.unsign(token, DomainAdmin.class);
                //解密token后的loginId与用户传来的loginId不一致，一般都是token过期
                if(null != loginId && null != domainAdmin) {
                    if(Integer.parseInt(loginId) == domainAdmin.getAdminId()) {
                        return true;
                    } else {
                        responseData = ResponseData.forbidden();
                        responseMessage(response, response.getWriter(), responseData);
                        return false;
                    }
            }
        }else {
            responseData = ResponseData.forbidden();
            responseMessage(response, response.getWriter(), responseData);
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }

    //请求不通过，返回错误信息给客户端
    private void responseMessage(HttpServletResponse response, PrintWriter out, ResponseData responseData) {
        responseData = ResponseData.forbidden();
        response.setContentType("application/json; charset=utf-8");
        String json = JSONObject.toJSONString(responseData);
        out.print(json);
        out.flush();
        out.close();
    }
}

package com.jzssm.fhf.utils;

import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author ：Angular
 * @ProjectName: JZSSM
 * @Package: com.jzssm.fhf.utils
 * @ClassName: CORSFilter
 * @date ：Created in 2021/1/10 8:41
 * @description：解决跨域问题
 * @modified By：
 * @version: v1.0.0$
 */
@Order(1)
//重点
@WebFilter(filterName = "corsFilter", urlPatterns = {"/*"})
public class CORSFilter implements Filter {

        @Override
        public void init(FilterConfig filterConfig) throws ServletException {
            System.out.println("初始化filter==========================");
        }
        @Override
        public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException, IOException {
            HttpServletResponse response = (HttpServletResponse) servletResponse;
            response.setHeader("Access-Control-Allow-Origin", "*"); //  这里最好明确的写允许的域名
            response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE, PUT");
            response.setHeader("Access-Control-Max-Age", "3600");
            response.setHeader("Access-Control-Allow-Headers", "Content-Type,Access-Token,Authorization,ybg");
            filterChain.doFilter(servletRequest, servletResponse);
            System.out.println("filter==========================");
        }
        @Override
        public void destroy() {
            System.out.println("销毁filter==========================");
        }

}

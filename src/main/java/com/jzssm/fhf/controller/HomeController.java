package com.jzssm.fhf.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author ：Angular
 * @ProjectName: JZSSM
 * @Package: com.jzssm.fhf.controller
 * @ClassName: HomeController
 * @date ：Created in 2021/1/9 13:01
 * @description：主页信息展示模块
 * @modified By：
 * @version: v1.0.0$
 */
@RestController
@RequestMapping(value = "home")
public class HomeController {

    @GetMapping(value = "/index")
    @ResponseBody
    public ModelAndView home(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("views/index");
        return modelAndView;
    }

    @GetMapping(value="/go")
    public String test() {

        System.out.println("成功进入controller");
        return "now doing something";
    }
}

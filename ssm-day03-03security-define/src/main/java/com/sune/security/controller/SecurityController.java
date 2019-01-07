package com.sune.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SecurityController {
    /**
     * 普通请求
     * @param model
     * @return
     */
    @RequestMapping("/common")
    public String common(Model model){
        model.addAttribute("title","spring security 问好");
        model.addAttribute("message","普通页面");
        return "common";
    }
    /**
     * 欢迎请求
     */
    @RequestMapping("/welcome")
    public String welcome(Model model){
        model.addAttribute("title","spring security 问好");
        model.addAttribute("message","欢迎页面");
        return "welcome";
    }
    /**
     * 管理请求
     */
    @RequestMapping("/admin")
    public String admin(Model model) {
        model.addAttribute("title", "spring security 问好");
        model.addAttribute("message", "管理页面");
        return "admin";
    }
}

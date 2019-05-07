package com.hcc.springboot_integrated.controller;

import com.hcc.springboot_integrated.pojo.User;
import com.hcc.springboot_integrated.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName UserController
 * @Description TODO
 * @Author Abel
 * @Date 2019/5/7 16:46
 * @Version 1.0
 **/
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/jsp")
    public String showUser(Model model) {
        List<User> list = new ArrayList<>();
        list.add(new User(1, "张三", 20, "男"));
        list.add(new User(2, "小丽", 22, "女"));
        list.add(new User(3, "小刚", 23, "男"));
        model.addAttribute("userList", list);
        //跳转视图
        return "index";
    }


    @RequestMapping("/ftl")
    public ModelAndView showUser2() {
        List<User> list = new ArrayList<>();
        list.add(new User(1, "张三三", 20, "男"));
        list.add(new User(2, "小丽", 22, "女"));
        list.add(new User(3, "小刚", 23, "男"));
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("userList", list);
        modelAndView.setViewName("demo");
        return modelAndView;
    }

    @RequestMapping("/th")
    public String showInfo(Model model) {
        model.addAttribute("msg", "Thymeleaf 第一个案例");
        return "demo2";
    }

    @RequestMapping("/{page}")
    public String page(@PathVariable String page) {
        return page;
    }

    @PostMapping("addUser")
    public String addUser(User user) {
        this.userService.addUser(user);
        return "ok";
    }


}

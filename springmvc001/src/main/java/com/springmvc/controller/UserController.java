package com.springmvc.controller;

import com.springmvc.domain.User;
import com.springmvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class UserController {

    @Autowired//按类型注入
    private UserService userService;

    @RequestMapping("/user/findAll")
    public String findAll(Model model) {//存数据，model对象
        System.out.println("Controller表现层：查询所有账户...");
        //调用service的方法
        List<User> list = userService.findAll();
        model.addAttribute("list", list);
        return "list";  //在视图解析器中配置了前缀后缀
    }
}
package com.example.demo.controller;

import cn.dev33.satoken.stp.StpUtil;
import com.example.demo.annotation.CustomerLog;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {


    @RequestMapping("/doLogin")
    @CustomerLog(value = "访问登录接口")
    public String doLogin(String username,String password){
        if ("ghost".equals(username) && "qq123456".equals(password)) {
            StpUtil.login(1001);
            return "登录成功";
        }
        return "登录失败";
    }

    @GetMapping("/isLogin")
    public String isLogin() {
        StpUtil.checkLogin();
        return "当前会话状态：" + (StpUtil.isLogin()? "已登录" : "未登录");
    }
}

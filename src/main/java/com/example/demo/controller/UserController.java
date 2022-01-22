package com.example.demo.controller;

import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.util.StrUtil;
import com.example.demo.annotation.CustomerLog;
import com.example.demo.common.CommonResult;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import io.netty.util.internal.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/doLogin")
    @CustomerLog(value = "访问登录接口")
    public CommonResult<Object> doLogin(@RequestBody User user){
        User findUser = userService.findByCondition(user);

        //登录失败
        if (findUser == null) {
            return CommonResult.fail(500,"用户名或密码错误！");
        }
        //登录成功 设置登录状态
        StpUtil.login(findUser.getId());
        String token = StpUtil.getTokenValue();
        return CommonResult.success(token,"登录成功！");
    }

    @GetMapping("/logout")
    public CommonResult<Object> logout(HttpServletRequest request) {
        StpUtil.logout();
        return CommonResult.success();
    }

}

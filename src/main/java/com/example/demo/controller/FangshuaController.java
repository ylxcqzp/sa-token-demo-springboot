package com.example.demo.controller;

import com.example.demo.annotation.AccessLimit;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author qzp
 * @Description: 接口防刷测试
 * @date 2021/7/29 10:40
 */
@RestController
public class FangshuaController {

    @RequestMapping("/fangshua")
    @AccessLimit(seconds = 5,maxCount = 3,needLogin = true)
    public String fangShua() {
        return "接口请求成功！";
    }
}

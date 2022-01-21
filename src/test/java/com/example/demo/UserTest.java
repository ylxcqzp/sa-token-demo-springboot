package com.example.demo;

import cn.hutool.crypto.digest.DigestUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * @author qzp
 * @Description: todo
 * @date 2022/1/20 11:27
 */
@SpringBootTest
@WebAppConfiguration
public class UserTest {
    @Autowired
    private UserService userService;

   /* @Test
    void UserInsertTest() {
        User user = new User();
        user.setUsername("GHOST")
                .setSex(1)
                .setNickname("陨落星辰")
                .setPassword(DigestUtil.md5Hex("qq123456"));
        System.out.println(user);
        userService.insertUser(user);
    }*/

    @Test
    void UserGetTest() {
        IPage<User> list = userService.findList(1, 10);
        return;
    }
}

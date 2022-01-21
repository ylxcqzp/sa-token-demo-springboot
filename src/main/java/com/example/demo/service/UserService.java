package com.example.demo.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.demo.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author qzp
 * @since 2022-01-19
 */
public interface UserService extends IService<User> {

    User findById(String id);

    User findByCondition(User user);

    boolean insertUser(User user);

    boolean updateUser(User user);

    IPage<User> findList(Integer pageNum, Integer pageSize);
}

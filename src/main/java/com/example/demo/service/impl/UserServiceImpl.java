package com.example.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.entity.Book;
import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author qzp
 * @since 2022-01-19
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User findById(String id) {
        return getById(id);
    }

    @Override
    public User findByCondition(User user) {
        return userMapper.selectOne(new QueryWrapper<User>().lambda().eq(User::getUsername,user.getUsername()).eq(User::getPassword,user.getPassword()));
    }

    @Override
    public boolean insertUser(User user) {
        return save(user);
    }

    @Override
    public boolean updateUser(User user) {
        return updateById(user);
    }

    @Override
    public IPage<User> findList(Integer pageNum, Integer pageSize) {
        IPage<User> pageParam = new Page<>(pageNum, pageSize);
        return page(pageParam);
    }
}

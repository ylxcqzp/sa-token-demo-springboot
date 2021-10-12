package com.example.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.entity.Book;
import com.example.demo.mapper.BookMapper;
import com.example.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author qzp
 * @Description: todo
 * @date 2021/10/12 15:45
 */
@Service
public class BookServiceImpl extends ServiceImpl<BookMapper, Book> implements BookService {
    @Autowired
    private BookMapper bookMapper;

    @Override
    public List<Book> findByName(String name) {
        return null;
    }

    @Override
    public IPage<Book> findListByPriceRange(Double lowPrice, Double highPrice, Integer pageNum, Integer pageSize) {
        IPage<Book> pageParam = new Page<>(pageNum, pageSize);
        QueryWrapper<Book> queryWrapper = new QueryWrapper<>();
        IPage<Book> pageResult = null;
        if (lowPrice == null && highPrice == null) {
            pageResult = page(pageParam);
        }else if (lowPrice != null && highPrice != null) {
            //todo 执行自定义sql
        }else if (lowPrice != null) {
            pageResult = bookMapper.selectPage(pageParam,queryWrapper.lambda().ge(Book::getPrice,lowPrice));
        }else if (highPrice != null) {
            pageResult = bookMapper.selectPage(pageParam,queryWrapper.lambda().le(Book::getPrice,highPrice));
        }
        return pageResult;
    }
}

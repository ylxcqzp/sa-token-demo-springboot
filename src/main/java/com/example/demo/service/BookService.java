package com.example.demo.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.entity.Book;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author qzp
 * @Description: todo
 * @date 2021/10/12 15:33
 */
public interface BookService extends IService<Book> {
    List<Book> findByName(String name);

    IPage<Book> findListByPriceRange(Double lowPrice, Double highPrice, Integer pageNum, Integer pageSize);
}

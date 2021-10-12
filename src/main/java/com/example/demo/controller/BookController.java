package com.example.demo.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.common.BasePageResult;
import com.example.demo.common.CommonResult;
import com.example.demo.entity.Book;
import com.example.demo.service.BookService;
import com.sun.istack.internal.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author qzp
 * @Description: todo
 * @date 2021/10/12 16:06
 */
@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;

    /**
     * 根据id查询书籍信息
     * @param id
     * @return
     */
    @GetMapping("/id/{id}")
    public Book getById(@PathVariable @NotNull String id) {
        return bookService.getById(id);
    }

    /**
     * 分页查询书本信息
     * @return
     */
    @GetMapping("/list")
    public CommonResult<Object> getBooks(Book book) {
        Page<Book> pageParams = new Page<>(book.getPageNum(), book.getPageSize());
        IPage<Book> pageResult = bookService.page(pageParams);
        return CommonResult.success().setData(BasePageResult.newInstance(pageResult));
    }

    /**
     * 根据价格区间查询
     * @param lowPrice 最低价格
     * @param highPrice 最高价格
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping("/price_range")
    public CommonResult<Object> getListByPriceRange(Double lowPrice, Double highPrice, @RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "10") Integer pageSize) {
        IPage<Book> listByPriceRange = bookService.findListByPriceRange(lowPrice, highPrice, pageNum, pageSize);
        return CommonResult.success().setData(BasePageResult.newInstance(listByPriceRange));
    }

}

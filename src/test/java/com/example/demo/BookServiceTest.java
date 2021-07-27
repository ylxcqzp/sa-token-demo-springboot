package com.example.demo;

import com.example.demo.service.BookService;
import com.example.demo.entity.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author qzp
 * @Description: todo
 * @date 2021/7/26 11:59
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class BookServiceTest {
    @Autowired
    private BookService bookService;


    @Test
    public void testSaveWithId()
    {
        Book book = new Book(2,"疯狂Python",
                "系统易懂的Python图书，覆盖数据分析、爬虫等热门内容", 118.0,60L);
        bookService.save(book);
    }
}

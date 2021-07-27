package com.example.demo.service;

import com.example.demo.entity.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import java.util.List;

/**
 * @author qzp
 * @Description: todo
 * @date 2021/7/26 11:52
 */
public interface BookService extends CrudRepository<Book,Integer> , QueryByExampleExecutor<Book> {
    
    List<Book> findByName(String name);

    List<Book> findByDescription(String description);
}

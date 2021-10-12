package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.Book;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author qzp
 * @Description: todo
 * @date 2021/10/12 15:29
 */
@Repository
public interface BookMapper extends BaseMapper<Book> {

}

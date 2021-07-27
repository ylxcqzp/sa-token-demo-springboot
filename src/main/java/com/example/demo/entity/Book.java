package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.TimeToLive;
import org.springframework.data.redis.core.index.Indexed;

import java.util.concurrent.TimeUnit;

/**
 * @author qzp
 * @Description: 书籍信息实体类
 * @date 2021/7/26 11:41
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@RedisHash("book")
public class Book {
    // 标识属性，可用于查询
    @Id
    private Integer id;

    // 带@Indexed注解的属性被称为“二级索引”，可用于查询
    @Indexed
    private String name;

    @Indexed
    private String description;

    private Double price;

    // 定义它的超时时长
    @TimeToLive(unit = TimeUnit.SECONDS)
    Long timeout;

}

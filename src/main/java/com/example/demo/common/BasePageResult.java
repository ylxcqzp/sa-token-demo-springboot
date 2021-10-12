package com.example.demo.common;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.Data;

import java.util.List;

/**
 * @author qzp
 * @Description: todo
 * @date 2021/10/12 16:36
 */
@Data
public class BasePageResult<T> {
    private List<T> data;

    private Long totalNum;

    public BasePageResult(List<T> data, Long totalNum){
        this.data = data;
        this.totalNum = totalNum;
    }

    public static <E> BasePageResult<E> newInstance(IPage<E> page) {
        return new BasePageResult<E>(page.getRecords(), page.getTotal());
    }
}

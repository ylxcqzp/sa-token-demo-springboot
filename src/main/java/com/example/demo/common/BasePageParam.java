package com.example.demo.common;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

/**
 * @author qzp
 * @Description: 分页参数
 * @date 2021/10/12 16:32
 */
@Data
public class BasePageParam {
    @TableField(exist = false)
    private Integer pageNum = 1;

    @TableField(exist = false)
    private Integer pageSize = 10;
}

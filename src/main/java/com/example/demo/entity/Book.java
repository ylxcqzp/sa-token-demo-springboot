package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.example.demo.common.BasePageParam;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import java.util.Date;

/**
 * @author qzp
 * @Description: 书籍信息实体类
 * @date 2021/7/26 11:41
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@TableName(value = "BOOK")
public class Book extends BasePageParam {
    @TableId(value = "id",type = IdType.UUID)
    private String id;

    private String name;

    private String description;

    private Double price;

    @TableField(value = "creatTime", fill = FieldFill.INSERT)
    private Date creatTime;

    @TableField(value = "updateTime",exist = true,fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    /**
     * 版本号(用于乐观锁 默认为1)
     */
    @Version
    private int version;

}

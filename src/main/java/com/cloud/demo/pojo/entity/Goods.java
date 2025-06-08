package com.cloud.demo.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.time.LocalDateTime;

@TableName
public class Goods implements Serializable {
    @TableId(type = IdType.AUTO)
    private Long goodsId;

    @TableField
    private String name;

    @TableField
    private Double price; // 原始商品价格

    @TableField
    private Double discountPrice; // 秒杀商品价格

    @TableField
    private Double stock; // 库存

    @TableField
    private LocalDateTime createTime;

    @TableField
    private LocalDateTime startTime;

    @TableField
    private LocalDateTime endTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}

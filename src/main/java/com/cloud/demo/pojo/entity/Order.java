package com.cloud.demo.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.time.LocalDateTime;

@TableName
public class Order implements Serializable {
    @TableId(type = IdType.AUTO)
    private Long orderId;

    @TableField
    private Long userId;

    @TableField
    private Long goodsId;

    @TableField
    private LocalDateTime createTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}

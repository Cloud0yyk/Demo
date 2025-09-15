package com.cloud.user.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@TableName
@Data
public class Product implements Serializable {
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 商品名
     */
    private String name;

    /**
     * 原始商品价格
     */
    private Double price;

    /**
     * 秒杀商品价格
     */
    private Double discountPrice; // 秒杀商品价格

    /**
     * 库存量
     */
    private Integer stock;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 秒杀开始时间
     */
    private Date startTime;

    /**
     * 秒杀结束时间
     */
    private Date endTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}

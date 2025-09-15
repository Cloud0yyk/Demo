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
public class Order implements Serializable {
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 创建订单的用户id
     */
    private Long userId;

    /**
     * 订单关联的商品id
     */
    private Long goodsId;

    /**
     * 订单创建时间
     */
    private Date createTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}

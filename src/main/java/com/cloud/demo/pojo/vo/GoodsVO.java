package com.cloud.demo.pojo.vo;

import java.io.Serializable;
import java.time.LocalDateTime;

public class GoodsVO implements Serializable {
    private Long goodsId;

    private String name;

    private Double price; // 原始商品价格

    private Double discountPrice; // 秒杀商品价格

    private Double stock; // 库存

    private LocalDateTime createTime;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    private static final long serialVersionUID = 1L;
}

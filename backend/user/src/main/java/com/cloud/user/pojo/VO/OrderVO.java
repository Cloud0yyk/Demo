package com.cloud.user.pojo.VO;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class OrderVO {
    private Long orderId;

    private Long userId;

    private Long goodsId;

    private LocalDateTime createTime;

    private static final long serialVersionUID = 1L;
}

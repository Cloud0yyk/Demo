package com.cloud.product.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cloud.product.pojo.entity.Order;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper extends BaseMapper<Order> {
}

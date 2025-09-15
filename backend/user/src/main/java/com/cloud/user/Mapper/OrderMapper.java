package com.cloud.user.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cloud.user.pojo.entity.Order;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper extends BaseMapper<Order> {
}

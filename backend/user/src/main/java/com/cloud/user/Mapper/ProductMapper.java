package com.cloud.user.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cloud.user.pojo.entity.Product;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductMapper extends BaseMapper<Product> {

}

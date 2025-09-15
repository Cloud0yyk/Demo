package com.cloud.demo.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cloud.demo.pojo.entity.Product;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductMapper extends BaseMapper<Product> {

}

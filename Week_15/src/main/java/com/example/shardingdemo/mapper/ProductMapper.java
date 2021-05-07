package com.example.shardingdemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.shardingdemo.entity.Product;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
/**
 * @author sunyu
 */
@Mapper
@Repository
public interface ProductMapper extends BaseMapper<Product> {
}

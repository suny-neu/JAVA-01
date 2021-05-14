package com.example.shardingdemo;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.shardingdemo.entity.Product;
import com.example.shardingdemo.mapper.ProductMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ShardingdemoApplicationTests {
    //注入 mapper
    @Autowired
    private ProductMapper productMapper;


    @Test
    public void addUser() {
        Product product = new Product();
//        product.setId(1l);
        product.setProductId(4L);
        product.setCount(122);
        product.setProductName("xinpin");
        productMapper.insert(product);
    }

    // 查询操作
    @Test
    public void findUser() {
        QueryWrapper<Product> wrapper = new QueryWrapper<>();
        wrapper.eq("PRODUCT_ID", 557526901044805633L);
        Product user = productMapper.selectOne(wrapper);
        System.out.println(user);
    }
}
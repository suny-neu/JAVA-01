
package com.example.shardingdemo.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("product")
public class Product {

    private Long id;
    private Long productId;
    private String productName;
    private int count;
}
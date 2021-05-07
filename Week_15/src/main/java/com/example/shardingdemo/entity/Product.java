/**
 * Copyright (c) 2021,TravelSky.
 * All Rights Reserved.
 * TravelSky CONFIDENTIAL
 * <p>
 * Project Name:shardingdemo
 * Package Name:com.example.shardingdemo.entity
 * File Name:Product.java
 * Date:2021/4/25 16:21
 */
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
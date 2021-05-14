package com.springboot.demo.bean;


import com.springboot.demo.util.MyDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class MyRoutingDataSource {

    @Bean
    @ConfigurationProperties("spring.datasource.master")
    public DataSource  getMaster(){
        return DataSourceBuilder.create().build();
    }


    @Bean
    @ConfigurationProperties("spring.datasource.slave")
    public DataSource getSlave(){
        return  DataSourceBuilder.create().build();
    }


    @Bean
    public DataSource  myroutingDataSource(@Qualifier("getMaster") DataSource masterDataSource,
                                           @Qualifier("getSlave") DataSource slaveDataSource){

        MyDataSource dynamicDataSource = new MyDataSource();
        Map<Object, Object> targetDataSources = new HashMap<>();
        targetDataSources.put("MASTER", masterDataSource);
        if (slaveDataSource != null) {
            targetDataSources.put("SLAVE", slaveDataSource);
        }
        dynamicDataSource.setTargetDataSources(targetDataSources);
        dynamicDataSource.setDefaultTargetDataSource(masterDataSource);
        return dynamicDataSource;
    }






}

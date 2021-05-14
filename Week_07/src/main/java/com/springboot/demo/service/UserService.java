package com.springboot.demo.service;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    public void getUsers(){
        System.out.println("数据库是从库");
    }


    public void  insert(){
        System.out.println("数据库是主库");
    }


}

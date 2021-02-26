package com.spring.bean.demo;

import com.spring.bean.demo.pojo.Dog;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {
    @Autowired
    private Dog  dog;

    @Test
    void contextLoads() {
        dog.setAge(5);
        dog.setColor("white");
        dog.setName("小花");
        dog.setSex("female");
        System.out.println(dog.toString());
    }

}

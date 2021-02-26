package demo.springboot.starter.controller;

import demo.springboot.starter.config.MyConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private MyConfiguration myConfiguration;

    @GetMapping("/hello")
    public String getName(){
       System.out.println(myConfiguration.getName());
       return myConfiguration.getName();
    }

}

package demo.springboot.starter.config;

import demo.springboot.starter.pojo.Dog;
import demo.springboot.starter.properties.PersonConfigProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(PersonConfigProperties.class)
@ConditionalOnProperty(prefix = "dog",name="color",havingValue = "black")
@ConditionalOnClass(Dog.class)
public class MyConfiguration {
     @Autowired
    private  PersonConfigProperties properties;


   @Bean
    public  String getName(){
       System.out.println(properties.getName());
       return properties.toString();
   }

}

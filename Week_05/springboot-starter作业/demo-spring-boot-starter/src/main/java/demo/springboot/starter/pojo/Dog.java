package demo.springboot.starter.pojo;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Dog {

    private String name;
    private String sex;
    private int age;
    private String color;
}

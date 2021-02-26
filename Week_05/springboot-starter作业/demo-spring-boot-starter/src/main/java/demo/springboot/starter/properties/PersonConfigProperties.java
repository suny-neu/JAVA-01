package demo.springboot.starter.properties;

import lombok.*;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix =PersonConfigProperties.PREFIXREAD )
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class PersonConfigProperties {

    public static final String PREFIXREAD = "dog";
    private String name;
    private int age;
    private String gendel;
    private String color;




}

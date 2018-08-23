package org.datacollector;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(basePackages = {"org.datacollector.mappers"})
public class DatacollectionsystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(DatacollectionsystemApplication.class, args);
    }
}

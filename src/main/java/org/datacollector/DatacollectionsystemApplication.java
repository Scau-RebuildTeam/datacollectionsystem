package org.datacollector;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@EnableTransactionManagement
@MapperScan(basePackages = {"org.datacollector.mappers"})
public class DatacollectionsystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(DatacollectionsystemApplication.class, args);
    }
}

package com.imooc.sell;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableJpaAuditing
//@EnableAutoConfiguration
@SpringBootApplication
@EnableSwagger2
public class SellApplication {

    public static void main(String[] args) {
        SpringApplication.run(SellApplication.class, args);
    }
}

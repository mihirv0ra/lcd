package com.lightningcd.api;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;


@SpringBootApplication
@EnableSwagger2
@ComponentScan(basePackages = "com.lightningcd.api")

public class Application {

    public static void main(String[] args){
        ApplicationContext ctx= SpringApplication.run(Application.class, args);

    }

}

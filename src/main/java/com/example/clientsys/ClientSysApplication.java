package com.example.clientsys;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

//@SpringBootApplication
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
@ComponentScan(basePackages = "com.zyber.*")
public class ClientSysApplication {

    public static void main(String[] args) {
        //static class
        SpringApplication.run(ClientSysApplication.class, args);
    }

}

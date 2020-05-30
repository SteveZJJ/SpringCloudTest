package com.asiainfo.billing.clouduser;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
//@ComponentScan(basePackages= {"com.asiainfo.billing.clouduser.controller","com.asiainfo.billing.clouduser.service"})
@ComponentScan(basePackages= {"com.asiainfo.billing.clouduser"})
@MapperScan("com.asiainfo.billing.clouduser.dao")
public class CloudUserApplication {


    public static void main(String[] args) {
        SpringApplication.run(CloudUserApplication.class, args);

    }

}

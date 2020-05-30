package com.asiainfo.billing.cloudproduct;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * description: CloudProductApplication <br>
 * date: 2020/3/25 10:54 <br>
 * author: YangRan <br>
 * version: 1.0 <br>
 */

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(basePackages= {"com.asiainfo.billing.cloudproduct"})
@MapperScan("com.asiainfo.billing.cloudproduct.dao")
public class CloudProductApplication {
    public static void main(String[] args) {
        SpringApplication.run(CloudProductApplication.class, args);

    }
}
package com.asiainfo.billing.cloudproduct.config;


import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.asiainfo.billing.cloudsuer.dao")
public class MybatisPlusConfig {


    @Bean
    public PaginationInterceptor paginationInterceptor() {
        System.out.println("注册分页插件");
        return new PaginationInterceptor();
    }
}
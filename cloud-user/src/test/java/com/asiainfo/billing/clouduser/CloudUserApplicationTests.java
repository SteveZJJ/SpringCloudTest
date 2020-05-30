package com.asiainfo.billing.clouduser;

import com.asiainfo.billing.clouduser.config.RedisConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootTest
@ComponentScan(basePackages= {"com.asiainfo.billing.clouduser"})
class CloudUserApplicationTests {


    @Test
    void contextLoads() {
    }

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(RedisConfig.class);
        context.getBean("jedisConnectionFactory");
    }

//    public void getHost(){
//        System.out.println(host);
//    }
}

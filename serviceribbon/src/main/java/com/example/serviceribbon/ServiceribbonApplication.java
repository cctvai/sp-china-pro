package com.example.serviceribbon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
@EnableHystrix         // 开启断路器
@EnableDiscoveryClient // 表明标注类是消费者
@SpringBootApplication
public class ServiceribbonApplication {

    public static void main(String[] args) {
           SpringApplication.run(ServiceribbonApplication.class, args);
    }
    @Bean
    @LoadBalanced //加入restTemplate以消费相关的服务
    RestTemplate restTemplate()
    {
        return new RestTemplate();
    }


}
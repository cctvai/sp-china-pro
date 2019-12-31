package com.example.serviceribbon.service;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HelloService {
    @Autowired
    RestTemplate restTemplate;
    //断路器配置,当无法调用如下方法时,就会调用自定的hiError 方法
    @HystrixCommand(fallbackMethod ="hiError" )
    public String hiService(String name)
    {
        Object forObject =restTemplate.getForObject("http://SERVICE-CLIENT/hi?name=" + name, String.class);
        return forObject.toString();
    }
    public String hiError(String name){
        return "key = "+name+", there is error hi page";
    }
}

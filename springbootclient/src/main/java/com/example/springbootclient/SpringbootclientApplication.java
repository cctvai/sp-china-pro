package com.example.springbootclient;

import com.example.springbootclient.entity.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;


@RestController
@EnableEurekaClient//表明自己属于一个生产者
@SpringBootApplication
public class SpringbootclientApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringbootclientApplication.class, args);
    }
    @Value("${server.port}")
    String port;
    //http://localhost:8763/hi?name=fys
    @RequestMapping(value = "/hi",method = RequestMethod.GET)
    public Object home(@RequestParam String name)
    {   Map<String,Object> outMap = new HashMap<>();
        User user =new User();
        user.setId(1);
        user.setName( "小明");
        outMap.put("user",user);
        outMap.put("str", "hi " + name + ",i am from port:" + port);
        return outMap.toString();
    }
}

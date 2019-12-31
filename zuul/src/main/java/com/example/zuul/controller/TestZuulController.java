package com.example.zuul.controller;


import com.example.zuul.Student;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/testZuul")
public class TestZuulController {

    @RequestMapping(value = "/query", method = RequestMethod.GET)
    @ResponseBody
    public Student test()
    {
        Student student =new Student();
        student.setId(1);
        student.setName("小明");
        student.setAge(12);
        return student;
    }


}

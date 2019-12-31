package com.example.person.dto;

import lombok.Data;

@Data
public class PersonInDTO {

    //姓名
    private String name;
    //相遇场所
    private String xycs;
    //性别
    private String sex;
    //爱好
    private String love;
    //第几页
    private Integer pageNo;
    //每页多少条数据
    private Integer pageSize;




}

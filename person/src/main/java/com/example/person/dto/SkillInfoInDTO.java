package com.example.person.dto;

import lombok.Data;

@Data
public class SkillInfoInDTO {
    //技术类型
    private String skillStype;
    //技术名称
    private String skillName;
    //技术内容
    private String skillContent;
    //第几页
    private Integer pageNo;
    //每页多少条数据
    private Integer pageSize;




}

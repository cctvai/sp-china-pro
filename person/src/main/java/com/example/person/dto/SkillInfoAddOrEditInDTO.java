package com.example.person.dto;

import lombok.Data;

@Data
public class SkillInfoAddOrEditInDTO {
    //主键ID
    private String id;
    //技术类型
    private String skillStype;
    //技术名称
    private String skillName;
    //技术内容
    private String skillContent;


}

package com.example.person.entity;

import lombok.Data;

@Data
public class SkillInfo {
    //主键ID
    private String id;
    //技术类型
    private String skillStype;
    //技术名称
    private String skillName;
    //技术内容
    private String skillContent;
    //创建时间
    private String createTime;

}

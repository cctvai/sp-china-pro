package com.example.person.entity;

import lombok.Data;

import java.util.Date;
@Data
public class ComFile {
    //id
    private String id;
    //父id
    private String parentId;
    //父实体类型
    private Long type;
    //文件名，带后缀
    private String name;
    //文件保存路径
    private String path;
    //录入日期
    private Date lrrq;

}
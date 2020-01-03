package com.example.person.dto;

import lombok.Data;

@Data
public class ComFileOutDTO {
    //序号
    private String rn;
    //id
    private String id;
    //父id
    private String parentId;
    //父实体类型
    private Long type;
    //文件名，带后缀
    private String name;
    //文件大小
    private String size;
    //文件保存路径
    private String path;
    //录入日期
    private String lrrq;



}

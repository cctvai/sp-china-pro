package com.example.person.dto;

import lombok.Data;

@Data
public class ComFileInDTO {

    //文件父级ID
    private String parentId;
    //第几页
    private Integer pageNo;
    //每页多少行
    private Integer pageSize;



}

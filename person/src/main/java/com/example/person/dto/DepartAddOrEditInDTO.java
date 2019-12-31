package com.example.person.dto;

import lombok.Data;

@Data
public class DepartAddOrEditInDTO {

    //主键ID
    private String id;
    //部门编号
    private String departCode;
    //部门名称
    private String departName;
    //部门所在地
    private String departAddress;


}

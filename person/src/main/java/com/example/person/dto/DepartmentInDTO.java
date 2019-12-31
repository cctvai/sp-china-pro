package com.example.person.dto;

import lombok.Data;

@Data
public class DepartmentInDTO {
    //部门编号
    private String departCode;
    //部门名称
    private String departName;
    //部门所在地
    private String departAddress;
    //第几页
    private Integer pageNo;
    //每页多少条数据
    private Integer pageSize;




}

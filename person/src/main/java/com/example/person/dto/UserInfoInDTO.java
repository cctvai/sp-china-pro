package com.example.person.dto;

import lombok.Data;

@Data
public class UserInfoInDTO {
    //登录账号
    private String loginNo;
    //用户名
    private String userName;
    //用户密码
    private String userPass;
    //用户手机号码
    private String userPhone;
    //部门编号
    private String userBmbh;
    //第几页
    private Integer pageNo;
    //每页多少条数据
    private Integer pageSize;




}

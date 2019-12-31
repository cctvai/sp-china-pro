package com.example.person.dto;

import lombok.Data;

@Data
public class UserInfoAddOrEditInDTO {

    //主键ID
    private String id;
    //登陆账号
    private String loginNo;
    //用户名
    private String userName;
    //用户密码
    private String userPass;
    //用户手机号码
    private String userPhone;
    //部门编号
    private String userBmbh;


}

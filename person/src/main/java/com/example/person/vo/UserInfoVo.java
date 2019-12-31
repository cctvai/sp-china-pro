package com.example.person.vo;

import lombok.Data;

@Data
public class UserInfoVo {
    //序号
    private Integer rn;
    //主键ID
    private String id;
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



}

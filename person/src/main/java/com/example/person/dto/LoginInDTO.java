package com.example.person.dto;

import lombok.Data;

@Data
public class LoginInDTO {
    //登录账号
    private String loginNo;
    //登录密码
    private String userPass;
    //验证码
    private String loginCard;


}

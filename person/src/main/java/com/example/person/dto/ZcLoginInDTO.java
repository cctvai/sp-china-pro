package com.example.person.dto;

import lombok.Data;

@Data
public class ZcLoginInDTO {
    //登录账号
    private String loginNo;
    //用户名
    private String userName;
    //用户密码
    private String userPass;
    //用户手机号码
    private String userPhone;


}

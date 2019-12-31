package com.example.person.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 用户信息实体类
 */
@Data
public class UserInfo implements Serializable {
    private static final long serialVersionUID = -432908543160176350L;
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

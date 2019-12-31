package com.example.person.vo;

import com.example.person.entity.UserInfo;
import com.example.person.entity.loginResource;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class LoginInfo implements Serializable {

    private static final long serialVersionUID = -432908543160176349L;
    //用户信息
    private UserInfo userInfo;
    //资源信息
    private List<loginResource> resourseList;


}

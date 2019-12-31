package com.example.person.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class loginResource implements Serializable {
    private static final long serialVersionUID = -432908543160176360L;
    //主键ID
    private String id;
    //资源code
    private String resourceCode;
    //资源名称
    private String resourceName;
    //资源名称
    private String title;
    //父级code
    private String parentCode;
    //资源级别
    private String resourceLevel;
    //资源类型
    private String resourceType;
    //资源路径
    private String resourceUrl;
    //创建时间
    private String createTime;


}

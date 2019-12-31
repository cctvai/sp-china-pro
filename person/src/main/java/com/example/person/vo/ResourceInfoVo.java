package com.example.person.vo;

import lombok.Data;

@Data
public class ResourceInfoVo {
    //序号
    private Integer rn;
    //主键ID
    private String id;
    //资源code
    private String resourceCode;
    //资源名称
    private String resourceName;
    //父级code
    private String parentCode;
    //资源级别
    private Integer resourceLevel;
    //资源类型
    private Integer resourceType;
    //资源路径
    private String resourceUrl;
    //创建时间
    private String createTime;
}

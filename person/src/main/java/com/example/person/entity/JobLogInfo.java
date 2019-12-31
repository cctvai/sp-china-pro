package com.example.person.entity;

import lombok.Data;

@Data
public class JobLogInfo {
    //主键ID
    private String id;
    //日志类型
    private String logType;
    //日志内容
    private String logNr;
    //处理情况
    private String isAble;
    //创建时间
    private String createTime;

}

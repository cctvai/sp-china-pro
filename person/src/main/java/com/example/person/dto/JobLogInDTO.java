package com.example.person.dto;

import lombok.Data;

@Data
public class JobLogInDTO {
    //日志类型
    private String logType;
    //日志内容
    private String logNr;
    //处理情况
    private String isAble;
    //第几页
    private Integer pageNo;
    //每页多少条数据
    private Integer pageSize;




}

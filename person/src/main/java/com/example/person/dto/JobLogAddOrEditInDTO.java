package com.example.person.dto;

import lombok.Data;

@Data
public class JobLogAddOrEditInDTO {

    //主键ID
    private String id;
    //日志类型
    private String logType;
    //日志内容
    private String logNr;
    //处理情况
    private String isAble;


}

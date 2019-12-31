package com.example.person.entity;

import lombok.Data;

@Data
public class PersonInfo {
    //主键ID
    private String pId;
    //姓名
    private String name;
    //性别
    private String sex;
    //出生年月
    private String csny;
    //老家地址
    private String csdz;
    //现住地址
    private String xzdz;
    //所会技能
    private String shjn;
    //相遇场所
    private String xycs;
    //工作时长
    private String gzsc;
    //婚姻状况
    private String hyzk;
    //身份证号码
    private String sfzhm;
    //手机号码
    private String sjhm;
    //微信号码
    private String wxhm;
    //QQ号码
    private String qqhm;
    //家庭状况
    private String jtzk;
    //公司职位
    private String gszw;
    //爱好
    private String love;


}

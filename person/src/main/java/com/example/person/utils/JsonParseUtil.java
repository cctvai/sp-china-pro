package com.example.person.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.example.person.entity.UserInfo;
import com.example.person.entity.loginResource;
import com.example.person.vo.LoginInfo;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * JSON 解析 Util
 */
@Slf4j
public class JsonParseUtil {

    public static LoginInfo LoginInfoJsonPare(String USER_INFO){
        LoginInfo loginInfo =new LoginInfo();
        JSONObject loginInfoJson = JSON.parseObject(USER_INFO);
        JSONObject userInfoJson = loginInfoJson.getJSONObject("userInfo");
        JSONArray resourseListJson = loginInfoJson.getJSONArray("resourseList");
        UserInfo userInfo = JSON.parseObject(userInfoJson.toJSONString(), new TypeReference<UserInfo>() {
        });
        List<loginResource> resourseList = JSON.parseObject(resourseListJson.toJSONString(), new TypeReference<List<loginResource>>() {
        });
        loginInfo.setUserInfo(userInfo);
        loginInfo.setResourseList(resourseList);
        return loginInfo;
    }
    public static List<loginResource> LoginInfoJsonPareResource(String USER_INFO){
        JSONObject loginInfoJson = JSON.parseObject(USER_INFO);
        JSONArray resourseListJson = loginInfoJson.getJSONArray("resourseList");
        return JSON.parseObject(resourseListJson.toJSONString(), new TypeReference<List<loginResource>>() {
        });

    }


}

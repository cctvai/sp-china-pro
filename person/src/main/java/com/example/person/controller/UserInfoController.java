package com.example.person.controller;

import com.example.person.dto.UserInfoAddOrEditInDTO;
import com.example.person.dto.UserInfoInDTO;
import com.example.person.result.Result;
import com.example.person.service.UserInfoService;
import com.example.person.utils.ExceptUtil;
import com.example.person.vo.UserInfoVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/userinfo")
public class UserInfoController {


    @Autowired
    public UserInfoService userInfoService;

    @RequestMapping(value = "/queryAll", method = RequestMethod.POST)
    @ResponseBody
    public Result queryAll(UserInfoInDTO inDTO) {
        log.info("UserInfoController.queryAll  inDTO =" + inDTO);
        List<UserInfoVo> outList = userInfoService.queryAll(inDTO);
        Map<String, Object> outMap = new HashMap<>();
        outMap.put("total", userInfoService.queryAllTotal(inDTO));
        outMap.put("list", outList);
        log.info("UserInfoController.queryAll  outMap =" + outMap);
        return new Result(ExceptUtil.SUCCESS_CODE_200, outMap, null);
    }



    @RequestMapping(value = "/addOrEdit", method = RequestMethod.POST)
    @ResponseBody
    public void addOrEdit(UserInfoAddOrEditInDTO inDTO) {
        log.info("UserInfoController.addOrEdit  inDTO =" + inDTO);
        userInfoService.addOrEdit(inDTO);
    }


    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    @ResponseBody
    public void delete(String id) {
         log.info("UserInfoController.delete  id =" + id);
        userInfoService.delete(id);
    }


}

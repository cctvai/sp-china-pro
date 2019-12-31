package com.example.person.controller;

import com.example.person.dto.ResourceAddOrEditInDTO;
import com.example.person.dto.ResourceInfoInDTO;
import com.example.person.result.Result;
import com.example.person.service.ResourceInfoService;
import com.example.person.utils.ExceptUtil;
import com.example.person.vo.ResourceInfoVo;
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
@RequestMapping("/resource")
public class ResourceInfoController {


    @Autowired
    public ResourceInfoService resourceInfoService;
    @RequestMapping(value = "/loginResource", method = RequestMethod.GET)
    @ResponseBody
    public Result  loginResource(){
           return new Result(ExceptUtil.SUCCESS_CODE_200, resourceInfoService.loginResource(), null);
    }


    @RequestMapping(value = "/queryAll", method = RequestMethod.POST)
    @ResponseBody
    public Result queryAll(ResourceInfoInDTO inDTO) {
        log.info("ResourceInfoController.queryAll  inDTO =" + inDTO);
        List<ResourceInfoVo> outList = resourceInfoService.queryAll(inDTO);
        Map<String, Object> outMap = new HashMap<>();
        outMap.put("total", resourceInfoService.queryAllTotal(inDTO));
        outMap.put("list", outList);
        log.info("ResourceInfoController.queryAll  outMap =" + outMap);
        return new Result(ExceptUtil.SUCCESS_CODE_200, outMap, null);
    }



    @RequestMapping(value = "/addOrEdit", method = RequestMethod.POST)
    @ResponseBody
    public void addOrEdit(ResourceAddOrEditInDTO inDTO) {
        log.info("ResourceInfoController.addOrEdit  inDTO =" + inDTO);
        resourceInfoService.addOrEdit(inDTO);
    }


    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    @ResponseBody
    public Result delete(String id) {
        log.info("ResourceInfoController.delete  id =" + id);
        resourceInfoService.delete(id);
        return new Result(ExceptUtil.SUCCESS_CODE_200,null,null);
    }


}

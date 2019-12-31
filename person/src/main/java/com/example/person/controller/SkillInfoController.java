package com.example.person.controller;

import com.example.person.dto.SkillInfoAddOrEditInDTO;
import com.example.person.dto.SkillInfoInDTO;
import com.example.person.result.Result;
import com.example.person.service.SkillInfoService;
import com.example.person.utils.ExceptUtil;
import com.example.person.vo.SkillInfoVo;
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
@RequestMapping("/skill")
public class SkillInfoController {


    @Autowired
    public SkillInfoService skillInfoService;


    @RequestMapping(value = "/queryAll", method = RequestMethod.POST)
    @ResponseBody
    public Result queryAll(SkillInfoInDTO inDTO) {
        log.info("SkillInfoController.queryAll  inDTO =" + inDTO);
        List<SkillInfoVo> outList = skillInfoService.queryAll(inDTO);
        Map<String, Object> outMap = new HashMap<>();
        outMap.put("total", skillInfoService.queryAllTotal(inDTO));
        outMap.put("list", outList);
        log.info("SkillInfoController.queryAll  outMap =" + outMap);
        return new Result(ExceptUtil.SUCCESS_CODE_200, outMap, null);
    }



    @RequestMapping(value = "/addOrEdit", method = RequestMethod.POST)
    @ResponseBody
    public void addOrEdit(SkillInfoAddOrEditInDTO inDTO) {
        log.info("SkillInfoController.addOrEdit  inDTO =" + inDTO);
        skillInfoService.addOrEdit(inDTO);
    }


    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    @ResponseBody
    public Result delete(String id) {
        log.info("SkillInfoController.delete  id =" + id);
        skillInfoService.delete(id);
        return new Result(ExceptUtil.SUCCESS_CODE_200,null,null);
    }


}

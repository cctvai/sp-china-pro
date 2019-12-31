package com.example.person.controller;

import com.example.person.dto.JobLogAddOrEditInDTO;
import com.example.person.dto.JobLogInDTO;
import com.example.person.result.Result;
import com.example.person.service.JobLogService;
import com.example.person.utils.ExceptUtil;
import com.example.person.vo.JobLogInfoVo;
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
@RequestMapping("/jobLog")
public class JobLogController {

    @Autowired
    public JobLogService jobLogService;

    @RequestMapping(value = "/queryAll", method = RequestMethod.POST)
    @ResponseBody
    public Result queryAll(JobLogInDTO inDTO) {
        log.info("JobLogController.queryAll  inDTO =" + inDTO);
        List<JobLogInfoVo> outList = jobLogService.queryAll(inDTO);
        Map<String, Object> outMap = new HashMap<>();
        outMap.put("total", jobLogService.queryAllTotal(inDTO));
        outMap.put("list", outList);
        log.info("JobLogController.queryAll  outMap =" + outMap);
        return new Result(ExceptUtil.SUCCESS_CODE_200, outMap, null);
    }



    @RequestMapping(value = "/addOrEdit", method = RequestMethod.POST)
    @ResponseBody
    public void addOrEdit(JobLogAddOrEditInDTO inDTO) {
        log.info("JobLogController.addOrEdit  inDTO =" + inDTO);
        jobLogService.addOrEdit(inDTO);
    }


    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    @ResponseBody
    public void delete(String id) {
         log.info("JobLogController.delete  id =" + id);
         jobLogService.delete(id);
    }


}

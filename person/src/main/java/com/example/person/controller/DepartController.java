package com.example.person.controller;

import com.example.person.dto.DepartAddOrEditInDTO;
import com.example.person.dto.DepartmentInDTO;
import com.example.person.result.Result;
import com.example.person.service.DepartmentService;
import com.example.person.utils.ExceptUtil;
import com.example.person.vo.DepartCodeNameVo;
import com.example.person.vo.DepartmentInfoVo;
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
@RequestMapping("/depart")
public class DepartController {


    @Autowired
    public DepartmentService departmentService;

    @RequestMapping(value = "/query", method = RequestMethod.GET)
    @ResponseBody
    public Result query() {

        List<DepartCodeNameVo> outList = departmentService.query();
        Map<String, Object> outMap = new HashMap<>();
        outMap.put("total", outList.size());
        outMap.put("list", outList);
        log.info("DepartController.query  outMap =" + outMap);
        return new Result(ExceptUtil.SUCCESS_CODE_200, outMap, null);
    }

    @RequestMapping(value = "/queryAll", method = RequestMethod.POST)
    @ResponseBody
    public Result queryAll(DepartmentInDTO inDTO) {
        log.info("DepartController.queryAll  inDTO =" + inDTO);
        List<DepartmentInfoVo> outList = departmentService.queryAll(inDTO);
        Map<String, Object> outMap = new HashMap<>();
        outMap.put("total", departmentService.queryAllTotal(inDTO));
        outMap.put("list", outList);
        log.info("DepartController.queryAll  outMap =" + outMap);
        return new Result(ExceptUtil.SUCCESS_CODE_200, outMap, null);
    }



    @RequestMapping(value = "/addOrEdit", method = RequestMethod.POST)
    @ResponseBody
    public void addOrEdit(DepartAddOrEditInDTO inDTO) {
        log.info("DepartController.addOrEdit  inDTO =" + inDTO);
        departmentService.addOrEdit(inDTO);
    }


    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    @ResponseBody
    public void delete(String id) {
         log.info("DepartController.delete  id =" + id);
        departmentService.delete(id);
    }


}

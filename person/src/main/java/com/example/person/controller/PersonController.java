package com.example.person.controller;

import com.example.person.dto.PersonAddOrEditInDTO;
import com.example.person.dto.PersonInDTO;
import com.example.person.result.Result;
import com.example.person.service.PersonService;
import com.example.person.utils.ExceptUtil;
import com.example.person.vo.PersinInfoVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/qryperson")
public class PersonController {


    @Autowired
    public PersonService personService;

    @RequestMapping(value = "/queryAll", method = RequestMethod.POST)
    @ResponseBody
    public Result queryAll(PersonInDTO inDTO) {
        log.info("PersonController.queryAll  inDTO =" + inDTO);
        List<PersinInfoVo> outList = personService.queryAll(inDTO);
        Map<String, Object> outMap = new HashMap<>();
        outMap.put("total", personService.queryAllTotal(inDTO));
        outMap.put("list", outList);
        log.info("PersonController.queryAll  outMap =" + outMap);
        return new Result(ExceptUtil.SUCCESS_CODE_200, outMap, null);
    }



    @RequestMapping(value = "/addOrEdit", method = RequestMethod.POST)
    @ResponseBody
    public void addOrEdit(PersonAddOrEditInDTO inDTO) {
        log.info("PersonController.addOrEdit  inDTO =" + inDTO);
        personService.addOrEdit(inDTO);
    }


    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    @ResponseBody
    public void delete(Long pId) {
         log.info("PersonController.delete  pId =" + pId);
         personService.delete(pId);
    }


}

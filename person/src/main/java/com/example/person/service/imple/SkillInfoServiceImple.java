package com.example.person.service.imple;

import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.example.person.dto.SkillInfoAddOrEditInDTO;
import com.example.person.dto.SkillInfoInDTO;
import com.example.person.mapper.SkillInfoMapper;
import com.example.person.service.SkillInfoService;
import com.example.person.vo.SkillInfoVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@Service
public class SkillInfoServiceImple implements SkillInfoService {

    @Resource
    public SkillInfoMapper skillInfoMapper;


    @Override
    public List<SkillInfoVo> queryAll(SkillInfoInDTO inDTO)
    {
       return skillInfoMapper.queryAll(inDTO);
    }
    @Override
    public int queryAllTotal(SkillInfoInDTO inDTO) {
        return skillInfoMapper.queryAllTotal(inDTO);
    }

    @Override
    public void addOrEdit(SkillInfoAddOrEditInDTO inDTO) {
        String pId= inDTO.getId();
        log.info(" addOrEditaddOrEdit =inDTO=  "+ inDTO);
        //添加Person
        if (  pId ==null ||pId=="" ){
            inDTO.setId(IdWorker.getId()+"" );
            log.info(" addOrEditaddOrEdit == add= inDTO=  "+ inDTO);
            skillInfoMapper.addSkill(inDTO);
        }
        //修改Person
        if ( pId!=null && pId!=""  ){
            log.info(" addOrEditaddOrEdit == edit= inDTO=  "+ inDTO);
            skillInfoMapper.editSkill(inDTO);
        }
    }

    @Override
    public void delete(String id) {
        skillInfoMapper.delete(id);
    }
}

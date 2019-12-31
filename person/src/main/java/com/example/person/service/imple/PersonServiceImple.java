package com.example.person.service.imple;

import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.example.person.dto.PersonAddOrEditInDTO;
import com.example.person.dto.PersonInDTO;
import com.example.person.mapper.PersonMapper;
import com.example.person.service.PersonService;
import com.example.person.vo.PersinInfoVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@Service
public class PersonServiceImple implements PersonService {

    @Resource
    public PersonMapper personMapper;

    @Override
    public List<PersinInfoVo> queryAll(PersonInDTO inDTO) {
         return personMapper.queryAll(inDTO);
    }

    @Override
    public int queryAllTotal(PersonInDTO inDTO) {
        return personMapper.queryAllTotal(inDTO);
    }

    @Override
    public void addOrEdit(PersonAddOrEditInDTO inDTO) {
        String pId= inDTO.getPId();
        log.info(" addOrEditaddOrEdit =pId=  "+ pId);
        //添加Person
       if (  pId ==null ||pId=="" ){
           inDTO.setPId(IdWorker.getId()+"" );
          log.info(" addOrEditaddOrEdit == add= inDTO=  "+ inDTO);
           personMapper.addPerson(inDTO);
       }
        //修改Person
        if ( pId!=null && pId!=""  ){
            log.info(" addOrEditaddOrEdit == edit= pId=  "+ pId);
            personMapper.editPerson(inDTO);
        }
    }

    @Override
    public void delete(Long pId) {
        personMapper.delete(pId);
    }
}

package com.example.person.service.imple;

import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.example.person.dto.JobLogAddOrEditInDTO;
import com.example.person.dto.JobLogInDTO;
import com.example.person.mapper.JobLogInfoMapper;
import com.example.person.service.JobLogService;
import com.example.person.vo.JobLogInfoVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@Service
public class JobLogServiceImple implements JobLogService {

    @Resource
    public JobLogInfoMapper jobLogInfoMapper;

    @Override
    public List<JobLogInfoVo> queryAll(JobLogInDTO inDTO) {
        return jobLogInfoMapper.queryAll(inDTO);
    }
    @Override
    public int queryAllTotal(JobLogInDTO inDTO) {
        return jobLogInfoMapper.queryAllTotal(inDTO);
    }

    @Override
    public void addOrEdit(JobLogAddOrEditInDTO inDTO) {
        String pId= inDTO.getId();
        log.info(" addOrEditaddOrEdit =inDTO=  "+ inDTO);
        //添加Person
        if (  pId ==null ||pId=="" ){
            inDTO.setId(IdWorker.getId()+"" );
            log.info(" addOrEditaddOrEdit == add= inDTO=  "+ inDTO);
            jobLogInfoMapper.addJobLog(inDTO);
        }
        //修改Person
        if ( pId!=null && pId!=""  ){
            log.info(" addOrEditaddOrEdit == edit= inDTO=  "+ inDTO);
            jobLogInfoMapper.editJobLog(inDTO);
        }
    }

    @Override
    public void delete(String id) {
        jobLogInfoMapper.delete(id);
    }
}

package com.example.person.service.imple;

import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.example.person.dto.DepartAddOrEditInDTO;
import com.example.person.dto.DepartmentInDTO;
import com.example.person.mapper.DepartmentMapper;
import com.example.person.service.DepartmentService;
import com.example.person.vo.DepartCodeNameVo;
import com.example.person.vo.DepartmentInfoVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@Service
public class DepartmentServiceImple implements DepartmentService {

    @Resource
    public DepartmentMapper departmentMapper;

    @Override
    public List<DepartCodeNameVo> query() {
        return departmentMapper.query();
    }

    @Override
    public List<DepartmentInfoVo> queryAll(DepartmentInDTO inDTO) {
        return departmentMapper.queryAll(inDTO);
    }
    @Override
    public int queryAllTotal(DepartmentInDTO inDTO) {
        return departmentMapper.queryAllTotal(inDTO);
    }

    @Override
    public void addOrEdit(DepartAddOrEditInDTO inDTO) {
        String pId= inDTO.getId();
        log.info(" addOrEditaddOrEdit =inDTO=  "+ inDTO);
        //添加Person
        if (  pId ==null ||pId=="" ){
            inDTO.setId(IdWorker.getId()+"" );
            log.info(" addOrEditaddOrEdit == add= inDTO=  "+ inDTO);
            departmentMapper.addDepart(inDTO);
        }
        //修改Person
        if ( pId!=null && pId!=""  ){
            log.info(" addOrEditaddOrEdit == edit= inDTO=  "+ inDTO);
            departmentMapper.editDepart(inDTO);
        }
    }

    @Override
    public void delete(String id) {
        departmentMapper.delete(id);
    }
}

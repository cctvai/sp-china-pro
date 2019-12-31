package com.example.person.service.imple;

import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.example.person.dto.UserInfoAddOrEditInDTO;
import com.example.person.dto.UserInfoInDTO;
import com.example.person.mapper.UserInfoMapper;
import com.example.person.service.UserInfoService;
import com.example.person.vo.UserInfoVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@Service
public class UserInfoServiceImple implements UserInfoService {

    @Resource
    public UserInfoMapper userInfoMapper;


    @Override
    public List<UserInfoVo> queryAll(UserInfoInDTO inDTO) {
        return userInfoMapper.queryAll(inDTO);
    }
    @Override
    public int queryAllTotal(UserInfoInDTO inDTO) {
        return userInfoMapper.queryAllTotal(inDTO);
    }

    @Override
    public void addOrEdit(UserInfoAddOrEditInDTO inDTO) {
        String pId= inDTO.getId();
        log.info(" addOrEditaddOrEdit =inDTO=  "+ inDTO);
        //添加Person
        if (  pId ==null ||pId=="" ){
            inDTO.setId(IdWorker.getId()+"" );
            log.info(" addOrEditaddOrEdit == add= inDTO=  "+ inDTO);
            userInfoMapper.addUser(inDTO);
        }
        //修改Person
        if ( pId!=null && pId!=""  ){
            log.info(" addOrEditaddOrEdit == edit= inDTO=  "+ inDTO);
            userInfoMapper.editUser(inDTO);
        }
    }

    @Override
    public void delete(String id) {
        log.info(" deletedelete === id=  "+ id);
        userInfoMapper.delete(id);
    }
}

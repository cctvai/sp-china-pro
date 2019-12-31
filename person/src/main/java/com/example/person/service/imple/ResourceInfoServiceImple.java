package com.example.person.service.imple;

import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.example.person.dto.ResourceAddOrEditInDTO;
import com.example.person.dto.ResourceInfoInDTO;
import com.example.person.entity.loginResource;
import com.example.person.mapper.ResourceInfoMapper;
import com.example.person.service.ResourceInfoService;
import com.example.person.utils.JsonParseUtil;
import com.example.person.utils.redis.RedisKeyUtil;
import com.example.person.utils.redis.RedisUtil;
import com.example.person.vo.ResourceInfoVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@Service
public class ResourceInfoServiceImple implements ResourceInfoService {

    @Resource
    public ResourceInfoMapper resourceInfoMapper;

    @Override
    public List<loginResource> loginResource() {
        //查看缓存里面是否存在
        String USER_INFO = RedisUtil.getStrByKey(RedisKeyUtil.USER_INFO);
        log.info( "loginResource  缓存取数据 USER_INFO ==  "+USER_INFO );
        if(USER_INFO!=null && USER_INFO !=""){
            return JsonParseUtil.LoginInfoJsonPareResource( USER_INFO);
        }
        return null;
    }

    @Override
    public List<ResourceInfoVo> queryAll(ResourceInfoInDTO inDTO)
    {
       return resourceInfoMapper.queryAll(inDTO);
    }
    @Override
    public int queryAllTotal(ResourceInfoInDTO inDTO) {
        return resourceInfoMapper.queryAllTotal(inDTO);
    }

    @Override
    public void addOrEdit(ResourceAddOrEditInDTO inDTO) {
        String pId= inDTO.getId();
        log.info(" addOrEditaddOrEdit =inDTO=  "+ inDTO);
        //添加Person
        if (  pId ==null ||pId=="" ){
            inDTO.setId(IdWorker.getId()+"" );
            log.info(" addOrEditaddOrEdit == add= inDTO=  "+ inDTO);
            resourceInfoMapper.addResource(inDTO);
        }
        //修改Person
        if ( pId!=null && pId!=""  ){
            log.info(" addOrEditaddOrEdit == edit= inDTO=  "+ inDTO);
            resourceInfoMapper.editResource(inDTO);
        }
    }

    @Override
    public void delete(String id) {
        resourceInfoMapper.delete(id);
    }
}

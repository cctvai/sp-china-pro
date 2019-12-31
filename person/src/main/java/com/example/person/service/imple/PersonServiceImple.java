package com.example.person.service.imple;

import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.example.person.dto.PersonAddOrEditInDTO;
import com.example.person.dto.PersonInDTO;
import com.example.person.mapper.PersonMapper;
import com.example.person.service.PersonService;
import com.example.person.utils.PoiUtil;
import com.example.person.vo.PersinInfoVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
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
    public void queryAllExport(PersonInDTO inDTO, HttpServletResponse response) throws Exception{
        List<List> dataList=new ArrayList<>();
        List<PersinInfoVo> personList =  personMapper.queryAllExport(inDTO);
        for (int i=0;i<personList.size();i++){
            PersinInfoVo persinInfoVo=personList.get(i);
            List data=new ArrayList<>();
            data.add( persinInfoVo.getRn());//序号
            data.add( persinInfoVo.getName());//姓名
            data.add( persinInfoVo.getSex());//性别
            data.add( persinInfoVo.getCsny());//出生年月
            data.add( persinInfoVo.getCsdz());//出生地址
            data.add( persinInfoVo.getXzdz());//现住地址
            data.add( persinInfoVo.getShjn());//所会技能
            data.add( persinInfoVo.getLove());//爱好
            data.add( persinInfoVo.getXycs());//相遇场所
            data.add( persinInfoVo.getGzsc());//工作时长
            data.add( persinInfoVo.getHyzk());//婚姻状况
            data.add( persinInfoVo.getSfzhm());//身份证号
            data.add( persinInfoVo.getSjhm());//手机号码
            data.add( persinInfoVo.getWxhm());//微信号码
            data.add( persinInfoVo.getQqhm());//QQ号码
            data.add( persinInfoVo.getJtzk());//家庭状况
            data.add( persinInfoVo.getGszw());//公司职位
            dataList.add(data);
        }
        String[] headTitle={"序号","姓名","性别","出生年月","出生地址","现住地址","所会技能","爱好","相遇场所","工作时长","婚姻状况","身份证号","微信号码","QQ号码","家庭状况","公司职位" };
        PoiUtil.exportExcelOneHead( dataList,"天翼成员信息表",50000,headTitle,response );

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

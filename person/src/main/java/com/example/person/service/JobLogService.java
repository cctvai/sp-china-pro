package com.example.person.service;

import com.example.person.dto.JobLogAddOrEditInDTO;
import com.example.person.dto.JobLogInDTO;
import com.example.person.vo.JobLogInfoVo;

import java.util.List;

public interface JobLogService {

    /**
     * 按条件查询所有工作日志信息
     * @param inDTO
     * @return
     */
    List<JobLogInfoVo> queryAll(JobLogInDTO inDTO);

    /**
     * 查询总数据量
     * @param inDTO
     * @return
     */
    int queryAllTotal(JobLogInDTO inDTO);

    /**
     *添加或者编辑
     * @param inDTO
     */
    void addOrEdit(JobLogAddOrEditInDTO inDTO);


    /**
     * 删除日志
     * @param id
     */
    void delete(String id);



}

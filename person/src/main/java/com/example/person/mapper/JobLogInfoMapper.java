package com.example.person.mapper;

import com.example.person.dto.JobLogAddOrEditInDTO;
import com.example.person.dto.JobLogInDTO;
import com.example.person.vo.JobLogInfoVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface JobLogInfoMapper {

    /**
     * 按条件查询所有工作日志信息
     * @param inDTO
     * @return
     */
    List<JobLogInfoVo> queryAll(@Param("param") JobLogInDTO inDTO);

    /**
     * 查询总数据量
     * @param inDTO
     * @return
     */
    int queryAllTotal(@Param("param") JobLogInDTO inDTO);

    /**
     *添加
     * @param inDTO
     */
    void addJobLog(@Param("param") JobLogAddOrEditInDTO inDTO);

    /**
     *编辑
     * @param inDTO
     */
    void editJobLog(@Param("param") JobLogAddOrEditInDTO inDTO);
    /**
     * 删除部门
     * @param id
     */
    void delete(@Param("id") String id);
}

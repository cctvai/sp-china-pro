package com.example.person.mapper;

import com.example.person.dto.ResourceAddOrEditInDTO;
import com.example.person.dto.ResourceInfoInDTO;
import com.example.person.entity.loginResource;
import com.example.person.vo.ResourceInfoVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ResourceInfoMapper {

    List<loginResource> loginResource(@Param("loginNo") String loginNo);

    /**
     * 按条件查询所有部门信息信息
     * @param inDTO
     * @return
     */
    List<ResourceInfoVo> queryAll(@Param("param") ResourceInfoInDTO inDTO);

    /**
     * 查询总数据量
     * @param inDTO
     * @return
     */
    int queryAllTotal(@Param("param") ResourceInfoInDTO inDTO);

    /**
     *添加
     * @param inDTO
     */
    void addResource(@Param("param") ResourceAddOrEditInDTO inDTO);

    /**
     *编辑
     * @param inDTO
     */
    void editResource(@Param("param") ResourceAddOrEditInDTO inDTO);
    /**
     * 删除部门
     * @param id
     */
    void delete(@Param("id") String id);
}

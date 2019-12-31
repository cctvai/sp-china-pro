package com.example.person.mapper;

import com.example.person.dto.SkillInfoAddOrEditInDTO;
import com.example.person.dto.SkillInfoInDTO;
import com.example.person.vo.SkillInfoVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SkillInfoMapper {

    /**
     * 按条件查询所有部门信息信息
     * @param inDTO
     * @return
     */
    List<SkillInfoVo> queryAll(@Param("param") SkillInfoInDTO inDTO);

    /**
     * 查询总数据量
     * @param inDTO
     * @return
     */
    int queryAllTotal(@Param("param") SkillInfoInDTO inDTO);

    /**
     *添加
     * @param inDTO
     */
    void addSkill(@Param("param") SkillInfoAddOrEditInDTO inDTO);

    /**
     *编辑
     * @param inDTO
     */
    void editSkill(@Param("param") SkillInfoAddOrEditInDTO inDTO);
    /**
     * 删除部门
     * @param id
     */
    void delete(@Param("id") String id);
}

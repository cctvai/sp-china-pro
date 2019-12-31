package com.example.person.service;

import com.example.person.dto.SkillInfoAddOrEditInDTO;
import com.example.person.dto.SkillInfoInDTO;
import com.example.person.vo.SkillInfoVo;
import java.util.List;

public interface SkillInfoService {


    /**
     * 按条件查询所有菜单资源信息
     * @param inDTO
     * @return
     */
    List<SkillInfoVo> queryAll(SkillInfoInDTO inDTO);

    /**
     * 查询总数据量
     * @param inDTO
     * @return
     */
    int queryAllTotal(SkillInfoInDTO inDTO);

    /**
     *添加或者编辑
     * @param inDTO
     */
    void addOrEdit(SkillInfoAddOrEditInDTO inDTO);


    /**
     * 删除
     * @param id
     */
    void delete(String id);



}

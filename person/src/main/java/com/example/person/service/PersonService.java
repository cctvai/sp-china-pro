package com.example.person.service;

import com.example.person.dto.PersonAddOrEditInDTO;
import com.example.person.dto.PersonInDTO;
import com.example.person.vo.PersinInfoVo;

import java.util.List;

public interface PersonService {
    /**
     * 查询所有人员信息
     * @param inDTO
     * @return
     */
    List<PersinInfoVo> queryAll(PersonInDTO inDTO);

    /**
     * 查询总数据量
     * @param inDTO
     * @return
     */
    int queryAllTotal(PersonInDTO inDTO);

    /**
     *添加或者编辑
     * @param inDTO
     */
    void addOrEdit(PersonAddOrEditInDTO inDTO);


    /**
     * 删除人员
     * @param pId
     */
    void delete(Long pId);



}

package com.example.person.service;

import com.example.person.dto.DepartAddOrEditInDTO;
import com.example.person.dto.DepartmentInDTO;
import com.example.person.vo.DepartCodeNameVo;
import com.example.person.vo.DepartmentInfoVo;

import java.util.List;

public interface DepartmentService {


    /**
     * 查询所有部门信息信息
     * @return
     */
    List<DepartCodeNameVo> query();

    /**
     * 按条件查询所有部门信息信息
     * @param inDTO
     * @return
     */
    List<DepartmentInfoVo> queryAll(DepartmentInDTO inDTO);

    /**
     * 查询总数据量
     * @param inDTO
     * @return
     */
    int queryAllTotal(DepartmentInDTO inDTO);

    /**
     *添加或者编辑
     * @param inDTO
     */
    void addOrEdit(DepartAddOrEditInDTO inDTO);


    /**
     * 删除部门
     * @param id
     */
    void delete(String id);



}

package com.example.person.service;

import com.example.person.dto.UserInfoAddOrEditInDTO;
import com.example.person.dto.UserInfoInDTO;
import com.example.person.vo.UserInfoVo;

import java.util.List;

public interface UserInfoService {


    /**
     * 按条件查询所有部门信息信息
     * @param inDTO
     * @return
     */
    List<UserInfoVo> queryAll(UserInfoInDTO inDTO);

    /**
     * 查询总数据量
     * @param inDTO
     * @return
     */
    int queryAllTotal(UserInfoInDTO inDTO);

    /**
     *添加或者编辑
     * @param inDTO
     */
    void addOrEdit(UserInfoAddOrEditInDTO inDTO);


    /**
     * 删除部门
     * @param id
     */
    void delete(String id);



}

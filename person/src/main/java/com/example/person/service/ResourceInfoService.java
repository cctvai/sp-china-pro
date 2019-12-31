package com.example.person.service;

import com.example.person.dto.ResourceAddOrEditInDTO;
import com.example.person.dto.ResourceInfoInDTO;
import com.example.person.entity.loginResource;
import com.example.person.vo.ResourceInfoVo;

import java.util.List;

public interface ResourceInfoService {

    /**
     * 登录查询所有资源
     * @return
     */
     List<loginResource> loginResource();


    /**
     * 按条件查询所有菜单资源信息
     * @param inDTO
     * @return
     */
    List<ResourceInfoVo> queryAll(ResourceInfoInDTO inDTO);

    /**
     * 查询总数据量
     * @param inDTO
     * @return
     */
    int queryAllTotal(ResourceInfoInDTO inDTO);

    /**
     *添加或者编辑
     * @param inDTO
     */
    void addOrEdit(ResourceAddOrEditInDTO inDTO);


    /**
     * 删除部门
     * @param id
     */
    void delete(String id);



}

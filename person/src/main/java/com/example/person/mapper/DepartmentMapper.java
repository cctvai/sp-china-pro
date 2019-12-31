package com.example.person.mapper;

import com.example.person.dto.DepartAddOrEditInDTO;
import com.example.person.dto.DepartmentInDTO;
import com.example.person.vo.DepartCodeNameVo;
import com.example.person.vo.DepartmentInfoVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DepartmentMapper {
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
    List<DepartmentInfoVo> queryAll(@Param("param") DepartmentInDTO inDTO);

    /**
     * 查询总数据量
     * @param inDTO
     * @return
     */
    int queryAllTotal(@Param("param") DepartmentInDTO inDTO);

    /**
     *添加
     * @param inDTO
     */
    void addDepart(@Param("param") DepartAddOrEditInDTO inDTO);

    /**
     *编辑
     * @param inDTO
     */
    void editDepart(@Param("param") DepartAddOrEditInDTO inDTO);
    /**
     * 删除部门
     * @param id
     */
    void delete(@Param("id") String id);
}

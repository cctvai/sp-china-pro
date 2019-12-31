package com.example.person.mapper;

import com.example.person.dto.PersonAddOrEditInDTO;
import com.example.person.dto.PersonInDTO;
import com.example.person.vo.PersinInfoVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PersonMapper {

    /**
     * 查询所有客户信息
     * @return
     * @throws Exception
     */
    List<PersinInfoVo> queryAll(@Param("param") PersonInDTO inDTO);

    /**
     * 导出所有人员信息
     * @param inDTO
     * @return
     */
    List<PersinInfoVo> queryAllExport(@Param("param") PersonInDTO inDTO);



    /**
     * 查询总数据量
     * @param inDTO
     * @return
     */
    int queryAllTotal(@Param("param") PersonInDTO inDTO);
    /**
     * 添加Person
     * @param inDTO
     */
     void addPerson(@Param("param") PersonAddOrEditInDTO inDTO);

    /**
     * 修改Person信息
     * @param inDTO
     */
    void editPerson(@Param("param") PersonAddOrEditInDTO inDTO);

    /**
     * 删除闲杂人员
     * @param pId
     */
    void delete(@Param("pId") Long pId);


}

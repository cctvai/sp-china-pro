package com.example.person.mapper;

import com.example.person.dto.ComFileInDTO;
import com.example.person.dto.ComFileOutDTO;
import com.example.person.entity.ComFile;
import org.apache.ibatis.annotations.Param;
import java.util.List;

public interface ComFileMapper {
    int deleteByPrimaryKey(@Param("id")String id);

    int insert(@Param("param")ComFile record);

    ComFile selectByPrimaryKey(String id);

    int updateByPrimaryKey(ComFile record);

    List<ComFileOutDTO> selectByCondition(@Param("param")ComFileInDTO inDTO);
    int selectByConditionTotal(@Param("param")ComFileInDTO inDTO);

    int deleteByTypeAndParentId(@Param("type") Integer type, @Param("parentId") String parentId);

    List<ComFile> listParentFiles(@Param("type") Integer type, @Param("parentId") String parentId);
}
package com.example.person.mapper;

import com.example.person.entity.ComFile;
import org.apache.ibatis.annotations.Param;
import java.util.List;

public interface ComFileMapper {
    int deleteByPrimaryKey(String id);

    int insert(ComFile record);

    ComFile selectByPrimaryKey(String id);

    int updateByPrimaryKey(ComFile record);

    List<ComFile> selectByCondition(ComFile comFile);

    int deleteByTypeAndParentId(@Param("type") Integer type, @Param("parentId") String parentId);

    List<ComFile> listParentFiles(@Param("type") Integer type, @Param("parentId") String parentId);
}
package com.example.person.service;

import com.example.person.dto.ComFileInDTO;
import com.example.person.dto.ComFileOutDTO;
import com.example.person.entity.ComFile;
import java.util.List;

/**
* ComFileService
* Created by yec on 2019/7/29.
*/
public interface ComFileService {

    List<ComFileOutDTO> selectByCondition(ComFileInDTO inDTO) throws Exception;

    int selectByConditionTotal(ComFileInDTO inDTO) throws Exception;

    ComFile save(ComFile comFile) throws Exception;

    ComFile update(ComFile comFile) throws Exception;

    ComFile selectByPrimaryKey(String id);

    int deleteByPrimaryKey(String id);

    int deleteByTypeAndParentId(Integer type, String parentId);

    void saveParentFiles(Integer type, String parentId, List<ComFile> files) throws Exception;

    List<ComFile> listParentFiles(Integer type, String parentId);
}

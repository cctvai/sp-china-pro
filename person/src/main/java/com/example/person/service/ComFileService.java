package com.example.person.service;

import com.example.person.entity.ComFile;
import java.util.List;

/**
* ComFileService
* Created by yec on 2019/7/29.
*/
public interface ComFileService {

    List<ComFile> selectByCondition(ComFile comFile) throws Exception;

    ComFile save(ComFile comFile) throws Exception;

    ComFile update(ComFile comFile) throws Exception;

    ComFile selectByPrimaryKey(String id);

    int deleteByPrimaryKey(String id);

    int deleteByTypeAndParentId(Integer type, String parentId);

    void saveParentFiles(Integer type, String parentId, List<ComFile> files) throws Exception;

    List<ComFile> listParentFiles(Integer type, String parentId);
}

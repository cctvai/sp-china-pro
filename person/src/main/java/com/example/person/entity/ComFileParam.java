package com.example.person.entity;

import lombok.Data;
import java.util.List;

/**
 * @Description
 * @Author 谭鲁
 * @Date 2019/08/10$
 **/
@Data
public class ComFileParam {

    private Integer type;
    private String parentId;
    private List<ComFile> files;

    public ComFileParam(){}

    public ComFileParam(Integer type, String parentId) {
        this.type = type;
        this.parentId = parentId;
    }

    public ComFileParam(Integer type, String parentId, List<ComFile> files) {
        this.type = type;
        this.parentId = parentId;
        this.files = files;
    }

}

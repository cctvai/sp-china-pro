package com.example.person.result;

import com.example.person.utils.ExceptUtil;
import lombok.Data;
import org.apache.ibatis.reflection.ExceptionUtil;

@Data
public class Result<T> {

    private Integer code;
    private T data;
    private String msg;

    public Result(Integer code, T data, String msg) {
        this.code = code;
        this.data = data;
        this.msg = msg;
    }

}
